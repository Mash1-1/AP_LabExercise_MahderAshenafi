package University;

import java.io.Serializable;

public class Student implements Serializable {
    public String id, name, department, section;
    public  int year;

    public Student(int year, String name, String id, String department, String section) {
        this.name = name;
        this.year = year;
        this.department = department;
        this.section = section;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "ID : " + this.id + " | Name : " + this.name + " | Department : " + this.department + " | Section : " + this.section + " | Year" + this.year;
    }
}
