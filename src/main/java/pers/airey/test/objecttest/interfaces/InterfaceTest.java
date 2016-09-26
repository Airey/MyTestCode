package pers.airey.test.objecttest.interfaces;

import org.junit.Test;
import pers.airey.test.objecttest.inherit.Employee;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Airey on 2016/9/21.
 */
public class InterfaceTest {
    @Test
    public void testCompare1() {
        Employee[] employees = new Employee[] {new Employee("Airey3", 300000, 2016, 9, 21), new Employee("Airey", 100000, 2016, 9, 21), new Employee("Airey2", 200000, 2016, 9, 21)};
        assertTrue(employees[0].getName().equals("Airey3"));
        Arrays.sort(employees);
        assertTrue(employees[0].getName().equals("Airey"));
    }

    @Test
    public void testCompare2() {
        Employee[] employees = new Employee[] {new Employee("Airey3", 300000, 2016, 9, 21), new Employee("Airey", 100000, 2016, 9, 21), new Employee("Airey2", 200000, 2016, 9, 21)};
        assertTrue(employees[0].getName().equals("Airey3"));
        Arrays.sort(employees, new EmployeeComparator());
        assertTrue(employees[0].getName().equals("Airey"));
    }

    @Test
    public void testInterfaceField() {
        System.out.println(ITest.test);
        //ITest.test = 4; 不能修改是final
    }

    @Test
    public void testInterfaceClass() {
        ITest.StaticClass staticClass = new ITest.StaticClass(); //是个静态类
        staticClass.test();
    }
}
