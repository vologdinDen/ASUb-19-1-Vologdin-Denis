package L314;

import java.io.*;

public class FileWork {

    final File file = new File("myFile.txt");
    private String enter_str = new String();

    public FileWork(){
        try{
            file.createNewFile();
        }catch (IOException e){

        }
    }

    public void fileSet(String text){
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.flush();
            fw.close();
        }catch (IOException e) {
            try {
                file.createNewFile();
                fileSet(text);
            }catch (IOException ex){

            }
        }
    }

    public String fileGet() throws IOException{
        try {
            FileReader fr = new FileReader(file);
            int c;
            //Вставляем в строку все символы из файла
            while((c = fr.read()) != -1) {
                enter_str = enter_str.concat(Character.toString(c));
            }
            fr.close();
        }catch (FileNotFoundException f) {
            System.out.println("Файла не существует. Создаю новый.");
            file.createNewFile();
            fileGet();
        }

        return enter_str;
    }
}
