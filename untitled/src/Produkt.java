public class Produkt {
    String nazwa;
    double cena;
    int iloscNaMagazynie;

    public Produkt(String nazwa, double cena, int iloscNaMagazynie) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.iloscNaMagazynie = iloscNaMagazynie;
    }

    public void wyswietlInformacje() {
        System.out.println
                ("Nazwa: " + this.nazwa + "\n"
                        + "Cena: " + this.cena + "\n" + "Ilość na magazynie: " + this.iloscNaMagazynie+"\n"
                );
    }

    public int dodajDoMagazynu(int ileDodac) {
        this.iloscNaMagazynie = this.iloscNaMagazynie + ileDodac;
        return this.iloscNaMagazynie;
    }

    public void usunZMagazynu(int ileZabrac) {
        if (this.iloscNaMagazynie < ileZabrac) {
            System.out.println("Nie ma wystarczajcej ilosci");
        } else {
            this.iloscNaMagazynie = this.iloscNaMagazynie - ileZabrac;
        }
    }

    public int getIloscNaMagazynie() {
        return iloscNaMagazynie;
    }

    public double getCena() {
        return cena;
    }
}
