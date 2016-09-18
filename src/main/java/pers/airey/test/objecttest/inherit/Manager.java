package pers.airey.test.objecttest.inherit;

import pers.airey.test.objecttest.inherit.Employee;

/**
 * Created by Airey on 2016/9/5.
 */
public class Manager extends Employee {
    private double bonues;
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonues = 0;
    }

    public double getBonues() {
        return bonues;
    }

    public void setBonues(double bonues) {
        this.bonues = bonues;
    }

    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;  //父类 getClass() 返回的是子类

        Manager manager = (Manager) o;

        return Double.compare(manager.bonues, bonues) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(bonues);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //    public double getTest() { //错误 虽然返回类型不属于签名的一部分，但必须是返回类型派生类
//        return 0.0;
//    }

    public Manager getBuddy() {//这种情况 返回类型可以不同
        return this;
    }
}
