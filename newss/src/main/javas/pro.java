import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;

/**
 * Created by sunbin on 2017/7/26.
 */
@Component("pro")
public class pro {
    @Value("一个人")
    private String name;
    public void Show(){
        System.out.println(name);
    }
    private Properties properties;
    private Map<String,String> map;
    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}


