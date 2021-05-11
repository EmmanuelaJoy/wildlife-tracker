import org.sql2o.*;
public class DB {
    // For local use
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "emmanuela", "adminPass");
    //For Heroku
    private static String connectionString = "jdbc:postgresql://ec2-54-163-254-204.compute-1.amazonaws.com:5432/de2jr153rr5f6k?sslmode=require";
    public static Sql2o sql2o = new Sql2o(connectionString, "swgavudvlixczf", "2948abef64b5819012a8e053e492dede708185e8e553b16645179cb21356ed72");
}