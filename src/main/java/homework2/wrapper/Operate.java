package homework2.wrapper;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/14
 * @project: leaderlearing
 * @packageName: homework2.wrapper
 * @description: XXXXXX
 */
public interface Operate {
    String desc = "1 ：加密\n" +
            "2 ：反转字符串\n" +
            "3：转成大写\n" +
            "4：转成小写\n" +
            "5：扩展或者剪裁到10个字符，不足部分用！补充\n" +
            "6:用户输入 任意组合，比如 1，3 表示先执行1的逻辑，再执行3的逻辑";
    String operateString = "default";
    String operate();
    String getOperateString();
}
