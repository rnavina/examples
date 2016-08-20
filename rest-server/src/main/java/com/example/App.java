package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.*;

public class App {
  private static final Logger logger = LoggerFactory.getLogger(App.class);
  private static final int JETTY_SERVER_PORT = 5555;

  public static void main(String[] args) {
    ResourceConfig resourceConfig = new ResourceConfig();
    resourceConfig.packages("com.example");

    ServletHolder servlet = new ServletHolder(new ServletContainer(resourceConfig));

    Server server = new Server(JETTY_SERVER_PORT);
    ServletContextHandler context = new ServletContextHandler(server, "/*");
    context.addServlet(servlet, "/*");

    try {
      try {
        server.start();
        logger.info(String.format("Starting Jetty Server at Port %s", JETTY_SERVER_PORT));
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        server.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } finally {
      server.destroy();
    }

  }
}
