package test;

import java.io.Serializable;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/9
 * @project: leaderlearing
 * @packageName: test
 * @description: XXXXXX
 */
public class Handler<T extends Thread> {

    private T t;

    public Handler(T t) {
        this.t = t;
    }



    private T getT(){
        return t;
    }


    public static void main(String[] args) {
        User u = new User();
        System.out.println(u instanceof Serializable);

    }
}
