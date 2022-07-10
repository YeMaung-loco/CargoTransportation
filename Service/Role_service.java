package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Role;
import config.DBConfig;


public class Role_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public Role_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}
	
	public int createRole(Role role) {
		int status=0;
		try {
			PreparedStatement ps= connection.prepareStatement("insert into role (role_name)values(?)");
			ps.setString(1, role.getRole_name());
			status=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public int updateRole(String id, Role role) {
		int status=0;
        try {

            PreparedStatement ps = this.dbConfig.getConnection()
                    .prepareStatement("UPDATE role SET roleName = ? WHERE role_id = ?");

            ps.setString(1, role.getRole_name());
            ps.setString(2, id);
            status=ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }return status;
    }
	public List<Role> getAllroles() {
        List<Role> roleList = new ArrayList<>();

        try (Statement st = connection.createStatement()) {

            String query = "SELECT * FROM role";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("role_id"));
                role.setRole_name(rs.getString("role_name"));
                roleList.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    public Role getById(String id) {
        Role role = new Role();

        try (Statement st = connection.createStatement()) {

            String query = "SELECT * FROM role WHERE role_id = " + id + ";";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                role.setId(rs.getInt("role_id"));
                role.setRole_name(rs.getString("roleName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }

   
}
