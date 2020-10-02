package L214;

public class Arr_sort {


    private String [][] enter_arr;

    public Arr_sort(String enter_str){
        String[] enter_pre_arr = enter_str.split(" ");
        this.enter_arr = new String[2][enter_pre_arr.length];
        for (byte i = 0; i < enter_pre_arr.length; i ++){
            this.enter_arr[0][i] = enter_pre_arr[i];
            this.enter_arr[1][i] = Integer.toString(enter_pre_arr[i].length());
        }

    }

    public Arr_sort(Arr_sort cop){
        this.enter_arr = cop.enter_arr;
    }

    public Arr_sort(){
        this.enter_arr = new String[2][2];
        this.enter_arr[0][0] = "Test";
        this.enter_arr[0][1] = "string";
        this.enter_arr[1][0] = "4";
        this.enter_arr[1][1] = "6";
    }

    public void setArr(String [][] str){
        this.enter_arr = str;
    }

    public String [][] getArr(){
        return this.enter_arr;
    }

    public void sort(){
        for (int i = 0; i < this.enter_arr[0].length; i++){
            for(int j = 0; j < this.enter_arr[0].length - 1; j++){
                if (Integer.parseInt(this.enter_arr[1][j]) > Integer.parseInt(this.enter_arr[1][j + 1])){
                    String prosh = this.enter_arr[0][j + 1];
                    String prosh2 = this.enter_arr[1][j + 1];
                    this.enter_arr[0][j + 1] = this.enter_arr[0][j];
                    this.enter_arr[1][j + 1] = this.enter_arr[1][j];
                    this.enter_arr[0][j] = prosh;
                    this.enter_arr[1][j] = prosh2;
                }
            }
        }
        System.out.print("Слова отсортированные по их длине: ");
        for (byte i = 0; i < this.enter_arr[0].length; i++) {
            System.out.print(this.enter_arr[0][i] + " ");
        }
    }

}
