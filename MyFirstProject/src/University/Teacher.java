package University;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;

public class Teacher implements Serializable{
    public String id, name, department;

    public Teacher(String name, String department, String id) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Student> readStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            FileInputStream fis = new FileInputStream("student");
            ObjectInput ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Student s = (Student) ois.readObject();
                    students.add(s);
                } catch (EOFException e) {
                    System.out.println("Finished reading students file from Teacher method 'ReadStudents' !");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading Student in teacher method 'ReadStudents' : " + e.getMessage());
        }
        return students;
    }

    @Override
    public String toString() {
        return "ID : " + this.id + " | Name : " + this.name + " | Department : " + this.department;
    }
}
