/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.pr2.proxy;


import java.io.IOException;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spark.Spark; // needed in order to stop the server

/** This is a simple JUnit4 test to verify the server starts and serves a given page
 *
 * @author Maurizio Atzori
 */
public class ProxyTest {
    
    /** try to start the server before the actual test */
    @BeforeClass
    public static void setUpClass() {
        // avviare il server proxy
        Main.main(new String[] {});
        
    }
    
    /** stop the server after all tests are done */
    @AfterClass
    public static void tearDownClass() {
        Spark.stop();
        // interrompere il server proxy
    }
    
    @Test
    public void testSimple() throws IOException {
        Document doc = Jsoup.connect("http://localhost:4567/proxy?url=http://www.unica.it/").get();
        assertTrue("title of www.unica.it must contains 'Univers'", doc.title().contains("Univers"));
    }

    @Test
    public void testWithAssertThat() throws IOException {
        Document doc = Jsoup.connect("http://localhost:4567/proxy?url=http://www.unica.it/").get();
 
        // ensure both "Univers" and "studi" are in the title of the page
        // assertThat is also able to automatically give a descriptive message 
        // when the test fails
        assertThat(doc.title(), allOf(containsString("Univers"),containsString("studi")));
        
    }
}
