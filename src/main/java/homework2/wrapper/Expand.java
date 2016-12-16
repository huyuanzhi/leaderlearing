package homework2.wrapper;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/14
 * @project: leaderlearing
 * @packageName: homework2.wrapper
 * @description: XXXXXX
 */
public class Expand implements Operate {

    private Operate operate;
    private String operateString;

    public Expand(Operate operate) {
        this.operate = operate;
        this.operateString = operate.getOperateString();
    }

    @Override
    public String operate() {
        return expand();
    }

    @Override
    public String getOperateString() {
        return operate();
    }

    private String expand(){
        String temp=operateString;
        for(int i=0;i<((10-operateString.length())<0?0:10-operateString.length());i++){
            temp+="!";
        }
        return temp.substring(0,10);
    }
}
