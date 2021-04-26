package Medtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShotRecordDao implements Dao<ShotRecord> {
    Connection connection;

    public ShotRecordDao() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void insert(ShotRecord shotRecord) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into ShotRecords(usId, mId, slId, notes, dateAndTime) values (?, ?, ?, ?, ?)");
            pStatement.setInt(1, shotRecord.getUsId());
            pStatement.setInt(2, shotRecord.getmId());
            pStatement.setInt(3, shotRecord.getSlId());
            pStatement.setString(4, shotRecord.getNotes());
            pStatement.setString(5, shotRecord.getDateAndTime());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ShotRecord> getall() {
        List<ShotRecord> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from ShotRecords");
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                ShotRecord temp = new ShotRecord(rSet.getInt("usId"), rSet.getInt("mId"), rSet.getInt("slId"), rSet.getString("notes"), rSet.getString("dateAndTime"));
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ShotRecord> getOne(String dateAndTime) {
        List<ShotRecord> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from ShotRecords where dateAndTime = ?");
            pStatement.setString(1, dateAndTime);
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                ShotRecord temp = new ShotRecord(rSet.getInt("usId"), rSet.getInt("mId"), rSet.getInt("slId"), rSet.getString("notes"), rSet.getString("dateAndTime"));
                list.add(temp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public Integer getShotRecordId(String dateAndTime, String notes) {
        ShotRecord shotRecord = new ShotRecord(0, 0, 0, notes, dateAndTime);
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from ShotRecords where notes = (?) and dateAndTime = (?)");
            pStatement.setString(1, notes);
            pStatement.setString(2, dateAndTime);
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()){
                shotRecord.setUsId(rSet.getInt("srId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shotRecord.getSrId();
    }

    public List<ShotRecord> getOneUsersRecords(String userName) {
        List<ShotRecord> list = new ArrayList<>();
        
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from ShotRecords where usId in (select usId from users where userName = (?))");
            pStatement.setString(1, userName);
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                ShotRecord temp = new ShotRecord(rSet.getInt("usId"), rSet.getInt("mId"), rSet.getInt("slId"), rSet.getString("notes"), rSet.getString("dateAndTime"));
                list.add(temp);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(ShotRecord e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(ShotRecord e) {
        // TODO Auto-generated method stub
        
    }

    public void deleteOneRecord(String notes, String dateAndTime) {
        PreparedStatement pStatement;
        try {
            pStatement = connection.prepareStatement("Delete * from shotrecords where notes = ? and dateAndTime = ?");
            pStatement.setString(1, notes);
            pStatement.setString(2, dateAndTime);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
