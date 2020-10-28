package L314;
import java.io.*;
import java.util.Scanner;

public class Interface {
    // Создаём все необходимые объекты заранее,чтобы не перегружать память
    private static Arr_sort_3 a = new Arr_sort_3();
    private static B_task b = new B_task();
    private static Scanner in = new Scanner(System.in);
    private static String enter_str = new String();
    private static byte choose = -1;
    private static FileWork forfile = new FileWork();

    // В конструкторе создаём файл для работы и оставшиееся необходимы объекты, вызываем меню
    public Interface(){
        menu();
    }


    // Создаём меню для управления программой
    private static byte menu(){
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
                        choose_1();
                        break;
                    case 2:
                        choose_2();
                        break;
                    case 3:
                        choose_3();
                        break;
                    case 0:
                        System.out.println("До встречи!");
                        in.close();
                        return 0;
                    default:
                        System.out.println("Вы ввели что-то не то!");
                        break;
            }
        }
    }


    private static void choose_1(){
        //Спрашиваем способ ввода
        chiose();
        a.setArr(enter_str);
        a.sort();

    }
    private static void choose_2(){
        //Спрашиваем способ ввода
        chiose();
        b.setStr(enter_str);
        byte count = b.counter();
        if (count != 0) {
            System.out.println("Кол-во предложений:" + count);
        }
        else {
            System.out.println("Нет предложений");
        }
    }
    private static void choose_3(){
        //Спрашиваем способ ввода
        chiose();
        //Поиск ненужных симовлов в строке и их удоление
        enter_str = a.del(enter_str);
        //Сортируем готовую строку
        a.setArr(enter_str);
        a.sort();
    }

    private static void chiose(){
        //Выводим список для выбора
        choose = 0;
        //Считываем выбор пользователя
        while (choose != 1 && choose != 2) {
            try {
                System.out.println("1. Ввести вручную");
                System.out.println("2. Использовать последнее сохранённое в файл предложение");
                System.out.print("Выберите способ ввода: ");
                choose = Byte.parseByte(in.nextLine());
                if(choose != 1 && choose != 2) {
                    System.out.println("Вы ввели что-то не то!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели что-то не то!");
            }
        }
        enter_str = "";
        if (choose == 1){
            System.out.print("Введите предлжение: ");
            enter_str = in.nextLine();
            //Спршиваем, необходимо ли запомнить то, что ввёл пользователь
            System.out.println("Сохранить введённый текст в файл?");
            System.out.println("1. Сохранить\n2. Не сохарнять");
            choose = Byte.parseByte(in.nextLine());
            if (choose == 1){
                forfile.fileSet(enter_str);
            }
        }
        else {
            try {
                enter_str = forfile.fileGet();
            }catch (IOException e){
                System.out.println("Что-то пошло не так");
            }
        }
    }

}
