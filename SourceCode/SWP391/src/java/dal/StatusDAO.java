package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Status;

public class StatusDAO {

    DBConnect mysqlConnect = new DBConnect();

    public List<Status> listStatus() {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM `status`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Status s = new Status();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                statuses.add(s);
            }
            return statuses;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
}
