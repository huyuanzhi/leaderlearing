package homework2.wrapper;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/14
 * @project: leaderlearing
 * @packageName: homework2.wrapper
 * @description: XXXXXX
 */
public class UpperCase implements Operate {

    private Operate operate;
    private String operateString;

    public UpperCase(Operate operate) {
        this.operate = operate;
        this.operateString = operate.getOperateString();
    }

    @Override
    public String operate() {
        return toUpperCase();
    }

    @Override
    public String getOperateString() {
        return operate();
    }

    private String toUpperCase(){
        return operateString.toUpperCase();
    }
}
