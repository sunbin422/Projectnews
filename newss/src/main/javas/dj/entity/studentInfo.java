package dj.entity;

import java.util.Date;

/**
 * Created by sunbin on 2017/8/11.
 */
public class studentInfo {
    private Integer studentId;
    private String studentName;
    private int classId;
    private Date studentcatetime;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Date getStudentcatetime() {
        return studentcatetime;
    }

    public void setStudentcatetime(Date studentcatetime) {
        this.studentcatetime = studentcatetime;
    }
}
