package L214;

public class B_task {

    private String  text;

    public B_task(){
        this.text = "Test. Test? Test!";
    }

    public B_task(B_task te){
        this.text = te.text;
    }

    public B_task(String te){
        this.text = te;
    }

    public void Setter(String str){
        this.text = str;
    }

    public String Getter(){
        return this.text;
    }

    public void counter(){
        byte number_str = 0;
        for (int i = 0; i < this.text.length(); i++){
            if (this.text.charAt(i) == '.' || this.text.charAt(i) == '!' || this.text.charAt(i) == '?') {
                number_str++;
            }
        }
        if (number_str != 0) System.out.print("Кол-во предложений в тексте: " + number_str + "\n");
        else System.out.print("Предложений нет \n");
    }
}
