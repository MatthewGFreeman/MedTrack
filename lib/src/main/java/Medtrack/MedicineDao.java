package Medtrack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDao implements Dao<Medicine> {
    Connection connection;

    public MedicineDao() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void insert(Medicine medicine) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into Medicines(mName) values (?)");
            pStatement.setString(1, medicine.getmName());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicine> getall() {
        List<Medicine> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from Medicines");
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                Medicine temp = new Medicine(rSet.getString("mName"));
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override

    public List<Medicine> getOne(String mName) {
        List<Medicine> list = new ArrayList<>();
        try {
            PreparedStatement pStatement = connection.prepareStatement("select mName from Medicines where mName = '(?)'");
            pStatement.setString(1, mName);
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()) {
                Medicine temp = new Medicine(rSet.getString("mName"));
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Integer getMedId(String mName) {
        Medicine med = new Medicine(mName);
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from Medicines where mname = (?)");
            pStatement.setString(1, mName);
            ResultSet rSet = pStatement.executeQuery();
            while(rSet.next()){
                med.setmId(rSet.getInt("mId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return med.getmId();

    }

    @Override
    public void update(Medicine medicine) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Medicine e) {
        // TODO Auto-generated method stub
        
    }
    
}
