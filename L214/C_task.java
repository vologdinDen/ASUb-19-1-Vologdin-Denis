package L214;
import java.util.Arrays;
import java.util.Comparator;

public class C_task {

    private String str;

    public C_task(){
        this.str = "Test,string.for!testing?program";
    }

    public C_task(C_task str){
        this.str = str.str;
    }

    public  C_task(String str){
        this.str = str;
    }

    public void Setter(String str){
        this.str = str;
    }

    public String Getter(){
        return this.str;
    }

    public void sort_c(){
        this.str = this.str.replaceAll(",", " ");
        this.str = this.str.replaceAll("\\.", " ");
        this.str = this.str.replaceAll("!", " ");
        this.str = this.str.replaceAll("\\?", " ");
        String[] str_arr = this.str.split(" ");
        Arrays.sort(str_arr, Comparator.comparing(String::length));
        System.out.print("Отсортированная строка: ");
        for (byte i = 0; i < str_arr.length; i++){
            System.out.print(str_arr[i] + " ");
        }
    }
}
