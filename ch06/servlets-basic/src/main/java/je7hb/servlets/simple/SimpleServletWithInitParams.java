/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013,2014 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package je7hb.servlets.simple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Date;

/**
 * The type SimpleServletWithInitParams
 *
 * @author Peter Pilgrim
 */
@WebServlet(
    name="servletWithInitParams", urlPatterns = { "/initparams" },
    initParams = {
        @WebInitParam(name = "source", value = "East Croydon"),
        @WebInitParam(name = "target", value = "London Bridge"),
        @WebInitParam(name = "time", value = "11:57:00")
    })
public class SimpleServletWithInitParams extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter pwriter = resp.getWriter();
        pwriter.printf("This is the class `%s'\nThe date time is %s\n",
                this.getClass().getName(), new Date());
        for ( String name: Collections.list(
                this.getServletConfig().getInitParameterNames()) ) {
            pwriter.printf("init parameter: %s = %s\n", name,
                getServletConfig().getInitParameter(name));
        }
    }
}


