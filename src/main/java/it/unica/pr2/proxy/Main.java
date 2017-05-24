/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.pr2.proxy;

import org.jsoup.Jsoup;
import static spark.Spark.*;

/** An extremely simple web proxy server consisting of 1 line of code in Java.
 *
 * Just go to <a>http://localhost:4567/proxy?url=YOUR_URL</a> to see the content of the specified url.
 * For instance, try with <a>http://localhost:4567/proxy?url=http://www.ft.com/</a>
 * 
 * A few JUnit4 tests are also provided.
 * <p>Note: this is meant for didactic purpose only.</p>
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Proxy_server">https://en.wikipedia.org/wiki/Proxy_server</a>
 * @author Maurizio Atzori, University of Cagliari
 *
*/
public class Main {

    /** Starts a the simple web proxy server.
     */
    public static void main(String[] args) {
        get("/proxy", (req, res) -> Jsoup.connect(req.queryParams("url")).get());
    }

}
