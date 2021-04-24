package Medtrack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ShotRecordTest {
    ShotRecord shotRecord = new ShotRecord(0, 1, 2, "Notes here", "Date and time here");

    @Test
    public void checkCreateShotRecord(){
        assertNotNull(shotRecord);
    }

    @Test
    public void checkGetUsId(){
        int usId = shotRecord.getUsId();
        assertEquals(usId, 0);
    }

    @Test
    public void checkSetUsId(){
        shotRecord.setUsId(1);
        assertEquals(shotRecord.getUsId(), 1);
    }

    @Test
    public void checkGetmId(){
        int mId = shotRecord.getmId();
        assertEquals(mId, 1);
    }
    
    @Test
    public void checkSetmId(){
        shotRecord.setmId(2);;
        assertEquals(shotRecord.getmId(), 2);
    }

    @Test
    public void checkGetslId(){
        int slId = shotRecord.getSlId();
        assertEquals(slId, 2);
    }

    @Test
    public void checkSetslId(){
        shotRecord.setSlId(3);
        assertEquals(shotRecord.getSlId(), 3);
    }

    @Test
    public void checkGetNotes(){
        String notes = shotRecord.getNotes();
        assertEquals(notes, "Notes here");
    }

    @Test
    public void checkSetNotes(){
        shotRecord.setNotes("New note");;
        assertEquals(shotRecord.getNotes(), "New note");
    }

    @Test
    public void checkGetDateAndTime(){
        String dateAndTime = shotRecord.getDateAndTime();
        assertEquals(dateAndTime, "Date and time here");
    }

    @Test
    public void checkSetDateAndTime(){
        shotRecord.setDateAndTime("New date with time");
        assertEquals(shotRecord.getDateAndTime(), "New date with time");
    }
}
