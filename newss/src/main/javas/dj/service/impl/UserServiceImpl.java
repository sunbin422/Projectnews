package dj.service.impl;

import dj.Dao.IUserDao;
import dj.entity.attendanceInfo;
import dj.entity.classesInfo;
import dj.entity.studentInfo;
import dj.service.IUserService;

import java.util.Date;
import java.util.List;

/**
 * Created by sunbin on 2017/8/11.
 */
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;
    public int login(String name, String pwd) {
        return userDao.login(name,pwd);
    }

    public List<classesInfo> list() {
        return userDao.list();
    }

    public List<studentInfo> listren(int id) {
        return userDao.listren(id);
    }

    public int insert(int id, Date attendancetime, String attendance) {
        return userDao.insert(id,attendancetime,attendance);
    }

    public List<attendanceInfo> lists(Date date) {
        return userDao.lists(date);
    }


    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
