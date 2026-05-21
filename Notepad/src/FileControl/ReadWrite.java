package FileControl;

import java.io.*;

public class ReadWrite {
    public int writeToFile(String s, File file) {
        try (BufferedWriter bw =  new BufferedWriter(new FileWriter(file));) {
            System.out.println("Writing to file " + file.getName());
            bw.write(s);
            return 1;
        } catch (Exception e) {
            System.out.println("Error when writing to file : " + e.getMessage());
        }
        return -1;
    }

    public String readFromFile(File file) {
        {
            try (BufferedReader br = new BufferedReader(new FileReader(file));) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }

                return sb.toString();
            } catch (FileNotFoundException e) {
                System.out.println("File Not found error when reading from file : " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error when reading file : " + e.getMessage());
            }
        return "";
        }
    }
}
