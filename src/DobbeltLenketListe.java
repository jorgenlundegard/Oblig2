////////////////// class DobbeltLenketListe //////////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private Node<T> forrigeNode;
    private Node<T> currentNode;
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen
    private int hodeIndex;         // hjelpevariable for konstruktoren
    private int haleIndex;


    // hjelpemetode
    private Node<T> finnNode(int indeks) throws IndexOutOfBoundsException {
        if (indeks < antall/2){     // leting starter ved hode og mot høyre

            Node current = hode;
            int teller = 0;

            while (current != null) {
                if (teller == indeks){
                    return current;
                }
                teller++;
                current = current.neste;
            }
        }
        else{                       // leting starter ved hale og mot venstre

            Node current = hale;
            int teller = antall;

            while (current != null) {
                if (teller == indeks){
                    return current;
                }
                teller--;
                current = current.forrige;
            }
        }
        return null;
    }


    public DobbeltLenketListe() {

    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a, "Tabellen er Null!");
        if(a.length==0) {                                       //Spesialtilfelle der tabellen a er tom men ikke null
            hode = null;
            hale = null;
        }else if(a.length==1){                                  //Spesialtilfelle der tabellen a kun har 1 element
            if(a[0]==null){
                hode = null;
                hale = null;
            }else {
                hode = new Node<>(a[0]);
                hale = hode;
                antall ++;
            }
        }else {                                                 //hvis tabellen har flere enn ett ikke-null elementer gaar vi videre.
            //setter verdi for hode, forste ikke-null element i tabellen.
            for (int i = 0; i < a.length; i++) {
                if (a[i] != null) {
                    hode = new Node<>(a[i], null, null);
                    hodeIndex = i;
                    forrigeNode = hode;
                    antall++;
                    break;
                }
            }
            //setter verdi for hale, siste ikke-null element i tabellen.
            for (int i = a.length - 1; i > hodeIndex; i--) {
                if (a[i] != null) {
                    hale = new Node<>(a[i], null, null);
                    haleIndex = i;
                    antall++;
                    break;
                }
            }
            //instansierer noder for resten av de ikke null elementene i tabellen a hvis de eksisterer.
            for (int i = hodeIndex + 1; i < haleIndex; i++) {
                if (a[i] != null) {
                    assert forrigeNode != null; //noe compileren gjorde for aa fjerne warning
                    forrigeNode.neste = new Node<>(a[i], forrigeNode, null);
                    forrigeNode = forrigeNode.neste;
                    antall++;
                }
            }
            if(antall==0){                              //hvis antall fortsatt er null besto tabellen kun av null elementer.
                hode = null;
                hale = null;
            }else if(antall==1){                        //hvis antall er 1 her betyr det at tabellen hadde flere enn 1 element, men kun ett av dem var ikke-null.
                hale = hode;
            }else {                                     //setter neste peker til hale i nest siste node.
                assert forrigeNode != null;             //for aa fjerne warning, aner ikke hva det gjor.
                forrigeNode.neste = hale;
                assert hale != null;
                hale.forrige = forrigeNode;
            }
        }
    }

    public Liste<T> subliste(int fra, int til){
        throw new NotImplementedException();
    }

    @Override
    public int antall() { //antallet ikke-null noder i listen.
        return antall;
    }

    @Override
    public boolean tom() { //er listen tom for ikke-null noder?
        if(antall==0){return true;}
        return false;
    }

    @Override
    public boolean leggInn(T verdi) { //metode for aa legge til verdi paa slutten av listen.
        Objects.requireNonNull(verdi, "Null verdier ikke tillatt.");
        if(hode == null && hale == null && antall == 0){
            hode = new Node<>(verdi);
            hale = hode;
            antall++;
        } else{
            hale.neste = new Node<>(verdi, hale, null); //instansierer ny node
            hale = hale.neste; //setter "hale" til aa peke paa denne.
            antall++; //oppdaterer antall noder.
        }
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean inneholder(T verdi) {
        int indexTil = indeksTil(verdi);
        if(indexTil==-1){
            return false;
        }else{return true;}
    }

    @Override
    public T hent(int indeks) {

        indeksKontroll(indeks,false);
        if (indeks >= antall) {throw new IndexOutOfBoundsException("Listen har kun " + antall + " antall elementer. Indeks " + indeks + " er for høy.");}
        if (tom() == true || indeks < 0){ throw new IndexOutOfBoundsException("Listen er tom, denne indeksen finnes ikke");}

        Node funnetNode = finnNode(indeks);
        return ((T) funnetNode.verdi);

    }

    @Override
    public int indeksTil(T verdi) {
        int index = 0;
        if(hode==null){return -1;}
        if(hode.verdi.equals(verdi)){
            return index;
        }
        index ++;
        forrigeNode = hode;
        while(forrigeNode!=hale){
            if(forrigeNode.neste.verdi.equals(verdi)){
                return index;
            } else{
                forrigeNode = forrigeNode.neste;
                index ++;
            }
        }
        if(hale.verdi.equals(verdi)){
            return index;
        }else{return -1;}
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean fjern(T verdi) {
        if (antall==0){return false;}
        if (antall==1){
            if (hode.verdi.equals(verdi)){
                hode = null;
                hale = null;
                antall--;
                return true;
            }
            else {return false;}
        }
        forrigeNode = hode;
        while (forrigeNode!=hale){
            if (forrigeNode.verdi.equals(verdi)){
                try {
                    forrigeNode.forrige.neste = forrigeNode.neste;
                }catch (NullPointerException e){
                    hode = hode.neste;
                    hode.forrige = null;
                }
                forrigeNode.neste.forrige = forrigeNode.forrige;
                antall--;
                return true;
            }
            forrigeNode = forrigeNode.neste;
        }
        if (hale.verdi.equals(verdi)){
            hale = hale.forrige;
            hale.neste = null;
            antall--;
            return true;
        }
        return false;
    }

    @Override
    public T fjern(int indeks) {
        if (antall == 0){throw new IndexOutOfBoundsException("listen er tom, denne indeksen finnes ikke");}
        if (indeks < 0 || indeks >= antall) {throw new IndexOutOfBoundsException();}
        T verdi;
        forrigeNode = hode;
        for (int i = 0; i < indeks; i++){
            forrigeNode = forrigeNode.neste;
        }
        verdi = forrigeNode.verdi;
        try {
            forrigeNode.neste.forrige = forrigeNode.forrige;
        } catch (NullPointerException e){
            try {
                hale = hale.forrige;
                hale.neste = null;
            }catch (NullPointerException E){ //hverken forrige eller neste finnes
                hale = null;
                hode = null;
                antall--;
                return verdi;
            }
        }
        try {
            forrigeNode.forrige.neste = forrigeNode.neste;
        }catch (NullPointerException e){
            hode = hode.neste;
            hode.forrige = null;
        }
        antall--;
        return verdi;

    }

    @Override
    public void nullstill() {

        long startTime = System.nanoTime();

        // Metode 1
        currentNode = hode.neste;
        while (currentNode.neste != hale) { // Fjerner alt mellom hode og hale
            currentNode.forrige.forrige = null;
            currentNode.forrige = null;
            currentNode.verdi = null;
            currentNode = currentNode.neste;
        }

        hode.neste = null; // Nuller ut hode
        hode.verdi = null;

        hale.forrige = null; // Nuller ut hale
        hale.verdi = null;

        fjern(0); // Fjerner siste null-element

        antall = 0;

        // Metode to
        /*
        while (antall != 0){
            fjern(0);
        }
        */

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Nanosekunder: " + timeElapsed);
        // Metode 1 utførtes på 67698 nanosekunder
        // Metode 2 utførtes på 210489 nanosekunder, betraktelig mye lenger tid.


    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        if(hode!=null) {
            str.append(hode.verdi);
        } else{return("[]");}
        forrigeNode = hode;
        while(forrigeNode.neste!=null){
            str.append(", ");
            str.append(forrigeNode.neste.verdi);
            forrigeNode = forrigeNode.neste;
        }
        str.append("]");
        return str.toString();
    }

    public String omvendtString() {
        StringBuilder omvstr = new StringBuilder();
        omvstr.append("[");
        if(hale!=null) {
            omvstr.append(hale.verdi);
        } else{return("[]");}
        forrigeNode = hale;
        while(forrigeNode.forrige!=null){
            omvstr.append(", ");
            omvstr.append(forrigeNode.forrige.verdi);
            forrigeNode = forrigeNode.forrige;
        }
        omvstr.append("]");
        return omvstr.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new NotImplementedException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new NotImplementedException();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new NotImplementedException();
        }

        @Override
        public void remove(){
            throw new NotImplementedException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new NotImplementedException();
    }

} // class DobbeltLenketListe


