package my.hostelcomply.app.electricianPanel;

import java.util.Date;

public class StudentelectricalComplaintDetailswithdate {

    private String date;
    private String time;

    private String firstname;
    private String problemIte;
    private String description;
    private String roomNumber;
    private String phoneNumber;
    private  String status;
    private String studentId;

//    private String efirstname;
    private String emobile;
    private  String key;
    private String randomUid;

    public StudentelectricalComplaintDetailswithdate() {
    }

    public StudentelectricalComplaintDetailswithdate(String date, String time, String firstname, String problemIte, String description, String roomNumber, String phoneNumber,String status,String studentId,String emobile,String key,String randomUid) {
        this.date = date;
        this.time = time;
        this.firstname = firstname;
        this.problemIte = problemIte;
        this.description = description;
        this.roomNumber = roomNumber;
        this.phoneNumber = phoneNumber;
        this.status=status;
        this.studentId=studentId;
//        this.efirstname=efirstname;
        this.emobile=emobile;
        this.key=key;
        this.randomUid=randomUid;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getProblemIte() {
        return problemIte;
    }

    public void setProblemIte(String problemIte) {
        this.problemIte = problemIte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

//    public String getEfirstname() {
//        return efirstname;
//    }
//
//    public void setEfirstname(String efirstname) {
//        this.efirstname = efirstname;
//    }

    public String getEmobile() {
        return emobile;
    }

    public void setEmobile(String emobile) {
        this.emobile = emobile;
    }

    public String getKey() {
        return key;
    }

    public String getRandomUid() {
        return randomUid;
    }

    public void setRandomUid(String randomUid) {
        this.randomUid = randomUid;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
