package cn.bdqn.s.dao.Impl;

import cn.bdqn.s.dao.BaseDao;
import cn.bdqn.s.dao.Igoods;
import cn.bdqn.s.entity.ent;
import cn.bdqn.s.entity.goods;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbin on 2017/6/16.
 */
public class goodsImpl extends BaseDao implements Igoods {
    @Test
    public void Show() throws SQLException {

        int count= count("",1);


    }
    public List<goods> PageList(String goodsname, int goodsNo, int pageIndex, int pageSize) throws SQLException {
           List<goods> list=new ArrayList<goods>();
        StringBuffer sb=new StringBuffer("select id,goodsname,st.TypeName,goodsprice from goods ,goodstype as st where st.TypeId=goods.goodsNo");
        if(null!=goodsname){

            sb.append(" and goods.goodsname like '%"+goodsname+"%'");

        }
        if(goodsNo!=0){

            sb.append(" and goods.goodsNo="+goodsNo);

        }
        sb.append(" limit ?,?");
        Object[] objects={ (pageIndex-1)*pageSize,pageSize };

        getConection();

        ResultSet rs = executeQuery(sb.toString(), objects);



            while (rs.next()){

                goods good=new goods();
                good.setId(rs.getInt("id"));
                good.setGoodsname(rs.getString("goodsname"));
                good.setGoodsNo(rs.getString("st.TypeName"));
                good.setGoodsprice(rs.getDouble("goodsprice"));

                list.add(good);
            }


        return list;
    }

    public int count(String goodsname, int goodsNo) throws SQLException {
        StringBuffer sb=new StringBuffer("select count(*) as num  from goods where 1=1");

        if(null!=goodsname){

            sb.append(" and goodsname like '%"+goodsname+"%'");

        }
        if(goodsNo!=0){

            sb.append(" and goodsNo="+goodsNo);

        }
        getConection();
        rs=executeQuery(sb.toString());
        int count=0;
        if (rs.next()) {
            count=rs.getInt("num");
        }
        closeResources();

        return count;
    }

    public List<ent> list(int num) {
        String sql="select * from ";
        return null;
    }
}
