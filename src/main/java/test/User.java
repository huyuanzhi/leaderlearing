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
public class User implements Serializable {

    private String username;
    private Integer age;
    private char sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
