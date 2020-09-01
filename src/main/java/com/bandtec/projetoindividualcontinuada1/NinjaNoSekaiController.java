package com.bandtec.projetoindividualcontinuada1;

import org.springframework.web.bind.annotation.*;
import sun.security.krb5.KdcComm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api-ninja")
public class NinjaNoSekaiController {

    List<Ninja> listaNinjas = new ArrayList<>();
    List<Missao> listaMissao = new ArrayList<>();


    //    @GetMapping("/addNinjaNoSekai")
    @GetMapping
    public void addNinja() {

        Ninja naruto = new Chunnin("Naruto", 15, 'M', 5, 6, 3, 50.0, 40.0, 15.0);
        Ninja sasuke = new Chunnin("Sasuke", 15, 'M', 5, 5, 8, 50.0, 40.0, 20.0);
        Ninja sakura = new Chunnin("Sakura", 15, 'F', 5, 3, 5, 55.0, 30.0, 10.0);

        Ninja kakashi = new Anbu("Kakashi", 22, 'M', 7, 6, 8, 40.0, 50.0, 30.0, true, 5);

        Missao m1 = new Missao("Konoha País do Fogo", 'B', "Escoltamento", true);


        listaNinjas.add(naruto);
        listaNinjas.add(sasuke);
        listaNinjas.add(sakura);
        listaNinjas.add(kakashi);


        m1.addNinjaMissao(naruto);
        m1.addNinjaMissao(sasuke);
        m1.addNinjaMissao(sakura);
        m1.addNinjaMissao(kakashi);


        listaMissao.add(m1);

        ////////////////////////////////////
        Ninja zabuza = new Anbu("Zabuza", 26, 'M', 5, 3, 4, 40.0, 35.0, 10.0, true, 5);
        Ninja haku = new Chunnin("Haku", 14, 'M', 6, 4, 6, 50.0, 30.0, 20.0);

        Missao m2 = new Missao("Kiri País da Água", 'B', "Infiltração", false);

        listaNinjas.add(zabuza);
        listaNinjas.add(haku);

        m2.addNinjaMissao(zabuza);
        m2.addNinjaMissao(haku);

        listaMissao.add(m2);

        /////////////////////////////
        Ninja killerB = new Jonnin("Killer B", 30, 'M', 6, 4, 5, 60.0, 40.0, 25.0, false);
        Ninja a = new Jonnin("A", 35, 'M', 6, 5, 4, 60.0, 50.0, 25.0, true);

        Missao m3 = new Missao("Kumo País do Relâmpagom", 'A', "Resgate");

        listaNinjas.add(killerB);
        listaNinjas.add(a);

        m3.addNinjaMissao(killerB);
        m3.addNinjaMissao(a);

        listaMissao.add(m3);

        //////////////////////////
        Ninja kurotsuchi = new Gennin("Kurotsuchi", 16, 'F', 5, 7, 6, 60.0, 40.0, 25.0);
        Ninja kirara = new Gennin("Suzumebachi", 17, 'F', 6, 6, 6, 55.0, 45.0, 30.0);

        Ninja kunoichi = new Jonnin("Kunoichi", 35, 'F', 7, 5, 4, 65.0, 56.0, 31.0, true);

        Missao m4 = new Missao("Iwa  País da Terra", 'C', "Espionagem");

        listaNinjas.add(kurotsuchi);
        listaNinjas.add(kirara);
        listaNinjas.add(kunoichi);

        m4.addNinjaMissao(kurotsuchi);
        m4.addNinjaMissao(kirara);
        m4.addNinjaMissao(kunoichi);

        listaMissao.add(m4);

        ////////////////////////
        Ninja gaara = new Gennin("Gaara", 14, 'M', 8, 3, 4, 55.5, 60.0, 10.0);
        Ninja kankuro = new Gennin("Kankurō", 16, 'M', 7, 2, 3, 50.0, 30.0, 20.0);
        Ninja temari = new Gennin("Temari", 18, 'F', 7, 5, 3, 60.5, 60.0, 30.0);

        Missao m5 = new Missao("Suna País do Vento", 'D', "Captura");

        listaNinjas.add(gaara);
        listaNinjas.add(kankuro);
        listaNinjas.add(temari);

        m5.addNinjaMissao(gaara);
        m5.addNinjaMissao(kankuro);
        m5.addNinjaMissao(temari);

        listaMissao.add(m5);

        /////////////////////
        Ninja itachi = new Anbu("Itachi", 20, 'M', 7, 7, 9, 70.0, 65.0, 60.0, false, 6);
        Missao m6 = new Missao("Konoha País do Fogo", 'S', "Massacre", true);

        listaNinjas.add(itachi);

        m6.addNinjaMissao(itachi);

        listaMissao.add(m6);

    }

    //GETs
    @GetMapping("/ninjas")
    public List<Ninja> getNinjas() {
        return listaNinjas;
    }

