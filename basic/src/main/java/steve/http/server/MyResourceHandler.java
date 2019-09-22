package steve.http.server;

import com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.PathHandler;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;

import javax.net.ssl.SSLSession;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Deque;
import java.util.Map;

/**
 * @author steve
 */
public class MyResourceHandler implements HttpHandler {

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        SSLSession sslSession = exchange.getConnection().getSslSession();
        String requestPath = exchange.getRequestPath();
        System.out.println(requestPath);
        String fileName = "build/resources/main/";
        if (requestPath.startsWith("/static/")) {
            String fileNameStrPart = requestPath.substring(8);
            fileName += fileNameStrPart;
            exchange.setRequestURI(fileName);
            FileChannel fileChannel = new FileInputStream(new File(fileName)).getChannel();
            long size = fileChannel.size();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) size);
//            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "image/jpg");
            exchange.getResponseSender().send(byteBuffer);
        } else {
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/html");
            exchange.getResponseSender().send("error!!!!!");
        }
    }
}
