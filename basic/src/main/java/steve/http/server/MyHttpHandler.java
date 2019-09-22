package steve.http.server;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.ServerConnection;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;

import java.util.Deque;
import java.util.Map;

/**
 * @author steve
 */
public class MyHttpHandler implements HttpHandler {
    @Override
    public void handleRequest(HttpServerExchange exchange) {
        HttpString requestMethod = exchange.getRequestMethod();
        System.out.println("request method: "+requestMethod.toString());
        Map<String, Deque<String>> queryParameters = exchange.getQueryParameters();
        Deque<String> name = queryParameters.get("name");
        String first = "";
        if (name != null && !name.isEmpty()) {
            first = name.getFirst();
            System.out.println(first);
        }
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("hello, " + first);
    }
}
