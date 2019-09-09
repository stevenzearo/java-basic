package steve.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author steve
 */
public class MongoTest {
    public static void main(String[] args) {
        MongoClientOptions.Builder builder = MongoClientOptions.builder();
        builder.socketKeepAlive(true);
        try (MongoClient mongoClient = new MongoClient("localhost", builder.build())) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            MongoCollection<Document> test2 = mongoDatabase.getCollection("test2");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
