//Cerchio.java
import java.awt.*;
import javax.swing.*;

public class Cerchio extends Figura{

    //Lunghezza raggio del cerchio
    private int raggio;

    public Cerchio(int raggio){
        this.raggio = raggio;
    }

    public void draw(Graphics g){
        g.drawOval(-raggio, -raggio, raggio*2, raggio*2);
    }
    
}