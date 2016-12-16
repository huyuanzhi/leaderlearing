package homework2.wrapper;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/14
 * @project: leaderlearing
 * @packageName: homework2.wrapper
 * @description: XXXXXX
 */
public class UserOperate implements Operate {

    private String operateString;

    public UserOperate(String operateString) {
        this.operateString = operateString;
    }

    @Override
    public String operate() {
        return operateString;
    }

    @Override
    public String getOperateString() {
        return operateString;
    }
}
