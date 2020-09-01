package com.bandtec.projetoindividualcontinuada1;

import java.util.Locale;

public class Gennin extends Ninja{


    private Double poder;

    public Gennin(String nome, Integer idade, char sexo,
                  Integer ninjutsu, Integer taijutsu, Integer genjutsu,
                  Double chakra, Double forca, Double agilidade)
    {
        super(nome, idade, sexo, ninjutsu, taijutsu, genjutsu, chakra, forca, agilidade);
        setTipoNinja("Gennin");
    }

    @Override
    public Double calcPoder() {
        return ((getNinjutsu() + getTaijutsu() + getGenjutsu())/3 + (getChakra() + getForca() + getAgilidade())) * 0.10;
    }

    @Override
    public String toString() {
        return "\nNinja Gennin\n" +
                super.toString() +
                "Poder: "+ String.format(Locale.US,"%.1f\n", calcPoder());
    }


    public Double getPoder() {
        return returnPoder(poder = calcPoder());
    }
}
