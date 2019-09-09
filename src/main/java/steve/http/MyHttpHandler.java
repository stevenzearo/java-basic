package steve.http;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.xnio.channels.StreamSourceChannel;

import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.Map;

/**
 * @author steve
 */
public class MyHttpHandler implements HttpHandler {
    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        Map<String, Deque<String>> queryParameters = exchange.getQueryParameters();
        Deque<String> name = queryParameters.get("name");
        String first = "";
        if (!name.isEmpty()) {
            first = name.getFirst();
            System.out.println(first);
        }
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("hello, " + first);
    }
}
