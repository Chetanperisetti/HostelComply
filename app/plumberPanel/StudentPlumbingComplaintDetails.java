package my.hostelcomply.app.plumberPanel;

import my.hostelcomply.app.studentPanel.StudentComplaintDetails;

public class StudentPlumbingComplaintDetails {
    private String desc;
    private String fname;
    private String phonenumber;
    private String problemitem;
    private String randomUid;
    private String roomnumber;
    private String studentId;
    private String status;
    private String washroomNumber;

    public StudentPlumbingComplaintDetails(String fname,String roomnumber,String phonenumber,String problemitem, String desc,String randomUid, String status,String studentId,String washroomNumber) {
        this.fname = fname;
        this.roomnumber = roomnumber;
        this.phonenumber = phonenumber;
        this.problemitem = problemitem;
        this.desc=desc;
        this.randomUid = randomUid;
        this.status=status;
        this.studentId = studentId;

        this.washroomNumber=washroomNumber;
    }

    public String getWashroomNumber() {
        return washroomNumber;
    }

    public void setWashroomNumber(String washroomNumber) {
        this.washroomNumber = washroomNumber;
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
