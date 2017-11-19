package bdqn.dao;

import bdqn.entity.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.Observer;

/**
 * Created by sunbin on 2017/8/4.
 */
public class AccountImpl extends JdbcDaoSupport implements IAccountDao {

    public boolean update(Account account, boolean isBuy) {
        String str=null;
          if(isBuy){
               str="update account set money=money-? where cid=?";

          }else {
              str="update account set money=money+? where cid=?";
          }

        int update = this.getJdbcTemplate().update(str, account.getMoney(), account.getCid());

          if(update>0){
              return true;
          }else {
              return false;
          }
    }
}