    @GetMapping("/ninjas-classe/{classe}")
    public List<Ninja> getNinjasClasse(@PathVariable String classe) {
        List<Ninja> returnNinja = new ArrayList<>();
        for (Ninja c : listaNinjas) {
            switch (classe.toLowerCase()) {
                case "gennin":
                    if (c instanceof Gennin) {
                        returnNinja.add(c);
                    }
                    break;
                case "chunnin":
                    if (c instanceof Chunnin) {
                        returnNinja.add(c);
                    }
                    break;
                case "jonnin":
                    if (c instanceof Jonnin) {
                        returnNinja.add(c);
                    }
                    break;
                case "anbu":
                    if (c instanceof Anbu) {
                        returnNinja.add(c);
                    }
                    break;
                default:
                    return returnNinja;
            }
        }
        return returnNinja;
    }

    @GetMapping("buscar/ninja/{id}")
    public Ninja buscaNinjaID(@PathVariable int id) {
        return listaNinjas.get(id - 1);
    }

    @GetMapping("/missoes")
    public List<Missao> getMissoes() {
        return listaMissao;
    }

    @GetMapping("buscar/missao/{id}")
    public Missao buscaMissaoID(@PathVariable int id) {
        return listaMissao.get(id - 1);
    }

    //POSTs
    @PostMapping("/cadastrar/ninja/gennin")
    public void cadastrarNinjaG(@RequestBody Gennin n) {
        listaNinjas.add(n);
    }

    @PostMapping("/cadastrar/ninja/chunnin")
    public void cadastrarNinjaC(@RequestBody Chunnin n) {
        listaNinjas.add(n);
    }

    @PostMapping("/cadastrar/ninja/jonnin")
    public void cadastrarNinjaJ(@RequestBody Jonnin n) {
        listaNinjas.add(n);
    }

    @PostMapping("/cadastrar/ninja/anbu")
    public void cadastrarNinjaA(@RequestBody Anbu n) {
        listaNinjas.add(n);
    }

    @PostMapping("/cadastrar/missao")
    public void cadastrarMissao(@RequestBody Missao m) {
        listaMissao.add(m);
    }

    @PostMapping("/cadastrar/ninja/missao/gennin/{id}")
    public void cadastrarNinjaMissaoGennin(@PathVariable int id, @RequestBody Gennin n) {
        listaMissao.get(id - 1).addNinjaMissao(n);
    }

    @PostMapping("/cadastrar/ninja/missao/chunnin/{id}")
    public void cadastrarNinjaMissaoChunnin(@PathVariable int id, @RequestBody Chunnin n) {
        listaMissao.get(id - 1).addNinjaMissao(n);
    }

    @PostMapping("/cadastrar/ninja/missao/jonnin/{id}")
    public void cadastrarNinjaMissaoJonnin(@PathVariable int id, @RequestBody Jonnin n) {
        listaMissao.get(id - 1).addNinjaMissao(n);
    }

    @PostMapping("/cadastrar/ninja/missao/anbu/{id}")
    public void cadastrarNinjaMissaoGAnbu(@PathVariable int id, @RequestBody Anbu n) {
        listaMissao.get(id - 1).addNinjaMissao(n);
    }

    //DETELEs
    @DeleteMapping("/excluir/ninja/{id}")
    public void excluirNinja(@PathVariable int id) {
        String nomeN = listaNinjas.get(id - 1).getNome();
        for (int idLMissao = 0; idLMissao < listaMissao.size(); idLMissao++) {
            for (int idLNinjaM = 0; idLNinjaM < listaMissao.get(idLMissao).getListNinja().size(); idLNinjaM++) {
                if (nomeN.equals(listaMissao.get(idLMissao).getListNinja().get(idLNinjaM).getNome())) {
                    int idM = listaMissao.indexOf(listaMissao.get(idLMissao));
                    excluirNinjaMissao(idM + 1, idLNinjaM + 1);
                }
            }
        }
        listaNinjas.remove(id - 1);
    }

    @DeleteMapping("/excluir/missao/{id}")
    public void excluirMissao(@PathVariable int id) {
        listaMissao.remove(id - 1);
    }

    @DeleteMapping("/excluir/missao/ninja/{idm}/{idn}")
    public void excluirNinjaMissao(@PathVariable int idm, @PathVariable int idn) {
        listaMissao.get(idm - 1).getListNinja().remove(idn - 1);
    }

    //PUTs
    @PutMapping("/atualizar/ninja/gennin/{id}")
    public void atualizarNinjaG(@PathVariable int id, @RequestBody Gennin n) {
        if (listaNinjas.get(id - 1).getTipoNinja().equals("Gennin")) {
            String nomeN = listaNinjas.get(id - 1).getNome();
            for (int idLMissao = 0; idLMissao < listaMissao.size(); idLMissao++) {
                for (int idLNinjaM = 0; idLNinjaM < listaMissao.get(idLMissao).getListNinja().size(); idLNinjaM++) {
                    if (nomeN.equals(listaMissao.get(idLMissao).getListNinja().get(idLNinjaM).getNome())) {
                        int idM = listaMissao.indexOf(listaMissao.get(idLMissao));
                        if (listaMissao.get(idM).getRank() == 'D' || listaMissao.get(idM).getRank() == 'C') {
                            listaMissao.get(idM).getListNinja().set(idLNinjaM, n);
                        } else {
                            excluirNinjaMissao(idM + 1, idLNinjaM + 1);
                        }
                    }
                }
            }
            listaNinjas.set(id - 1, n);
        }

    }

