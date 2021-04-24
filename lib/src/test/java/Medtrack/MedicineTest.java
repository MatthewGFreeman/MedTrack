package Medtrack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class MedicineTest {
    Medicine medicine = new Medicine("test med");

    @Test
    public void checkCreateMedicine(){
        assertNotNull(medicine);
    }
    
    @Test 
    public void checkGetMName(){
        String mName = medicine.getmName();
        assertEquals(mName, "test med");
    }

    @Test 
    public void checkSetMName(){
        medicine.setmName("TestMed1");;
        assertEquals(medicine.getmName(), "TestMed1");
    }
}
