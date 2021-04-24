package Medtrack;

public class ShotRecord {
    private int srId;
    private int usId;
    private int mId;
    private int slId;
    private String notes;
    private String dateAndTime;
    /**
     * @param usId
     * @param mId
     * @param slId
     * @param notes
     * @param dateAndTime
     */
    public ShotRecord(int usId, int mId, int slId, String notes, String dateAndTime) {
        this.usId = usId;
        this.mId = mId;
        this.slId = slId;
        this.notes = notes;
        this.dateAndTime = dateAndTime;
    }
    /**
     * @return the srId
     */
    public int getSrId() {
        return srId;
    }
    /**
     * @param srId the srId to set
     */
    public void setSrId(int srId) {
        this.srId = srId;
    }
    /**
     * @return the usId
     */
    public int getUsId() {
        return usId;
    }
    /**
     * @param usId the usId to set
     */
    public void setUsId(int usId) {
        this.usId = usId;
    }
    /**
     * @return the mId
     */
    public int getmId() {
        return mId;
    }
    /**
     * @param mId the mId to set
     */
    public void setmId(int mId) {
        this.mId = mId;
    }
    /**
     * @return the slId
     */
    public int getSlId() {
        return slId;
    }
    /**
     * @param slId the slId to set
     */
    public void setSlId(int slId) {
        this.slId = slId;
    }
    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }
    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
    /**
     * @return the dateAndTime
     */
    public String getDateAndTime() {
        return dateAndTime;
    }
    /**
     * @param dateAndTime the dateAndTime to set
     */
    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    
}
