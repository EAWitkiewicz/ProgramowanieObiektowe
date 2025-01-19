import java.util.ArrayList;
import java.util.List;

public class zestaw9_programownie_generatywne {

    //E - Element: Jest używany głównie w kolekcjach, jak java.util.List<E>,
    // java.util.Set<E>, gdzie E oznacza typ elementów w kolekcji.

    //K-key
    //V-value przy mapach i
    //T- typ ogolny
    //N-typy rozszarzajace klase java.lang.Number
    //S,U,V - na dodatkowe typy generyczbe a potem leca alfabetycznie
    //<T>-to bedzie generyczne
    //1. Stwórz prostą klasę generyczną Box, która może przechowywać obiekt dowolnego typu.
    //Klasa powinna zawierać metodę set, aby ustawić obiekt, oraz metodę get, aby go pobrać.
    public class Box<T> {
        private T element;

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }
    }

    //2. Napisz generyczną metodę isEqual, która przyjmuje dwa dowolne obiekty tego samego
    //  typu i zwraca true, jeśli są one równe, w przeciwnym razie false.
    public static <T> boolean isEqual(T obj1, T obj2) {
        return obj1.equals(obj2);
    }

//    3.Stwórz klasę generyczną Counter<T>, która będzie zliczać ilość dodanych elementów
//    określonego typu. Klasa powinna mieć metodę add(T element), która dodaje element
// do wewnętrznej struktury, oraz metodę getCount(), która zwraca liczbę dodanych ele
//    mentów
public static class Counter<T> {
    List<T> elementy = new ArrayList<T>();

    void add(T element) {
        elementy.add(element);
    }

    int getCount() {
        return elementy.size();
    }
}

