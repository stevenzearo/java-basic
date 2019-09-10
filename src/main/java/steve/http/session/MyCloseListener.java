package steve.http.session;

import io.undertow.server.ServerConnection;

import java.io.IOException;

/**
 * @author steve
 */
public class MyCloseListener implements ServerConnection.CloseListener {
    SessionManager sessionManager;
    String sessionId;
    @Override
    public void closed(ServerConnection connection) {
        sessionManager.closeSession(sessionId);
        System.out.println("connection closed: " + sessionId);
    }
}
