package com.example.unitconverter;




import androidx.annotation.StringRes;

public enum Unit {
    SQ_CENTIMETRES(R.string.sqcentiment, 0.0001, 10000),
    SQ_KILOMETRES(R.string.sqkilometr, 100000.0, 0.00001),
    SQ_METRES(R.string.sqmetres, 1.0, 1.0),
    HECTARE(R.string.hectar, 10000.0, 0.001),
    KILOMETRE(R.string.kilometr, 1000.0, 0.001),
    MILE(R.string.mile, 1.0, 1.0),
    METRE(R.string.metre, 1.0, 1.0),
    CENTIMENTRE(R.string.santiment, 0.01, 100.0),
    MILIMENTRE(R.string.milimetr, 0.001, 1000),
    MICROMETRE(R.string.micrometre, 0.000001, 100000.0);


    @StringRes
    public int mLabelResource;
    public double mConventionToBase;
    public double mConvertionFromBase;

    Unit(int mLabelResource, double mConventionToBase, double mConvertionFromBase) {
        this.mLabelResource = mLabelResource;
        this.mConventionToBase = mConventionToBase;
        this.mConvertionFromBase = mConvertionFromBase;
    }



}
