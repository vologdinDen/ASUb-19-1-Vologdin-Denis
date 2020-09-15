package L114;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class L114 {

    public static void main(String[] args){
        //Создаём объект класса Scanner для считывания строк
        Scanner in = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String enter_str = in.nextLine();
        //Преобразуем строку в массив
        String [] enter_ar = enter_str.split(" ");
        //Сортируем массив по длине слов
        Arrays.sort(enter_ar, Comparator.comparing(String::length));
        System.out.print("Слова отсортированные по их длине: ");
        //Выводим полученный массив
        for (String str_out : enter_ar) {
            System.out.print(str_out + " ");
        }
        System.out.print("\n Введите текст: ");
        String text = in.nextLine();
        int number_str = 0;
        //Проверяем каждый элемент строки
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?'){
                number_str ++;
            }
        }
        if (number_str != 0) System.out.printf("Кол-во предложений в тексте: %d \n", number_str);
        else System.out.print("Предложений нет \n");
        System.out.print("Введите строку: ");
        text = in.nextLine();
        //Поиск ненужных симовлов в строке и их удоление
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?' || text.charAt(i) == ','){
                text = text.substring(0, i) + " " +text.substring(i + 1, text.length());
            }
        }
        //Из готовой строки делаем массив и сортируем слова в нём
        String [] text_arr = text.split(" ");
        Arrays.sort(text_arr, Comparator.comparing(String::length));
        System.out.print("Отсортированная строка: ");
        //Вывод отсортированной строки
        for (String str_out : text_arr) {
            System.out.print(str_out + " ");
        }
        in.close();
    }
}
