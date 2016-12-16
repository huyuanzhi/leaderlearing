package homework2.wrapper;

import java.util.Scanner;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/14
 * @project: leaderlearing
 * @packageName: homework2.wrapper
 * @description: XXXXXX
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Operate operate = new UserOperate(input);
        System.out.println(operate.desc);
        String choice = scanner.next();
        String[] choices = choice.split(",");
        for(int i=0;i<choices.length;i++){
            switch (choices[i]){
                case "1":operate = new Encrypt(operate);break;
                case "2":operate = new Reverse(operate);break;
                case "3":operate = new UpperCase(operate);break;
                case "4":operate = new LowerCase(operate);break;
                case "5":operate = new Encrypt(operate);break;
            }
        }
        System.out.println(operate.operate());
    }
}
