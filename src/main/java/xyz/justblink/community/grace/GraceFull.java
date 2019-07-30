package xyz.justblink.community.grace;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import xyz.justblink.grace.Processor;
import xyz.justblink.grace.render.raw.ExportableTag;
import xyz.justblink.grace.render.raw.ExportableTagRenderer;
import xyz.justblink.grace.tag.Document;

import java.io.File;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class GraceFull {
    public static void main(String[] args) throws Exception {
        Document process = Processor.process(new File("sample.txt"));
        ExportableTagRenderer tagRenderer = ExportableTagRenderer.builder().build();
        final ExportableTag render = tagRenderer.render(process);
        final Gson gson = new Gson();

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/", exchange -> {
            byte[] response = gson.toJson(render).getBytes();
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.sendResponseHeaders(200, response.length);
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(response);
            responseBody.close();
        });
        httpServer.setExecutor(null);
        httpServer.start();
    }
}
