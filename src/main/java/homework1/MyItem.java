package homework1;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/6
 * @project: leaderlearing
 * @packageName: homework1
 * @description: XXXXXX
 */
public class MyItem {

    private byte type;
    private byte color;
    private byte price;

    public MyItem(byte type, byte color, byte price) {
        this.type = type;
        this.color = color;
        this.price = price;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getColor() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
    }

    public byte getPrice() {
        return price;
    }

    public void setPrice(byte price) {
        this.price = price;
    }
}
