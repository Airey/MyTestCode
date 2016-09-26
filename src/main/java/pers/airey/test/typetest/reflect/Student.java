package pers.airey.test.typetest.reflect;

/**
 * Created by Airey on 2016/9/15.
 */
public class Student extends Human implements ILeanring{

    private String id;

    public Student(String id, String name) {
        super(name);
        this.id = id;
    }

    public String getId() {
        return id;
    }

     public void learning() {
        System.out.println("start to learning");
    }
}
