Simple Web Proxy Server in Java
===============================

This is an extremely simple Web Proxy Server written in Java. 
It is a one-liner that:
  1. starts a web server (using [Spark Java](http://sparkjava.com/))
  2. reads the *url* get parameter where a url should be provided
  3. fetches the page at the given url (using [JSoup](https://jsoup.org/))
  4. responds by providing the fetched page

The proxy is meant for didactic purposes only.
It is a simple example of a test-driven development made with JUnit4, Netbeans, Maven, git and GitHub, and proper minimal documentation (README and javadoc).

