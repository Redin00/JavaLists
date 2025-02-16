package org.redinn;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Questo programma ha lo scopo di ricreare le liste in java, per comprenderne il funzionamento e la loro gestione.
        // La lista in questo programma viene utilizzata per immagazzinare i dati relativi agli studenti, attraverso un menu interattivo.
        // Si fa uso di due classi principali: Nodo e ListaStudenti


        System.out.println("===========================================");
        System.out.println("Benvenuto nel programma gestione liste!");
        System.out.println("===========================================");
        System.out.println();

        ListaStudenti lista = new ListaStudenti();
        String ch = ""; // Variabile per la scelta comando nel menu interattivo utilizzato per la gestione della lista.

        Scanner input = new Scanner(System.in);

        System.out.println("######### IMPLEMENTAZIONE LISTE IN JAVA #########\n");

        boolean loop = true;
        // Loop programma
        while(loop){

            System.out.println("Decidi quali operazioni eseguire sulla lista studenti! (USCITA PROGRAMMA: 0)");
            System.out.println("1 <> Stampa lista studenti");
            System.out.println("2 <> Aggiungi uno studente alla lista");
            System.out.println("3 <> Elimina uno studente dalla lista\n");

            System.out.print("Operazione da eseguire >> ");
            ch = input.nextLine();

            switch(ch){
                case "0":
                    loop = false;

                    System.out.println("Uscita programma in corso....");
                    Thread.sleep(500);

                    break;
                case "1":

                    if(lista.isVuota()){
                        System.out.println("La lista e' attualmente vuota.");
                    }
                    else{
                        System.out.println("Lista studenti:");
                        lista.visualizzaLista();
                    }
                    System.out.println("\n");
                    break;
                case "2":

                    System.out.print("\nInserisci nome nuovo studente >> ");
                    String tempNome = input.nextLine();
                    System.out.print("Inserisci cognome >> ");
                    String tempCognome = input.nextLine();
                    System.out.print("Voto in pagella >> ");
                    int tempVoto = input.nextInt();

                    input.nextLine(); // Rimuoviamo la "\n" che viene rilasciata dalla funzione nextInt() e che può creare un salto di input in seguito.


                    System.out.println("\nScegli il tipo di inserimento che desideri:");
                    System.out.println("1 - Inserimento in coda");
                    System.out.println("2 - Inserimento in testa");
                    System.out.println("3 - Inserimento in ordine (basato sul voto maggiore)");

                    System.out.print("Operazione da eseguire >> ");
                    ch = input.nextLine();

                    if(Objects.equals(ch, "1")){
                        lista.inserisciInCoda(new Studente(tempNome, tempCognome, tempVoto));
                    }
                    else if (Objects.equals(ch, "2")) {
                        lista.inserisciInTesta(new Studente(tempNome, tempCognome, tempVoto));
                    }
                    else if(Objects.equals(ch, "3")){
                        lista.inserimentoInOrdine(new Studente(tempNome, tempCognome, tempVoto));
                    }

                    System.out.println("Studente correttamente inserito!\n\n");

                    break;

                case "3":

                    System.out.println("\nScegli il tipo di eliminazione:");
                    System.out.println("1 - Eliminazione in coda");
                    System.out.println("2 - Eliminazione in testa");
                    System.out.println("3 - Eliminazione di tutti gli elementi");
                    System.out.println("4 - Eliminazione in ordine (in base al nome e cognome inserito)");

                    System.out.print("Operazione da eseguire >> ");
                    ch = input.nextLine();

                    // Si potrebbe anche implementare uno switch case, ma ho preferito fare uso di if e else-if per renderlo meno ridondante
                    if(Objects.equals(ch, "1")){
                        lista.eliminaInCoda();
                        System.out.println("Studente correttamente rimosso dalla lista.");
                    }
                    else if(Objects.equals(ch, "2")){
                        lista.eliminaInTesta();
                        System.out.println("Studente correttamente rimosso dalla lista.");
                    }
                    else if(Objects.equals(ch, "3")){
                        lista.eliminaTutto();
                        System.out.println("Studente/i correttamente rimosso/i dalla lista.");
                    }
                    else if(Objects.equals(ch, "4")){
                        System.out.print("Inserisci il nome dello studente da rimuovere dalla lista >> ");
                        String nome = input.nextLine();
                        System.out.print("Inserisci ora il cognome >> ");
                        String cognome = input.nextLine();

                        if(lista.eliminaInOrdine(nome, cognome)){
                            System.out.println("Studente correttamente rimosso dalla lista.");
                        }
                        else{
                            System.out.println("Lo studente cercato non è stato trovato.");
                        }
                    }
                    else{
                        System.out.println("Errore! Il numero inserito non e' compreso nell'intervallo di scelte (1-4).");
                    }

                    System.out.println("\n");


                    break;
                default:
                    System.out.println("\nErrore! Il numero inserito non e' compresso nell'intervallo di scelte (1-3).");

            }

            if(loop){
                System.out.print("Premi invio per continuare...");
                input.nextLine();
                System.out.println();
            }


        }

        input.close();

    }
}