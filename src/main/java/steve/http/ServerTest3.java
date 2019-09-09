package steve.http;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;

/**
 * @author steve
 */
public class ServerTest3 {
    public static void main(String[] args) {
        PathHandler pathHandler = Handlers.path();
        MyHttpHandler myHttpHandler = new MyHttpHandler();
        pathHandler.addPrefixPath("/", myHttpHandler);
        Undertow server = Undertow.builder().addHttpListener(9000, "localhost").setHandler(pathHandler).build();
        server.start();
    }
}
