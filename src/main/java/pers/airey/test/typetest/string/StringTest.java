package pers.airey.test.typetest.string;

/**
 * Created by Airey on 2016/8/28.
 */
public class StringTest {
    static  void testAllocate() {
        System.out.println("start testAllocate");
        String str1 = "Hello";   // in stack  java7 字符串常量是在堆中
        //java 7 在JVM字符串常量池中的所有字符串如果在应用中没有被引用都会被gc
        String str2 = "Hello";   // in stack  same as str1
        System.out.println(str1 == str2); //true 1

        String str3 = new String ("Hello"); //in heap  //如果没有 "Hello" 在常量池中 也会创建一个"Hello"在常量池中
                                            //所以最多创建了两个常量池
        System.out.println(str3 == str1); //false 2

        String str4 = new String ("Hello"); //in heap not same as str3
        System.out.println(str4 == str3); //false 3

        String str5 = "Hel" + "lo";  //same as str1. 编译期确定
        System.out.println(str5 == str1); //true  4

        String lo = "lo";
        String str6 = "Hel" + lo;  // 编译期不能确定
        System.out.println(str6 == str1); //false 5

        String str7 = str3.intern(); //intern() 返回常量池中的字符串， 没有会在常量池中新建
        System.out.println(str7 == str1); //true 7
        System.out.println(str3 == str1); //true 8  //intern() 不影响字字符串本身

        System.out.println("end testAllocate");
    }

    static void testConcat() {
        System.out.println("start testConcat");
        String str1 = new String("Hello");  //
        //String str1 = "Hello"; //same
        String str2 = str1;
        str1 += " World!";
        System.out.println(str1 == str2);  //false  会创建新的String  java 认为String 共享大于修改
        //实际上是通过StringBuilder  所以尽量使用StringBuilder进行拼接 直接拼接性能差  还会产生大量的String对象
        System.out.println("end testConcat");
    }

    static void testToString() { //why?  //据说是JVM优化了
        System.out.println("start testToString");
        Integer i = new Integer(4);
        String s1 = new String(i.toString()); //看代码显示 Integer.ToString 调用的是方式
                                              // String(char[] value, boolean share) 生成的是共享的String
        //String s2 = s1.intern();
        System.out.println(s1 == s1.intern());//true
       // System.out.println(s1 == s2);//true
        System.out.println("end testToString");

        //Boolean：(全部缓存)
        //Byte：(全部缓存)
        //Character(<= 127缓存)
        //Short(-128 — 127缓存)
        //Long(-128 — 127缓存)
        //Float(没有缓存)
        //Doulbe(没有缓存)
    }

    public static void main(String[] args) {
        //testAllocate();
        //testConcat();
        testToString();
    }
}
