package steve.http.session;

import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

/**
 * @author steve
 */
public class SessionManager {
    Map<String, Session> sessionMap = new Hashtable<>();

    public void closeSession(String id) {
        sessionMap.remove(id);
    }

    public String openSession() {
        String id = UUID.randomUUID().toString();
        Session session = new Session();
        session.id = id;
        session.valueMap = new Hashtable<>();
        sessionMap.put(id, session);
        return id;
    }
}
