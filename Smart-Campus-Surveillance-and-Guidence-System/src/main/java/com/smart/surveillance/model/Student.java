package com.smart.surveillance.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

    @Id
    private String _id;
    private String s_name;
    private String email;
    private String mob_no;
    private List<ClassSchedule> schedules;
    private String username;
    private String password;
    private String photoBase64;  // 📸 New field for photo

    public Student(String _id, String s_name, String email, String mob_no, String username, String password) {
        super();
        this._id = _id;
        this.s_name = s_name;
        this.email = email;
        this.mob_no = mob_no;
        this.username = _id;
        this.password = password;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ClassSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ClassSchedule> schedules) {
        this.schedules = schedules;
    }

    public String getReg_no() {
        return _id;
    }

    public void setReg_no(String _id) {
        this._id = _id;
        this.username = _id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
