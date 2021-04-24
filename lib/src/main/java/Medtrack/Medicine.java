package Medtrack;

public class Medicine {
    //May need to remove mId
    private int mId;
    private String mName;
    /**
     * @param mName
     */
    public Medicine(String mName) {
        this.mName = mName;
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
     * @return the mName
     */
    public String getmName() {
        return mName;
    }
    /**
     * @param mName the mName to set
     */
    public void setmName(String mName) {
        this.mName = mName;
    }
}
