package ui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class MainWindow extends JFrame {
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
        addItem.addActionListener(e -> {
            CreateFigureDialog d = new CreateFigureDialog(this);
            if (d.getFigure() != null) {
                List<Figure> figures = drawPanel.getFigures();
                if (figures.size() > 0)
                    figures.get(figures.size() - 1).setSelected(false);
                drawPanel.addFigure(d.getFigure());
            }
        });

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    System.out.println("Q");
                    List<Figure> figures = getDrawPanel().getFigures();
                    if (figures.size() > 0) {
                        Figure figure = figures.get(figures.size() - 1);
                        figure.setSelected(false);
                        figures.remove(figures.size() - 1);
                        figures.add(0, figure);
                        drawPanel.repaint();
                    }
                }
            }
        });
        menuBar.add(figuresMenu);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        setVisible(true);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        new MainWindow();
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }
}
