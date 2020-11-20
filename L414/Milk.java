package L414;

import java.util.Scanner;

public class Milk extends Animals{

    private String view = "";
    private int age = 0;
    private int eat = 0;
    private Scanner in = new Scanner(System.in);
    private byte for_eat = 0;
    private byte for_age = 0;

    public Milk(){
        while (this.eat == 0) {
            try {
                System.out.println("Введите сытость:");
                this.eat = Integer.parseInt(in.nextLine());
                if (this.eat > 100 || this.eat < 0) {
                    System.out.println("Сытость не может быть меньше 0 и больше 100");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели что-то не то");

            }
        }
        while (this.age == 0) {
            try {
                System.out.println("Введите возраст:");
                this.age = Integer.parseInt(in.nextLine());
                if (this.age > 100 || this.age < 0) {
                    System.out.println("Возраст не может быть меньше 0 и больше 100");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели что-то не то");

            }
        }
        while (this.view.equals("")) {
            try {
                System.out.println("Введите вид:");
                this.view = in.nextLine();
                if (this.view.length() < 1) {
                    System.out.println("Вы ничего не ввели");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели что-то не то");

            }
        }

    }

    private void new_view(){
        String new_view = this.view;
        while (new_view.equals(this.view)){
            System.out.println("Введите новый вид: ");
            new_view = in.nextLine();
            if (new_view.length() < 1){
                System.out.println("Вы ничего не ввели");
                new_view = this.view;
            }
        }
        this.view = new_view;
    }


    public void new_year(){
        while(this.for_age == 0){
            System.out.println("Сколько лет прибавить или отнять? (чтобы отнять напишите отрицательно число)");
            this.for_age = Byte.parseByte(in.nextLine());
            if (this.for_age > (100 - this.age)) {
                System.out.println("Вы не можете добавить слишком много");
                System.out.printf("На данный момент возраст млекопитающего: %d \n", this.age);
                this.for_age = 0;
            }
        }
        this.age = this.age + this.for_age;
        this.for_age = 0;
    }

    private void eating(){
        while(this.for_eat==0) {
            try {
                System.out.println("Сколько корма?");
                this.for_eat = Byte.parseByte(in.nextLine());
                if (this.eat + this.for_eat > 100) {
                    System.out.println("Слишком много корма");
                    this.for_eat = 0;
                }
            }catch (NumberFormatException e){
                System.out.println("Вы ввели что-то не то");
            }
        }
        this.eat = this.eat + this.for_eat;
        this.for_eat = 0;
    }

    @Override
    public void changing() {
        byte choose = 0;
        while (choose == 0){
            System.out.println("Что хотите поменять?");
            System.out.println("1. Сытость");
            System.out.println("2. Возраст");
            System.out.println("3. Вид");
            System.out.println("4. Узнать параметры");
            System.out.println("5. Почистить клетку");
            System.out.println("6. Узнать немного информации.");
            System.out.println("0. Ничего(вернуться в прошлое меню)");
            try {
                choose = Byte.parseByte(in.nextLine());
                switch (choose){
                    case 1:
                        this.eating();
                        break;
                    case 2:
                        this.new_year();
                        break;
                    case 3:
                        this.new_view();
                        break;
                    case 4:
                        this.characters();
                        break;
                    case 5:
                        this.cleaning();
                        break;
                    case 6:
                        this.info();
                        break;
                    case 0:
                        choose = 5;
                        break;
                    default:
                        System.out.println("Вы ввели что-то не то");
                        choose = 0;
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Вы ввели что-то не то");
            }
        }
    }

    @Override
    public void characters(){
        System.out.printf("Возраст: %d\nСытость: %d\nВид: %s\n", this.age, this.eat, this.view);
    }

    @Override
    public void cleaning(){
        System.out.println("Чистим клетку");
        try {
            Thread.sleep(7000);
        }catch (InterruptedException e){
            System.out.println("не получилось, питчка улетела вместе с клеткой!");
        }
        System.out.println("Готово!");
    }

    @Override
    public void info(){
        System.out.println("Млекопитающие — класс позвоночных животных, основной отличительной особенностью которых является вскармливание детёнышей молоком. Класс входит в кладу синапсид надкласса четвероногих. \nПо оценкам биологов, известно до 5500 современных видов млекопитающих, среди которых — и вид Человек разумный; общее же число видов млекопитающих, включая вымершие, превышает 20 000.");
    }
}
