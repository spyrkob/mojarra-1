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

<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
    <html>
        <body>
            <h:form id="form">
                <h:dataTable value="#{interweaving08.items}" var="item"
binding="#{interweaving08.table}">
                    <h:column>
                        <%-- 
                           Validates CASE 1 in UIComponentClassicTagBase when
                           using a component binding with a lifetime longer
                           than request
                        --%>
                        ciao
                        <h:outputText value="#{item}"/>
                    </h:column>
                </h:dataTable>                
            </h:form>
        </body>
    </html>
</f:view>

