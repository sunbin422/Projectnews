package conn.Servlet;

import conn.entity.category;
import conn.service.ICateService;
import conn.util.FreemarkerUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunbin on 2017/8/7.
 */
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FreemarkerUtil free=new FreemarkerUtil();
        Template template = free.getTemplate("one.html", getServletContext());
        Map<String ,Object> map=new HashMap<String, Object>();
        request.getRequestDispatcher("utf-8");
        response.setCharacterEncoding("utf-8");

        WebApplicationContext applicationContext= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());

        ICateService cateService= (ICateService)applicationContext.getBean("bookService");
        List<category> list=cateService.lists(1);
       map.put("list",list);
        try {
            template.process(map,response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
