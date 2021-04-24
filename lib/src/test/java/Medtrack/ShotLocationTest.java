package Medtrack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ShotLocationTest {
    ShotLocation shotLocation = new ShotLocation("Face");

    @Test
    public void checkCreateShotLocation() {
        assertNotNull(shotLocation);
    }

    @Test
    public void checkGetShotLocationName() {
        String locName = shotLocation.getLocName();
        assertEquals(locName, "Face");
    }

    @Test
    public void checkSetShotLocationName() {
        shotLocation.setLocName("Not the Face");
        assertEquals(shotLocation.getLocName(), "Not the Face");
    }
    
}
