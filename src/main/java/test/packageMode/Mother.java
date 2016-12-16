package test.packageMode;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/13
 * @project: leaderlearing
 * @packageName: test.packageMode
 * @description: XXXXXX
 */
public class Mother implements Work {
    private Work work;

    public Mother(Work work) {
        this.work = work;
    }

    @Override
    public void paint() {
        System.out.println("妈妈正在为画上色");
        work.paint();
        System.out.println("妈妈已经为画上好了色");
    }
}
