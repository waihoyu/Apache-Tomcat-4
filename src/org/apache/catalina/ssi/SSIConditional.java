/*
 * SSIConditional.java
 * $Header: /home/cvs/jakarta-tomcat-4.0/catalina/src/share/org/apache/catalina/ssi/SSIConditional.java,v 1.1 2002/11/25 10:15:42 dsandberg Exp $
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

import java.io.PrintWriter;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletOutputStream;

/**
 *  SSI command that handles all conditional directives.
 *
 *  @version   $Revision: 1.1 $
 *  @author    Paul Speed
 */
public class SSIConditional implements SSICommand {
    /**
     * @see SSICommand
     */
    public void process( SSIMediator ssiMediator,
			 String commandName,
			 String[] paramNames,
			 String[] paramValues,
			 PrintWriter writer) throws SSIStopProcessingException {

        // Retrieve the current state information
        SSIConditionalState state = ssiMediator.getConditionalState();

        if ( "if".equalsIgnoreCase( commandName ) ) {
            // Do nothing if we are nested in a false branch
            // except count it
            if ( state.processConditionalCommandsOnly ) {
                state.nestingCount++;
                return;
            }

            state.nestingCount = 0;

            // Evaluate the expression
            if ( evaluateArguments(paramNames, paramValues, ssiMediator) ) {
                // No more branches can be taken for this if block
                state.branchTaken = true;
            } else {
                // Do not process this branch
                state.processConditionalCommandsOnly = true;
                state.branchTaken = false;
            }

        } else if ( "elif".equalsIgnoreCase( commandName ) ) {
            // No need to even execute if we are nested in
            // a false branch
            if (state.nestingCount > 0)
                return;

            // If a branch was already taken in this if block
            // then disable output and return
            if ( state.branchTaken ) {
                state.processConditionalCommandsOnly = true;
                return;
            }

            // Evaluate the expression
            if ( evaluateArguments(paramNames, paramValues, ssiMediator) ) {
                // Turn back on output and mark the branch
                state.processConditionalCommandsOnly = false;
                state.branchTaken = true;
            } else {
                // Do not process this branch
                state.processConditionalCommandsOnly = true;
                state.branchTaken = false;
            }

        } else if ( "else".equalsIgnoreCase( commandName ) ) {
            // No need to even execute if we are nested in
            // a false branch
            if (state.nestingCount > 0)
                return;

            // If we've already taken another branch then
            // disable output otherwise enable it.
            state.processConditionalCommandsOnly = state.branchTaken;

            // And in any case, it's safe to say a branch
            // has been taken.
            state.branchTaken = true;

        } else if ( "endif".equalsIgnoreCase( commandName ) ) {
            // If we are nested inside a false branch then pop out
            // one level on the nesting count
            if (state.nestingCount > 0) {
                state.nestingCount--;
                return;
            }

            // Turn output back on
            state.processConditionalCommandsOnly = false;

            // Reset the branch status for any outer if blocks,
            // since clearly we took a branch to have gotten here
            // in the first place.
            state.branchTaken = true;
        } else {
	    throw new SSIStopProcessingException();
            //throw new SsiCommandException( "Not a conditional command:" + cmdName );
        }
    }

    /**
     *  Retrieves the expression from the specified arguments
     *  and peforms the necessary evaluation steps.
     */
    private boolean evaluateArguments( String[] names, 
				       String[] values,
                                       SSIMediator ssiMediator ) throws SSIStopProcessingException {
        String expr = getExpression( names, values );
        if (expr == null) {
	    throw new SSIStopProcessingException();
            //throw new SsiCommandException( "No expression specified." );
	}

        try {
            ExpressionParseTree tree = new ExpressionParseTree( expr,
                                                                ssiMediator );
            return tree.evaluateTree();
        } catch (ParseException e) {
            //throw new SsiCommandException( "Error parsing expression." );
	    throw new SSIStopProcessingException();
        }
    }

    /**
     *  Returns the "expr" if the arg name is appropriate, otherwise
     *  returns null.
     */
    private String getExpression( String[] paramNames, String[] paramValues ) {
        if ( "expr".equalsIgnoreCase( paramNames[0]) )
            return paramValues[0];
        return null;
    }
}
