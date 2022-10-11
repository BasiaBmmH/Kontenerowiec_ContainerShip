import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConteinerShip {
    public static void main(String[] args) throws FileNotFoundException {

        Kontener.utworzKontenery(); // generuje i zapisuje w pliku .txt 15000 kontenerow
        Kontenerowiec.zczytywanie();
        Kontenerowiec.zaladunek();

//        Kontenerowiec.graficznePrzedstawienieKontenerow(); //pokazuje poklady wypelnione kontenerami7 poziomow kontenerow(pion) | 10 stoi obok siebie (szerokosc statku) | 23 wzdluz osi statku (dlugosc statku)

    }

}

class Kontener {
    private String typ;
    private String nazwaKontenera;
    private double wysokosc;
    private double szerokosc;
    private double dlugosc;
    private double masa;
    private static String towar;


    static Kontener[] kontenery = new Kontener[15000];


    public Kontener(String nazwaKontenera, String typ, double dlugosc, String towar) {
        this.typ = typ;
        this.dlugosc = dlugosc;
        this.nazwaKontenera = nazwaKontenera;
        this.wysokosc = 270;
        this.szerokosc = 235;
        this.towar = towar;
        this.masa = (int) (Math.random() * 5000) + 3000;

    }


    public static void utworzKontenery() throws FileNotFoundException { //generowanie 15000 kontenerow
        PrintWriter zapis = new PrintWriter("kontenery.txt");

        for (int i = 0; i < 15000; i++) {

            int jakiTowar = (int) (Math.random() * 4) + 1;

            switch (jakiTowar) { //wybor towaru
                case 1:
                    towar = "mrozonki";
                    break;
                case 2:
                    towar = "ciecze";
                    break;
                case 3:
                    towar = "materialy budowlane";
                    break;
                case 4:
                    towar = "gumowe kaczki";
                    break;
                case 5:
                    towar = "wegiel";
                    break;
            }

            int b = (int) (Math.random() * 1) + 1;
            String nazwa = "K" + (i + 1);
            switch (b) { //wybor typu kontenera i jego wielkosci
                case 1:
                    if (towar == "mrozonki") {
                        Kontener kontener = new Kontener(nazwa, "chlodniczy", 239, towar);
                        kontenery[i] = kontener;
                        zapis.println("Nazwa kontenera: " + kontener.nazwaKontenera + " |  Wysokosc: " + kontener.wysokosc + "cm  |Szerokosc: " + kontener.szerokosc + "cm  |Dlugosc: " + kontener.dlugosc + "cm  |Towar: " + kontener.towar + "  | Masa: " + kontener.masa + "kg");
                    }
                    if (towar == "ciecze") {
                        Kontener kontener = new Kontener(nazwa, "ciecze", 239, towar);
                        kontenery[i] = kontener;
                        zapis.println("Nazwa kontenera: " + kontener.nazwaKontenera + " |  Wysokosc: " + kontener.wysokosc + "cm  |Szerokosc: " + kontener.szerokosc + "cm  |Dlugosc: " + kontener.dlugosc + "cm  |Towar: " + kontener.towar + "  | Masa: " + kontener.masa + "kg");
                    } else {
                        Kontener kontener = new Kontener(nazwa, "klasyczny", 239, towar);
                        kontenery[i] = kontener;
                        zapis.println("Nazwa kontenera: " + kontener.nazwaKontenera + " |  Wysokosc: " + kontener.wysokosc + "cm  |Szerokosc: " + kontener.szerokosc + "cm  |Dlugosc: " + kontener.dlugosc + "cm  |Towar: " + kontener.towar + "  | Masa: " + kontener.masa + "kg");

                    }
                    break;
                case 2:
                    if (towar == "mrozonki") {
                        Kontener kontener = new Kontener(nazwa, "chlodniczy", 270, towar);
                        kontenery[i] = kontener;
                        zapis.println("Nazwa kontenera: " + kontener.nazwaKontenera + " |  Wysokosc: " + kontener.wysokosc + "cm  |Szerokosc: " + kontener.szerokosc + "cm  |Dlugosc: " + kontener.dlugosc + "cm  |Towar: " + kontener.towar + "  | Masa: " + kontener.masa + "kg");
                    }
                    if (towar == "ciecze") {
                        Kontener kontener = new Kontener(nazwa, "ciecze", 270, towar);
                        kontenery[i] = kontener;
                        zapis.println("Nazwa kontenera: " + kontener.nazwaKontenera + " |  Wysokosc: " + kontener.wysokosc + "cm  |Szerokosc: " + kontener.szerokosc + "cm  |Dlugosc: " + kontener.dlugosc + "cm  |Towar: " + kontener.towar + "  | Masa: " + kontener.masa + "kg");
                    } else {
                        Kontener kontener = new Kontener(nazwa, "klasyczny", 270, towar);
                        kontenery[i] = kontener;
                        zapis.println("Nazwa kontenera: " + kontener.nazwaKontenera + " |  Wysokosc: " + kontener.wysokosc + "cm  |Szerokosc: " + kontener.szerokosc + "cm  |Dlugosc: " + kontener.dlugosc + "cm  |Towar: " + kontener.towar + "  | Masa: " + kontener.masa + "kg");
                    }
                    break;
            }


        }
        zapis.close();
    }

}

class Kontenerowiec extends Kontener {

    public Kontenerowiec(String nazwaKontenera, String typ, double dlugosc, String towar) {
        super(nazwaKontenera, typ, dlugosc, towar);
    }

    //ten kontenerowiec moze zmiescic 1610 kontenerow
    int tab1[][][] = new int[7][10][23]; // 7 poziomow kontenerow(pion) | 10 stoi obok siebie (szerokosc statku) | 23 wzdluz osi statku (dlugosc statku)


    public static void graficznePrzedstawienieKontenerow() {
        char tab[][][] = new char[7][10][23]; // 7 poziomow kontenerow(pion) | 10 stoi obok siebie (szerokosc statku) | 23 wzdluz osi statku (dlugosc statku)
        char kontener = '\u2B1C';
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 23; k++) {
                    tab[i][j][k] = kontener;
                    System.out.print(tab[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void zaladunek() {

        System.out.println();
        System.out.println("zaladunek");

//        if(utworzKontenery().kontener.typ="ciecze"){
//            System.out.println();
//        }


    }

    public static void zczytywanie() throws FileNotFoundException {
        File zczytywanie = new File("kontenery.txt");
        Scanner in = new Scanner(zczytywanie);

        for (int i = 0; i < 15000; i++) {

            String coZczytal = in.nextLine();
            System.out.println(coZczytal);
        }

    }

}



