package Aspectj;



/**
 * Created by sunbin on 2017/8/2.
 */
public class ISomeService implements IsomeServices {

    public void show() {
        System.out.println("呵呵");
    }

    public void Two() {
        System.out.println("哈哈");
    }

    public int three() {
        System.out.println("嘻嘻");
        return 1;
    }
}
