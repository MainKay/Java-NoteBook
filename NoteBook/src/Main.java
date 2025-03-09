import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("__________________________________");
        System.out.println("Witaj w NoteBooku!");

        Menus.menuOne();
        char wybor = scanner.next().charAt(0);
        scanner.nextLine();

        String tekst = null;

        do {
            switch (wybor) {
                case '1':
                    Menus.menuTwo();
                    char w1 = scanner.next().charAt(0);
                    scanner.nextLine();

                    if (w1 == '1') {
                        System.out.println("Napisz tekst:");
                        tekst = scanner.nextLine();

                    } else if (w1 == '2') {
                        if (tekst == null) {
                            System.out.println("Jeszcze nie ma tekstu.");
                            System.out.println("Najpierw coś napisz.");
                        } else {
                            Menus.menuSubTwo();
                            char w2 = scanner.next().charAt(0);
                            scanner.nextLine();

                            if (w2 == '1') {
                                System.out.println("Wpisz tekst (ze spacjami): ");
                                String tekst2 = scanner.nextLine();
                                tekst = tekst + tekst2;
                                System.out.println("Dokonano zmian: " + tekst);

                            } else if (w2 == '2') {
                                System.out.println("Wpisz tekst (ze spacjami): ");
                                String tekst3 = scanner.nextLine();
                                tekst = tekst3 + tekst;
                                System.out.println("Dokonano zmian: " + tekst);

                            } else if (w2 == '3') {
                                System.out.println("Aktualny tekst: " + tekst);
                                System.out.println("Wybierz numer znaku, po którym chcesz wstawić tekst: ");
                                int liczba = scanner.nextInt();
                                scanner.nextLine();

                                if (liczba < 1 || liczba > tekst.length()) {
                                    System.out.println("Niepoprawny numer!");
                                } else {
                                    System.out.println("Wpisz tekst do dodania (ze spacjami): ");
                                    String tekst3 = scanner.nextLine();
                                    tekst = Funkcje.tekstWSrodku(tekst, tekst3, liczba);
                                    System.out.println("Dokonano zmian: " + tekst);
                                }
                            } else {
                                System.out.println("Nieprawidłowy wybór.");
                            }
                        }
                    }
                    break;

                case '2':
                    if (tekst == null) {
                        System.out.println("Pusty tekst!");
                    } else {
                        System.out.println(tekst);
                        System.out.println();
                        System.out.println("Długość tekstu to: " + tekst.length() + " znaków.");
                    }
                    break;

                case '3':
                    if (tekst == null) {
                        System.out.println("Pusty tekst!");
                    } else {
                        Menus.menuTree();
                        char w3 = scanner.next().charAt(0);
                        scanner.nextLine();

                        if (w3 == '1') {
                            Menus.menuSubThreeOne();
                            char w4 = scanner.next().charAt(0);
                            scanner.nextLine();

                            if (w4 == '1') {
                                tekst = tekst.toUpperCase();
                            } else if (w4 == '2') {
                                tekst = tekst.toLowerCase();
                            } else if (w4 == '3') {
                                tekst = Funkcje.wybierzDuzeLitery(tekst, 1);
                                tekst = Funkcje.zdanieZDuzej(tekst);
                            } else if (w4 == '4') {
                                System.out.println(tekst);
                                System.out.println("Wybierz numer litery:");
                                int liczba = scanner.nextInt();
                                scanner.nextLine();
                                tekst = Funkcje.wybierzDuzeLitery(tekst, liczba);
                            }
                            System.out.println("Dokonano zmian: " + tekst);

                        } else if (w3 == '2') {
                            Menus.menuSubThreeTwo();
                            char w4 = scanner.next().charAt(0);
                            scanner.nextLine();

                            if (w4 == '1') {
                                System.out.println(tekst);
                                System.out.println("Wybierz wyraz lub literę do usunięcia:");
                                String tekstUsun = scanner.nextLine();
                                tekst = tekst.replace(tekstUsun, "");
                                System.out.println("Dokonano zmian: " + tekst);
                            } else if (w4 == '2') {
                                tekst = Funkcje.trimTrim(tekst);
                                System.out.println("Dokonano zmian: " + tekst);
                            }
                        }
                    }
                    break;

                case '4':
                    if (tekst == null) {
                        System.out.println("Pusty tekst!");
                    } else {
                        Menus.menuFour();
                        char a5 = scanner.next().charAt(0);
                        scanner.nextLine();

                        if (a5 == '1') {
                            tekst = Funkcje.trimTrim(tekst);
                            tekst = Funkcje.sortJeden(tekst);
                        } else if (a5 == '2') {
                            tekst = Funkcje.trimTrim(tekst);
                            tekst = Funkcje.sortDwa(tekst);
                        } else if (a5 == '3') {
                            tekst = Funkcje.wypiszOdTylu(tekst);
                        }
                        System.out.println("Dokonano zmian: " + tekst);
                    }
                    break;

                case '5':
                    if (tekst == null) {
                        System.out.println("Pusty tekst!");
                    } else {
                        Menus.menuFive();
                        String tekst4 = scanner.nextLine();
                        Funkcje.szukajWZdaniu(tekst, tekst4);
                    }
                    break;

                default:
                    if (wybor != 'z' && wybor != 'Z') {
                        System.out.println("Nieprawidłowy wybór!");
                    }
                    break;
            }

            if (wybor != 'z' && wybor != 'Z') {
                Menus.menuOne();
                wybor = scanner.next().charAt(0);
                scanner.nextLine();
            }

        } while (wybor != 'z' && wybor != 'Z');

        scanner.close();
    }
}
