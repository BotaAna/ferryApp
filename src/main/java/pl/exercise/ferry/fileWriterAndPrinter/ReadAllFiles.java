package pl.exercise.ferry.fileWriterAndPrinter;

import java.io.*;
import java.util.Scanner;

public class ReadAllFiles {

    Scanner scanner = new Scanner(System.in);
    String pathName = "D:/Java-programowanie 2/projekty/Baza";
    File directory = new File(pathName);

    public void readDirectory() throws FileNotFoundException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                readFiles(file);
            }
        }
    }

    public void readFiles(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new FileReader(file));
        String line = "";
        while (fileScanner.hasNextLine()) {
            line += fileScanner.nextLine();
            System.out.println(line);
        }
        fileScanner.close();
    }
}