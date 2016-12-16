package homework2.wrapper;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/14
 * @project: leaderlearing
 * @packageName: homework2.wrapper
 * @description: XXXXXX
 */
public class Reverse implements Operate {

    private Operate operate;
    private String operateString;

    public Reverse(Operate operate) {
        this.operate = operate;
        this.operateString = operate.getOperateString();
    }

    @Override
    public String operate() {
        return reverse();
    }

    @Override
    public String getOperateString() {
        return operate();
    }

    private String reverse(){
        return new StringBuffer(operateString).reverse().toString();
    }
}
