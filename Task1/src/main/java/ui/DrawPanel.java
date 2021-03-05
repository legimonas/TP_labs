package ui;

import figures.Figure;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    private List<Figure> figures;

    public DrawPanel(){
        figures = new ArrayList<>();
    }


}
