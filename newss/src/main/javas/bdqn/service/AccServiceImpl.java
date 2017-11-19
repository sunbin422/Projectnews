package bdqn.service;

import bdqn.dao.IAccountDao;
import bdqn.dao.ISocke;
import bdqn.entity.Account;
import bdqn.entity.Socke;
import bdqn.entity.exception;

/**
 * Created by sunbin on 2017/8/4.
 */
public class AccServiceImpl implements IAService {
   private IAccountDao acc;
   private ISocke  socke;
    public void set(Account account, Socke sock)  {
        boolean isBuy=true;
        boolean update = getSocke().update(sock, isBuy);
        try {
            throw new exception();
        } catch (bdqn.entity.exception exception) {
            exception.printStackTrace();
        }
        if(update&& getAcc().update(account,isBuy)){
                   System.out.println("成功");
               }
    }

    public IAccountDao getAcc() {
        return acc;
    }

    public void setAcc(IAccountDao acc) {
        this.acc = acc;
    }

    public ISocke getSocke() {
        return socke;
    }

    public void setSocke(ISocke socke) {
        this.socke = socke;
    }
}
