package ui;

import figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CreateFigureDialog extends JDialog {
    JPanel editPanel;

    Figure figure;
    JComboBox figuresComboBox;
    String[] figuresNames;
    JTextField point1TextField;
    JTextField point2TextField;
    JTextField pointsTextField;
    JTextField amountOfAgesTextField;
    JButton addButton;

    public CreateFigureDialog(){
        setTitle("Add figure");
        setModal(true);
        figuresNames = new String[]{
                "Line",
                "Ray",
                "Section",
                "Circle",
                "Ellipse",
                "Equilateral Triangle",
                "Polygon",
                "Rectangle",
                "Regular Polygon",
                "Regular Triangle",
                "Rhombus"
        };
        figuresComboBox = new JComboBox(figuresNames);
        point1TextField = new JTextField();
        point2TextField = new JTextField();
        pointsTextField = new JTextField();
        amountOfAgesTextField = new JTextField();
        addButton = new JButton("Add");
        editPanel = new JPanel();

        setLayout(new BorderLayout());
        add(figuresComboBox, BorderLayout.NORTH);
        editPanel.setLayout(new GridLayout(2, 2));
        editPanel.add(new JLabel("Point 1: "));
        editPanel.add(point1TextField);
        editPanel.add(new JLabel("Point 2: "));
        editPanel.add(point2TextField);
        editPanel.setVisible(true);

        createChangeEditPanelListener();


        editPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(editPanel, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(150, 150);
        getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pack();
        setVisible(true);
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
                    pack();
                    editPanel.revalidate();
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
                case "Equilateral Triangle":
                    //TODO
                    break;
                case "Polygon":
                    editPanel.removeAll();
                    editPanel.setLayout(new GridLayout(1, 2));
                    editPanel.add(new JLabel("Enter points, separated by space or \",\": "));
                    editPanel.add(pointsTextField);
                    pack();
                    editPanel.revalidate();
                    break;
                case "Rectangle":
                    //TODO
                    break;
                case "Regular Polygon":
                    //TODO
                    break;
                case "Regular Triangle":
                    //TODO
                    break;
                case "Rhombus":
                    //TODO
                    break;

            }
        });
    }

}
