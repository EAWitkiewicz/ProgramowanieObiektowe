public class Zamowienie {
    KoszykZakupowy koszyk;

    enum Status {
        przekazane_do_realizacji,
        w_realizacji,
        gotowe_do_wysylki,
        wyslane,
        wydane_do_doreczenia,
        doreczone,
        odebrane

    }

    Status statusZamowienia;

    Zamowienie(KoszykZakupowy koszyk, Status status) {
        this.koszyk = koszyk;
        this.statusZamowienia = status;
    }

//    public String ustawStatusZamowienia() {
//        switch (statusZamowienia) {
//            case przekazane_do_realizacji:
//                return "przekazane do realizacji";
//            case w_realizacji:
//                return "w realizacji";
//            case gotowe_do_wysylki:
//                return "gotowe do wysyłki";
//            case wydane_do_doreczenia:
//                return "wydane do doręczenia";
//            case doreczone:
//                return "doręczone";
//            case odebrane:
//                return "odebrane";
//            default:
//                throw new AssertionError();
//        }
//
//    }
//    public void wyswietlZamowienie(){
//        koszyk.wyswietlZawartoscKoszyka();
//        System.out.println(statusZamowienia);
//    }
}
