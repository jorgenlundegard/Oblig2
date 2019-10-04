////////////////// class DobbeltLenketListe //////////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
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

    public DobbeltLenketListe() {

    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a, "Tabellen er Null!");
        if(a.length==0) {
            hode = null;
            hale = null;
        }else if(a.length==1){
            if(a[0]==null){
                hode = null;
                hale = null;
            }else {
                hode = new Node<>(a[0]);
                hale = hode;
                antall ++;
            }
        }else {
            //setter verdi for hode;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != null) {
                    hode = new Node<>(a[i], null, null);
                    hodeIndex = i;
                    forrigeNode = hode;
                    antall++;
                    break;
                }
            }
            //setter verdi for hale;
            for (int i = a.length - 1; i > hodeIndex; i--) {
                if (a[i] != null) {
                    hale = new Node<>(a[i], null, null);
                    haleIndex = i;
                    antall++;
                    break;
                }
            }
            //instansierer noder for resten av de ikke null elementene i listen a
            for (int i = hodeIndex + 1; i < haleIndex; i++) {
                if (a[i] != null) {
                    assert forrigeNode != null;
                    forrigeNode.neste = new Node<>(a[i], forrigeNode, null);
                    forrigeNode = forrigeNode.neste;
                    antall++;
                }
            }
            if(antall==0){
                hode = null;
                hale = null;
            }else if(antall==1){
                hale = hode;
            }else {
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
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        if(antall==0){return true;}
        return false;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Null verdier ikke tillatt.");
        if(hode == null && hale == null && antall == 0){
            hode = new Node<>(verdi);
            hale = hode;
            antall++;
        } else{
            hale.neste = new Node<>(verdi, hale, null);
            hale = hale.neste;
            antall++;
        }
        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T hent(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T fjern(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public void nullstill() {
        throw new NotImplementedException();
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
        StringBuilder str = new StringBuilder();
        str.append("[");
        if(hale!=null) {
            str.append(hale.verdi);
        } else{return("[]");}
        forrigeNode = hale;
        while(forrigeNode.forrige!=null){
            str.append(", ");
            str.append(forrigeNode.forrige.verdi);
            forrigeNode = forrigeNode.forrige;
        }
        str.append("]");
        return str.toString();
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
            throw new NotImplementedException();
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new NotImplementedException();
        }

        @Override
        public boolean hasNext(){
            throw new NotImplementedException();
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


