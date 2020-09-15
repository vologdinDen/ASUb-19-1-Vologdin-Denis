package L214;
import java.util.Scanner;

public class L214 {

    public static void main(String[] args){
        //Создаём объект класса Scanner для считывания строк
        Scanner in = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String enter_str = in.nextLine();
        //Преобразуем строку в массив
        A_task a = new A_task(enter_str);
        //Сортируем массив по длине слов
        a.sort();
        System.out.print("\n Введите текст: ");
        String text = in.nextLine();
        B_task b = new B_task(text);
        //Проверяем каждый элемент строки
        b.counter();
        System.out.print("Введите строку: ");
        text = in.nextLine();
        //Поиск ненужных симовлов в строке и их удоление
        C_task c = new C_task(text);
        //Из готовой строки делаем массив и сортируем слова в нём
        c.sort_c();
        in.close();
    }
}
