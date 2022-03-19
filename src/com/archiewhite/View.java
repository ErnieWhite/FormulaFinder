package com.archiewhite;

import javax.swing.*;
import java.awt.*;


public class View {
    private JFrame frame;
    private JLabel basisValueLabel;
    private JLabel unitPriceLabel;
    private JLabel formulaTypeLabel;
    private JLabel formulaLabel;
    private JTextField basisValueTextfield;
    private JTextField unitPriceTextfield;
    private JTextField formulaTextfield;
    private JComboBox formulaTypeCombobox;
    private JButton copyButton;

    public View (String title) {
        JFrame frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Create UI elements
        basisValueLabel = new JLabel("Basis Value");
        unitPriceLabel = new JLabel("Unit Price");
        formulaLabel = new JLabel("Formula Type");
        basisValueTextfield = new JTextField();
        unitPriceTextfield = new JTextField();
        String formulaTypes[] = {"*", "X", "D", "-", "GP"};
        formulaTypeCombobox = new JComboBox<>(formulaTypes);
        formulaTextfield = new JTextField();
        copyButton = new JButton("Copy");

        // Add UI elements to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(basisValueLabel)
                        .addComponent(unitPriceLabel)
                        .addComponent(formulaTypeLabel)
                        .addComponent(formulaLabel)
                        .addComponent(copyButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(basisValueTextfield)
                        .addComponent(unitPriceTextfield)
                        .addComponent(formulaTypeCombobox)
                        .addComponent(formulaTextfield))

        );
        frame.getContentPane().setLayout(layout);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getFormulaLabel() {
        return formulaLabel;
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

    public JLabel getFormulaTypeLabel() {
        return formulaTypeLabel;
    }

    public void setFormulaTypeLabel(JLabel formulaTypeLabel) {
        this.formulaTypeLabel = formulaTypeLabel;
    }

    public void setFormulaLabel(JLabel formulaLabel) {
        this.formulaLabel = formulaLabel;
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

    public JComboBox<String> getFormulaTypeCombobox() {
        return formulaTypeCombobox;
    }

    public void setFormulaTypeCombobox(JComboBox formulaTypeCombobox) {
        this.formulaTypeCombobox = formulaTypeCombobox;
    }

    public JButton getCopyButton() {
        return copyButton;
    }

    public void setCopyButton(JButton copyButton) {
        this.copyButton = copyButton;
    }

    public JTextField getFormulaTextfield() {
        return formulaTextfield;
    }

    public void setFormulaTextfield(JTextField formulaTextfield) {
        this.formulaTextfield = formulaTextfield;
    }
}
