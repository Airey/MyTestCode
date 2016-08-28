package pers.airey.test.typetest.basictype;

/**
 * Created by Airey on 2016/8/28.
 */
public class BasicTypeTest {
    static void testIntegerAdd() {
        System.out.println("start testIntegerAdd");
        Integer i1 = 10;
        Integer i2 = i1;
        System.out.println(i1 == i2); //true
        i1 += 10;   //虽然是引用  但加会改变指向
        System.out.println(i1 == i2); //false
        System.out.println("end testIntegerAdd");
    }

    static void testIntegerCache() {
        System.out.println("start testIntegerCache");
        Integer i1 = 10;
        Integer i2 = 5;
        System.out.println(i1 == i2); //false
        i1 -= i2;
        System.out.println(i1 == i2); //true

        Integer i3 = 10000;
        Integer i4 = 5000;
        System.out.println(i3 == i4); //false
        i3 -= i4; //i3 == 5000
        System.out.println(i3 == i4); //false //所以不能使用 == 判断相等  上面返回true是因为Integer中的cache
        System.out.println(i3.equals(i4)); //true

        System.out.println("end testIntegerCache");
    }

    public static void main(String[] args) {
        //testIntegerAdd();
        testIntegerCache();
    }
}
