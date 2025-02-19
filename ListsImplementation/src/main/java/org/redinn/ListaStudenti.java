package org.redinn;

// Classe per una lista che si occupa della gestione degli studenti. I metodi implementati sono ovviamente simili a quelli utilizzati nella lista default di java
// Con qualche modifica alla stampa della lista e l'aggiunta del metodo "inserimentoInOrdine".

import java.util.Objects;

public class ListaStudenti
{

    private Nodo head;
    private int nElementi;

    public ListaStudenti()
    {
        head = null;
        nElementi = 0;
    }

    // Restituisce il nodo head, utilizzabile per l'operazione di visualizzazione ricorsiva della lista o altri scopi
    public Nodo getHead(){
        return head;
    }

    // Restituisce la lunghezza della lista
    public int getLunghezza(){
        return nElementi;
    }

    // Restituisce se la lista e' vuota oppure no
    public boolean isVuota(){
        return nElementi == 0;
    }

    public void visualizzaLista()
    {
        Nodo n = head;
        while(n != null)
        {
            // Stampiamo le informazioni della lista chiamando il metodo della classe Studente
            n.getDati().StampaInformazioni();

            n = n.getLink();
        }
    }


    public void visualizzaRicorsivo(Nodo n){
        // Metodo che ci permette di visualizzare il contenuto della lista, ma sfruttando la ricorsione
        if(n == null){
            return;
        }

        n.getDati().StampaInformazioni();
        visualizzaRicorsivo(n.getLink());
    }

    // Inserimento di un oggetto nella testa della lista
    public void inserisciInTesta(Studente dati) {

        Nodo n = new Nodo(dati);
        n.setLink(head);

        head = n;
        nElementi++;
    }

    // Inserimento in coda di un oggetto
    public void inserisciInCoda(Studente dati)
    {

        if(head == null){
            head = new Nodo(dati);
            nElementi++;
            return;
        }

        Nodo c = new Nodo(dati);
        Nodo n = head;

        while(n.getLink() != null)
        {
            n = n.getLink();
        }

        n.setLink(c);
        c.setLink(null);
        nElementi++;
    }

    // Metodo per inserire in ordine i dati di ogni studente. L'ordinamento e' fatto in modo decrescente a partire dal voto
    public void inserimentoInOrdine(Studente dati){

        // Se la lista è vuota, inseriamo i dati senza sfruttare controlli e cicli vari
        if(head == null){
            head = new Nodo(dati);
            nElementi++;
            return;
        }

        Nodo n = new Nodo(dati);
        Nodo attuale = head;
        Nodo successivo = head.getLink();


        // Scorro finché non raggiungo la fine o finché non trovo un voto minore del voto che voglio inserire
        while(successivo != null && successivo.getDati().getVoto() > dati.getVoto()){

            attuale = successivo;
            successivo = successivo.getLink();
        }

        if(successivo == null){
            inserisciInCoda(dati);
        }
        else{
            n.setLink(successivo);
            attuale.setLink(n);
            nElementi++;
        }

    }


    // Eliminazione di un elemento della lista dato un indice di posizione
    public void elimina(int index){

        if(index == 0){
            head = head.getLink();
            nElementi--;
            return;
        }

        Nodo c = head;
        Nodo d = head.getLink();

        for(int i=index-1; i>0; i--){
            c = d;
            d = d.getLink();
        }

        c.setLink(d.getLink());
        nElementi--;

    }


    // Eliminazione dell'elemento in testa alla lista
    public void eliminaInTesta()
    {
        if(head != null)
        {
            head = head.getLink();
            nElementi--;
        }
    }


    // Eliminazione dell'elemento in coda alla lista
    public void eliminaInCoda()
    {

        if(nElementi > 1) {
            Nodo pu = head;
            Nodo u = head.getLink();

            while (u.getLink() != null) {
                pu = u;
                u = u.getLink();
            }

            pu.setLink(null);
            nElementi--;
        }
        else{
            eliminaInTesta();
        }
    }

    // Eliminazione in base ai parametri di input. I parametri utilizzati per questa eliminazione sono il nome e il cognome.
    public boolean eliminaInOrdine(String nome, String cognome){

        // Il metodo ritorna "true" se viene trovata una corrispondenza, "false" se invece non esiste nessun elemento con i parametri inseriti.

        if(head != null) {
            // Metodo per eliminare un elemento dalla lista a nostra scelta, senza sapere la posizione di quest'ultimo
            Nodo prima = head;
            Nodo dopo = head.getLink();

            // Prima viene controllato il nodo della testa, per verificare se i parametri inseriti corrispondano a quest'ultimo, altrimenti viene ciclata la lista.
            if (Objects.equals(head.getDati().getNome(), nome) && Objects.equals(head.getDati().getCognome(), cognome)) {
                eliminaInTesta();
                return true;
            }
            else if(dopo != null)
            {
                // Scorriamo la lista finché non arriviamo ad un nodo nel quale il nome e il cognome passati come parametri sono stati trovati o finché non arriviamo alla fine della lista.
                while (dopo.getLink() != null && (!Objects.equals(dopo.getDati().getNome(), nome) || !Objects.equals(dopo.getDati().getCognome(), cognome))) {
                    prima = dopo;
                    dopo = dopo.getLink();
                }

                // Controlliamo che il nodo attuale abbia come parametri quelli passati, se sì andiamo ad eliminarlo.
                if(Objects.equals(dopo.getDati().getNome(), nome) && Objects.equals(dopo.getDati().getCognome(), cognome)){
                    prima.setLink(dopo.getLink());  // Questo ci permette di spostare il link al nodo successivo a quello che vogliamo eliminare
                    nElementi--;
                    return true;
                }

            }
        }

        return false;

    }


    // Metodo per eliminare tutti gli elementi della lista
    public void eliminaTutto(){

        if(head != null){
            head.setLink(null);
            head = null;
            nElementi = 0;
        }

    }

    // Permette di ottenere il dato da un indice in input
    public Studente get(int index){

        Nodo n = head;

        for(int i=index; i>0; i--){
            n = n.getLink();
        }

        return n.getDati();
    }


    // Restituisce i dati contenuti nel primo elemento
    public Studente getPrimo(){
        return head.getDati();
    }


    // Restituisce i dati contenuti nell'ultimo elemento
    public Studente getUltimo(){

        Nodo n = head;

        while(n.getLink() != null){
            n = n.getLink();
        }

        return n.getDati();
    }


    // Metodo utilizzato per impostare il valore di un elemento nella lista, iterando in base all'indice.
    public void set(int index, Studente dati){

        Nodo n = head;

        for(int i=index; i>0; i--){
            n = n.getLink();
        }

        n.setDati(dati);
    }

}
