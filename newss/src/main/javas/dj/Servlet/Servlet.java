package dj.Servlet;

import com.google.gson.Gson;
import dj.entity.attendanceInfo;
import dj.entity.classesInfo;
import dj.entity.studentInfo;
import dj.service.IUserService;
import dj.utils.FreemarkerUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunbin on 2017/8/11.
 */
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         FreemarkerUtil free=new FreemarkerUtil();

        request.getRequestDispatcher("utf-8");
        response.setCharacterEncoding("utf-8");
        if("login".equals(request.getParameter("action"))){

            WebApplicationContext applicationContext= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
            IUserService service=(IUserService)applicationContext.getBean("userService");
            String user=request.getParameter("user");
            String pwd=request.getParameter("pwd");
            System.out.println(11);
            int num=service.login(user,pwd);
            if(num>0) {
                System.out.println("=========================");
                Map<String ,Object> map=new HashMap<String, Object>();
                Gson gson=new Gson();
                String li=gson.toJson("11");
                request.setAttribute("li", li);

                //JSONArray jso n=JSONArray.fromObject(object)js
                PrintWriter out=response.getWriter();

                out.write(li);

            }
            else {
                Gson gson=new Gson();
                String li=gson.toJson("账号密码错误");
                request.setAttribute("li", li);

                //JSONArray jso n=JSONArray.fromObject(object)js
                PrintWriter out=response.getWriter();

                out.write(li);

            }

        }else if("yes".equals(request.getParameter("action"))){
            Template template = free.getTemplate("mains.html", getServletContext());
            WebApplicationContext applicationContext= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
            IUserService service=(IUserService)applicationContext.getBean("listService");
            List<classesInfo> list=service.list();

            Map<String ,Object> map=new HashMap<String, Object>();
            map.put("list",list);
            try {
                template.process(map,response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }


        }else  if("listren".equals(request.getParameter("action"))){
           int num=Integer.parseInt(request.getParameter("cid"));
            Template template = free.getTemplate("mainss.html", getServletContext());
            WebApplicationContext applicationContext= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
            IUserService service=(IUserService)applicationContext.getBean("listrenService");
            List<studentInfo> list=service.listren(num);

            Map<String ,Object> map=new HashMap<String, Object>();
            map.put("lists",list);
            try {
                template.process(map,response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }


        }else if("insert".equals(request.getParameter("action"))){
            String p=request.getParameter("at");
            System.out.println(p);
            String[] split = p.split(",");
            int [] num=new int[10];
            Template template = free.getTemplate("mainsss.html", getServletContext());
            WebApplicationContext applicationContext= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
            IUserService service=(IUserService)applicationContext.getBean("insert");
           for (int i=0;i<split.length;i++) {
               if (split[i] != null & split[i].length() > 0) {
                   System.out.println(split[i].substring(0, 1));
                   num[i] = Integer.parseInt(split[i].substring(0, 1));
                   split[i] = split[i].substring(1, 2);
                   System.out.println(num[i] + "===" + split[i]);
                   if (split[i].equals("s")) {
                       split[i] = "事假";
                   } else if (split[i].equals("c")) {
                       split[i] = "出勤";
                   } else if (split[i].equals("w")) {
                       split[i] = "未出勤";
                   } else if (split[i].equals("b")) {
                       split[i] = "病假";
                   }
                   service.insert(num[i], new Date(), split[i]);

               }
           }

            Map<String ,Object> map=new HashMap<String, Object>();

            try {
                template.process(map,response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }else if("select".equals(request.getParameter("action"))){
            Template template = free.getTemplate("min.html", getServletContext());
            WebApplicationContext applicationContext= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
            IUserService service=(IUserService)applicationContext.getBean("insert");
            String data=request.getParameter("select");
            System.out.println(data);
            java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<attendanceInfo> lists=null;
            try {
                Date date =  formatter.parse(data);
                System.out.println(date);
             lists = service.lists(date);
                for (attendanceInfo item:lists
                     ) {
                   item.setTime(sdf.format(item.getAttendancetime()));
                   item.setStudentName(item.getStudentInfo().getStudentName());
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
            Map<String ,Object> map=new HashMap<String, Object>();
            map.put("lists",lists);
            try {
                template.process(map,response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}
