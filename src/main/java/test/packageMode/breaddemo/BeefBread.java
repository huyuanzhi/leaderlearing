package test.packageMode.breaddemo;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/13
 * @project: leaderlearing
 * @packageName: test.packageMode.breaddemo
 * @description: XXXXXX
 */
public class BeefBread implements Bread {

    private Bread bread;

    public BeefBread(Bread bread) {
        this.bread = bread;
    }

    @Override
    public int getPrice() {
        return bread.getPrice()+15;
    }

    @Override
    public String getName() {
        return bread.getName()+"+牛肉";
    }
}
