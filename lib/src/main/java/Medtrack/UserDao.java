package Medtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    Connection connection;

    public UserDao() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void insert(User user) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into Users(fName, lName, userName, password) values (?, ?, ?, ?)");
            pStatement.setString(1, user.getFname());
            pStatement.setString(2, user.getLname());
            pStatement.setString(3, user.getUserName());
            pStatement.setString(4, user.getPassword());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getall() {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from Users");
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                User temp = new User(rSet.getString("fName"), rSet.getString("lname"), rSet.getString("userName"), rSet.getString("password"));
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User userLogin(String userName, String password) {
        User loggedInUser = null;

        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from users where userName = ? and password = ?");
            pStatement.setString(1, userName);
            pStatement.setString(2, password);
            ResultSet rSet = pStatement.executeQuery();
            rSet.next();
            String fName = rSet.getString("fName");
            String lName = rSet.getString("lName");
            String uName = rSet.getString("userName");
            String pWord = rSet.getString("password");
            loggedInUser = new User(fName, lName, uName, pWord);
            loggedInUser.setUsId(rSet.getInt("usId"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loggedInUser;
    }

    public Integer getUserId(String userName) {
        User user = new User(null, null, userName, null);
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from users where userName = (?)");
            pStatement.setString(1, userName);
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()){
                user.setFname(rSet.getString("fName"));
                user.setLname(rSet.getString("lName"));
                user.setPassword(rSet.getString("password"));
                user.setUsId(rSet.getInt("usID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.getUsId();

    }

    @Override
    public List<User> getOne(String s){
        List<User> user = new ArrayList<>();
        //TODO
        return user;
    }


    @Override
    public void update(User e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(User e) {
        // TODO Auto-generated method stub
        
    }

    public User getUserById(int usId) {
        User user = null;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from users where usId = ?");
            pStatement.setInt(1, usId);
            ResultSet rSet = pStatement.executeQuery();
            rSet.next();
            String fName = rSet.getString("fName");
            String lName = rSet.getString("lName");
            String uName = rSet.getString("userName");
            String pWord = rSet.getString("password");
            user = new User(fName, lName, uName, pWord);
            user.setUsId(rSet.getInt("usId"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
    
}
