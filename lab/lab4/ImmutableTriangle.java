//Classe ImmutableTriangle (i metodi di modifica dei punti quindi
//non andranno direttamente a cambaire i valori degli attributi di istanza,
//ma restituiranno un nuovo oggetto come valore)
public class ImmutableTriangle{

    //Attributi: i 3 punti a,b,c (questa volta immutable)
    private ImmutablePoint a;
    private ImmutablePoint b;
    private ImmutablePoint c;

    //Metodo costruttore
    public ImmutableTriangle (ImmutablePoint a, ImmutablePoint b, ImmutablePoint c){
        //Verifica dell'eseistenza dei punti
        assert a != null : "Punto A non esiste!";
        assert b != null : "Punto B non esiste!";
        assert c != null : "Punto C non esiste!";
        //Verifica delle condizioni di esistenza del triangolo: la somma di 2
        //lati deve sempre essere maggiore del terzo
        assert ( a.distance(b) + b.distance(c) > c.distance(a) ) ||
               ( a.distance(b) + c.distance(a) > b.distance(c) ) ||
               ( c.distance(a) + b.distance(c) > a.distance(b) )
               : "La somma di 2 lati di un triangolo e minore del terzo!";

        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Metodi getter dei punti del triangolo
    public ImmutablePoint getA (){ return a; }
    public ImmutablePoint getB (){ return b; }
    public ImmutablePoint getC (){ return c; }

    //Metodo di stampa delle info del triangolo
    public void info (){
        System.out.println("***INFO TRIANGOLO***");
        System.out.println("Coordinate: " +
        "A(" + a.getX() + "," + a.getY() + ") " +
        "B(" + b.getX() + "," + b.getY() + ") " +
        "C(" + c.getX() + "," + c.getY() + ") ");
        System.out.println("Perimetro del triangolo: " + perimeter());
        System.out.println("Area del triangolo: " + area());
        System.out.println();
    }

    //Metodo per traslare il triangolo di un certo valore di x ed y
    //(crea un nuovo triangolo per mantenere gli attriburi intatti)
    public ImmutableTriangle translate (double dx, double dy){
        return new ImmutableTriangle(getA().translate(dx, dy), getB().translate(dx, dy), getC().translate(dx, dy));
    }

    //Metodo per ruotare il triangolo di una certa angolazione 
    //(crea un nuovo triangolo per mantenere gli attriburi intatti)
    public ImmutableTriangle rotate (double angle){
        return new ImmutableTriangle(getA().rotate(angle), getB().rotate(angle), getC().rotate(angle));
    }

    //Perimetro del triangolo
    public double perimeter (){
        double latoAB = a.distance(b);
        double latoBC = b.distance(c);
        double latoCA = c.distance(a);

        return latoAB + latoBC + latoCA;
    }

    //Area del triangolo
    public double area (){
        //Coordinate dei punti per calcolarne l'area
        double ax = a.getX();   double ay = a.getY();
        double bx = b.getX();   double by = b.getY();
        double cx = c.getX();   double cy = c.getY();

        return Math.abs( ( ax*(by - cy) + bx*(cy - ay) + cx*(ay - by) ) / 2 );
    }

}