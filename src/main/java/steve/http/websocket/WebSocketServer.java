package steve.http.websocket;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.PathResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;
import io.undertow.server.handlers.resource.ResourceManager;
import io.undertow.websockets.WebSocketConnectionCallback;
import io.undertow.websockets.WebSocketProtocolHandshakeHandler;
import io.undertow.websockets.core.StreamSinkFrameChannel;
import io.undertow.websockets.core.WebSocketCallback;
import io.undertow.websockets.core.WebSocketChannel;
import io.undertow.websockets.core.WebSocketFrame;
import io.undertow.websockets.core.WebSocketFrameType;
import io.undertow.websockets.core.protocol.version13.WebSocket13Channel;
import io.undertow.websockets.spi.WebSocketHttpExchange;
import org.xnio.ChannelListener;
import org.xnio.MessageConnection;
import org.xnio.OptionMap;
import org.xnio.StreamConnection;
import org.xnio.XnioWorker;
import org.xnio.channels.BoundChannel;
import org.xnio.channels.SocketAddressBuffer;
import steve.http.server.MyHttpHandler;
import steve.http.session.RootHttpHandler;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.file.Path;

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
        resourceHandler2.setDirectoryListingEnabled(true);
        resourceHandler2.setWelcomeFiles("favicon.ico");

        new WebSocketCallback<WebSocketChannel>() {
            @Override
            public void complete(WebSocketChannel channel, WebSocketChannel context) {

            }

            @Override
            public void onError(WebSocketChannel channel, WebSocketChannel context, Throwable throwable) {

            }
        };
        pathHandler.addPrefixPath("/static", resourceHandler);
        pathHandler.addPrefixPath("/", resourceHandler2);
        new WebSocketProtocolHandshakeHandler(new WebSocketConnectionCallback() {
            @Override
            public void onConnect(WebSocketHttpExchange exchange, WebSocketChannel channel) {
                try {
                    XnioWorker worker = channel.getWorker();
                    // process connection
                    worker.acceptMessageConnection(
                        new SocketAddressBuffer().getDestinationAddress()
                        , new ChannelListener<MessageConnection>() {
                            @Override
                            public void handleEvent(MessageConnection channel) {

                            }
                        }
                        , new ChannelListener<BoundChannel>() {
                            @Override
                            public void handleEvent(BoundChannel channel) {

                            }
                        }
                        , OptionMap.EMPTY);
                    channel.send(WebSocketFrameType.TEXT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Undertow server = Undertow.builder()
            .addHttpListener(9000, "localhost", new RootHttpHandler())
            .setHandler(pathHandler)
            .build();
        server.start();
    }
}
