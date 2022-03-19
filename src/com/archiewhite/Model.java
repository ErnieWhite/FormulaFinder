package com.archiewhite;

public class Model {
    private double basisValue;
    private double unitPrice;
    private String decimalPlaces;
    private String multiplierFormula;
    private String discountFormula;
    private String markupFormula;
    private String grossProfitFormula;

    public Model (double basisValue, double unitPrice, String decimalPlaces) {
        this.basisValue = basisValue;
        this.unitPrice = unitPrice;
        this.decimalPlaces = decimalPlaces;
    }

    public double getBasisValue() {
        return basisValue;
    }

    public void setBasisValue(double basisValue) {
        this.basisValue = basisValue;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(String decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public String getMultiplierFormula() {
        return multiplierFormula;
    }

    public void setMultiplierFormula(String multiplierFormula) {
        this.multiplierFormula = multiplierFormula;
    }

    public String getDiscountFormula() {
        return discountFormula;
    }

    public void setDiscountFormula(String discountFormula) {
        this.discountFormula = discountFormula;
    }

    public String getMarkupFormula() {
        return markupFormula;
    }

    public void setMarkupFormula(String markupFormula) {
        this.markupFormula = markupFormula;
    }

    public String getGrossProfitFormula() {
        return grossProfitFormula;
    }

    public void setGrossProfitFormula(String grossProfitFormula) {
        this.grossProfitFormula = grossProfitFormula;
    }
}
