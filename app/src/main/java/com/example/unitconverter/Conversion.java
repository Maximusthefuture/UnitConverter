package com.example.unitconverter;

import androidx.annotation.StringRes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Conversion {
    SQUARE(R.string.square, Arrays.asList(Unit.SQ_KILOMETRES, Unit.SQ_CENTIMETRES, Unit.SQ_METRES, Unit.HECTARE)),
    GOTOVKA(R.string.gotovka, Collections.<Unit>emptyList()),
    MONEY(R.string.money, Collections.<Unit>emptyList()),
    DATA(R.string.data, Collections.<Unit>emptyList()),
    ENERGY(R.string.energy, Collections.<Unit>emptyList()),
    TOPLIVO(R.string.toplivo, Collections.<Unit>emptyList()),
    DLINAR(R.string.dlina,Arrays.asList(Unit.KILOMETRE, Unit.METRE, Unit.CENTIMENTRE, Unit.MICROMETRE, Unit.MILIMENTRE, Unit.MILE)),
    MASSA(R.string.massa, Collections.<Unit>emptyList()),
    MOSHNOST(R.string.moshnost, Collections.<Unit>emptyList()),
    DAVLENIE(R.string.davlenie, Collections.<Unit>emptyList()),
    SPEED(R.string.speed, Collections.<Unit>emptyList());

    private @StringRes int res;
    final List<Unit> mUnits;



    Conversion(int to, List<Unit> units) {
        this.res = to;
        mUnits = units;
    }




}
