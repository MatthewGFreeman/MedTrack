package Medtrack;

public class ShotLocation {
    //May need to remove slId
    private int slId;
    private String locName;
    /**
     * @param locName
     */
    public ShotLocation(String locName) {
        this.locName = locName;
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
     * @return the locName
     */
    public String getLocName() {
        return locName;
    }
    /**
     * @param locName the locName to set
     */
    public void setLocName(String locName) {
        this.locName = locName;
    }
    
}
