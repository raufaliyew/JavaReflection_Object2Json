package udemy_master_class.section_2.two.web;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import udemy_master_class.section_2.two.init.ServerConfiguration;

public class WebServer {
    public void startServer() throws IOException {
        HttpServer httpserver = HttpServer.create(ServerConfiguration.getInstance().getServerAddress(), 0);
        httpserver.createContext("/greeting").setHandler(exchange -> {
            String responseMessage = ServerConfiguration.getInstance().getGreetingMessage();
            exchange.sendResponseHeaders(200, responseMessage.length());

            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();
        });

        System.out.println(String.format("Starting server on address %s:%d",
                ServerConfiguration.getInstance().getServerAddress().getHostName(),
                ServerConfiguration.getInstance().getServerAddress().getPort()));

        httpserver.start();
    }
}
