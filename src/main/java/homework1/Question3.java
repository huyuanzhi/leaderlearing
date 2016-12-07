package homework1;

import java.util.Arrays;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/11/16
 * @project: leaderlearing
 * @packageName: homework1
 * @description: XXXXXX
 */
public class Question3 {


    public static void main(String[] args) {
       MyItem myItem = new MyItem((byte)11,(byte)15,(byte)16);
       ByteStore1 byteStore1 = new ByteStore1(100);
       byteStore1.putMyItem(10,myItem);
        MyItem o = byteStore1.getMyItem(10);
        System.out.println(o.getPrice());
    }

    //冒泡排序
    public static void bubbleSort(Salary[] salaries){
        Salary temp ;
        for(int i=0;i<salaries.length;i++){
            for(int j=0;j<salaries.length-i-1;j++){
                if(salaries[j].getCompareFiled()>salaries[j+1].getCompareFiled()){
                    temp = salaries[j];
                    salaries[j] = salaries[j+1];
                    salaries[j+1] = temp;
                }
            }
        }
    }
    //快速排序
    public static void quickSort(Salary[] salaries, int start, int end) {
        if (start < end) {
            Salary base = salaries[start];
            Salary temp;
            int i = start, j = end;
            do {
                while ((salaries[i].getCompareFiled() < base.getCompareFiled()) && (i < end))
                    i++;
                while ((salaries[j].getCompareFiled() > base.getCompareFiled()) && (j > start))
                    j--;
                if (i <= j) {
                    temp = salaries[i];
                    salaries[i] = salaries[j];
                    salaries[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(salaries, start, j);
            if (end > i)
                quickSort(salaries, i, end);
        }
    }

    public static void q1() {
        byte b = 127;
        //byte bb = b<<2;在进行位移操作时除long类型外,其他类型都会自动转化为int,b<<2其实得到的是一个int类型值,必须强转位byte
        byte bb = (byte) (b << 2);
        System.out.println(bb);
    }

    public static void q2() {
        int a = -1024;//1000 0000 0000 0000 0000 0100 0000 0000
        //1111 1111 1111 1111 1111 1011 1111 1111 (取反-反码,符号位不变)
        //1111 1111 1111 1111 1111 1100 0000 0000 (加1-补码)
        System.out.println(a >> 1);//1111 1111 1111 1111 1111 1110 0000 0000 (有符号右移一位,高位用1补)
        //1000 0000 0000 0000 0000 0001 1111 1111 (取反-反码,符号位不变)
        //1000 0000 0000 0000 0000 0010 0000 0000 (加1-补码,结果-512)
        System.out.println(a >>> 1);//0111 1111 1111 1111 1111 1110 0000 0000 (无符号右移一位,高位用0补,结果为2147483136)
    }

    public static void q4(){
        Salary[] salaries = new Salary[100];
        Arrays.setAll(salaries, value -> new Salary());
        Arrays.sort(salaries, (o1, o2) -> o2.getCompareFiled().compareTo(o1.getCompareFiled()));
        for(int i=0;i<10;i++){
            System.out.println(salaries[i].getName()+"--"+salaries[i].getCompareFiled());
        }
    }


    public static void countByHang(byte b[][]) {
        long current = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 10240; i++) {
            for (int j = 0; j < 10240; j++) {
                sum += b[i][j];
            }
        }
        long future = System.currentTimeMillis();
        System.out.println("行排序耗时" + (future - current));
    }

    public static void countByLie(byte b[][]) {
        long current = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 10240; i++) {
            for (int j = 0; j < 10240; j++) {
                sum += b[j][i];
            }
        }
        long future = System.currentTimeMillis();
        System.out.println("列排序耗时" + (future - current));
    }
}
