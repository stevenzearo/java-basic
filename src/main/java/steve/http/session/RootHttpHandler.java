package steve.http.session;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.Cookie;
import io.undertow.server.handlers.CookieImpl;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author steve
 */
public class RootHttpHandler implements HttpHandler {
    SessionManager sessionManager = new SessionManager();
    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        // implement a session
        Cookie sessionIdCookie = null;
        String sessionId = null;
        if (exchange.getRequestCookies().containsKey("sessionId")) {
            sessionIdCookie = exchange.getRequestCookies().get("sessionId");
            sessionId = sessionIdCookie.getValue();
            System.out.println("connection already established: " + sessionId);

        } else {
            sessionId = sessionManager.openSession();
            CookieImpl sessionIdCookieR = new CookieImpl("sessionId", sessionId);
            System.out.println("connection established: " + sessionId);
            exchange.setResponseCookie(sessionIdCookieR);
        }
        exchange.getRequestCookies().remove("sessionId");
        exchange.getResponseCookies().remove("sessionId");
        MyCloseListener myCloseListener = new MyCloseListener();
        myCloseListener.sessionId = sessionId;
        myCloseListener.sessionManager = sessionManager;
        exchange.getConnection().addCloseListener(myCloseListener);
    }
}
