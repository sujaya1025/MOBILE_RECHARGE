package dao;

import model.Operator;
import model.RechargePlan;
import model.UserAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Operations {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Pvpsit@123"; 

    private Connection getConnection() {
        Connection conn = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return conn;
    }

    
    public boolean validateAdmin(String username, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM admins WHERE username = ? AND password = ?"; 

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, username);
            stmt.setString(2, password); 

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isValid = true; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
    
    public boolean createUser(UserAccount user) {
        String sql = "INSERT INTO user_accounts (username, password, email) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserAccount getUser(String username, String password) {
        String sql = "SELECT * FROM user_accounts WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new UserAccount(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

    public boolean addOperator(Operator operator) {
        String query = "INSERT INTO operators (id,name, description) VALUES (?,?,?)";
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, operator.getId());
            stmt.setString(2, operator.getName());
            stmt.setString(3, operator.getDescription());
            
            System.out.println("Executing SQL query: " + query);
            System.out.println("Operator name: " + operator.getName());
            System.out.println("Operator description: " + operator.getDescription());
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            return rowsAffected > 0; 
        } catch (Exception e) {
            System.out.println("Error adding operator: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteOperator(int id) {
        String sql = "DELETE FROM operators WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            System.out.println("Error deleting operator: " + e.getMessage());
            return false; 
        }
    }

    public boolean updateOperator(int id, String operatorName, String description) {
        String sql = "UPDATE operators SET name = ?, description = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, operatorName);
            pstmt.setString(2, description);
            pstmt.setInt(3, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public List<Operator> getAllOperators() {
        List<Operator> operators = new ArrayList<>();
        String sql = "SELECT * FROM operators";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                operators.add(new Operator(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operators;
    }

    public List<RechargePlan> getPlansByOperatorId(int operatorId) {
        List<RechargePlan> plans = new ArrayList<>();
        String sql = "SELECT * FROM recharge_plans WHERE operator_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, operatorId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                plans.add(new RechargePlan(
                        rs.getInt("id"),
                        rs.getInt("operator_id"),
                        rs.getString("plan_name"),
                        rs.getString("plan_description"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plans;
    }
    
 
    public boolean addRechargePlan(int id, int operatorId, String planName, String description, double price) {
        String sql = "INSERT INTO recharge_plans (id, operator_id, plan_name, plan_description, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);              
            pstmt.setInt(2, operatorId);     
            pstmt.setString(3, planName);     
            pstmt.setString(4, description);  
            pstmt.setDouble(5, price);       
            return pstmt.executeUpdate() > 0; 
        } catch (SQLException e) { e.printStackTrace();   }
        
        return false;                       
    }

    
    public boolean deleteRechargePlan(int id) {
        String sql = "DELETE FROM recharge_plans WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean updateRechargePlan(int id, String planName, double price, String description) {
        String sql = "UPDATE recharge_plans SET plan_name = ?, price = ?, plan_description = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, planName);
            pstmt.setDouble(2, price);
            pstmt.setString(3, description);
            pstmt.setInt(4, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<RechargePlan> getAllRechargePlans() {
        List<RechargePlan> plans = new ArrayList<>();
        String sql = "SELECT * FROM recharge_plans"; 
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                plans.add(new RechargePlan(
                        rs.getInt("id"),
                        rs.getInt("operator_id"),
                        rs.getString("plan_name"),
                        rs.getString("plan_description"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plans;
    }

    public Operator getOperatorById(int id) {
        String sql = "SELECT * FROM operators WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Operator(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public RechargePlan getRechargePlanById(int id) {
        String sql = "SELECT * FROM recharge_plans WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new RechargePlan(
                    rs.getInt("id"),
                    rs.getInt("operator_id"),
                    rs.getString("plan_name"),
                    rs.getString("plan_description"),
                    rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
