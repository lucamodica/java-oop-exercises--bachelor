//Classe MutableTriangle (i metodi di modifica dei punti quindi,
//andranno direttamente a cambaire i valori degli attributi di istanza)
public class MutableTriangle{

    //Attributi: i 3 punti a,b,c
    private MutablePoint a;
    private MutablePoint b;
    private MutablePoint c;

    //Metodo costruttore
    public MutableTriangle (MutablePoint a, MutablePoint b, MutablePoint c){
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
    public MutablePoint getA (){ return a; }
    public MutablePoint getB (){ return b; }
    public MutablePoint getC (){ return c; }

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
    public void translate (double dx, double dy){
        a.translate(dx, dy);
        b.translate(dx, dy);
        c.translate(dx, dy);
    }

    //Metodo per ruotare il triangolo di una certa angolazione
    public void rotate (double angle){
        a.rotate(angle);
        b.rotate(angle);
        c.rotate(angle);
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