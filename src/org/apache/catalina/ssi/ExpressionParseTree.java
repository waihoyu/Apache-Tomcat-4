/*
 * ExpressionParseTree.java
 * $Header: /home/cvs/jakarta-tomcat-4.0/catalina/src/share/org/apache/catalina/ssi/ExpressionParseTree.java,v 1.1 2002/11/25 10:15:42 dsandberg Exp $
 * $Revision: 1.1 $
 * $Date: 2002/11/25 10:15:42 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * [Additional notices, if required by prior licensing conditions]
 *
 */

package org.apache.catalina.ssi;

import java.util.LinkedList;
import java.util.List;
import java.text.ParseException;

/**
 *  Represents a parsed expression.
 *
 *  @version   $Revision: 1.1 $
 *  @author    Paul Speed
 */
public class ExpressionParseTree
{
    /**
     *  Contains the current set of completed nodes.  This
     *  is a workspace for the parser.
     */
    private LinkedList nodeStack = new LinkedList();

    /**
     *  Contains operator nodes that don't yet have values.
     *  This is a workspace for the parser.
     */
    private LinkedList oppStack = new LinkedList();

    /**
     *  The root node after the expression has been parsed.
     */
    private Node root;

    /**
     *  The SSIMediator to use when evaluating the expressions.
     */
    private SSIMediator ssiMediator;

    /**
     *  Creates a new parse tree for the specified expression.
     */
    public ExpressionParseTree( String expr,
                                SSIMediator ssiMediator )
                                        throws ParseException {
        this.ssiMediator = ssiMediator;
        parseExpression( expr );
    }

    /**
     *  Evaluates the tree and returns true or false.  The specified
     *  SSIMediator is used to resolve variable references.
     */
    public boolean evaluateTree() {
        return root.evaluate();
    }

    /**
     *  Pushes a new operator onto the opp stack, resolving existing
     *  opps as needed.
     */
    private void pushOpp( OppNode node ) {

        // If node is null then it's just a group marker
        if( node == null ) {
            oppStack.add( 0, node );
            return;
        }

        while (true) {
            if (oppStack.size() == 0)
                break;
            OppNode top = (OppNode)oppStack.get(0);

            // If the top is a spacer then don't pop
            // anything
            if (top == null)
                break;

            // If the top node has a lower precedence then
            // let it stay
            if (top.getPrecedence() < node.getPrecedence())
                break;

            // Remove the top node
            oppStack.remove(0);

            // Let it fill its branches
            top.popValues( nodeStack );

            // Stick it on the resolved node stack
            nodeStack.add( 0, top );
        }

        // Add the new node to the opp stack
        oppStack.add( 0, node );
    }

    /**
     *  Resolves all pending opp nodes on the stack until the
     *  next group marker is reached.
     */
    private void resolveGroup() {

        OppNode top = null;
        while ((top=(OppNode)oppStack.remove(0)) != null ) {
            // Let it fill its branches
            top.popValues( nodeStack );

            // Stick it on the resolved node stack
            nodeStack.add( 0, top );
        }
    }

    /**
     *  Parses the specified expression into a tree of
     *  parse nodes.
     */
    private void parseExpression( String expr ) throws ParseException {

        StringNode currStringNode = null;

        // We cheat a little and start an artificial
        // group right away.  It makes finishing easier.
        pushOpp( null );

        ExpressionTokenizer et = new ExpressionTokenizer(expr);
        while (et.hasMoreTokens()) {
            int token = et.nextToken();

            if (token != ExpressionTokenizer.TOKEN_STRING)
                currStringNode = null;

            switch (token) {
            case ExpressionTokenizer.TOKEN_STRING:
                if (currStringNode == null) {
                    currStringNode = new StringNode( et.getTokenValue() );
                    nodeStack.add( 0, currStringNode );
                } else {
                    // Add to the existing
                    currStringNode.value.append( " " );
                    currStringNode.value.append( et.getTokenValue() );
                }
                break;
            case ExpressionTokenizer.TOKEN_AND:
                pushOpp( new AndNode() );
                break;
            case ExpressionTokenizer.TOKEN_OR:
                pushOpp( new OrNode() );
                break;
            case ExpressionTokenizer.TOKEN_NOT:
                pushOpp( new NotNode() );
                break;
            case ExpressionTokenizer.TOKEN_EQ:
                pushOpp( new EqualNode() );
                break;
            case ExpressionTokenizer.TOKEN_NOT_EQ:
                pushOpp( new NotNode() );
                // Sneak the regular node in.  The NOT will
                // be resolved when the next opp comes along.
                oppStack.add( 0, new EqualNode() );
                break;
            case ExpressionTokenizer.TOKEN_RBRACE:
                // Closeout the current group
                resolveGroup();
                break;
            case ExpressionTokenizer.TOKEN_LBRACE:
                // Push a group marker
                pushOpp( null );
                break;
            case ExpressionTokenizer.TOKEN_GE:
                pushOpp( new NotNode() );
                // Similar stategy to NOT_EQ above, except this
                // is NOT less than
                oppStack.add( 0, new LessThanNode() );
                break;
            case ExpressionTokenizer.TOKEN_LE:
                pushOpp( new NotNode() );
                // Similar stategy to NOT_EQ above, except this
                // is NOT greater than
                oppStack.add( 0, new GreaterThanNode() );
                break;
            case ExpressionTokenizer.TOKEN_GT:
                pushOpp( new GreaterThanNode() );
                break;
            case ExpressionTokenizer.TOKEN_LT:
                pushOpp( new LessThanNode() );
                break;
            case ExpressionTokenizer.TOKEN_END:
                break;
            }
        }

        // Finish off the rest of the opps
        resolveGroup();

        if (nodeStack.size() == 0) {
            throw new ParseException( "No nodes created.",
                                      et.getIndex() );
        }
        if (nodeStack.size() > 1) {
            throw new ParseException( "Extra nodes created.",
                                      et.getIndex() );
        }
        if (oppStack.size() != 0) {
            throw new ParseException( "Unused opp nodes exist.",
                                      et.getIndex() );
        }

        root = (Node)nodeStack.get(0);
    }

