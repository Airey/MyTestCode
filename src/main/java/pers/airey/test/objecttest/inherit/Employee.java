package pers.airey.test.objecttest.inherit;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Airey on 2016/9/5.
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new GregorianCalendar(year, month - 1, day).getTime();
    }

    public String getName() {
        return name;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        System.out.println("Test: " + getClass());
        if (o == null || getClass() != o.getClass()) return false; // 不能使用instanceof 违反交换性
        Employee employee = (Employee) o;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return hireDay != null ? hireDay.equals(employee.hireDay) : employee.hireDay!= null;
    }

    @Override
    public int hashCode() {
        int result;
        int temp;
        result = name != null ? name.hashCode() : 0;
        temp = (new Double(salary)).hashCode();
        result = 31 * result + temp;
        result = 31 * result + (hireDay != null ? hireDay.hashCode() : 0);
        return result;
    }

    //    public int getTest() {
//        return 0;
//    }

    public Employee getBuddy() {
        return this;
    }
}
