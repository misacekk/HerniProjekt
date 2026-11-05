import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost/herniprojekt";
        final String USER = "root";
        final String PASSWORD = "";
        HerniAplikace h = new HerniAplikace();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Připojeno k databázi");
            //h.zalozHrace(conn, 1,"Michal", 6, 10000);
            //h.vytvorPostavu(conn,1,"Mixina","Ranger",40);
            h.zvysLevel(conn,"Michal",11);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}