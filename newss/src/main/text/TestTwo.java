import auto.IsomeServices;
import cns.entity.category;
import dj.entity.classesInfo;
import dj.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * Created by sunbin on 2017/7/24.
 */
public class TestTwo {
    @Test
    public void Test7() throws IOException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext07.xml");
        IUserService cateservice = (IUserService)app.getBean("userService");
        int list=cateservice.login("123123","123123");

        IUserService cateservice1 = (IUserService)app.getBean("listService");
        List<classesInfo> list1=cateservice1.list();
        for (classesInfo item:list1
                ) {
            System.out.println(item.getClassName());
        }
    }
    @Test
    public void Test6() throws IOException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext06.xml");
        cns.service.ICateService cateservice = (cns.service.ICateService)app.getBean("cateservice");
        List<category> list=cateservice.list();
        for (category item:list
             ) {
            System.out.println(item.getCname());
        }
    }
    @Test
    public void Test5() throws IOException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext05auto.xml");
        Aspectj.IsomeServices iSomeServices = (Aspectj.IsomeServices)app.getBean("ISomeServices");
        iSomeServices.show();
        iSomeServices.three();
        iSomeServices.Two();
    }
    @Test
    public void Test2() throws IOException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext04auto.xml");
        Aspectj.IsomeServices iSomeServices = (Aspectj.IsomeServices)app.getBean("ISomeServices");
        iSomeServices.show();
        iSomeServices.three();
        iSomeServices.Two();
    }
    @Test
    public void Test1() throws IOException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext03auto.xml");
        IsomeServices iSomeServices = (IsomeServices)app.getBean("ISomeServices");
        iSomeServices.show();
        iSomeServices.three();
        iSomeServices.Two();
    }
    @Test
    public void Test455() throws IOException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext02auto.xml");
        IsomeServices iSomeServices = (IsomeServices)app.getBean("ISomeServices");
        iSomeServices.show();
        iSomeServices.three();
        iSomeServices.Two();
    }
}
