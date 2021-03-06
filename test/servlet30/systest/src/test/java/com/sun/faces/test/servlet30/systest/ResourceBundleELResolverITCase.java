/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.test.servlet30.systest;


import com.gargoylesoftware.htmlunit.html.HtmlPage;
import junit.framework.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import junit.framework.TestSuite;


public class ResourceBundleELResolverITCase extends HtmlUnitFacesITCase {


    // ------------------------------------------------------------ Constructors


    /**
     * Construct a new instance of this test case.
     *
     * @param name Name of the test case
     */
    public ResourceBundleELResolverITCase(String name) {
        super(name);
    }


    // ------------------------------------------------------ Instance Variables


    // ---------------------------------------------------- Overall Test Methods


    /**
     * Set up instance variables required by this test case.
     */
    public void setUp() throws Exception {
        super.setUp();
    }


    /**
     * Return the tests included in this test suite.
     */
    public static Test suite() {
        return (new TestSuite(ResourceBundleELResolverITCase.class));
    }


    /**
     * Tear down instance variables required by this test case.
     */
    public void tearDown() {
        super.tearDown();
    }


    // ------------------------------------------------- Individual Test Methods


    public void testResourceBundleELResolverGetType() throws Exception {
        HtmlPage page = getPage("/faces/resourceBundle05.jsp");
        String text = page.asXml();
        assertTrue(text.contains("Result:\nclass java.util.ResourceBundle"));
    }

    public void testGetFeatureDescriptors() throws Exception {
        HtmlPage page = getPage("/faces/resourceBundle05.jsp");
        String text = page.asXml();

        String [] unorderedListOfStringsToFindInPage = {
            "Name: application displayName: application",
            "Name: applicationScope displayName: applicationScope",
            "Name: cookie displayName: cookie",
            "Name: facesContext displayName: facesContext",
            "Name: view displayName: view",
            "Name: header displayName: header",
            "Name: headerValues displayName: headerValues",
            "Name: initParam displayName: initParam",
            "Name: param displayName: param",
            "Name: paramValues displayName: paramValues",
            "Name: request displayName: request",
            "Name: requestScope displayName: requestScope",
            "Name: session displayName: session",
            "Name: sessionScope displayName: sessionScope",
            "Name: resourceBundle01 displayName: resourceBundle01 displayName",
            "Name: resourceBundle03 displayName: resourceBundle03 displayName",
            "Name: test1 displayName: test1"
        };
        boolean [] foundFlags = new boolean[unorderedListOfStringsToFindInPage.length];
        int i,j;
        for (i = 0; i < foundFlags.length; i++) {
            foundFlags[i] = false;
        }
        String [] textSplitOnSpace = text.split("[[\\n][\\n\\r][\\u0085][\\u2028]]");
        j = 0;
        for (i = 0; i < textSplitOnSpace.length; i++) {
            for (j = 0; j < unorderedListOfStringsToFindInPage.length; j++) {
                if (textSplitOnSpace[i].contains(unorderedListOfStringsToFindInPage[j])) {
                    foundFlags[j++] = true;
                    break;
                }
            }
        }
        for (i = 0; i < foundFlags.length; i++) {
            if (!foundFlags[i]) {
                fail("Unable to find " + unorderedListOfStringsToFindInPage[i] +
                     ".");
            }
        }

    }
}
