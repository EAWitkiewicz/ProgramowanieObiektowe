import java.util.Scanner;
public class zestaw2 {
    public static void main(String[] args) {
        System.out.println("zad 1");
        //nie ma metody ktora wyswietli jaki to typ danych
        //w momencie zrzutownia na objekt zmienia sie to na klase
        //a do klas istnieje metoda ktora pokaze jakiego typu jest klasa
        //getName() uwuswa przedrostek class

        //chyba ze chodzilo o sledzenei tego w debugerze czy same dowiedzenie sie co np daje int+double
        System.out.println("Typ :"+ (23.0+76) +" " +((Object)(23.0+76)).getClass().getName());
        System.out.println("Typ :" + (41*2.0+3) +" " + ((Object)(41*2.0+3)).getClass().getName());
        System.out.println("Typ :" + (5-33) +" " + ((Object)(5-33)).getClass().getName());
        System.out.println("Typ :" + (50/2) +" " + ((Object)(50/2)).getClass().getName());
        System.out.println("Typ :" + (4|2) +" " + ((Object)(4|2)).getClass().getName());
        System.out.println("Typ :"+ (3^5) +" " + ((Object)(3^5)).getClass().getName());
        System.out.println("Typ : " + (7&9)+" "+ ((Object)(7&9)).getClass().getName());
        System.out.println();

        System.out.println("zad 2");
        System.out.println( (int)((((Math.sqrt(7))-1)/2)+(Math.pow(3,3))%2) );
        System.out.println((int)(2003/((23)*(4))));
        System.out.println( (int)(((3+Math.sqrt(3))/(((Math.sqrt(5))/2)/3))+1) );
        System.out.println( (int)(123%50%20) );
        System.out.println( ((("Witkiewicz".length())%("Elzbieta".length()))+1)/(Math.pow(2,1.0/4.0)) );
        System.out.println();

//        System.out.println("zad 3");
//        //tworzenie obiektu klasy scaner alby mow czytywac dane od uzytkownika
        Scanner scan = new Scanner(System.in);
//        System.out.println("Podaj imie");
//        String name=scan.nextLine();
//        System.out.println("Podaj nazwisko");
//        String lastname=scan.nextLine();
//        System.out.println(name +" "+ lastname+"\n" );

        System.out.println("zad 4");
        System.out.println("Podaj dwie cyfry");
        double a=scan.nextDouble();
        double b=scan.nextDouble();
        System.out.println(a +" + "+ b +" = "+(a+b));
        System.out.println(a +" - "+ b +" = "+(a-b));
        System.out.println(a +" / "+ b +" = "+(a/b));
        System.out.println(a +" * "+ b +" = "+(a*b)+"\n");

        System.out.println("zad 5");
        System.out.println("Podaj cyfre");
        double c=scan.nextDouble();
        System.out.println("Powiekszona o 100 : "+ (c+100));
        System.out.println("Pomniejszona o 31 : "+ (c-31));
        System.out.println("Powiekszona 7 razy : "+ (c*7));
        System.out.println("Pomniejszona 13 razy : "+ (c/13));
        System.out.println("Modulo 7 : "+ (c%7));
        System.out.println("Czesc calkowita dzielenia przez 4 : "+ (int)(c/4));
        System.out.println("Do potegi 45 : "+ (Math.pow(45,4)));
        System.out.println("Suma bitowa 59 : "+( (int)c|59));
        System.out.println("Iloraz bitowy 67: "+((int)c&67));
        System.out.println("Xor z 23 : "+ ((int)c^23) );
        System.out.println("Przesunieta o 5 bitow w lewo : "+((int)c<<5));
        System.out.println("Przesunieta o 6 bitow w prawo : "+ ((int)c>>6));
    }
}