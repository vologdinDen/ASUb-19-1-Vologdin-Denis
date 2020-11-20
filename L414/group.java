package L414;

import java.util.ArrayList;
import java.util.Scanner;

public class group {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Animals> animal = new ArrayList<>();
        byte choose = -1;
        while(choose != 0){
            System.out.println("Выберите что хотите сделать:");
            System.out.println("1. Создать птицу");
            System.out.println("2. Создать парнокопытное");
            System.out.println("3. Создать млекопитающее");
            System.out.println("4. Перейти к управлению объектами");
            System.out.println("0. Выйти из программы");
            choose = Byte.parseByte(in.nextLine());
            switch (choose){
                case 1:
                    animal.add(new Bird());
                    break;
                case 2:
                    animal.add(new Art());
                    choose = -1;
                    break;
                case 3:
                    animal.add(new Milk());
                    break;
                case 4:
                    control(animal, in);
                    choose = -1;
                    break;
                case 0:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Вы ввели что-то не то");
                    break;
            }

        }

    }


    public static void control(ArrayList<Animals>animal, Scanner in){
        byte choose = 0;
        while(choose == 0) {
            System.out.printf("Сейчас имеется объектов - %d, какой хотите поменять?\n", animal.toArray().length);
            try {
                choose = Byte.parseByte(in.nextLine());
                choose--;
                if (choose > animal.toArray().length){
                    System.out.println("Вы ввели что-то не то");
                    choose = 0;
                }
                else{
                    animal.get(choose--).changing();
                    choose = -1;
                }
            }catch (NumberFormatException e){
                System.out.println("Вы ввели что-то не то!");
            }

        }

    }
}
