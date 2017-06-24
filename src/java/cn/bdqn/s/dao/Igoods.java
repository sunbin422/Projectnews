package cn.bdqn.s.dao;

import cn.bdqn.s.entity.ent;
import cn.bdqn.s.entity.goods;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sunbin on 2017/6/16.
 */
public interface Igoods {

      public  List<goods>  PageList(String goodsname,int goodsNo,int pageIndex,int pageSize) throws SQLException;

      public int count(String goodsname,int goodsNo) throws SQLException;

      public List<ent> list(int num);
}
