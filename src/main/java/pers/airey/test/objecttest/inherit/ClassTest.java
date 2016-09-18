package pers.airey.test.objecttest.inherit;

/**
 * Created by Airey on 2016/9/5.
 */
public class ClassTest {
    static void testArrayError() {
        System.out.println("start testArrayError");
        Manager[] managers = new Manager[10]; //10个 null 不想C++ 调用默认构造函数
        System.out.println(managers[0] == null); //true
        Employee[] staff = managers; //数组引用
        staff[0] = new Employee("Airey", 100000, 2016, 9, 5); //staff[0]就是managers[0] 要避免类似错误
        managers[0].setBonues(10); //ERROR ArrayStoreException
        System.out.println("end testArrayError");
    }

    static void testEquals() {
        System.out.println("start testEquals");
        Manager m1 = new Manager("Airey", 100000, 2016, 9, 5);
        Manager m2 = new Manager("Airey", 100000, 2016, 9, 5);
        System.out.println(m1.equals(m2));
        System.out.println("end testEquals");
    }


    public static void main(String args[]) {
        //testArrayError();
        testEquals();
    }
}
