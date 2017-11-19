package cn.Service;

import cn.dao.UserDao;
import cn.dao.UserDaoImpl;
import cn.entity.User;

/**
 * Created by sunbin on 2017/7/24.
 */
public class ServletImpl implements ServiceDao {

    public UserDao getDaos() {
        return daos;
    }

    public void setDaos(UserDao daos) {
        this.daos = daos;
    }

    //  UserDao users=new UserDaoImpl();
  private  UserDao  daos;


    public void show(User user) {
         daos.show(user);
    }




}
