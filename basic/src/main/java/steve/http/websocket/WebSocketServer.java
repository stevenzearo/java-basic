package steve.http.websocket;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.PathResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;
import io.undertow.server.handlers.resource.ResourceManager;
import io.undertow.websockets.WebSocketConnectionCallback;
import io.undertow.websockets.core.*;
import io.undertow.websockets.spi.WebSocketHttpExchange;
import steve.http.server.MyHttpHandler;

import java.io.IOException;
import java.nio.file.Path;

import static io.undertow.Handlers.websocket;

/**
 * @author steve
 */
public class WebSocketServer {
    public static void main(String[] args) {
        PathHandler pathHandler = Handlers.path();
        MyHttpHandler myHttpHandler = new MyHttpHandler();
        pathHandler.addPrefixPath("/test", myHttpHandler);
        ResourceManager resourceManager = new PathResourceManager(Path.of("build/resources/main/static/"));
        ResourceHandler resourceHandler = new ResourceHandler(resourceManager);
        resourceHandler.setDirectoryListingEnabled(true);
        ResourceManager resourceManager2 = new PathResourceManager(Path.of("build/resources/main/"));
        ResourceHandler resourceHandler2 = new ResourceHandler(resourceManager2);
        resourceHandler2.setDirectoryListingEnabled(false);
        resourceHandler2.setWelcomeFiles("index.html");
//        resourceHandler2.setWelcomeFiles("favicon.ico");

        pathHandler.addPrefixPath("/static", resourceHandler);
        pathHandler.addPrefixPath("/", resourceHandler2);
        pathHandler.addPrefixPath("/websocket", websocket(new WebSocketConnectionCallback() {
            @Override
            public void onConnect(WebSocketHttpExchange exchange, WebSocketChannel channel) {
                channel.getReceiveSetter().set(new AbstractReceiveListener() {
                    @Override
                    protected void onFullTextMessage(WebSocketChannel channel, BufferedTextMessage message) throws IOException {
                        WebSockets.sendText(message.getData(), channel, null);
                    }
                });
                channel.resumeReceives();
            }
        }));
        Undertow server = Undertow.builder()
            .addHttpListener(9000, "localhost")
            .setHandler(pathHandler)
            .build();
        server.start();
    }
}
