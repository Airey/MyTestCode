package pers.airey.test.objecttest.innerclass;

/**
 * Created by Administrator on 2016/9/21.
 */
public class OuterClass {
    private String privatefield = "OuterClass";
    InnerClass inner = new InnerClass();

    public void testAccessInnerClassPrivate() {
        System.out.println( inner.privatefieldInner);//也可以访问innerClass的室友变量
    }

    class InnerClass { //嵌套类会保有外部类的一个指针 所以能访问
        private String privatefieldInner = "InnerClass";
        void testAccessOuterClassPrivate() {
            System.out.println(privatefield);//能够访问室友成员 原理是OuterClass 会生成access$0函数 用来给内部类访问field0
        }
    }

    private class InnerClassPrivate {  //外部无法新建
        void testAccessOuterClassPrivate() {
            System.out.println(privatefield);
        }
    }

    public void testInnerClassLocal() {
        final String tip = "cool I can read!";
        class InnerClassLocal { //局部内部类  不能带访问符 因为只在该函数内可见
            void test() {
                System.out.println(privatefield); //同样能访问OuterClass
                System.out.println("InnerClassLocal");
                System.out.println(tip); //能够访问final 因为创建了内访问final
            }
        }

        InnerClassLocal innerClassLocal = new InnerClassLocal();
        innerClassLocal.test();
    }

    public void testAnonymousInnerClassLocal() {
        final String tip = "cool I can read!";
        InnerClass innerClass = new InnerClass()  //匿名内部类  没有名字所以不可能有自己的构造函数
            //equals 会出问题 因为类型不一样了
        {
            void testAccessOuterClassPrivate() {
                super.testAccessOuterClassPrivate();
                System.out.println(tip); //能够访问final 因为创建了内访问final
            }
        };
        innerClass.testAccessOuterClassPrivate();
    }

    static class StaticInnerClass { //静态内部类
        void testStaticInnerClass() {
            //System.out.println(privatefield); //静态的不能访问
            System.out.println("StaticInnerClass");
        }
    }
}
