package L514;

public class B_task {

    private String  text;

    public B_task(){
        this.text = "Test. Test? Test!";
    }

    public B_task(B_task te){
        this.text = te.text;
    }

    public B_task(String text){
        this.text = text;
    }

    public void setStr(String text){
        this.text = text;
    }

    public String getStr(){
        return this.text;
    }

    public byte counter(){
        byte number_str = 0;
        for (int i = 0; i < this.text.length(); i++){
            if (this.text.charAt(i) == '.' || this.text.charAt(i) == '!' || this.text.charAt(i) == '?') {
                number_str++;
            }
        }
        return number_str;
    }
}
