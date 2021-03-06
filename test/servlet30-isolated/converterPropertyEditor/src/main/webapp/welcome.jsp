<%--

    Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.

    This program and the accompanying materials are made available under the
    terms of the Eclipse Public License v. 2.0, which is available at
    http://www.eclipse.org/legal/epl-2.0.

    This Source Code may also be made available under the following Secondary
    Licenses when the conditions for such availability set forth in the
    Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
    version 2 with the GNU Classpath Exception, which is available at
    https://www.gnu.org/software/classpath/license.html.

    SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0

--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <f:view>
            <h:form>

<p>This selectOneMenu is bound to a list test.Payment instances.  There
is a converter-for-class registered for the test.Payment class.  This
will cause the EL coerceToType to be called to coerce the value from a
String to a test.Payment instance.  The EL uses JavaBeans PropertyEditor
instances to do this. </p>

<p>This test verifies that a custom converter-for-class converter is
called by the EL coerceToType via the ConverterPropertyEditor class in
Sun's JSF Impl.</p>

<p>This test uses UISelcOne.</p>

                <h:selectOneMenu value="#{testBean.payment}">
                    <f:selectItem itemLabel="cc1" itemValue="1"/>
                    <f:selectItem itemLabel="cc2" itemValue="2"/>
                </h:selectOneMenu>
                <h:commandButton id="press" value="submit" />
            </h:form>

<p>Test <a href="selectmany.jsp">UISelectMany</a>.</p>



        </f:view>
    </body>
</html>
