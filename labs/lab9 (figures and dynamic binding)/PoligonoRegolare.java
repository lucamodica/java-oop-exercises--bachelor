//PoligonoRegoalre.java
import java.awt.*;
import javax.swing.*;

public class PoligonoRegolare extends Figura{

    //Raggio del poligono
    private int raggio;
    //Numero vertici/lati del poligono
    private int n;
    //Colore del poligono
    private Color c;

    public PoligonoRegolare(int raggio, int n, Color c){
        this.raggio = raggio;
        this.n = n;
        this.c = c;
    }

    //Metodo private per calcolare la coordinata x del vertice i
    private int getVertX(int i){
        return (int) ( raggio * Math.cos((2*Math.PI*i)/n) );
    }

    //Metodo private per calcolare la coordinata y del vertice i
    private int getVertY(int i){
        return (int) ( raggio * Math.sin((2*Math.PI*i)/n) );
    } 

    public void draw(Graphics g){

        //Ciclo per ogni vertice, in modo da calcolare
        //le coordinate di ogni lato
        g.setColor(c);
        for(int i=0;i<n;i++){
            int x1 = getVertX(i-1);
            int y1 = getVertY(i-1);
            int x2 = getVertX(i);
            int y2 = getVertY(i);
            g.drawLine(x1, y1, x2, y2);
        }
        g.setColor(Color.black);

    }
    
}