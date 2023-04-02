package main.java.thread;

/**
 * @author zhanghuihui
 * @Date 2022/11/20 21:49
 * @Description
 */

public class User {

private String name;
private String  id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
