package steve.http.session;

import java.util.Map;

/**
 * @author steve
 */
public class Session {
    String id;
    Map<String, Object> valueMap;
    // int timeOut; // create scheduler to manage session effective time
}
