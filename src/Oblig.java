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
    }

}
