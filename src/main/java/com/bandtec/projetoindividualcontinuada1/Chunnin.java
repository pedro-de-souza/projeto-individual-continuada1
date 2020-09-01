package com.bandtec.projetoindividualcontinuada1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Chunnin extends Ninja{

    private Double poder;

    public Chunnin(String nome, Integer idade, char sexo,
                  Integer ninjutsu, Integer taijutsu, Integer genjutsu,
                  Double chakra, Double forca, Double agilidade)
    {
        super(nome, idade, sexo, ninjutsu, taijutsu, genjutsu, chakra, forca, agilidade);
        setTipoNinja("Chunnin");
    }

    @Override
    public Double calcPoder() {
        return ((getNinjutsu() + getTaijutsu() + getGenjutsu())/3 + (getChakra() + getForca() + getAgilidade())) * 0.20;
    }

    @Override
    public String toString() {
        return "\nNinja Chunnin\n" +
                super.toString() +
                "Poder: "+ String.format(Locale.US,"%.1f\n", calcPoder());
    }

    public Double getPoder() {
        return returnPoder(poder = calcPoder());
    }
}
