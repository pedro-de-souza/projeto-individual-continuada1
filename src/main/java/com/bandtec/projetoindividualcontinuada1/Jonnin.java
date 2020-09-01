package com.bandtec.projetoindividualcontinuada1;

import java.util.Locale;

public class Jonnin extends Ninja {

    private Boolean supervisor;
    private Double poder;

    public Jonnin(String nome, Integer idade, char sexo,
                  Integer ninjutsu, Integer taijutsu, Integer genjutsu,
                  Double chakra, Double forca, Double agilidade, Boolean supervisor) {
        super(nome, idade, sexo, ninjutsu, taijutsu, genjutsu, chakra, forca, agilidade);
        setTipoNinja("Jonnin");
        this.supervisor = supervisor;
    }

    @Override
    public Double calcPoder() {
        if (supervisor) {
            return ((getNinjutsu() + getTaijutsu() + getGenjutsu()) / 3 + (getChakra() + (getForca() + getAgilidade()) * 2)) * 0.35;
        } else {
            return ((getNinjutsu() + getTaijutsu() + getGenjutsu()) / 3 + (getChakra() + (getForca() + getAgilidade()) * 2)) * 0.30;
        }
    }

    @Override
    public String toString() {
        return "\nNinja Jonnin\n" +
                super.toString() +
                "Supervisor: " + supervisor + "\n" +
                "Poder: " + String.format(Locale.US, "%.1f\n", calcPoder());
    }

    public Boolean getSupervisor() {
        return supervisor;
    }

    public Double getPoder() {
        return returnPoder(poder = calcPoder());
    }

}
