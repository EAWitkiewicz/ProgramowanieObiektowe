public class zestaw8 {

    public class Klientfirmowy extends zestaw6.Klient{
        final String NIP=null;//todo dodac set i get z walidacja czy nie ma mniej lub wiecej cyfr
        final String REGON=null;
        public Klientfirmowy(String imie, String nazwisko) {
            super(imie, nazwisko);
        }

    }

    public class KlientIndwiudualny extends zestaw6.Klient{
        final String PESEL = null;//todo dodac set i get z walidacja czy nie ma mniej lub wiecej cyfr

        public KlientIndwiudualny(String imie, String nazwisko) {
            super(imie, nazwisko);
        }

    }
    interface ProduktSporzywczy{
        public abstract void smak(String smak);
        public abstract void umyj();
        public abstract void zjedz();
    }

    class Owoc implements ProduktSporzywczy{

        public void smak(String smak) {
            System.out.println("Owoc ma smak :"+smak);
        }

        public void umyj(){
            System.out.println("Owoc został umyty");
        }
        public void zjedz(){
            System.out.println("owoc został zjedzony");
        }

    }
    class Warzywo implements ProduktSporzywczy{
        public void smak(String smak) {
            System.out.println("warzywo ma smak :"+smak);
        }
        public void umyj(){
            System.out.println("Warzywo został umyty");
        }
        public void zjedz(){
            System.out.println("Warzywo został zjedzony");
        }
    }

    public static void main(String[] args) {

    }
}
