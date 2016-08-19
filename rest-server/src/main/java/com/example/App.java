package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {
  public static void main(String[] args) {
    ResourceConfig resourceConfig = new ResourceConfig();
    resourceConfig.packages("com.example");

    ServletHolder servlet = new ServletHolder(new ServletContainer(resourceConfig));

    Server server = new Server(5555);
    ServletContextHandler context = new ServletContextHandler(server, "/*");
    context.addServlet(servlet, "/*");

    try {
      try {
        server.start();
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
