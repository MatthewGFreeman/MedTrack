package Medtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShotLocationDao implements Dao<ShotLocation> {
    Connection connection;

    public ShotLocationDao() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void insert(ShotLocation shotLocation) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into ShotLocations(locName) values (?)");
            pStatement.setString(1, shotLocation.getLocName());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ShotLocation> getall() {
        List<ShotLocation> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from ShotLocations");
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                ShotLocation temp = new ShotLocation(rSet.getString("locName"));
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ShotLocation> getOne(String locName) {
        List<ShotLocation> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select mName from ShotLocations where locName = (?)");
            pStatement.setString(1, locName);
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                ShotLocation temp = new ShotLocation(rSet.getString("locName"));
                list.add(temp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public Integer getSlId(String locName) {
        Integer slId = null;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from ShotLocations where locName = (?)");
            pStatement.setString(1, locName);
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()){
                slId = rSet.getInt("slId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slId;

    }

    @Override
    public void update(ShotLocation e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(ShotLocation e) {
        // TODO Auto-generated method stub
        
    }
    
}

