package L314;

public class Arr_sort_3 {


    private String [][] enter_arr;

    public Arr_sort_3(String enter_str){
        String[] enter_pre_arr = enter_str.split(" ");
        this.enter_arr = new String[2][enter_pre_arr.length];
        for (byte i = 0; i < enter_pre_arr.length; i ++){
            this.enter_arr[0][i] = enter_pre_arr[i];
            this.enter_arr[1][i] = Integer.toString(enter_pre_arr[i].length());
        }

    }

    public Arr_sort_3(Arr_sort_3 cop){
        this.enter_arr = cop.enter_arr;
    }

    public Arr_sort_3(){
        this.enter_arr = new String[2][2];
        this.enter_arr[0][0] = "Test";
        this.enter_arr[0][1] = "string";
        this.enter_arr[1][0] = "4";
        this.enter_arr[1][1] = "6";
    }

    public void setArr(String enter_str){
        String[] enter_pre_arr = enter_str.split(" ");
        this.enter_arr = new String[2][enter_pre_arr.length];
        for (byte i = 0; i < enter_pre_arr.length; i ++){
            this.enter_arr[0][i] = enter_pre_arr[i];
            this.enter_arr[1][i] = Integer.toString(enter_pre_arr[i].length());
        }
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
        System.out.println();
    }

    public String del(String enter_str){
        for (int i = 0; i < enter_str.length(); i++) {
            if (enter_str.charAt(i) == '.' || enter_str.charAt(i) == '!' || enter_str.charAt(i) == '?' || enter_str.charAt(i) == ',') {
                enter_str = enter_str.substring(0, i) + " " + enter_str.substring(i + 1, enter_str.length());
            }
        }
        return enter_str;
    }

}
