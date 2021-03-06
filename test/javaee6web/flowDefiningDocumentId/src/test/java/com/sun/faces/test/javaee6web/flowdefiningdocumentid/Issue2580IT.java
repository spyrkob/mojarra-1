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

package com.sun.faces.test.javaee6web.flowdefiningdocumentid;

import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import static org.junit.Assert.assertTrue;

public class Issue2580IT {
    /**
     * Stores the web URL.
     */
    private String webUrl;
    /**
     * Stores the web client.
     */
    private WebClient webClient;

    /**
     * Setup before testing.
     * 
     * @throws Exception when a serious error occurs.
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     * Cleanup after testing.
     * 
     * @throws Exception when a serious error occurs.
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Setup before testing.
     */
    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
    }

    /**
     * Tear down after testing.
     */
    @After
    public void tearDown() {
        webClient.close();
    }

    @Test
    public void testFlow01() throws Exception {

        doTest("flow01");
        doTest("flow02");
    }
    public void doTest(String flowId) throws Exception {
        HtmlPage page = webClient.getPage(webUrl);
        String pageText = null;
        HtmlSubmitInput button = (HtmlSubmitInput) page.getElementById(flowId);
        HtmlTextInput text = null;
        
        page = button.click();
        pageText = page.asText();
        assertTrue(pageText.contains(flowId + " name"));
        
        button = (HtmlSubmitInput) page.getElementById("next_a");
        page = button.click();
        
        text = (HtmlTextInput) page.getElementById("input");
        String textValue = "" + System.currentTimeMillis();
        text.setText(textValue);
        
        button = (HtmlSubmitInput) page.getElementById("next");
        page = button.click();
        
        pageText = page.asText();
        assertTrue(pageText.contains(textValue));
        
        button = (HtmlSubmitInput) page.getElementById("return");
        page = button.click();
        
        pageText = page.asText();
        assertTrue(pageText.contains("return page"));
    }
}
