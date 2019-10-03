public class Oblig {

    public static void main(String[] args) {
        // Oppgave 1
        Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + "  " + liste.tom());

        String[] s = { "Ole" , null , "Per" , "Kari ", null };
        Liste<String> liste2 = new DobbeltLenketListe<>(s);
        System. out .println(liste2.antall () + " " + liste2.tom ());

    }

}
