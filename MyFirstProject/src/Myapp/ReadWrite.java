package Myapp;

import University.Student;
import University.Teacher;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite {
    public void write(ArrayList<Student> students, ArrayList<Teacher> teachers) {
        try {
            FileOutputStream fos = new FileOutputStream("student");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Student s : students) {
                oos.writeObject(s);
            }

            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error when writing student : " + e.getMessage());
        }

        try {
            FileOutputStream fos = new FileOutputStream("teacher");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Teacher t : teachers) {
                oos.writeObject(t);
            }
        } catch (IOException e) {
            System.out.println("Error when writing teacher : " + e.getMessage());
        }
    }

    public void readStudents() {
        try {
            FileInputStream fis = new FileInputStream("student");
            ObjectInput ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Student s = (Student) ois.readObject();
                    System.out.println("student " + s.getName());
                } catch (EOFException e) {
                    System.out.println("Finished reading students file!");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading Student : " + e.getMessage());
        }


    }

    public void readTeachers() {
        try {
            FileInputStream fis = new FileInputStream("teacher");
            ObjectInput ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Teacher t = (Teacher) ois.readObject();
                    System.out.println("Teacher " + t.getName());
                } catch (EOFException e) {
                    System.out.println("Finished reading teachers file!");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading Student : " + e.getMessage());
        }
    }
}
