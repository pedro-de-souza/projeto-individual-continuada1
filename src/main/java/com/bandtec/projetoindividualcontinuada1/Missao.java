package com.bandtec.projetoindividualcontinuada1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Missao {

    private String representante;//Konoha País do Fogo, Kiri País da Água, Kumo País do Relâmpagom, Iwa  País da Terra, Suna País do Vento
    private char rank;
    private String tipo;// Massacre , Espionagem, Escoltamento,Resgate, Infiltração, Captura
    private String status;
    private Boolean vitoria;
    private List<Ninja> listNinja;

    public Missao() {
        this.status = "EM ANDAMENTO";
        this.listNinja = new ArrayList<Ninja>();
    }

    public Missao(String representante, char rank, String tipo) {
        this.representante = representante;
        this.rank = rank;
        this.tipo = tipo;
        this.status = "EM ANDAMENTO";
        this.listNinja = new ArrayList<Ninja>();
    }

    public Missao(String representante, char rank, String tipo, Boolean vitoria) {
        this(representante, rank, tipo);
        this.vitoria = vitoria;
        this.status = "FINALIZADA";
        this.listNinja = new ArrayList<Ninja>();
    }

    public void addNinjaMissao(Ninja nj) {


        if ((rank == 'D' || rank == 'C') && nj instanceof Gennin) {
            listNinja.add(nj);
        } else if ((rank == 'C' || rank == 'B') && nj instanceof Chunnin) {
            listNinja.add(nj);
        } else if ((rank == 'D' || rank == 'C' || rank == 'B' || rank == 'A' || rank == 'S') && nj instanceof Jonnin) {
            listNinja.add(nj);
        } else if ((rank == 'B' || rank == 'A' || rank == 'S') && nj instanceof Anbu) {
            listNinja.add(nj);
        }

    }

    public void atualizarNinjaMissao(Integer id, Ninja n) {
        listNinja.set(id, n);
    }

    public List<Ninja> displayAllNinja() {
        return listNinja;
    }

    public List<Ninja> displayNinjaGennin() {
        List<Ninja> listaNjGennin = new ArrayList<>();
        for (Ninja njG : listNinja) {
            if (njG instanceof Gennin) {
                listaNjGennin.add(njG);
            }
        }
        return listaNjGennin;
    }

    public List<Ninja> displayNinjaChunnin() {
        List<Ninja> listaNjChunnin = new ArrayList<>();
        for (Ninja njC : listNinja) {
            if (njC instanceof Chunnin) {
                listaNjChunnin.add(njC);
            }
        }
        return listaNjChunnin;
    }

    public List<Ninja> displayNinjaJonnin() {
        List<Ninja> listaNjJonnin = new ArrayList<>();
        for (Ninja njJ : listNinja) {
            if (njJ instanceof Jonnin) {
                listaNjJonnin.add(njJ);
            }
        }
        return listaNjJonnin;
    }

    public List<Ninja> displayNinjaGeniAnbu() {
        List<Ninja> listaNjAnbu = new ArrayList<>();
        for (Ninja njA : listNinja) {
            if (njA instanceof Anbu) {
                listaNjAnbu.add(njA);
            }
        }
        return listaNjAnbu;
    }

    public Double totalPower() {
        Double total = 0.0;
        for (Ninja n : listNinja) {
            total += n.calcPoder();
        }
        return total;
    }

    @Override
    public String toString() {
        return "\nMissão\n" +
                "Representante: " + representante + "\n" +
                "Rank: " + rank + "\n" +
                "Tipo: " + tipo + "\n" +
                "Status: " + status + "\n" +
                "Total poder: " + String.format(Locale.US, "%.1f\n", totalPower());
    }

    public String getRepresentante() {
        return representante;
    }

    public char getRank() {
        return rank;
    }

    public String getTipo() {
        return tipo;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getVitoria() {
        return vitoria;
    }

    public void setVitoria(Boolean vitoria) {
        this.vitoria = vitoria;
        this.status = "FINALIZADA";
    }

    public List<Ninja> getListNinja() {
        return listNinja;
    }
}


