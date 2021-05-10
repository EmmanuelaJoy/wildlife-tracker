import org.sql2o.Sql2o;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DB {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "emmanuela", "adminPass");
//    String connectionString = "jdbc:postgresql://ec2-54-163-254-204.compute-1.amazonaws.com:5432/de2jr153rr5f6k";
//    public static Sql2o sql2o = new Sql2o(connectionString, "swgavudvlixczf", "2948abef64b5819012a8e053e492dede708185e8e553b16645179cb21356ed72");

    private static URI dbUri;
    public static Sql2o sql2o;

    static {
        Logger logger = LoggerFactory.getLogger(DB.class);

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://localhost:5432/wildlife_tracker");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }
            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? DatabaseProps.username : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? DatabaseProps.password : dbUri.getUserInfo().split(":")[1];
            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e) {
            logger.error("Unable to connect to database.");
        }
    }
}