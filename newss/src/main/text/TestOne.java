import cn.Service.ServiceDao;
import cn.entity.User;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import page.page;

import java.io.IOException;

/**
 * Created by sunbin on 2017/7/24.
 */
public class TestOne {
    public static final String name="Dog华";
    public static  final String path="sun";
    public page getPages(String ip,int port){

        RmiProxyFactoryBean bean=new RmiProxyFactoryBean();
        bean.setServiceInterface(page.class);
         String str="rmi://"+ip+":"+port+"/"+path;
         bean.setServiceUrl(str);
         bean.afterPropertiesSet();
         page pages=(page)bean.getObject();
         return pages;
    }
    @Test
    public void Test455() throws IOException {
        page sun = getPages("127.0.0.1", 50000);

       sun.page();
    }
    @Test
    public void Test45() throws IOException {
       /* BASE64Encoder encoder=new BASE64Encoder();
      String by=  encoder.encode(name.getBytes());
        System.out.println(by);
        BASE64Decoder decoder=new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(by);
        String bb=new String(bytes,"utf-8");
        System.out.println(bb);*/
        Base64 base=new Base64();
        byte[] encode = base.encode(name.getBytes());
        System.out.println(new String(encode));
        System.out.println(new String(base.decode(encode)));
        org.apache.commons.codec.binary.Base64 base2=new org.apache.commons.codec.binary.Base64();
        byte[] encode1 = base2.encode(name.getBytes());
        System.out.println(new String(encode1));
        System.out.println(new String(base2.decode(encode1)));
    }
    @Test
    public void Test4(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");

       pro pro=(pro)app.getBean("map");
        System.out.println(pro.getMap());

        pro.Show();
    }
    @Test
    public void Test3(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext01.xml");
        User user=new User();
        ServiceDao servlet =(ServiceDao) app.getBean("userService");
        servlet.show(user);


    }

    @Test
    public void Test2(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Print print=(Print)app.getBean("print");
        print.Show();


    }
    @Test
    public void Test(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=(Student)app.getBean("student");
        System.out.println(student.toString());

    }
    @Test
    public void Show(){

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        //SomeService service=(SomeService)ctx.getBean("SomeService");
       // service.setInfo("Spring");
       // service.Show();


    }
}
