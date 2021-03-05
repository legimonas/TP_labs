package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    private JPanel drawPanel;
    private JButton createFigureButton;

    public MainWindow() {
        super("lab1");
        setLayout(new BorderLayout());
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        createFigureButton.addActionListener(e -> {
            CreateFigureDialog d = new CreateFigureDialog();

        });

        add(createFigureButton, BorderLayout.NORTH);


        setBounds(100, 100, 700, 400);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MainWindow();
    }
}
