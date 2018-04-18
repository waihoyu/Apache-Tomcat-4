/*
 * ExpressionTokenizer.java
 * $Header: /home/cvs/jakarta-tomcat-4.0/catalina/src/share/org/apache/catalina/ssi/ExpressionTokenizer.java,v 1.1 2002/11/25 10:15:42 dsandberg Exp $
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

/**
 *  Parses an expression string to return the individual tokens.
 *  This is patterned similar to the StreamTokenizer in the JDK
 *  but customized for SSI conditional expression parsing.
 *
 *  @version   $Revision: 1.1 $
 *  @author    Paul Speed
 */
public class ExpressionTokenizer {

    public static final int TOKEN_STRING = 0;
    public static final int TOKEN_AND    = 1;
    public static final int TOKEN_OR     = 2;
    public static final int TOKEN_NOT    = 3;
    public static final int TOKEN_EQ     = 4;
    public static final int TOKEN_NOT_EQ = 5;
    public static final int TOKEN_RBRACE = 6;
    public static final int TOKEN_LBRACE = 7;
    public static final int TOKEN_GE     = 8;
    public static final int TOKEN_LE     = 9;
    public static final int TOKEN_GT     = 10;
    public static final int TOKEN_LT     = 11;
    public static final int TOKEN_END    = 12;

    private char[] expr;
    private int tokenType = TOKEN_STRING;
    private String tokenVal = null;
    private int index;
    private int length;

    /**
     *  Creates a new parser for the specified expression.
     */
    public ExpressionTokenizer( String expr ) {
        this.expr = expr.trim().toCharArray();
        this.length = this.expr.length;
    }

    /**
     *  Returns true if there are more tokens.
     */
    public boolean hasMoreTokens() {
        return index < length;
    }

    /**
     *  Returns the current index for error reporting purposes.
     */
    public int getIndex() {
        return index;
    }

    protected boolean isMetaChar( char c ) {
	return Character.isWhitespace( c ) || 
	    c == '(' || c == ')' || c == '!' || 
	    c == '<' || c == '>' || c == '|' || 
	    c == '&' || c == '=';
    }

    /**
     *  Returns the next token type and initializes any
     *  state variables accordingly.
     */
    public int nextToken() {
        // Skip any leading white space
        while (index<length && Character.isWhitespace(expr[index]))
            index++;

        // Clear the current token val
        tokenVal = null;

        if (index == length)
            return TOKEN_END;  // End of string

        int start = index;
        char currentChar = expr[index];
        char nextChar = (char)0;
        index++;
        if (index < length)
            nextChar = expr[index];

        // Check for a known token start
        switch (currentChar) {
        case '(':
            return TOKEN_LBRACE;
        case ')':
            return TOKEN_RBRACE;
        case '=':
            return TOKEN_EQ;
        case '!':
            if (nextChar == '=') {
                index++;
                return TOKEN_NOT_EQ;
            } else {
                return TOKEN_NOT;
            }
        case '|':
            if (nextChar == '|') {
               index++;
               return TOKEN_OR;
            }
            break;
        case '&':
            if (nextChar == '&') {
               index++;
               return TOKEN_AND;
            }
            break;
        case '>':
            if (nextChar == '=') {
                index++;
                return TOKEN_GE;  // Greater than or equal
            } else {
                return TOKEN_GT;  // Greater than
            }
        case '<':
            if (nextChar == '=') {
                index++;
                return TOKEN_LE;  // Less than or equal
            } else {
                return TOKEN_LT;  // Less than
            }
        default:
            // Otherwise it's a string
            break;
        }

        int end = index;

        // If it's a quoted string then end is the next unescaped quote
        if (currentChar == '"' || currentChar == '\'') {
            char endChar = currentChar;
            boolean escaped = false;
            start++;
            for ( ; index < length; index++) {
                if (expr[index] == '\\' && !escaped) {
                    escaped = true;
                    continue;
                }
                if (expr[index] == endChar && !escaped)
                    break;

                escaped = false;
            }
            end = index;
            index++; // Skip the end quote
        } else {
            // End is the next whitespace character
            for ( ; index < length; index++) {
                if ( isMetaChar(expr[index]) )
                    break;
            }
            end = index;
        }

        // Extract the string from the array
        this.tokenVal = new String( expr, start, end - start );

        return TOKEN_STRING;
    }

    /**
     *  Returns the String value of the token if it was type
     *  TOKEN_STRING.  Otherwise null is returned.
     */
    public String getTokenValue() {
        return tokenVal;
    }
}
