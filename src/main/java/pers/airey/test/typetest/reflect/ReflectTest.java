package pers.airey.test.typetest.reflect;

import java.lang.reflect.*;

/**
 * Created by Airey on 2016/9/16.
 */
public class ReflectTest {
    static void testCreate() {
        System.out.println("start testCreate");
        try {
            Class c1 = Class.forName("pers.airey.test.typetest.reflect.Student");
            Class c2 = Student.class;
            Class c3 = (new Student("s1", "Airey")).getClass();
            Class c4 = int.class;

            System.out.println(c1.getName());
            System.out.println(c2.getName());
            System.out.println(c3.getName());
            System.out.println(c4.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("end testCreate");
    }

    static void printClass(Class c1) {
        //get name;
        String modifier = Modifier.toString(c1.getModifiers()); //使用Modifier 可以直接转换成String
        if (modifier.length() > 0)
            System.out.print(modifier + " ");
        System.out.print(c1.getName());
        Class superClass = c1.getSuperclass();
        if(superClass != null && superClass != Object.class)
            System.out.print(" extends " + superClass.getName());

        Class interfaces[] = c1.getInterfaces();
        if (interfaces.length > 0) {
            System.out.print(" impliments ");
            boolean isFirst = true;
            for (Class inter : interfaces) {
                if (isFirst) {
                    System.out.print(inter.getName());
                    isFirst = false;
                }
                else
                    System.out.print("," + inter.getName());
            }
        }

        System.out.println("\n{");

        //get field;
        for (Field field : c1.getDeclaredFields()) { //不会获得父类的属性 getFields 只能获得public的 但是能过的父类的public
            modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().getName();
            String name = field.getName();
            System.out.println(modifier + " " + type + " " + name + ";");
        }

        //get constructors;
        for (Constructor constructor : c1.getDeclaredConstructors()) {
            modifier = Modifier.toString(constructor.getModifiers());
            String name = constructor.getName();
            String type = "";
            boolean isFirst = true;
            for (Class param : constructor.getParameterTypes()) {
                if(isFirst) {
                    type += param.getName();
                    isFirst = false;
                }
                else {
                    type += ",";
                    type += param.getName();
                }
            }
            System.out.println(modifier + " " + name + "("+ type + ");");
        }

        for (Method method : c1.getDeclaredMethods()) {
            modifier = Modifier.toString(method.getModifiers());
            String name = method.getName();
            String type = "";
            boolean isFirst = true;
            for (Class param : method.getParameterTypes()) {
                if(isFirst) {
                    type += param.getName();
                    isFirst = false;
                }
                else {
                    type += ",";
                    type += param.getName();
                }
            }
            System.out.println(modifier + " " + name + "("+ type + ");");
        }

        System.out.println("}");
    }

    static void testPrintClass() {
        System.out.println("start testPrintClass");
        printClass(Student.class);
        System.out.println("end testPrintClass");
    }

    static void testField() {
        System.out.println("start testField");
        try {
            //Student s1 = Class.forName("pers.airey.test.typetest.reflect.Student").newInstance("s1", "airey"); 不能这样初始化 newInstance 不接受参数 必须提供默认构造函数
            Student s1 = new Student("s1", "airey");
            Field f = s1.getClass().getDeclaredField("id");
            f.setAccessible(true);// 不设置会丢IllegalAccessException 因为id是private
            System.out.println(f.get(s1));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("end testField");
    }

    static void testMethod() {
        System.out.println("start testMethod");
        Student s1 = new Student("s1", "airey");
        try {
            Method method = s1.getClass().getMethod("getName"); //使用getDeclaredMethod 将抛出NoSuchMethodException
            //Method method = s1.getClass().getDeclaredMethod("getName");
            System.out.println(method.invoke(s1));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("end testMethod");
    }

    static void testArrayCopy() {
        System.out.println("start testArrayCopy");
        double[] original = {1.0, 2.0, 3.0};
        System.out.println(original.getClass());
        Object newArray = arrayCopy(original, original.length);
        System.out.println(newArray.getClass()); //是相同类型 也不会是Double 没有装箱
        System.out.println("send testArrayCopy");
    }

    static Object arrayCopy(Object a, int newLength) {
        Class c1 = a.getClass();
        if (!c1.isArray()) return null;
        int len = Array.getLength(a);
        Class componetType = c1.getComponentType();
        Object newArray = Array.newInstance(componetType, newLength);//反射创建数组 通过compoentTyoe 可以保证数组类型
        System.arraycopy(a, 0, newArray, 0, Math.min(len, newLength));
        return newArray;
    }

    public static void main(String args[]) {
        //testCreate();
        //testPrintClass();
        //testField();
        //testMethod();
        testArrayCopy();
    }
}
