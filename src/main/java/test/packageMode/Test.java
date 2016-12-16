package test.packageMode;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/13
 * @project: leaderlearing
 * @packageName: test.packageMode
 * @description: XXXXXX
 */
public class Test {

    public static void main(String[] args) {

        Work work = new Son();
        work.paint();
        System.out.println("===========================");

        work = new Mother(work);
        work.paint();
        System.out.println("===========================");

        work = new Father(work);
        work.paint();


    }
}
