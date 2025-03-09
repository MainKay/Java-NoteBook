public class Funkcje {

    public static String tekstWSrodku(String tekst, String tekst3, int indeks){
        if (tekst3 == ""){
            System.out.println("Nie dodano tekstu.");
        }
        tekst = tekst.substring(0, indeks) + tekst3 + tekst.substring(indeks);

        return tekst;
    }

    public static String wypiszOdTylu(String tekst) { //DONE
        String tekstDwa = "";
        for (int i = tekst.length() - 1; i >= 0; i--) {
            tekstDwa += tekst.charAt(i);
        }
        return tekstDwa;
    }

    public static void szukajWZdaniu(String tekst, String alpha) {
        boolean zawiera = tekst.contains(alpha);
        int licznik = 0;
        int index = tekst.indexOf(alpha);
        int ostatniIndex = tekst.lastIndexOf(alpha);

        int start = 0;
        while ((start = tekst.indexOf(alpha, start)) != -1) {
            licznik++;
            start += alpha.length();
        }

        if (zawiera) {
            System.out.println("Słowo pojawia się w tekście " + licznik + " razy.");
            System.out.println("Pierwsze pojawienie od prawej, w pozycji: " + ostatniIndex);
        } else {
            System.out.println("Tekst nie zawiera takiego słowa!");
        }
    }

    public static String wybierzDuzeLitery(String tekst, int i) {
        if (i <= 0 || i > tekst.length()) {
            System.out.println("Niepoprawny indeks!");
            return tekst;
        }

        String tekstDwa = "";
        tekstDwa += tekst.charAt(i - 1);
        tekstDwa = tekstDwa.toUpperCase();
        tekst = tekst.substring(0, i - 1) + tekstDwa + tekst.substring(i);
        return tekst;
    }

    public static String zdanieZDuzej(String tekst) {
        for (int i = 0; i < tekst.length() - 2; i++) {
            String tekstDwa = "";
            if (tekst.charAt(i) == '.') {
                if (i + 2 < tekst.length()) {
                    tekstDwa += tekst.charAt(i + 2);
                    tekstDwa = tekstDwa.toUpperCase();
                    tekst = tekst.substring(0, i + 2) + tekstDwa + tekst.substring(i + 3);
                }
            }
        }
        return tekst;
    }

    public static String sortJeden(String tekst) {
        int ilosc = 1;
        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) == ' ') {
                ilosc++;
            }
        }

        String[] tablica = new String[ilosc];
        int index = 0;
        String slowo = "";

        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) == ' ') {
                tablica[index] = slowo;
                index++;
                slowo = "";
            } else {
                slowo += tekst.charAt(i);
            }
        }
        tablica[index] = slowo;

        String temp;
        for (int j = 0; j < tablica.length - 1; j++) {
            for (int i = 0; i < tablica.length - 1; i++) {
                if (tablica[i].length() > tablica[i + 1].length()) {
                    temp = tablica[i];
                    tablica[i] = tablica[i + 1];
                    tablica[i + 1] = temp;
                }
            }
        }

        String wynik = "";
        for (int i = 0; i < tablica.length; i++) {
            wynik += tablica[i];
            if (i < tablica.length - 1) {
                wynik += " ";
            }
        }
        tekst = wynik;
        return tekst;
    }



    public static String sortDwa (String tekst){
        int ilosc = 1;
        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) == ' ') {
                ilosc++;
            }
        }

        String[] tablica = new String[ilosc];
        int index = 0;
        String slowo = "";

        for (int i = 0; i < tekst.length(); i++) {
            if (tekst.charAt(i) == ' ') {
                tablica[index] = slowo;
                index++;
                slowo = "";
            } else {
                slowo += tekst.charAt(i);
            }
        }
        tablica[index] = slowo;

        String temp;
        for (int j = 0; j < tablica.length - 1; j++) {
            for (int i = 0; i < tablica.length - 1; i++) {
                if (tablica[i].length() < tablica[i + 1].length()) {
                    temp = tablica[i];
                    tablica[i] = tablica[i + 1];
                    tablica[i + 1] = temp;
                }
            }
        }

        String wynik = "";
        for (int i = 0; i < tablica.length; i++) {
            wynik += tablica[i];
            if (i < tablica.length - 1) {
                wynik += " ";
            }
        }
        tekst = wynik;
        return tekst;
    }

    public static String trimTrim(String tekst){
        tekst = tekst.replaceAll("\\s+", " ");
        tekst = tekst.replace(" .", ".");
        tekst = tekst.replace(" ,", ",");
        tekst = tekst.replace(" :", ":");
        tekst = tekst.replace(" ?", "?");
        tekst = tekst.replace(" !", "!");
        tekst = tekst.trim();
        return tekst;
    }


}
