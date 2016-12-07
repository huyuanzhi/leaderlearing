package homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/6
 * @project: leaderlearing
 * @packageName: homework1
 * @description: XXXXXX
 */
public class ByteStore {

    private byte[] storeByteArray;
    private int length;

    public ByteStore(int length) {
        this.length = length;
        this.storeByteArray = new byte[length+3];
    }

    public void putMyItem(int index, MyItem myItem) {
        int pos = 3*index;
        if(index>length){
           throw new ArrayIndexOutOfBoundsException("空间不足");
        }
        System.arraycopy(storeByteArray, pos, storeByteArray, pos + 3,
                length - pos - 3);
        put(pos,myItem);

    }

    public MyItem getMyItem(int index){
        int pos = 3*index;
        return new MyItem(storeByteArray[pos],storeByteArray[pos+1],storeByteArray[pos+2]);
    }

    private void put(int pos,MyItem myItem){
        storeByteArray[pos] = myItem.getType();
        storeByteArray[++pos] = myItem.getColor();
        storeByteArray[++pos] = myItem.getPrice();
    }

}