// 4. Stwórz klasę generyczną Triple<T, U, V>, która może przechowywać trzy obiekty róż
//    nych typów. Zaimplementuj metody getFirst(), getSecond() i getThird() do pobie
//    rania odpowiednio pierwszego, drugiego i trzeciego elementu
    public static class Triple<T,U,V>{
    private T first;
    private U second;
    private V third;
    public Triple(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public T getFirst() {
        return first;
    }
    public U getSecond() {
        return second;
    }
    public V getThird() {
        return third;
    }
}
//
// 5. Napisz generyczną metodę max, która przyjmuje tablicę elementów typu porównywalnego
//            (implementujących interfejs Comparable<T>) i zwraca element o najwyższej wartości.
//    Uwzględnij obsługę przypadku pustej tablicy.

    public <T extends Comparable> T max(List<T> list ) {
        if(list.isEmpty()){
            return null;
        }else {
        T max=list.get(0);

            for (int i=1;i<list.size();i++)
            {
                if(max.compareTo(list.get(i))==1)
                {
                max=list.get(i);
                }
            }
        return max;
        }
    }
    //6. Zdefiniuj generyczny interfejs Stack<T> z metodami push(T item), T pop(), T peek()
    // i boolean isEmpty(). Stwórz klasę implementującą ten interfejs, która będzie reprezen
    //tować stos przechowujący elementy dowolnego typu.
    interface Stack<T>{
        void push(T element);
        T pop();
        T peek();
        boolean isEmpty();
    }
    //12. Napisz statyczną metodę generyczną swap, która przyjmuje tablicę dowolnego typu i
    //dwa indeksy, a następnie zamienia miejscami elementy w tej tablicy pod wskazanymi
    //indeksami. Metoda powinna działać dla tablicy każdego typu. Przykładowe wywołanie
    //metody: swap(myArray, 0, 2);, gdzie myArray to tablica typu Integer[] lub dowol
    //nego innego typu. Zabezpiecz metodę tak, aby nie można było jej wywołać z indeksami
    //spoza zakresu tablicy
    public static <T> T[] swap(T[] arrays, int i, int j )
    {
        if(i>arrays.length && j>arrays.length){
            return arrays;
        }else {
            T swap=arrays[i];
            arrays[i]=arrays[j];
            arrays[j]=swap;
            return arrays;
        }

    }
    // 14. Napisz statyczną metodę generyczną minValue, która przyjmuje tablicę elementów typu
    // generycznego T, gdzie T rozszerza Comparable<T>. Metoda powinna zwracać najmniejszy
    // element z tablicy. Przetestuj tę metodę na tablicach zawierających różne typy porówny
    //walnych obiektów, takie jak Integer, Double, czy String. Zabezpiecz metodę tak, aby
    // nie można było jej wywołać z tablicą o zerowej liczbie elementów. Dodaj klasę Person z
    // polami name i age i przetestuj metodę minValue na tablicy obiektów Person.
    static <T extends Comparable<T>>T minValue(T[] arrays){
        if(arrays.length<=0)
        {
        return null;
        }
        else {
            T min=arrays[0];
            for (int i=0;i<arrays.length;i++){
                if(arrays[i].compareTo(arrays[i+1])==-1)
                {
                    min=arrays[i];
                }
            }
            return min;
        }
    }

    public static class Person implements Comparable<Person>{
        public int age;
        Person(int age) {
            this.age = age;
        }
        @Override
        public int compareTo(Person other) {
            if(other.age>this.age)
                return -1;
            if(other.age<this.age)
                return 1;
            return 0;
        }


    }
    //21.Utwórz dwie klasy: Animal (Zwierzę) i Dog (Pies), gdzie Dog dziedziczy po Animal. Na
    //stępnie napisz statyczną metodę generyczną findMax, która przyjmuje dwa argumenty:
    // element1 i element2 typu extends Animal. Metoda powinna zwracać element więk
    //szy według własnie zdefiniowanego kryterium porównania. W implementacji porównaj
    // elementy bazując na wybranym przez siebie atrybucie, na przykład wieku.
    public class Animal {
        private int wiek;

        public Animal(int wiek) {
            this.wiek = wiek;
        }
        public void setWiek(int wiek) {
            this.wiek = wiek;
        }
        public int getWiek() {
            return wiek;
        }
    }
    public class Dog extends Animal {
        private int Age;
        public Dog(int wiek) {
            super(wiek);
        }
        public int getAge(){
            return this.Age;
        }
        public void setAge(int age){
            this.Age = age;
        }
    }
    public class z21 {
        public static <T extends Animal> T findMax(T element1,T element2){
            if(element1.getWiek() > element2.getWiek()){
                return element1;
            }
            else{
                return element2;
            }
        }
    }

    //15. Napisz statyczną metodę generyczną maxValue, która przyjmuje tablicę elementów typu
    // generycznego T, gdzie T rozszerza Comparable<T>. Metoda powinna zwracać największy
    // element z tablicy. Upewnij się, że metoda nie akceptuje pustej tablicy (o zerowej liczbie
    // elementów). Przetestuj metodę na tablicach zawierających różne typy porównywalnych
    // obiektów, jak Integer, Float, czy String. Stwórz klasę Vehicle z polami model i
    // speed, implementującą generyczny Comparable, i przetestuj metodę maxValue na tablicy
    // obiektów Vehicle.

    public static <T extends Comparable<T>> T maxElement(T[] tab){
        if(tab.length==0){
            return null;
        }else{
            T element=tab[0];
            for (int i=1;i<tab.length;i++){
                if(element.compareTo(tab[i])==-1){
                    element=tab[i];
                }
            }
            return element;
        }
    }
    public static class Vehicle implements Comparable<Vehicle>{
        public int speed;
        public String color;
        public Vehicle(int speed, String color) {
            this.speed = speed;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Model"+speed+" : "+ color;
        }

        @Override
        public int compareTo(Vehicle o) {
            if(this.speed>o.speed) return 1;
            if(this.speed<o.speed) return -1;
             return 0;
        }
    }

    //24
    //22
    //29

    //28. Stwórz klasę generyczną Pair<T> która przechowuje dwa obiekty tego samego typu.
    // Utwórz dwie klasy: Animal (Zwierzę) i Dog (Pies), gdzie Dog dziedziczy po Animal.
    // Klasa Dog ma posiadać prywatne pole age, które nie posiada klasa Animal. Następnie
    // napisz statyczną metodę generyczną findMinMaxAge, która przyjmuje jako argument ta
    //blicę obiektów typu Dog oraz Pair<?super Dog> result. Metoda powinna ma zapisać
    // (jako obiekty typu Dog) najmniejszy i najmniejszy (pod kątem wieku) psa z tablicy w
    // drugim argumencie metody. Zrób to bezpośrednio bez używania interfejsów Comparable
    // czy Comparator.
    public class Pair<T> {
        private T obj1;
        private T obj2;

        public static <T> void findMinMaxAge(Dog[] tab,Pair<?super Dog> result){
            Dog minDog = tab[0];
            Dog maxDog = tab[0];
            for(int i = 0; i < tab.length; i++){
                if(tab[i].getAge() < minDog.getAge()){
                    minDog = tab[i];
                }
                if(tab[i].getAge() > maxDog.getAge()){
                    maxDog = tab[i];
                }
            }
            result.obj1 = minDog;
            result.obj2 = maxDog;
        }
        public T getObj1(){
            return obj1;
        }
        public T getObj2(){
            return obj2;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person(25);
        Person p2 = new Person(20);
        Person p5 = new Person(20);
        Person p3 = new Person(30);
        Person p4 = new Person(19);
        Person[] ludzie={p1,p5,p2,p3,p4};
        System.out.println(ludzie[0].compareTo(p2));
        System.out.println(ludzie[1].compareTo(ludzie[2]));

        //15
        Vehicle pojazd=new Vehicle(90,"pink");
        Vehicle pojazd1=new Vehicle(100,"green");
        Vehicle pojazd2=new Vehicle(90,"white");
        Vehicle pojazd3=new Vehicle(140,"black");
        Vehicle[] tablicaPojazdow={pojazd,pojazd1,pojazd2,pojazd3};
        System.out.println(maxElement(tablicaPojazdow));
    }
}

