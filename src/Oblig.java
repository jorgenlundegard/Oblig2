public class Oblig {

    public static void main(String[] args) {
        // Oppgave 1


        Liste<Integer> listetest = new DobbeltLenketListe<>(new Integer[]{1});
        System.out.println(listetest.antall() + "  " + listetest.tom());
        System.out.println(listetest.toString());

        Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + "  " + liste.tom());
        System.out.println(liste.toString());



        String[] s = {};
        DobbeltLenketListe<String> liste2 = new DobbeltLenketListe<>(s);
        System.out.println(liste2.antall () + " " + liste2.tom ());
        System.out.println(liste2.toString());
        System.out.println(liste2.omvendtString());


        //Oppgave 2 a)
        String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + "​  "+ l2.toString()     +"​ ​"+ l3.toString() +"​ ​"+ l1.omvendtString() +
                "​ ​"     + l2.omvendtString() +"​ ​" + l3.omvendtString());


        //b)
        DobbeltLenketListe<Integer> liste3 = new DobbeltLenketListe<>();
        System.out.println(liste3.toString() + "​ ​" + liste3.omvendtString());
        for(int i = 1; i <= 3; i++)   {
            liste3.leggInn(i);
            System.out.println(liste3.toString() + "​ ​" + liste3.omvendtString());
        }

        // Oppgave 3
        System.out.println("\nOppgave 3:");
        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> listeo3 = new DobbeltLenketListe<>(c);
        System.out.println("Antall: " + listeo3.antall());
        System.out.println(listeo3.hent(0));
        System.out.println(listeo3.hent(1));
        System.out.println(listeo3.hent(2));
        System.out.println(listeo3.hent(3));
        System.out.println(listeo3.hent(4));
        System.out.println(listeo3.hent(5));
        System.out.println(listeo3.hent(6));
        System.out.println(listeo3.hent(7));
        System.out.println(listeo3.hent(8));
        System.out.println(listeo3.hent(9));
        System.out.println(listeo3.subliste(3,8));  // [D, E, F, G, H]
        System.out.println(listeo3.subliste(5,5));  // []
        System.out.println(listeo3.subliste(8,listeo3.antall()));  // [I, J]
        //System.out.println(listeo3.subliste(0,11));  // skal kaste unntak*/


        //Oppgave 6
        System.out.println("Oppgave 6:");
        l1 = new DobbeltLenketListe<>();
        System.out.println(l1.toString() + l1.getEndringer());
        l1.leggInn("A");
        System.out.println(l1.toString() + l1.getEndringer());
        l1.fjern(0);
        System.out.println(l1.toString() + l1.getEndringer());

        l1.leggInn("A");

        System.out.println(l1.toString() + l1.getEndringer());

        //Oppgave 8
        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Liste<String> listeo8 = new DobbeltLenketListe<>(navn);

        for (String o8 : listeo8) System.out.print(o8 + " ");
        System.out.println();
        listeo8.forEach(o8 -> System.out.print(o8 + " "));

        //Oppgave 9
        DobbeltLenketListe<String> listeo9 = new DobbeltLenketListe<>(new String[]
                {"Birger","Lars","Anders","Bodil","Kari","Per","Berit"});
        listeo9.fjernHvis(navnet -> navnet.charAt(0) =='B'); // fjerner navn som starter med B
        System.out.println(liste + "​ ​" + listeo9.omvendtString());





    }
}
