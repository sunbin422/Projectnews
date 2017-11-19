package bdqn.dao;

import bdqn.entity.Account;
import bdqn.entity.Socke;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by sunbin on 2017/8/4.
 */
public class SockeImpl  extends JdbcDaoSupport implements ISocke{

    public boolean update(Socke socke, boolean isBuy) {


        String str=null;
        if(isBuy){
            str="update socke set count=count+? where sid=?";

        }else {
            str="update socke set count=count-? where sid=?";
        }

        System.out.println(socke.getCount()+","+socke.getSid());
        System.out.println();
        int update = this.getJdbcTemplate().update(str, socke.getCount(),socke.getSid());
        if(update>0){
            return true;
        }else {
            return false;
        }
    }
}
