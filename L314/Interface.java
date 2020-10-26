package L314;
import java.io.*;
import java.util.Scanner;

public class Interface {
    // Создаём все необходимые объекты заранее,чтобы не перегружать память
    private static Arr_sort_3 a = new Arr_sort_3();
    private static B_task b = new B_task();
    private static Scanner in = new Scanner(System.in);
    private static File file = new File("myFile.txt");
    private static String enter_str = new String();
    private static byte choose = -1;

    // В конструкторе создаём файл для работы и оставшиееся необходимы объекты, вызываем меню
    public Interface(){
        try{
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter(file);
            menu(fw, fr);
        }catch (IOException e){
            try {
                file.createNewFile();
            }catch (IOException ex){

            }
        }
    }
    // Создаём меню для управления программой
    private static byte menu(FileWriter fw, FileReader fr){
        // Реалезуем меню в цикле
        while (true){
            System.out.println("1. Задание a");
            System.out.println("2. Задание b");
            System.out.println("3. Задание c");
            System.out.println("0. Выйти из программы");
            choose = -1;
            while (choose == -1) {
                System.out.print("Выберете задание: ");
                try {
                    choose = Byte.parseByte(in.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели что-то не то");
                }
            }
            // Проверяем какое задание выбрал пользователь
            switch (choose){
                    case 1:
                        choose_1(fr, fw);
                        break;
                    case 2:
                        choose_2(fr, fw);
                        break;
                    case 3:
                        choose_3(fr, fw);
                        break;
                    case 0:
                        System.out.println("До встречи!");
                        in.close();
                        try {
                            fr.close();
                            fw.close();
                        }catch (IOException as){

                        }
                        return 0;
                    default:
                        System.out.println("Вы ввели что-то не то!");
                        break;
            }
        }
    }


    private static void choose_1(FileReader fr, FileWriter fw){
        //Спрашиваем способ ввода
        chiose(fr, fw);
        a.setArr(enter_str);
        a.sort();

    }
    private static void choose_2(FileReader fr, FileWriter fw){
        //Спрашиваем способ ввода
        chiose(fr, fw);
        b.setStr(enter_str);
        byte count = b.counter();
        if (count != 0) {
            System.out.println("Кол-во предложений:" + count);
        }
        else {
            System.out.println("Нет предложений");
        }
    }
    private static void choose_3(FileReader fr, FileWriter fw){
        //Спрашиваем способ ввода
        chiose(fr, fw);
        //Поиск ненужных симовлов в строке и их удоление
        enter_str = a.del(enter_str);
        //Сортируем готовую строку
        a.setArr(enter_str);
        a.sort();
    }

    private static void chiose(FileReader fr, FileWriter fw){
        //Выводим список для выбора
        System.out.println("1. Ввести вручную");
        System.out.println("2. Использовать последнее сохранённое в файл предложение");
        System.out.print("Выберите способ ввода: ");
        //Считываем выбор пользователя
        choose = Byte.parseByte(in.nextLine());
        enter_str = "";
        if (choose == 1){
            System.out.print("Введите предлжение: ");
            enter_str = in.nextLine();
            //Спршиваем, необходимо ли запомнить то, что ввёл пользователь
            System.out.println("Сохранить введённый текст в файл?");
            System.out.println("1. Сохранить\n2. Не сохарнять");
            choose = Byte.parseByte(in.nextLine());
            if (choose == 1){
                try{
                    setFile(enter_str, fw);
                }catch (IOException exe){

                }
            }
        }
        else {
            try {
                getFile(fr);
            }catch (IOException e){

            }
        }
    }

    private static void setFile(String text, FileWriter fw) throws IOException{
        //Записываем введённую строку в файл
        fw.write(text);
        fw.flush();

    }

    private static void getFile(FileReader fr) throws IOException{
        char [] chars = new char[100];
        fr.read(chars);
        //Вставляем в строку все символы из файла
        for(byte i = 0; i < chars.length; i++){
            enter_str = enter_str.concat(Character.toString(chars[i]));
        }
        //Проверяем и удаляем лишние пустые места в строке
        int k = enter_str.lastIndexOf(' ');
        while (k == enter_str.length() - 1){
            k = enter_str.lastIndexOf(' ');
            enter_str = enter_str.substring(0, enter_str.length() - 1);
        }
    }


}
