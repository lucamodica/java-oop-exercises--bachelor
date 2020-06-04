//RettangoloColorato.java
import java.awt.*;
import javax.swing.*;

public class RettangoloColorato extends Rettangolo{

    //Base
    private int base;
    //Altezza
    private int altezza;
    //Colore
    private Color c;

    public RettangoloColorato(int base, int altezza, Color c){
        super(base, altezza);
        this.c = c;
    }

    //Disegno il rettangolo colorato
    public void draw(Graphics g){
        g.setColor(c);
        super.draw(g);
        g.setColor(Color.black);
    }
    
}