
//Classe di testing (sia per MutableTriangel che per ImmutableTriangle)
public class TriangleDemo{

    //Metodo main
    public static void main(String[] args){

        //Punti del MutableTriangle
        MutablePoint A = new MutablePoint(15, 15); 
        MutablePoint B = new MutablePoint(23, 30);
        MutablePoint C = new MutablePoint(50, 25);

        //Punti del ImutableTriangle
        ImmutablePoint a = new ImmutablePoint(15, 15); 
        ImmutablePoint b = new ImmutablePoint(23, 30);
        ImmutablePoint c = new ImmutablePoint(50, 25);

        //Oggetto MutableTriangle
        MutableTriangle tr = new MutableTriangle(A, B, C);

        //Oggetto ImmutableTriangle
        ImmutableTriangle tr1 = new ImmutableTriangle(a, b, c);

        //Stampa delle info del MutableTriangle
        System.out.println("1. Operazioni con MutableTriangle ");
        tr.info();

        //Traslazione del MutableTriangle di x = 5 e y = 6
        double dx = 5;
        double dy = 6;
        tr.translate(dx, dy);
        System.out.println("Dopo aver traslato il triangolo di x = " + dx + " e y = " + dy);
        tr.info();

        //Rotazione del MutableTriangle di 45°
        double angle = 45;
        tr.rotate(angle);
        System.out.println("Dopo aver ruotato il triangolo di " + angle + " gradi");
        tr.info();
        System.out.println("\n");



        //Stampa delle info dell'ImmutableTriangle
        System.out.println("2. Operazioni con ImmutableTriangle ");
        tr1.info();

        //Traslazione dell'ImmutableTriangle di x = 4 e y = 5
        dx = 4;
        dy = 5;
        ImmutableTriangle tr_mod = tr1.translate(dx, dy); //Triangolo dove viene copiato l'oggetto tr1, con dati modificati
        System.out.println("Dopo aver traslato il triangolo di x = " + dx + " e y = " + dy);
        tr_mod.info();
        //Stampa dei dati di tr1 per verifica
        System.out.println("Dati del triangolo tr1: ");
        tr1.info();

        //Traslazione dell'ImmutableTriangle di x = 4 e y = 5
        ImmutableTriangle tr_rot = tr1.rotate(angle); //Triangolo dove viene copiato l'oggetto tr1, con dati modificati
        System.out.println("Dopo aver ruotato il triangolo di " + angle + " gradi");
        tr_mod.info();
        //Stampa dei dati di tr1 per verifica
        System.out.println("Dati del triangolo tr1: ");
        tr1.info();
        System.out.println("\n");



        //Test: è possibile modificare il MutableTriangle senza translate() o rotate() ?
        MutableTriangle t = new MutableTriangle(A, B, C);
        System.out.println("3.1. Prova modifica punto di un MutableTriangle ");
        System.out.println("Utilizzando i metodi di MutablePoint dei punti del triangolo, è possibile modificarlo");
        System.out.println("Modifichiamo ad esempio il punto A: ");
        System.out.println("Punto A prima della modifica: (" + t.getA().getX() + "," + t.getA().getY() + ")");
        t.getA().rotate(angle);  //Prova rotazione di un singolo punto
        System.out.println("Punto A dopo della modifica: (" + t.getA().getX() + "," + t.getA().getY() + ")" );
        System.out.println();

        //Test: è possibile modificare il MutableTriangle senza translate() o rotate() ?
        ImmutableTriangle t1 = new ImmutableTriangle(a, b, c);
        System.out.println("3.2. Prova modifica punto di un ImmutableTriangle ");
        System.out.println("Anche utilizzando i metodi di ImmutablePoint dei punti del triangolo, non è possibile modificarlo!");
        System.out.println("Modifichiamo ad esempio il punto B: ");
        System.out.println("Punto B prima della modifica: (" + t1.getA().getX() + "," + t1.getA().getY() + ")");
        t1.getA().rotate(angle);  //Prova rotazione di un singolo punto
        System.out.println("Punto B dopo della modifica: (" + t1.getA().getX() + "," + t1.getA().getY() + ")" ); 


    }

}