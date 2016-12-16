package test.packageMode;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/13
 * @project: leaderlearing
 * @packageName: test.packageMode
 * @description: XXXXXX
 */
public class Father implements Work {

    private Work work;

    public Father(Work work) {
        this.work = work;
    }

    @Override
    public void paint() {
        System.out.println("爸爸正在为画上相框");
        work.paint();
        System.out.println("爸爸已经为画上好了相框");
    }
}
