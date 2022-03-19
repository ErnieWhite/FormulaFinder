package com.archiewhite;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.*;

/*
        +------------------------------+
        | Formula Finder               |
        +------------------------------+
        |            +------+ +------+ |
        | Base Value |      | |      | |
        |            +------+ +------+ |
        |            +------+ +------+ |
        | Unit Price |      | |      | |
        |            +------+ +------+ |
        |            +------+ +------+ |
        | Decimals   |      | |      | |
        |            +------+ +------+ |
        |                     +------+ |
        |                     |      | |
        |                     +------+ |
        +------------------------------+
*/

public class View {
    private JFrame frame;
    private JLabel basisValueLabel;
    private JLabel unitPriceLabel;
    private JLabel decimalPlacesLabel;
    private JTextField basisValueTextfield;
    private JTextField unitPriceTextfield;
    private JTextField multiplierFormulaTextfield;
    private JTextField discountFormulaTextfield;
    private JTextField markupFormulaTextfield;
    private JTextField grossProfitFormulaTextfield;
    private JComboBox<String> decimalPlacesCombobox;

    public View (String title) {
        JFrame frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setVisible(true);

        // Create UI elements
        basisValueLabel = new JLabel("Basis Value");
        unitPriceLabel = new JLabel("Unit Price");
        decimalPlacesLabel = new JLabel("Decimals");
        basisValueTextfield = new JTextField();
        unitPriceTextfield = new JTextField();
        String[] decimalPlaces = {"Auto", "0", "1", "2", "3", "4", "5", "6"};
        decimalPlacesCombobox = new JComboBox<>(decimalPlaces);
        multiplierFormulaTextfield = new JTextField();
        discountFormulaTextfield = new JTextField();
        markupFormulaTextfield = new JTextField();
        grossProfitFormulaTextfield = new JTextField();

        // Add UI elements to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(basisValueLabel)
                        .addComponent(unitPriceLabel)
                        .addComponent(decimalPlacesLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(basisValueTextfield)
                        .addComponent(unitPriceTextfield)
                        .addComponent(decimalPlacesCombobox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(multiplierFormulaTextfield)
                        .addComponent(discountFormulaTextfield)
                        .addComponent(markupFormulaTextfield)
                        .addComponent(grossProfitFormulaTextfield))

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(basisValueLabel)
                        .addComponent(basisValueTextfield)
                        .addComponent(multiplierFormulaTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(unitPriceLabel)
                        .addComponent(unitPriceTextfield)
                        .addComponent(discountFormulaTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(decimalPlacesLabel)
                        .addComponent(decimalPlacesCombobox)
                        .addComponent(markupFormulaTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(grossProfitFormulaTextfield)));

        frame.getContentPane().setLayout(layout);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getBasisValueLabel() {
        return basisValueLabel;
    }

    public void setBasisValueLabel(JLabel basisValueLabel) {
        this.basisValueLabel = basisValueLabel;
    }

    public JLabel getUnitPriceLabel() {
        return unitPriceLabel;
    }

    public void setUnitPriceLabel(JLabel unitPriceLabel) {
        this.unitPriceLabel = unitPriceLabel;
    }

    public JTextField getBasisValueTextfield() {
        return basisValueTextfield;
    }

    public void setBasisValueTextfield(JTextField basisValueTextfield) {
        this.basisValueTextfield = basisValueTextfield;
    }

    public JTextField getUnitPriceTextfield() {
        return unitPriceTextfield;
    }

    public void setUnitPriceTextfield(JTextField unitPriceTextfield) {
        this.unitPriceTextfield = unitPriceTextfield;
    }

    public JTextField getMultiplierFormulaTextfield() {
        return multiplierFormulaTextfield;
    }

    public void setMultiplierFormulaTextfield(JTextField multiplierFormulaTextfield) {
        this.multiplierFormulaTextfield = multiplierFormulaTextfield;
    }

    public JTextField getDiscountFormulaTextfield() {
        return discountFormulaTextfield;
    }

    public void setDiscountFormulaTextfield(JTextField discountFormulaTextfield) {
        this.discountFormulaTextfield = discountFormulaTextfield;
    }

    public JTextField getMarkupFormulaTextfield() {
        return markupFormulaTextfield;
    }

    public void setMarkupFormulaTextfield(JTextField markupFormulaTextfield) {
        this.markupFormulaTextfield = markupFormulaTextfield;
    }

    public JTextField getGrossProfitFormulaTextfield() {
        return grossProfitFormulaTextfield;
    }

    public void setGrossProfitFormulaTextfield(JTextField grossProfitFormulaTextfield) {
        this.grossProfitFormulaTextfield = grossProfitFormulaTextfield;
    }

    public JLabel getDecimalPlacesLabel() {
        return decimalPlacesLabel;
    }

    public void setDecimalPlacesLabel(JLabel decimalPlacesLabel) {
        this.decimalPlacesLabel = decimalPlacesLabel;
    }

    public JComboBox<String> getDecimalPlacesCombobox() {
        return decimalPlacesCombobox;
    }

    public void setDecimalPlacesCombobox(JComboBox<String> decimalPlacesCombobox) {
        this.decimalPlacesCombobox = decimalPlacesCombobox;
    }

}
