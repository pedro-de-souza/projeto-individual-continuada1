package com.bandtec.projetoindividualcontinuada1;

import java.util.Locale;

public class Anbu extends Ninja{

    private Boolean lider;
    private Integer senmon;
    private Double poder;

    public Anbu(String nome, Integer idade, char sexo,
                Integer ninjutsu, Integer taijutsu, Integer genjutsu,
                Double chakra, Double forca, Double agilidade,
                Boolean lider, Integer senmon)
    {
        super(nome, idade, sexo, ninjutsu, taijutsu, genjutsu, chakra, forca, agilidade);
        setTipoNinja("Anbu");
        this.lider = lider;
        this.senmon = senmon;
    }

    @Override
    public Double calcPoder() {
        if(lider){
            return ((getNinjutsu() + getTaijutsu() + getGenjutsu())/3 + (getChakra()+ senmon + (getForca() + getAgilidade())*2)) * 0.45;
        }else{
            return ((getNinjutsu() + getTaijutsu() + getGenjutsu())/3 + (getChakra()+ senmon + (getForca() + getAgilidade())*2)) * 0.40;
        }
    }

    @Override
    public String toString() {
        return "\nNinja Anbu\n" +
                super.toString() +
                "Líder: "+lider+"\n" +
                "Senmon: "+senmon+"\n" +
                "Poder: "+ String.format(Locale.US,"%.1f\n", calcPoder());
    }

    public Boolean getLider() {
        return lider;
    }

    public Integer getSenmon() {
        return senmon;
    }

    public Double getPoder() {
        return returnPoder(poder = calcPoder());
    }
}
