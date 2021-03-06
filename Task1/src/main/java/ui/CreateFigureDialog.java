package ui;

import ellipses.Circle;
import ellipses.Ellipse;
import figures.Figure;
import figures.FiguresConstants;
import oneD.Line;
import oneD.Ray;
import oneD.Section;
import polygons.Polygon;
import polygons.Rectangle;
import polygons.RegularPolygon;
import polygons.Rhombus;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    private JTextField point3TextField;
    private JTextField pointsTextField;
    private JTextField amountOfAgesTextField;
    private JButton addButton;
    private JButton borderColorButton;
    private JButton fillColorButton;

    public CreateFigureDialog() {
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
        point3TextField = new JTextField();
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

    public Figure getFigure() {
        return figure;
    }

    private void createChangeEditPanelListener1D() {
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
    }

    private void createChangeEditPanelListener2D() {
        editPanel.removeAll();
        editPanel.setLayout(new GridLayout(2, 2));
        editPanel.add(new JLabel("Point 1: "));
        editPanel.add(point1TextField);
        editPanel.add(new JLabel("Point 2: "));
        editPanel.add(point2TextField);
        buttonsPanel.remove(addButton);
        buttonsPanel.add(fillColorButton);
        buttonsPanel.add(addButton);
        pack();
        editPanel.revalidate();
        buttonsPanel.revalidate();
    }

    private void createChangeEditPanelListener() {
        figuresComboBox.addActionListener(e -> {
            String selectedItem = (String) figuresComboBox.getSelectedItem();
            switch (Objects.requireNonNull(selectedItem)) {
                case "Line":
                case "Ray":
                case "Section":
                    createChangeEditPanelListener1D();
                    break;
                case "Circle":
                case "Ellipse":
                case "Rectangle":
                    createChangeEditPanelListener2D();
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
                case "Regular Polygon":
                    editPanel.removeAll();
                    editPanel.setLayout(new GridLayout(3, 2));
                    editPanel.add(new JLabel("Point 1: "));
                    editPanel.add(point1TextField);
                    editPanel.add(new JLabel("Center: "));
                    editPanel.add(point2TextField);
                    editPanel.add(new JLabel("Amount of ages: "));
                    editPanel.add(amountOfAgesTextField);
                    buttonsPanel.remove(addButton);
                    buttonsPanel.add(fillColorButton);
                    buttonsPanel.add(addButton);
                    pack();
                    editPanel.revalidate();
                    buttonsPanel.revalidate();
                    break;
                case "Rhombus":
                    editPanel.removeAll();
                    editPanel.setLayout(new GridLayout(3, 2));
                    editPanel.add(new JLabel("Point 1: "));
                    editPanel.add(point1TextField);
                    editPanel.add(new JLabel("Point 2: "));
                    editPanel.add(point2TextField);
                    editPanel.add(new JLabel("Center: "));
                    editPanel.add(point3TextField);
                    buttonsPanel.remove(addButton);
                    buttonsPanel.add(fillColorButton);
                    buttonsPanel.add(addButton);
                    pack();
                    editPanel.revalidate();
                    buttonsPanel.revalidate();
                    break;

            }
        });
    }

    private Point getPoint(JTextField pointTextField) {
        String pointString = pointTextField.getText();
        String[] coords = pointString.split("[ ,]");
        return new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }

    private void addCreateFigureEventListener() {
        addButton.addActionListener(e -> {
            String selectedItem = (String) figuresComboBox.getSelectedItem();
            Point pointA = new Point();
            Point pointB = new Point();
            if (point1TextField.getParent() != null && point2TextField.getParent() != null) {
                pointA = getPoint(point1TextField);
                pointB = getPoint(point2TextField);
            }
            switch (Objects.requireNonNull(selectedItem)) {
                case "Line":
                    figure = new Line(pointA, pointB, borderColor);
                    break;
                case "Ray":
                    figure = new Ray(pointA, pointB, borderColor);
                    break;
                case "Section":
                    figure = new Section(pointA, pointB, borderColor);
                    break;
                case "Circle":
                    figure = new Circle(pointA, pointB, borderColor, fillColor);
                    break;
                case "Ellipse":
                    figure = new Ellipse(pointA, pointB, borderColor, fillColor);
                    break;
                case "Rectangle":
                    figure = new Rectangle(pointA, pointB, borderColor, fillColor);
                    break;
                case "Polygon": {
                    String pointsString = pointsTextField.getText();
                    String[] coords = pointsString.split("[ ,]");
                    ArrayList<Point> points = new ArrayList<>();
                    for (int i = 0; i < coords.length; i += 2) {
                        points.add(new Point(Integer.parseInt(coords[i]), Integer.parseInt(coords[i + 1])));
                    }
                    figure = new Polygon(points, borderColor, fillColor);
                    break;
                }
                case "Regular Polygon": {
                    int amountOfAges = Integer.parseInt(amountOfAgesTextField.getText());
                    Point point = getPoint(point1TextField);
                    Point centerPoint = getPoint(point2TextField);
                    figure = new RegularPolygon(centerPoint, point, amountOfAges, borderColor, fillColor);
                    break;
                }
                case "Rhombus": {
                    Point centerPoint = getPoint(point3TextField);
                    figure = new Rhombus(centerPoint, pointA, pointB, borderColor, fillColor);
                    break;
                }
            }
            dispose();
        });
    }

    private void addColorChoosers() {
        borderColorButton.addActionListener(e -> {
            borderColor = JColorChooser.showDialog(
                    this,
                    "Choose border color",
                    FiguresConstants.STANDARD_COLOR
            );
            updateButtonsIcons();
        });
        fillColorButton.addActionListener(e -> {
            fillColor = JColorChooser.showDialog(
                    this,
                    "Choose fill color",
                    FiguresConstants.STANDARD_COLOR
            );
            updateButtonsIcons();
        });
    }

    private void updateButtonsIcons() {
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
