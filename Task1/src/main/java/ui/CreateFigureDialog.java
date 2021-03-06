package ui;

import figures.Figure;
import figures.FiguresConstants;
import oneD.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class CreateFigureDialog extends JDialog {
    private JPanel editPanel;
    private JPanel buttonsPanel;

    private Figure figure;
    Color fillColor = FiguresConstants.STANDARD_COLOR;
    Color borderColor = FiguresConstants.STANDARD_COLOR;
    private JComboBox figuresComboBox;
    private String[] figuresNames;
    private JTextField point1TextField;
    private JTextField point2TextField;
    private JTextField pointsTextField;
    private JTextField amountOfAgesTextField;
    private JButton addButton;
    private JButton borderColorButton;
    private JButton fillColorButton;

    public CreateFigureDialog(){
        setTitle("Add figure");
        setModal(true);
        figuresNames = new String[]{
                "Line",
                "Ray",
                "Section",
                "Circle",
                "Ellipse",
                "Polygon",
                "Rectangle",
                "Regular Polygon",
                "Rhombus"
        };
        figuresComboBox = new JComboBox(figuresNames);
        point1TextField = new JTextField();
        point2TextField = new JTextField();
        pointsTextField = new JTextField();
        amountOfAgesTextField = new JTextField();


        addButton = new JButton("Add");
        borderColorButton = new JButton("Border Color");
        fillColorButton = new JButton("Fill Color");

        editPanel = new JPanel();
        buttonsPanel = new JPanel();

        setLayout(new BorderLayout());
        add(figuresComboBox, BorderLayout.NORTH);
        editPanel.setLayout(new GridLayout(2, 2));
        editPanel.add(new JLabel("Point 1: "));
        editPanel.add(point1TextField);
        editPanel.add(new JLabel("Point 2: "));
        editPanel.add(point2TextField);
        editPanel.setVisible(true);


        editPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(editPanel, BorderLayout.CENTER);

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(borderColorButton);
        buttonsPanel.add(addButton);

        add(buttonsPanel, BorderLayout.SOUTH);

        createChangeEditPanelListener();
        addCreateFigureEventListener();
        addColorChoosers();
        updateButtonsIcons();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(150, 150);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pack();
        setVisible(true);
    }

    public Figure getFigure(){
        return figure;
    }

    private void createChangeEditPanelListener(){
        figuresComboBox.addActionListener(e->{
            //TODO: modify edit panel for each figure
            String selectedItem = (String) figuresComboBox.getSelectedItem();
            switch (Objects.requireNonNull(selectedItem)){
                case "Line":
                    editPanel.removeAll();
                    editPanel.setLayout(new GridLayout(2, 2));
                    editPanel.add(new JLabel("Point 1: "));
                    editPanel.add(point1TextField);
                    editPanel.add(new JLabel("Point 2: "));
                    editPanel.add(point2TextField);
                    buttonsPanel.remove(fillColorButton);
                    pack();
                    editPanel.revalidate();
                    buttonsPanel.revalidate();
                    break;
                case "Ray":
                    //TODO
                    break;
                case "Section":
                    //TODO
                    break;
                case "Circle":
                    //TODO
                    break;
                case "Ellipse":
                    //TODO
                    break;
                case "Polygon":
                    editPanel.removeAll();
                    editPanel.setLayout(new GridLayout(1, 2));
                    editPanel.add(new JLabel("Enter points, separated by space or \",\": "));
                    editPanel.add(pointsTextField);
                    buttonsPanel.remove(addButton);
                    buttonsPanel.add(fillColorButton);
                    buttonsPanel.add(addButton);
                    pack();
                    editPanel.revalidate();
                    buttonsPanel.revalidate();
                    break;
                case "Rectangle":
                    //TODO
                    break;
                case "Regular Polygon":
                    //TODO
                    break;
                case "Rhombus":
                    //TODO
                    break;

            }
        });
    }

    private void addCreateFigureEventListener(){
        addButton.addActionListener(e->{
            String selectedItem = (String) figuresComboBox.getSelectedItem();
            switch (Objects.requireNonNull(selectedItem)) {
                case "Line":
                    String pointAString = point1TextField.getText();
                    String pointBString = point2TextField.getText();
                    String[] coordsA = pointAString.split("[ ,]");
                    Point pointA = new Point(Integer.parseInt(coordsA[0]), Integer.parseInt(coordsA[1]));
                    String[] coordsB = pointBString.split("[ ,]");
                    Point pointB = new Point(Integer.parseInt(coordsB[0]), Integer.parseInt(coordsB[1]));
                    figure = new Line(pointA, pointB, borderColor);
                    break;
                case "Ray":
                    //TODO
                    break;
                case "Section":
                    //TODO
                    break;
                case "Circle":
                    //TODO
                    break;
                case "Ellipse":
                    //TODO
                    break;
                case "Polygon":
                    //TODO
                    break;
                case "Rectangle":
                    //TODO
                    break;
                case "Regular Polygon":
                    //TODO
                    break;
                case "Rhombus":
                    //TODO
                    break;
            }
            dispose();
        });
    }

    private void addColorChoosers(){
        borderColorButton.addActionListener(e->{
            borderColor = JColorChooser.showDialog(
                    this,
                    "Choose border color",
                    FiguresConstants.STANDARD_COLOR
            );
            updateButtonsIcons();
        });
        fillColorButton.addActionListener(e->{
            fillColor = JColorChooser.showDialog(
                    this,
                    "Choose fill color",
                    FiguresConstants.STANDARD_COLOR
            );
            updateButtonsIcons();
        });
    }

    private void updateButtonsIcons(){
        BufferedImage borderColorImage = new BufferedImage(15, 15, BufferedImage.TYPE_INT_ARGB);
        Graphics g = borderColorImage.getGraphics();
        g.setColor(borderColor);
        g.fillRect(0, 0, borderColorImage.getWidth(), borderColorImage.getHeight());
        ImageIcon borderColorButtonIcon = new ImageIcon(borderColorImage);
        borderColorButton.setIcon(borderColorButtonIcon);

        BufferedImage fillColorImage = new BufferedImage(15, 15, BufferedImage.TYPE_INT_ARGB);
        g = fillColorImage.getGraphics();
        g.setColor(fillColor);
        g.fillRect(0, 0, fillColorImage.getWidth(), fillColorImage.getHeight());
        ImageIcon fillColorButtonIcon = new ImageIcon(fillColorImage);
        fillColorButton.setIcon(fillColorButtonIcon);
    }

}
