package com.archiewhite;

import javax.swing.JOptionPane;
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
    }

    public void initController() {
        view.getBasisValueTextfield().addActionListener(e -> saveBasisValue());
        view.getUnitPriceTextfield().addActionListener(e -> saveUnitPrice());
    }

    private void saveBasisValue() {
        model.setBasisValue(Double.parseDouble(view.getBasisValueTextfield().getText()));
        updateFormulas();
    }

    private void saveUnitPrice() {
        model.setUnitPrice(Double.parseDouble(view.getUnitPriceTextfield().getText()));
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
            String decimalPart = String.format("%0" + model.getDecimalPlaces() + "d", 0);
            df = new DecimalFormat("0." + decimalPart);
        }
        multiplier = model.getUnitPrice() / model.getBasisValue();
        model.setMultiplierFormula("*" + df.format(multiplier));
        model.setDiscountFormula((multiplier > 0 ? "+" : "") + df.format((multiplier - 1 ) * 100));
        model.setMarkupFormula("D" + df.format(1 / multiplier));
        // the GP formulas cannot be < -99.999999 or greater than 99.999999 (Eclipse limitation)
        double gpValue = (1- 1 / multiplier) * 100;
        model.setGrossProfitFormula(gpValue >= -99.999999 || gpValue <= 99.999999 ? df.format(gpValue) : "Invalid");
        updateView();
    }

    private void updateView() {
        view.getMultiplierFormulaTextfield().setText(model.getMultiplierFormula());
        view.getDiscountFormulaTextfield().setText(model.getDiscountFormula());
        view.getMarkupFormulaTextfield().setText(model.getMarkupFormula());
        view.getGrossProfitFormulaTextfield().setText(model.getGrossProfitFormula());
    }
}
