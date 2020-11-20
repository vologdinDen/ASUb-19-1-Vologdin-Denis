package L414;

import java.util.Scanner;

public class Bird extends Animals {

    final Scanner in = new Scanner(System.in);
    private int eat = 0;
    private int age = 0;
    private byte for_eat = 0;
    private byte for_age = 0;

    public Bird(){
        while(this.eat == 0){
            System.out.print("Введите сытость: ");
            this.eat = Byte.parseByte(in.nextLine());
            if(this.eat > 100 || this.eat < 0){
                System.out.println("Сытость не может превышать 100, или быть меньше 0");
                this.eat = 0;
            }
        }
        while(this.age == 0){
            System.out.print("Введите возраст: ");
            this.age = Byte.parseByte(in.nextLine());
            if(this.age < 0 || this.age > 15){
                System.out.println("Вы ввели что-то не так");
                this.age = 0;
            }
        }
    }

    private void new_year(){
        while(this.for_age == 0){
            System.out.println("Сколько лет прошло?");
            this.for_age = Byte.parseByte(in.nextLine());
            if (this.for_age < 0 || this.for_age > (15 - this.age)) {
                System.out.println("Вы не можете не прибавить год, или добавить слишком много");
                System.out.printf("На данный момент возраст птицы: %d \n", this.age);
                this.for_age = 0;
            }
        }
        this.age = this.age + this.for_age;
        this.for_age = 0;

    }

    private void eating(){
        while(this.for_eat == 0){
            System.out.println("Сколько корма?");
            this.for_eat = Byte.parseByte(in.nextLine());
            if( this.for_eat > (100 - this.eat)){
                System.out.println("Вы не можете дать слишком много корма");
                System.out.printf("На данный момент сытость составляет: %d\n", this.eat);
                this.for_eat = 0;
            }
        }
        this.eat = this.eat + for_eat;
        this.for_eat = 0;
    }
    @Override
    public void characters(){
        System.out.printf("Сытость %d\n", this.eat);
        System.out.printf("Возраст %d\n", this.age);
    }

    @Override
    public void changing(){
        byte choose = 0;
        while (choose == 0){
            System.out.println("Что хотите поменять?");
            System.out.println("1. Сытость");
            System.out.println("2. Возраст");
            System.out.println("3. Узнать параметры");
            System.out.println("4. Почистить клетку");
            System.out.println("5. Узнать немного информации");
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
                        this.characters();
                        break;
                    case 4:
                        this.cleaning();
                        break;
                    case 5:
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
    public void cleaning(){
        System.out.println("Чистим клетку");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println("не получилось, питчка улетела вместе с клеткой!");
        }
        System.out.println("Готово!");
    }

    @Override
    public void info(){
        System.out.println("Птицы — группа теплокровных яйцекладущих позвоночных животных, традиционно рассматриваемая в ранге отдельного класса. \nХорошо обособлена от остальных групп современных животных. \nОдин из наиболее характерных признаков — покров из перьев, предохраняющий тело от неблагоприятных изменений температуры и играющий важную роль при полёте. \nСпособность к полёту — главнейшая особенность птиц. \nПередние конечности приобрели форму крыльев. Птицы обладают особым строением органов дыхания и пищеварения, что тесно связано с их способностью летать. \nЕщё один отличительный признак птиц — наличие клюва.");
    }
}
