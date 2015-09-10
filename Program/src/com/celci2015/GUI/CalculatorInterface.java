package com.celci2015.GUI;

import com.celci2015.Processor;
import com.celci2015.UserInterface;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pablo on 05/09/15.
 */
public class CalculatorInterface extends UserInterface {
    private JTextField input;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton eButton;
    private JButton dButton;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton multiButton;
    private JButton cButton;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton minusButton;
    private JButton blankSpace;
    private JButton b0;
    private JButton pipe;
    private JButton plusButton;
    private JButton equalButton;
    private JPanel mainPanel;
    private JButton negativeButton;

    private String first="";
    private String operator="";

    public static void start() {
        JFrame frame = new JFrame("CalculatorInterface");
        frame.setContentPane(new CalculatorInterface().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public CalculatorInterface() {
        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "0");
            }
        });
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "1");
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "2");
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "3");
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "4");
            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "5");
            }
        });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "6");
            }
        });
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "7");
            }
        });
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "8");
            }
        });
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "9");
            }
        });
        minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "-");

            }
        });
        blankSpace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + " ");
            }
        });
        pipe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText(input.getText() + "|");
            }
        });
        plusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setOperation(" + ");
            }
        });
        minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setOperation(" - ");
            }
        });
        multiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setOperation(" * ");
            }
        });
        eButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setOperation(" e ");
            }
        });
        cButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input.setText("");
            }
        });
        dButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                first = ""; operator = "";
                input.setText("");
            }
        });
        equalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                query(first + operator + input.getText());

            }
        });



    }

    private void setOperation(String op) {
        first = input.getText();
        operator = op;
        if (!first.matches(Processor.expressionPattern))
        {
            display("Expression doesn't match pattern");
        }
        input.setText("");
    }

    @Override
    public void display(String result) {
        input.setText(result);
        first = ""; operator = "";
    }
}
