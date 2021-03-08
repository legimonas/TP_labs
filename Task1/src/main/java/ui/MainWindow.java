package ui;

//import com.formdev.flatlaf.FlatIntelliJLaf;
//import com.formdev.flatlaf.FlatLightLaf;

import figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class MainWindow extends JFrame {
    private DrawPanel drawPanel;
    private JMenuBar menuBar;


    public MainWindow() {
        super("Main window");
        setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

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

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Q) {
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

        addKeyListener(new KeyAdapter() {
            public void move(int keyCode) {
                List<Figure> figures = getDrawPanel().getFigures();
                if (figures.size() == 0) return;
                Figure selectedFigure = figures.get(figures.size() - 1);
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        selectedFigure.move(-20, 0);
                        break;
                    case KeyEvent.VK_UP:
                        selectedFigure.move(0, -20);
                        break;
                    case KeyEvent.VK_RIGHT:
                        selectedFigure.move(20, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        selectedFigure.move(0, 20);
                        break;
                }
                drawPanel.repaint();
            }

            @Override
            public void keyTyped(KeyEvent e) {
                move(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                move(e.getKeyCode());
            }
        });

        menuBar.add(figuresMenu);

        setFocusable(true);
        requestFocusInWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        //   UIManager.setLookAndFeel(new FlatIntelliJLaf());
        new MainWindow();
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }
}
