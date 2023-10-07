package model;
import java.util.*;

public class EmployeeInfo {

    private final int id;
    private final String name;
    private final float salary;
    private final String job;

    public EmployeeInfo(int id, String name, float salary, String job) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.job = job;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" + "id=" + id + ", name=" + name + ", salary=" + salary + ", job="+ job +"}\n";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public float getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }

}
