package dj.service;

import dj.entity.attendanceInfo;
import dj.entity.classesInfo;
import dj.entity.studentInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by sunbin on 2017/8/11.
 */
public interface IUserService {
    public int login(String name, String pwd);
    public List<classesInfo> list();
    public List<studentInfo> listren(int id);
    public int insert(int id, Date attendancetime, String attendance);
    public List<attendanceInfo>lists(Date date);
}
