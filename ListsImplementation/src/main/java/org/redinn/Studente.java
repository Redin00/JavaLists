package org.redinn;

import java.text.DecimalFormat;

public class Studente {

    // Classe studente che si occupa di immagazzinare il nome, il cognome e il voto di quest'ultimo in una materia (nel nostro caso faremo informatica lol)

    private String nome;
    private String cognome;
    private int voto;

    public Studente(String nome, String cognome, int voto){
        this.nome = nome;
        this.cognome = cognome;
        this.voto = voto;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public int getVoto(){
        return voto;
    }

    // Stampa le informazioni sullo studente in modo formattato
    public void StampaInformazioni(){

        // Pattern per mostrare il voto (che è di tipo double) con solo 2 cifre decimali

        System.out.println("Nome: " + nome + " Cognome: " + cognome + " | " + "Voto: " + voto);
    }

}
