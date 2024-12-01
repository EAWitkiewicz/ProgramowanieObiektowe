public class Main {
    public static void main(String[] args) {
        System.out.println("ZADANIE 1");
        Produkt produkt = new Produkt("ksiazka", 22, 5);

        produkt.wyswietlInformacje();
        produkt.usunZMagazynu(3);
        produkt.wyswietlInformacje();
        produkt.usunZMagazynu(3);
        produkt.wyswietlInformacje();
        System.out.println(produkt.dodajDoMagazynu(10));
        produkt.wyswietlInformacje();

        System.out.println("ZADANIE 2");
        Produkt notes = new Produkt("notes", 10, 5);
        Produkt dlugopis = new Produkt("dlugopis", 5, 5);
        Produkt olowek = new Produkt("olowek", 1, 5);
        KoszykZakupowy koszykZakupowy = new KoszykZakupowy();

        koszykZakupowy.wyswietlZawartoscKoszyka();

        koszykZakupowy.dodajProdukty(2,notes);
        koszykZakupowy.dodajProdukty(2,dlugopis);
        koszykZakupowy.dodajProdukty(2,olowek);

        koszykZakupowy.wyswietlZawartoscKoszyka();

        System.out.println("koszt całkowity:"+koszykZakupowy.obliczCalkowitaWartosc());
        System.out.println("ZADANIE 3");

    }
}
//hashowanie

