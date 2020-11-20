package L414;

public class Art extends Milk {

    @Override
    public void cleaning(){
        System.out.println("Чистим клетку");
        try {
            Thread.sleep(9000);
        }catch (InterruptedException e){
            System.out.println("не получилось, парнокопытное ушло вместе с клеткой!");
        }
        System.out.println("Готово!");
    }

    @Override
    public void info(){
        System.out.println("Парнокопытные, или парнопалые — парафилетическая группа плацентарных млекопитающих. \nНасчитывает примерно 220 современных видов, из которых некоторые, особенно из семейства полорогих, имеют большое экономическое значение для человека.");
    }

}
