package com.archiewhite;

public class Model {
    private double basisValue;
    private double unitPrice;
    private String formulaType;
    private double formula;

    public Model (double basisValue, double unitPrice, String formulaType, double formula) {
        this.basisValue = basisValue;
        this.unitPrice = unitPrice;
        this.formulaType = formulaType;
        this.formula = formula;
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

    public String getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(String formulaType) {
        this.formulaType = formulaType;
    }

    public double getFormula() {
        return formula;
    }

    public void setFormula(double formula) {
        this.formula = formula;
    }
}
