package L514;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Модуль сохранения/загрузки
class SaveLoad {

    public static String task_FileRead(String filename) {
        boolean checkForEx = false;
        while (!checkForEx) {
            try {
                checkForEx = true;
                Scanner sc = new Scanner(new FileReader(filename));
                String str = sc.nextLine();
                sc.close();
                return str;
            } catch (IOException e) {
                checkForEx = false;
                System.out.println("Невозможно найти файл!");
            }
        }
        return "Стандартная настройка";
    }

    public static void task_File(String filename, String stringSave) {
        boolean checkForEx = false;
        while (!checkForEx) {
            try {
                checkForEx = true;
                FileWriter fw;
                fw = new FileWriter(filename, false);
                fw.write(stringSave);
                fw.close();
            }
            catch (IOException e) {
                checkForEx = false;
                System.out.println("Файл с таким названием не создать!");
            }
        }
    }
}
