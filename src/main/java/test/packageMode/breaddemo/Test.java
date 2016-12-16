package test.packageMode.breaddemo;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/13
 * @project: leaderlearing
 * @packageName: test.packageMode.breaddemo
 * @description: XXXXXX
 */
public class Test {

    public static void main(String[] args) {
        Bread bread = new BaseBread();
        bread = new BeefBread(bread);
        bread = new PotatoBread(bread);
        System.out.println(bread.getName()+"==="+bread.getPrice());
    }
}
