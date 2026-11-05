import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HerniAplikace {

    public static void zalozHrace(Connection conn, int id_hrace, String jmeno, int level, int zlato) {
        String prikazINSERT = "INSERT INTO hrac (id_hrace, jmeno, level, zlato) VALUES (?,?, ?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(prikazINSERT)) {
            insertStmt.setInt(1, id_hrace);
            insertStmt.setString(2, jmeno);
            insertStmt.setInt(3, level);
            insertStmt.setInt(4, zlato);

            insertStmt.executeUpdate();

            System.out.println("Hráč vytvořen");
        } catch (SQLException e) {
            System.err.println("Problém s databází: " + e.getMessage());
        }
    }

    public static void zvysLevel(Connection conn, String jmeno, int novyLevel) {
        String prikazUPDATE = "UPDATE hrac SET level = ? WHERE jmeno = ?";
        try (PreparedStatement updateStmt = conn.prepareStatement(prikazUPDATE)) {
            updateStmt.setInt(1, novyLevel);
            updateStmt.setString(2, jmeno);

            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Level hráče " + jmeno + " byl změněn na " + novyLevel);
            } else {
                System.out.println("Hráč se jménem " + jmeno + " nebyl nalezen.");
            }
        } catch (SQLException e) {
            System.err.println("Problém s databází: " + e.getMessage());
        }
    }

    public static void vytvorPostavu(Connection conn, int id_hrace, String seznam, String typ, int utok) {
        String prikazINSERT = "INSERT INTO postava (id_hrace, seznam, typ, utok) VALUES (?,?, ?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(prikazINSERT)) {
            insertStmt.setInt(1, id_hrace);
            insertStmt.setString(2, seznam);
            insertStmt.setString(3, typ);
            insertStmt.setInt(4, utok);

            insertStmt.executeUpdate();

            System.out.println("Postava vytvořena");
        } catch (SQLException e) {
            System.err.println("Problém s databází: " + e.getMessage());
        }
    }
}