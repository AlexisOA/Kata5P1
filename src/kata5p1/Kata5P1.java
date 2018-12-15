package kata5p1;

import java.util.List;

public class Kata5P1 {
    public static void main(String[] args) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
        + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
        + " Mail text NOT NULL);";
        new SelectApp().createNewTable(sql);
    }
    
    
}


