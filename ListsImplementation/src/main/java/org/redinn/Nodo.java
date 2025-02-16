package org.redinn;

public class Nodo
{
    // Classe che rappresenta ogni singolo nodo di una lista. Ogni nodo contiene i dati e il link al prossimo nodo


    private Studente dati;
    private Nodo link;  // Memorizza il prossimo nodo (sarà null se quello attuale è già l'ultimo)

    public Nodo(Studente oggetto) {
        dati = oggetto;
        link = null;

    }

    // Getters e Setters

    public Studente getDati() {
        return dati;
    }

    public Nodo getLink() {
        return link;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }

    public void setDati(Studente dati){
        this.dati = dati;
    }

}
