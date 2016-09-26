package pers.airey.test.objecttest.interfaces;

/**
 * Created by Administrator on 2016/9/21.
 */
public interface ITest {
    int test = 3; //接口中的属性会转换为 static final public

    class StaticClass { //默认是 static public
        void test() {
            System.out.println("i am a static calss");
        }
    }
}