    /**
     *  A node in the expression parse tree.
     */
    private abstract class Node {

        /**
         *  Return true if the node evaluates to true.
         */
        public abstract boolean evaluate();
    }

    /**
     *  A node the represents a String value
     */
    private class StringNode extends Node {

        StringBuffer value;
        String resolved = null;

        public StringNode( String value ) {
            this.value = new StringBuffer(value);
        }

        /**
         *  Resolves any variable references and returns the
         *  value string.
         */
        public String getValue() {
            if (resolved == null)
                resolved = ssiMediator.substituteVariables( value.toString() ) ;
            return resolved;
        }

        /**
         *  Returns true if the string is not empty.
         */
        public boolean evaluate() {
            return !(getValue().length() == 0);
        }

        public String toString() {
            return value.toString();
        }
    }

    private static final int PRECEDENCE_NOT = 5;
    private static final int PRECEDENCE_COMPARE = 4;
    private static final int PRECEDENCE_LOGICAL = 1;

    /**
     *  A node implementation that represents an operation.
     */
    private abstract class OppNode extends Node {

        /**
         *  The left branch.
         */
        Node left;

        /**
         *  The right branch.
         */
        Node right;

        /**
         *  Returns a preference level suitable for comparison to
         *  other OppNode preference levels.
         */
        public abstract int getPrecedence();

        /**
         *  Lets the node pop its own branch nodes off the front of
         *  the specified list.  The default pulls two.
         */
        public void popValues( List values ) {
            right = (Node)values.remove(0);
            left = (Node)values.remove(0);
        }
    }

    private final class NotNode extends OppNode {

        public boolean evaluate() {
            return !left.evaluate();
        }

        public int getPrecedence() {
            return PRECEDENCE_NOT;
        }

        /**
         *  Overridden to pop only one value.
         */
        public void popValues( List values ) {
            left = (Node)values.remove(0);
        }

        public String toString() {
            return left + " NOT";
        }
    }

    private final class AndNode extends OppNode {

        public boolean evaluate() {
            if (!left.evaluate()) // Short circuit
                return false;
            return right.evaluate();
        }

        public int getPrecedence() {
            return PRECEDENCE_LOGICAL;
        }

        public String toString() {
            return left + " " + right + " AND";
        }
    }

    private final class OrNode extends OppNode {

        public boolean evaluate() {
            if (left.evaluate()) // Short circuit
                return true;
            return right.evaluate();
        }

        public int getPrecedence() {
            return PRECEDENCE_LOGICAL;
        }

        public String toString() {
            return left + " " + right + " OR";
        }
    }

    private abstract class CompareNode extends OppNode {
        protected int compareBranches() {
            String val1 = ((StringNode)left).getValue();
            String val2 = ((StringNode)right).getValue();
            return val1.compareTo(val2);
        }
    }

    private final class EqualNode extends CompareNode {

        public boolean evaluate() {
            return (compareBranches() == 0);
        }

        public int getPrecedence() {
            return PRECEDENCE_COMPARE;
        }

        public String toString() {
            return left + " " + right + " EQ";
        }
    }

    private final class GreaterThanNode extends CompareNode {

        public boolean evaluate() {
            return (compareBranches() > 0);
        }

        public int getPrecedence() {
            return PRECEDENCE_COMPARE;
        }

        public String toString() {
            return left + " " + right + " GT";
        }
    }

    private final class LessThanNode extends CompareNode {

        public boolean evaluate() {
            return (compareBranches() < 0);
        }

        public int getPrecedence() {
            return PRECEDENCE_COMPARE;
        }

        public String toString() {
            return left + " " + right + " LT";
        }
    }
}
