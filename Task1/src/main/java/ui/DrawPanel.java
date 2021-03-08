package ui;

import figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    private List<Figure> figures;

    public DrawPanel() {
        figures = new ArrayList<>();
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (figures.size() > 0)
            figures.get(figures.size() - 1).setSelected(true);
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        for (Figure figure : figures) {
            figure.draw(g);
        }
    }

    public List<Figure> getFigures() {
        return figures;
    }
}
