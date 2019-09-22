package steve.http.session;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.PathResourceManager;
import io.undertow.server.handlers.resource.ResourceHandler;
import io.undertow.server.handlers.resource.ResourceManager;
import steve.http.server.MyHttpHandler;

import java.nio.file.Path;

/**
 * @author steve
 */
public class SessionTestServer {
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

        pathHandler.addPrefixPath("/static", resourceHandler);
        pathHandler.addPrefixPath("/", resourceHandler2);
        Undertow server = Undertow.builder()
            .addHttpListener(9000, "localhost", new RootHttpHandler())
            .setHandler(pathHandler)
            .build();
        server.start();
    }
}
