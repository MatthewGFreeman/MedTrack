package Medtrack;

public class User {
    //May need to remove usId;
    private int usId;
    private String fname;
    private String lname;
    private String userName;
    private String password;
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @param fname
     * @param lname
     * @param userName
     * @param password
     */
    public User(String fname, String lname, String userName, String password) {
        this.fname = fname;
        this.lname = lname;
        this.userName = userName;
        this.password = password;
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
     * @return the fname
     */
    public String getFname() {
        return fname;
    }
    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }
    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }
    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName the email to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
