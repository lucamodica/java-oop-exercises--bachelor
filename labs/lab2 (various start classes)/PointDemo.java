
//Classe Point, con i vari metodi
class Point {

    //Coordinate
    private double x;
    private double y;

    //Costruttore, inizializzando x e y
    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    //Metodi getter/setter
    public double getX (){
        return x;
    }
    public double getY (){
        return y;
    }

    //Metodo per traslare il punto
    public void translate (double dx, double dy){
        x += dx;
        y += dy;
    }
    //Metodi per traslare il punto, senza modificare il valore dell'oggetto
    public double translateX (double dx){
        return x + dx;
    }
    public double translateY (double dy){
        return y + dy;
    }

    //Metodo per ruotare il punto dei un certo angolo rispetto all'origine
    public void rotate (double angle){
        x = (x*Math.sin(angle)) - (y*Math.cos(angle));
        y = (y*Math.cos(angle)) + (y*Math.cos(angle));
    }
    //Metodi per ruotare il punto, senza modificare il valore dell'oggetto
    public double rotateX (double angle){
        return (x*Math.sin(angle)) - (y*Math.cos(angle));
    }
    public double rotateY (double angle){
        return (y*Math.cos(angle)) + (y*Math.cos(angle));
    }

    //Metodo per calcolare la distanza da un punto ad un altro
    public double distanceFrom (Point p){

        double d = Math.sqrt(
            Math.pow(p.getX() - x,2) + 
            Math.pow(p.getY() - y,2));

        return d;

    }

}


//Classe di testing di Point
class PointDemo {

    public static void main(String[] args) {
        
        //Creazione oggetti
        Point p1 = new Point(6, 8);
        Point p2 = new Point(3, 4);

        //Stampa valori dei punti
        System.out.println("Dati p1: x = " + p1.getX() + ", y = " + p1.getY());
        System.out.println("Dati p2: x = " + p2.getX() + ", y = " + p2.getY() + '\n');

        //Traslazione di p1
        int dx = 10, dy = 5;
        p1.translate(dx, dy);
        System.out.println("Traslazione di p1 di " + dx + " sull'asse x, " + 
        dy + " sull'asse y: x = " + p1.getX() + ", y = " + p1.getY() + '\n');

        //Traslazione di p1, senza modificare il valore nell'oggetto
        System.out.println("Traslazione di p1 di altri " + dx + " sull'asse x, " + 
        dy + " sull'asse y:\n" + 
        "x = " + p1.translateX(dx) + " lasciando x = " + p1.getX() + ",\n" + 
        "y = " + p1.translateY(dy) + " lasciando y = " + p1.getY() + '\n');

        //Rotazione di p2
        double angle = 45.5;
        p2.rotate(angle);
        System.out.println("Rotazione di p2 di " + angle + " gradi: x = " + 
        p2.getX() + ", y = " + p2.getY() + '\n');

        //Rotazione di p2, senza modificare il valore nell'oggetto
        System.out.println("Rotazione di p2 di altri " + angle + " gradi:\n" + 
        "x = " + p2.rotateX(angle) + " lasciando x = " + p2.getX() + ",\n" + 
        "y = " + p2.rotateY(angle) + " lasciando y = " + p2.getY() + '\n');

        //Calcolo distanza fra i 2 punti
        System.out.println("La distanza fra p1 e p2 e': " + p1.distanceFrom(p2));

    }

}