package zetthard.lesson11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) throws IOException {
        File file1 = new File("/Users/semennikolaev/github/ITMOJavaFirstProject/src/zetthard/lesson11/testFile.txt");
        File file2 = new File("src/zetthard/lesson11/fromStr.txt");
        File file3 = new File("src/zetthard/lesson11/copyTestFile.txt");
        File file4 = new File("src/zetthard/lesson11/printWriterFile.txt");

        //11.1 test
        System.out.println(stringList(file1));

        //11.2 test
        //writeString(file2, "New string has been written");

        //11.4 test
        //System.out.println(copyFile(file1, file3));

        //11.3 test
        //System.out.println(mergeFiles(file3, file4));

        //11.5 test
        for (File file :
                findFiles("src/zetthard/lesson11", "TEST")) {
            System.out.println(file.getName());
        }
    }

    //11.1
    public static List<String> stringList(File file) {
        List<String> result = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                result.add(sc.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(file.getPath() + "\n" + fnfe.getMessage());
        }
        return result;
    }

    //11.2
    public static void writeString(File file, String str) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        writer.write(str + "\n");
        writer.close();
    }

    //11.4
    public static boolean copyFile(File input, File output) throws IOException {
        FileWriter writer = new FileWriter(output); //or PrintWriter can be used instead
        boolean ans = false;
        try (BufferedReader bReader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = bReader.readLine()) != null) {
                writer.write(line + "\n");
            }
            ans = true;
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
        finally {
            writer.close();
        }
        return ans;
    }

    //11.3
    public static boolean mergeFiles(File toFile, File fromFile) {
        try (FileWriter writer = new FileWriter(toFile, true)) {
            for (String str :
                    stringList(fromFile)) {
                writer.write(str + "\n");
            }
            return true;
        } catch (IOException ioe) {
            System.out.println("Unable to write file.");
            return false;
        }
    }

    //11.5
    //according to problem description method should return list
    public static File[] findFiles(String dir, String key) {
        class MyFileFilter implements FilenameFilter {
            private final String key;

            public MyFileFilter(String key) {
                this.key = key.toLowerCase();
            }

            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().contains(key);
            }
        }
        File file = new File(dir);
        return file.listFiles(new MyFileFilter(key));
    }
}
