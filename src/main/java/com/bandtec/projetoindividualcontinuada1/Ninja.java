package com.bandtec.projetoindividualcontinuada1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Ninja {

    private String nome;
    private Integer idade;
    private char sexo;
    private Integer ninjutsu;
    private Integer taijutsu;
    private Integer genjutsu;
    private Double chakra;
    private Double forca;
    private Double agilidade;
    private String tipoNinja;

    public Ninja(String nome, Integer idade, char sexo,
                 Integer ninjutsu, Integer taijutsu, Integer genjutsu,
                 Double chakra, Double forca, Double agilidade)
    {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.ninjutsu = ninjutsu;
        this.taijutsu = taijutsu;
        this.genjutsu = genjutsu;
        this.chakra = chakra;
        this.forca = forca;
        this.agilidade = agilidade;
    }

    public abstract Double calcPoder();

    public Double returnPoder(Double p){
        BigDecimal bd = new BigDecimal(p).setScale(1, RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    public Integer getNinjutsu() {
        return ninjutsu;
    }

    public Integer getTaijutsu() {
        return taijutsu;
    }

    public Integer getGenjutsu() {
        return genjutsu;
    }

    public Double getChakra() {
        return chakra;
    }

    public Double getForca() {
        return forca;
    }

    public Double getAgilidade() {
        return agilidade;
    }

    public void setTipoNinja(String tipoNinja) {
        this.tipoNinja = tipoNinja;
    }

    public String getTipoNinja() {
        return tipoNinja;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "Sexo: " + sexo + "\n" +
                "Ninjutsu: " + ninjutsu + "\n" +
                "Taijutsu: " + taijutsu + "\n" +
                "Genjutsu: " + genjutsu + "\n" +
                "Chakra: " + chakra + "\n" +
                "Força: " + forca + "\n" +
                "Agilidade: " + agilidade + "\n";
    }

}
