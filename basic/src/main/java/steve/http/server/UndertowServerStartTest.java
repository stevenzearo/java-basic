package steve.http.server;


import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class UndertowServerStartTest {
    public static void main(String[] args) {
        Undertow server = Undertow.builder().addHttpListener(8843, "localhost").setHandler(new HttpHandler() {
            @Override
            public void handleRequest(HttpServerExchange exchange) throws Exception {
                exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                exchange.getResponseSender().send("Hello, Undertow!");
            }
        }).build();
        server.start();
    }
}
