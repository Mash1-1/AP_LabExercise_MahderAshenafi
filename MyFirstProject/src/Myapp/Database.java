package Myapp;
import University.Student;
import University.Teacher;
import org.postgresql.jdbc2.ArrayAssistant;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection createConnection() {
        try {
            // Create driver
            Class.forName("org.postgresql.Driver");
            // Create a connection
            String url = "jdbc:postgresql://localhost:5432/JavaPractice";
            return DriverManager.getConnection(url, "postgres", "6915");
        } catch (Exception e) {
            System.out.println("Error when connecting to database : " + e.getMessage());
        }
        return null;
    }

    public void insertTeacher(ArrayList<Teacher> teachers, Connection con) {
        try {
            Statement stmt = con.createStatement();
            for (Teacher t : teachers) {
                stmt.execute("INSERT INTO \"Teacher\" (id, department, name) VALUES ('" + t.id + "', '"+ t.department +"', '"+ t.name +"')");
            }
            System.out.println("Successfully added teachers");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error when inserting teacher : " + e.getMessage());
        }
    }

    public ArrayList<Teacher> readTeachers(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from \"Teacher\"");
            ArrayList<Teacher> teachers = new ArrayList<Teacher>();
            while (rs.next()) {
                String name = rs.getString("name");
                String department = rs.getString("department");
                String id = rs.getString("id");

                teachers.add(new Teacher(name, department, id));
            }
            System.out.println("Fetched all teachers successfully");
            return teachers;
        } catch (SQLException e) {
            System.out.println("Error when fetching teachers from database : " + e.getMessage() );
        }
        return null;
    }

    public void insertStudent(ArrayList<Student> students, Connection con) {
        try {
            Statement stmt = con.createStatement();
            for (Student t : students) {
                stmt.execute("INSERT INTO \"Students\" (id, name, department, section, year) VALUES ('" + t.id + "', '"+ t.name +"', '"+ t.department +"', '"+ t.section +"', '"+ t.year +"')");
            }
            System.out.println("Successfully added students");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error when inserting students : " + e.getMessage());
        }
    }

    public ArrayList<Student> readStudents(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from \"Students\"");
            ArrayList<Student> students = new ArrayList<Student>();
            while (rs.next()) {
                String name = rs.getString("name");
                String department = rs.getString("department");
                String id = rs.getString("id");
                int year = rs.getInt("year");
                String section = rs.getString("section");
                students.add(new Student(year, name, id, department, section));
            }

            System.out.println("Fetched all students successfully");
            return students;
        } catch (SQLException e) {
            System.out.println("Error when fetching teachers from database : " + e.getMessage() );
        }
        return null;
    }

}

