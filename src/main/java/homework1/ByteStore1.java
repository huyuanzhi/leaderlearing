package homework1;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/6
 * @project: leaderlearing
 * @packageName: homework1
 * @description: XXXXXX
 */
public class ByteStore1 {

    private int[] storeIntArray;
    private int length;

    public ByteStore1(int length) {
        this.length = length;
        this.storeIntArray = new int[length+1];
    }

    public void putMyItem(int index, MyItem myItem) {
        if(index>length){
            throw new ArrayIndexOutOfBoundsException("空间不足");
        }
        System.arraycopy(storeIntArray, index, storeIntArray, index + 1,
                length - index-1);
        put(index,myItem);

    }

    public MyItem getMyItem(int index){
        int item = storeIntArray[index];
        return new MyItem((byte)(item>>16 & 0xff),(byte)(item>>8 & 0xff),(byte)(item & 0xff));
    }

    private void put(int pos,MyItem myItem){
       storeIntArray[pos] = myItem.getType()<<16 |
                            myItem.getColor()<< 8 |
                            myItem.getPrice();
    }
}
