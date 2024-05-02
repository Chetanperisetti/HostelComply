package my.hostelcomply.app.electricianPanel;

public class StudentelectricalComplaintDetails {

    private String desc;
    private String fname;
    private String phonenumber;
    private String problemitem;
    private String randomUid;
    private String roomnumber;
    private String studentId;
    private String status;

    public StudentelectricalComplaintDetails(String desc, String fname, String phonenumber, String problemitem, String randomUid, String roomnumber, String studentId,String status) {
        this.desc = desc;
        this.fname = fname;
        this.phonenumber = phonenumber;
        this.problemitem = problemitem;
        this.randomUid = randomUid;
        this.roomnumber = roomnumber;
        this.studentId = studentId;
        this.status=status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getProblemitem() {
        return problemitem;
    }

    public void setProblemitem(String problemitem) {
        this.problemitem = problemitem;
    }

    public String getRandomUid() {
        return randomUid;
    }

    public void setRandomUid(String randomUid) {
        this.randomUid = randomUid;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
