package test.packageMode.breaddemo;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/13
 * @project: leaderlearing
 * @packageName: test.packageMode.breaddemo
 * @description: XXXXXX
 */
public class PotatoBread implements Bread {

    private Bread bread;

    public PotatoBread(Bread bread) {
        this.bread = bread;
    }

    @Override
    public int getPrice() {
        return bread.getPrice()+5;
    }

    @Override
    public String getName() {
        return bread.getName()+"+土豆";
    }
}
