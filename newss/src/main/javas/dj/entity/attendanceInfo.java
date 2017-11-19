package dj.entity;

import java.util.Date;

/**
 * Created by sunbin on 2017/8/11.
 */
public class attendanceInfo {

    private Integer studentattendaneid;
    private  Integer studentid;
    private Date attendancetime;
    private String attendance;
    private String studentName;
    private studentInfo studentInfo;
    private String time;

    public Integer getStudentattendaneid() {
        return studentattendaneid;
    }

    public void setStudentattendaneid(Integer studentattendaneid) {
        this.studentattendaneid = studentattendaneid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Date getAttendancetime() {
        return attendancetime;
    }

    public void setAttendancetime(Date attendancetime) {
        this.attendancetime = attendancetime;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public dj.entity.studentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(dj.entity.studentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
