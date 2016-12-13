package test.packageMode;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/13
 * @project: leaderlearing
 * @packageName: test.packageMode
 * @description: XXXXXX
 */
public class PhotoCircle implements Album {

    private Album album;

    public PhotoCircle(Album album) {
        this.album = album;
    }

    @Override
    public String memory() {
        return "用相框包起来更好保存,记忆更持久";
    }
}
