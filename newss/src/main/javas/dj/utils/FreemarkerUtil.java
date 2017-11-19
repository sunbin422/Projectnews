package dj.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Created by sunbin on 2017/7/14.
 */
public class FreemarkerUtil {
    public Template getTemplate(String name,ServletContext getServletContext){
        try {

            //通过Freemarker的Configuration读取相应的ftl
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);//这里是对应的你使用jar包的版本号：<version>2.3.23</version>
            configuration.setDefaultEncoding("UTF-8");
          // configuration.setDirectoryForTemplateLoading("SuperMarket",""); //如果是maven项目可以使用这种方式
           /// configuration.setClassForTemplateLoading("SuperMarket", "");

            configuration.setServletContextForTemplateLoading(getServletContext,"html");

            Template template = configuration.getTemplate(name);

            return template;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }





}
