package pers.airey.test.objecttest.innerclass;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/21.
 */
public class InnerClassTest {

    @Test
    public void testAccessPrivate() {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(); //只能通过outerClass 新建
        outerClass.testAccessInnerClassPrivate();
        innerClass.testAccessOuterClassPrivate();
    }

    @Test
    public void testCreatePrivateInnerClass() {
        OuterClass outerClass = new OuterClass();
        //OuterClass.InnerClassPrivate innerClass = OuterClass.new InnerClassPrivate(); //无法新建
    }

    @Test
    public void testInnerClassLocal() {
        OuterClass outerClass = new OuterClass();
        outerClass.testInnerClassLocal();
    }

    @Test
    public void testAnonymousInnerClassLocal() {
        OuterClass outerClass = new OuterClass();
        outerClass.testAnonymousInnerClassLocal();
    }

    @Test
    public void testAnonymousInnerClassLocal2() {
        ArrayList<String> test = new ArrayList<String>(){{add("test11"); add("test2");}}; //使用匿名内部类和代码段一句话初始化array
        System.out.println(test.toString());
    }

    @Test
    public void testStaticInnerClass() {
        OuterClass.StaticInnerClass staicInnerClass= new OuterClass.StaticInnerClass(); //不依赖OuterClass的实例 OuterClass只相当于命名空间
        staicInnerClass.testStaticInnerClass();
    }
}
