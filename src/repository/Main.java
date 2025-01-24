import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try (var connection =  DB.connect()){
            System.out.println("connected to the PostgreSQL database.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());


        }
    }
}