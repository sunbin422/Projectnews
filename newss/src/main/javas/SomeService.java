/**
 * Created by sunbin on 2017/7/24.
 */
public class SomeService {
    private String info;

    public SomeService() {
        System.out.println("123123123");
    }

    public void Show(){
        System.out.println("Hello"+info);

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