    @PutMapping("/atualizar/ninja/chunnin/{id}")
    public void atualizarNinjaC(@PathVariable int id, @RequestBody Chunnin n) {
        String tipoNome = listaNinjas.get(id - 1).getTipoNinja();
        if (tipoNome.equals("Chunnin") || tipoNome.equals("Gennin")) {
            String nomeN = listaNinjas.get(id - 1).getNome();
            for (int idLMissao = 0; idLMissao < listaMissao.size(); idLMissao++) {
                for (int idLNinjaM = 0; idLNinjaM < listaMissao.get(idLMissao).getListNinja().size(); idLNinjaM++) {
                    if (nomeN.equals(listaMissao.get(idLMissao).getListNinja().get(idLNinjaM).getNome())) {
                        int idM = listaMissao.indexOf(listaMissao.get(idLMissao));
                        if (listaMissao.get(idM).getRank() == 'C' || listaMissao.get(idM).getRank() == 'B') {
                            listaMissao.get(idM).getListNinja().set(idLNinjaM, n);
                        } else {
                            excluirNinjaMissao(idM + 1, idLNinjaM + 1);
                        }
                    }
                }
            }
            listaNinjas.set(id - 1, n);
        }
    }

    @PutMapping("/atualizar/ninja/jonnin/{id}")
    public void atualizarNinjaJ(@PathVariable int id, @RequestBody Jonnin n) {
        String tipoNome = listaNinjas.get(id - 1).getTipoNinja();
        if (tipoNome.equals("Jonnin") || tipoNome.equals("Anbu") || tipoNome.equals("Chunnin") || tipoNome.equals("Gennin")) {
            String nomeN = listaNinjas.get(id - 1).getNome();
            for (int idLMissao = 0; idLMissao < listaMissao.size(); idLMissao++) {
                for (int idLNinjaM = 0; idLNinjaM < listaMissao.get(idLMissao).getListNinja().size(); idLNinjaM++) {
                    if (nomeN.equals(listaMissao.get(idLMissao).getListNinja().get(idLNinjaM).getNome())) {
                        int idM = listaMissao.indexOf(listaMissao.get(idLMissao));
                        if (listaMissao.get(idM).getRank() == 'D' || listaMissao.get(idM).getRank() == 'C' ||
                                listaMissao.get(idM).getRank() == 'B' || listaMissao.get(idM).getRank() == 'A' || listaMissao.get(idM).getRank() == 'S') {
                            listaMissao.get(idM).getListNinja().set(idLNinjaM, n);
                        } else {
                            excluirNinjaMissao(idM + 1, idLNinjaM + 1);
                        }
                    }
                }
            }
            listaNinjas.set(id - 1, n);
        }
    }

    @PutMapping("/atualizar/ninja/anbu/{id}")
    public void atualizarNinjaA(@PathVariable int id, @RequestBody Anbu n) {
        String tipoNome = listaNinjas.get(id - 1).getTipoNinja();
        if (tipoNome.equals("Anbu") || tipoNome.equals("Jonnin") || tipoNome.equals("Chunnin") || tipoNome.equals("Gennin")) {
            String nomeN = listaNinjas.get(id - 1).getNome();
            for (int idLMissao = 0; idLMissao < listaMissao.size(); idLMissao++) {
                for (int idLNinjaM = 0; idLNinjaM < listaMissao.get(idLMissao).getListNinja().size(); idLNinjaM++) {
                    if (nomeN.equals(listaMissao.get(idLMissao).getListNinja().get(idLNinjaM).getNome())) {
                        int idM = listaMissao.indexOf(listaMissao.get(idLMissao));
                        if (listaMissao.get(idM).getRank() == 'B' || listaMissao.get(idM).getRank() == 'A' || listaMissao.get(idM).getRank() == 'S') {
                            listaMissao.get(idM).getListNinja().set(idLNinjaM, n);
                        } else {
                            excluirNinjaMissao(idM + 1, idLNinjaM + 1);
                        }
                    }
                }
            }
            listaNinjas.set(id - 1, n);
        }
    }

    @PutMapping("/atualizar/missao/{id}")
    public void atualizarMissao(@PathVariable int id, @RequestBody Missao m) {
        int idMissao = id - 1;
        List<Ninja> listaNinjaMissao = listaMissao.get(idMissao).getListNinja();
        listaMissao.set(idMissao, m);
        for(Ninja n: listaNinjaMissao){
            listaMissao.get(idMissao).addNinjaMissao(n);
        }


    }


}
