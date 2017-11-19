package bdqn.service;

import bdqn.entity.Account;
import bdqn.entity.Socke;
import bdqn.entity.exception;

/**
 * Created by sunbin on 2017/8/4.
 */
public interface IAService{

    public void  set(Account account, Socke sock) throws exception;
}
