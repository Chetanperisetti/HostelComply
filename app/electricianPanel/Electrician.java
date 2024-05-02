package my.hostelcomply.app.electricianPanel;

import java.util.HashMap;

public class Electrician {
String Mobile_No,First_Name,Last_Name,EmailId,Password,Confirm_Password;

    public Electrician(String mobile_No, String first_Name, String last_Name, String emailId, String password, String confirm_Password) {
        Mobile_No = mobile_No;
        First_Name = first_Name;
        Last_Name = last_Name;
        EmailId = emailId;
        Password = password;
        Confirm_Password = confirm_Password;
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

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirm_Password() {
        return Confirm_Password;
    }

    public void setConfirm_Password(String confirm_Password) {
        Confirm_Password = confirm_Password;
    }
}
