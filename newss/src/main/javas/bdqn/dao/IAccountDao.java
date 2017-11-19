package bdqn.dao;

import bdqn.entity.Account;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by sunbin on 2017/8/4.
 */
public interface IAccountDao {

    public boolean update(Account account ,boolean isBuy);


}
