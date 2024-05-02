package my.hostelcomply.app.studentPanel;


public class StudentpComplaintDetails {
    String Roomnumber, Mobile_No, problemitem, desc, RandomUid, StudentId, First_Name,Status,WashroomNumber;


    public StudentpComplaintDetails(String first_Name,String roomnumber, String phonenumber, String problems, String description, String randomUid,String status, String studentId,String washroomNumber) {
        First_Name=first_Name;
        Roomnumber = roomnumber;
        Mobile_No = phonenumber;
        problemitem = problems;
        desc = description;
        RandomUid = randomUid;
        Status=status;
        StudentId = studentId;
        WashroomNumber=washroomNumber;


    }

    public String getMobile_No() {
        return Mobile_No;
    }

    public void setMobile_No(String mobile_No) {
        Mobile_No = mobile_No;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getWashroomNumber() {
        return WashroomNumber;
    }

    public void setWashroomNumber(String washroomNumber) {
        WashroomNumber = washroomNumber;
    }

    public String getRoomnumber() {
        return Roomnumber;
    }

    public String getPhonenumber() {
        return Mobile_No;
    }

    public String getProblemitem() {
        return problemitem;
    }

    public String getDesc() {
        return desc;
    }

    public String getRandomUid() {
        return RandomUid;
    }

    public String getStudentId() {
        return StudentId;
    }

    public String getFname() {
        return First_Name;
    }

    public void setRoomnumber(String roomnumber) {
        Roomnumber = roomnumber;
    }

    public void setPhonenumber(String phonenumber) {
        Mobile_No = phonenumber;
    }

    public void setProblemitem(String problemitem) {
        this.problemitem = problemitem;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRandomUid(String randomUid) {
        RandomUid = randomUid;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public void setFname(String fname) {
        First_Name = fname;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}


