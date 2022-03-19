package com.archiewhite;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.text.DecimalFormat;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        initView();
    }

    public void initView() {
        model.setDecimalPlaces(view.getDecimalPlacesCombobox().getItemAt(view.getDecimalPlacesCombobox().getSelectedIndex()));
    }

    public void initController() {
        view.getBasisValueTextfield().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                saveBasisValue();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveBasisValue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                saveBasisValue();
            }
        });
        view.getUnitPriceTextfield().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                saveUnitPrice();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saveUnitPrice();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                saveUnitPrice();
            }
        });
        view.getDecimalPlacesCombobox().addActionListener(e -> saveDecimalPlaces());
    }

    private void saveBasisValue() {
        try {
            model.setBasisValue(Double.parseDouble(view.getBasisValueTextfield().getText()));
            updateFormulas();
        } catch (NumberFormatException e) {
            clearFormulas();
            model.setBasisValue(0);
        }
    }

    private void saveUnitPrice() {
        try {
            model.setUnitPrice(Double.parseDouble(view.getUnitPriceTextfield().getText()));
            updateFormulas();
        } catch (NumberFormatException e) {
            clearFormulas();
            model.setUnitPrice(0);
        }
    }

    private void saveDecimalPlaces() {
        model.setDecimalPlaces(view.getDecimalPlacesCombobox().getItemAt(view.getDecimalPlacesCombobox().getSelectedIndex()));
        updateFormulas();
    }

    private void updateFormulas() {
        String formula;
        double multiplier;
        DecimalFormat df;

        if (model.getBasisValue() == 0 || model.getUnitPrice() == 0) {
            return;
        }

        // Create our format string based on the decimal places specified
        if (model.getDecimalPlaces().equals( "Auto")) {
            // This will only use as many places as needed up to a maximum of 6
            df = new DecimalFormat("0.######");
        } else {
            // Create a string that has the number of 0's we need for the requested number of decimal places
            if (!model.getDecimalPlaces().equals("0")) {
                String decimalPart = String.format("%0" + model.getDecimalPlaces() + "d", 0);
                df = new DecimalFormat("0." + decimalPart);
            } else {
                df = new DecimalFormat("0");
            }
        }
        multiplier = model.getUnitPrice() / model.getBasisValue();
        model.setMultiplierFormula("*" + df.format(multiplier));
        model.setDiscountFormula((multiplier - 1 > 0 ? "+" : "") + df.format((multiplier - 1 ) * 100));
        model.setMarkupFormula("D" + df.format(1 / multiplier));
        // the GP formulas cannot be < -99.999999 or greater than 99.999999 (Eclipse limitation)
        double gpValue = (1- 1 / multiplier) * 100;
        model.setGrossProfitFormula(gpValue >= -99.999999 && gpValue <= 99.999999 ? "GP" + df.format(gpValue) : "Invalid");
        updateView();
    }

    private void updateView() {
        view.getMultiplierFormulaTextfield().setText(model.getMultiplierFormula());
        view.getDiscountFormulaTextfield().setText(model.getDiscountFormula());
        view.getMarkupFormulaTextfield().setText(model.getMarkupFormula());
        view.getGrossProfitFormulaTextfield().setText(model.getGrossProfitFormula());
    }

    private void clearFormulas() {
        view.getMultiplierFormulaTextfield().setText("");
        view.getDiscountFormulaTextfield().setText("");
        view.getMarkupFormulaTextfield().setText("");
        view.getGrossProfitFormulaTextfield().setText("");
    }
}
