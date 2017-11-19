import bdqn.entity.exception;
import dj.entity.attendanceInfo;
import dj.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by sunbin on 2017/7/24.
 */
public class TestThree {
    @Test
    public void Test7() throws IOException, exception {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext07.xml");
        IUserService cateservice = (IUserService)app.getBean("data");
        List<attendanceInfo> lists = cateservice.lists(new Date());

        for (attendanceInfo item:lists
             ) {
            System.out.println(item.getStudentInfo().getStudentName());
        }



    }

}
