package test.packageMode.breaddemo;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/13
 * @project: leaderlearing
 * @packageName: test.packageMode.breaddemo
 * @description: XXXXXX
 */
public class BaseBread implements Bread {

    @Override
    public int getPrice() {
        return 8;
    }

    @Override
    public String getName() {
        return "面包";
    }
}
