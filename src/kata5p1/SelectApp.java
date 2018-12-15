
package kata5p1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
    private Connection connect() {
         String url = "jdbc:sqlite:Kata5.db";
         Connection conn = null;
         try {
             conn = DriverManager.getConnection(url);
             System.out.println("Connexión a SQLite establecida");
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return conn;
     }
     
     public void selectAll(){
         String sql = "SELECT * FROM PEOPLE";
         try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
             
             while (rs.next()) {
                 System.out.println(rs.getInt("Id") + "\t" +
                 rs.getString("Name") + "\t" +
                 rs.getString("Apellidos") + "\t" +
                 rs.getString("Departamento") + "\t");
             }
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
     
     public void createNewTable(String sql) {
         String url = "jdbc:sqlite:Kata5.db";
         try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
             stmt.execute(sql);
             System.out.println("Tabla creada");
         } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public void insert(String table, String field, String value) {
        String sql = "INSERT INTO " + table + "(" + field + ")" + " VALUES(?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, value);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}

