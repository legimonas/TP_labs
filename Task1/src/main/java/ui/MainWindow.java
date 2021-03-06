package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    private DrawPanel drawPanel;
    private JButton createFigureButton;
    private JMenuBar menuBar;


    public MainWindow() {
        super("lab1");
        setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
        createFigureButton = new JButton("add figure");

        JMenu figuresMenu = new JMenu("Figures");
        JMenuItem addItem = new JMenuItem("Add");
        figuresMenu.add(addItem);
        addItem.addActionListener(e->{
            CreateFigureDialog d = new CreateFigureDialog();
            if(d.getFigure() != null)
                drawPanel.addFigure(d.getFigure());
        });


        menuBar.add(figuresMenu);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
