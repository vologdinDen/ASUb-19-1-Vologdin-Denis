package L214;
import java.util.Scanner;

public class L214 {

    public static void main(String[] args){
        //Создаём объект класса Scanner для считывания строк
        Scanner in = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String enter_str = in.nextLine();
        //Преобразуем строку в массив
        Arr_sort a = new Arr_sort(enter_str);
        /*Тестируем конструктор копирования
        Arr_sort a_cop = new Arr_sort(a);
        String [][] result = a_cop.getArr();
        System.out.println("Результат копирования:" + String.join(" ", result[0]));
        Тестируем конструктор по умолчанию
        Arr_sort a_po = new Arr_sort();
        result = a_po.getArr();
        System.out.println("Результат конструктора по умолчанию:" + String.join(" ", result[0]));*/
        //Сортируем массив по длине слов
        a.sort();
        System.out.print("\nВведите текст: ");
        String text = in.nextLine();
        B_task b = new B_task(text);
        /*Проверяем копирование
        B_task b_cop = new B_task(b);
        String res = b_cop.getStr();
        System.out.println("Результат копирования:" + res);
        Проверяем по умолчанию
        B_task b_op = new B_task();
        res = b_op.getStr();
        System.out.println("Результат констурктора по умолачнию:" + res);*/
        //Проверяем каждый элемент строки
         byte count = b.counter();
         if (count != 0) {
             System.out.println("Кол-во предложений:" + count);
         }
         else{
             System.out.println("Нет предложений");
         }
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
        String [][] ready_arr = new String[2][text_arr.length];
        for(byte i = 0; i < text_arr.length; i++){
            ready_arr[0][i] = text_arr[i];
            ready_arr[1][i] = Integer.toString(text_arr[i].length());
        }
        a.setArr(ready_arr);
        a.sort();
        in.close();
    }
}
