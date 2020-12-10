package L514;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame {

    protected JComboBox<String> choose_task_ComboBox;
    protected JTextField input_sentence_TextField;
    protected JButton do_task_Button;
    protected JMenuItem save_Button;
    protected JMenuItem load_Button;
    protected JFileChooser file_Chooser;
    protected JLabel result_sentence_TextLabel;

    public MainFrame() {
        // Инициализация окна
        super("Лабораторная работа №5");
        this.setSize(400, 300);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));

        // Инициализация меню бара
        var menuBar = new JMenuBar();
        var menu = new JMenu("File");
        save_Button = new JMenuItem("Save");
        load_Button = new JMenuItem("Load");
        var exitButton = new JMenuItem("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        menu.add(save_Button);
        menu.add(load_Button);
        menu.add(exitButton);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        file_Chooser = new JFileChooser();
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new FlowLayout());

        // Инициализация компонентов ввода
        String[] choices = {"1 Задание (Сортировка строки)", "2 Задание (Количество предложений)", "3 Задание (Удаление лишних символов и сотрировка строки)"};
        choose_task_ComboBox = new JComboBox<>(choices);
        choose_task_ComboBox.setPreferredSize(new Dimension(390, 24));
        input_sentence_TextField = new JTextField();
        input_sentence_TextField.setPreferredSize(new Dimension(277, 24));
        var inputSentenceTextLabel = new JLabel("Предложение: ");

        var resultSentenceLabel = new JLabel("Результат: ");
        result_sentence_TextLabel = new JLabel("нет результата!");

        do_task_Button = new JButton("Решить задание");

        // Добавление компонентов в панели
        fieldsPanel.add(choose_task_ComboBox);
        fieldsPanel.add(inputSentenceTextLabel);
        fieldsPanel.add(input_sentence_TextField);
        fieldsPanel.add(do_task_Button);
        resultPanel.add(resultSentenceLabel);
        resultPanel.add(result_sentence_TextLabel);

        // Добавление компонентов в окно
        this.add(fieldsPanel, 0);
        this.add(resultPanel, 1);
    }

    // Валидация полей ввода
    public boolean validateFields() {
        if (input_sentence_TextField.getText().isEmpty()) {
            return false;
        }
        return true;
    }
}
