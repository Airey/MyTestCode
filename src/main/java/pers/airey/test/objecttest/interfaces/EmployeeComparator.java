package pers.airey.test.objecttest.interfaces;

import pers.airey.test.objecttest.inherit.Employee;

import java.util.Comparator;

/**
 * Created by Airey on 2016/9/21.
 */
public class EmployeeComparator implements Comparator<Employee> {
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}
