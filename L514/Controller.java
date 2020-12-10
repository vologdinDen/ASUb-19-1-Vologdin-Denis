package L514;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controller {

    private final MainFrame main_Frame = new MainFrame();
    private int taskChosen = 1;
    private File file;
    private boolean isThereAnyFrames = false;

    public Controller() {

        main_Frame.setVisible(true);

        Arr_sort_3 arr = new Arr_sort_3();
        B_task task_b = new B_task();
        boolean exit = true;
        // Меню выбора задания
        main_Frame.choose_task_ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                taskChosen = main_Frame.choose_task_ComboBox.getSelectedIndex() + 1;
            }
        });


        // Добавляем действие кнопки "Решить задание"
        main_Frame.do_task_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!main_Frame.validateFields()) {
                    createDialog(main_Frame, "Поле пустое!", 150);
                    return;
                }
                switch (taskChosen) {
                    case 1: {
                        main_Frame.result_sentence_TextLabel.setText(" ");
                        String sentence = main_Frame.input_sentence_TextField.getText();
                        arr.setArr(sentence);
                        arr.sort();
                        main_Frame.result_sentence_TextLabel.setText(arr.getArr());
//                        System.out.println(arr.getArr());
                        break;
                    }
                    case 2: {
                        String sentence = main_Frame.input_sentence_TextField.getText();
                        task_b.setStr(sentence);
                        main_Frame.result_sentence_TextLabel.setText(String.valueOf(task_b.counter()));
//                        System.out.println(task_b.counter(););
                        break;
                    }
                    case 3: {
                        main_Frame.result_sentence_TextLabel.setText(" ");
                        String sentence = main_Frame.input_sentence_TextField.getText();
                        sentence = arr.del(sentence);
                        arr.setArr(sentence);
                        arr.sort();
                        main_Frame.result_sentence_TextLabel.setText(arr.getArr());
//                        System.out.println(arr.getArr());
                    }
                }
            }
        });

        // действие кнопки сохранения
        main_Frame.save_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main_Frame.file_Chooser.showSaveDialog(null);
                file = main_Frame.file_Chooser.getSelectedFile();
                if (main_Frame.input_sentence_TextField.getText().isEmpty()) {
                    createDialog(main_Frame, "Поле пустое!", 150);
                    return;
                }
                SaveLoad.task_File(file.getAbsolutePath(), main_Frame.input_sentence_TextField.getText());
            }
        });

        // Действие кнопки загрузки
        main_Frame.load_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main_Frame.file_Chooser.showOpenDialog(null);
                file = main_Frame.file_Chooser.getSelectedFile();
                main_Frame.input_sentence_TextField.setText(SaveLoad.task_FileRead(file.getAbsolutePath()));
            }
        });
    }

    //    Создание диалогового окна
    private void createDialog(JFrame mainFrame, String text, int width) {
        final JDialog temp = new JDialog(mainFrame, "Ошибка");
        temp.add(new JLabel(text));
        temp.setLayout(new FlowLayout());
        JButton okBtn = new JButton("Ok");
        temp.add(okBtn);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                isThereAnyFrames = false;
                temp.dispose();
            }
        });
        temp.setLocationRelativeTo(mainFrame);
        temp.setLocation(temp.getX() - width / 2, temp.getY() - 50);
        temp.setSize(width, 90);
        temp.setVisible(true);
    }

}
