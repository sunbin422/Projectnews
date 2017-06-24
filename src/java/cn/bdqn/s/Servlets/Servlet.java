package cn.bdqn.s.Servlets;

import cn.bdqn.s.dao.Igoods;
import cn.bdqn.s.dao.Impl.goodsImpl;
import cn.bdqn.s.entity.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sunbin on 2017/6/16.
 */
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("UTF-8");
     response.setCharacterEncoding("UTF-8");
     response.setContentType("UTF-8");
        Igoods goodss=new goodsImpl();
        try {
            List<goods>list=null;
            int pageIndex=1;

                String name=  request.getParameter("name");
                if("undefined".equals(name)){

                    name="";
                }
                  String num=request.getParameter("type");
                  int num2=0;
            System.out.println(name);
                  if(null!=num){
                      num2=Integer.parseInt(num);

                  }

            if(null==request.getParameter("pageindex")) {

                list=goodss.PageList(name,num2,pageIndex,3);

            }else{

                pageIndex = Integer.parseInt(request.getParameter("pageindex"));
                System.out.println(pageIndex);
                list=goodss.PageList(name,num2,pageIndex,3);
            }
            int count= goodss.count(name,num2);
            count =count%3==0?count/3:count/3+1;

            request.setAttribute("count",count);
          request.setAttribute("name",name);
          request.setAttribute("type",num2);
            request.setAttribute("list",list);
            request.setAttribute("pageIndex",pageIndex);
            request.getRequestDispatcher("MyJsp.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


           doPost(request,response);

    }
}
