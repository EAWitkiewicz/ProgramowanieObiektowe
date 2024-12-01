public class Produkt {
    String nazwa;
    double cena;
    int iloscNaMagazynie;

    public Produkt(String nazwa, double cena, int iloscNaMagazynie) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.iloscNaMagazynie = iloscNaMagazynie;
    }

    public void wyswietlInformacje(){
        System.out.println
                ("Nazwa: " + this.nazwa+"\n"
                        + "Cena: " + this.cena+"\n"+"Ilość na magazynie: "+this.iloscNaMagazynie
                );
    }

    public int dodajDoMagazynu(int iloscNaMagazynie){
        this.iloscNaMagazynie=iloscNaMagazynie++;
        return this.iloscNaMagazynie;
    }

    public int usunZMagazynu(int iloscNaMagazynie,int iloscWystarczjaca){
        if(this.iloscNaMagazynie>iloscWystarczjaca){
            this.iloscNaMagazynie--;
        }
        return this.iloscNaMagazynie;
    }
}
