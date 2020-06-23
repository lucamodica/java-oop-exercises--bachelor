// Disegno.java
import java.awt.*;
import javax.swing.*;

// Finestra che contiene il disegno di un array di oggetti di tipo Figura
public class Disegno extends JFrame {
    // Array di figure disegnate nel riquadro della finestra
    private Figura[] figure;

    // Costruttore
    public Disegno(Figura[] figure){
        super();
        this.figure = figure;
    }

    // Metodo di JFrame che ridisegna il contenuto della finestra
    @Override
    public void paint(Graphics g) {
        // Cancella tutto il riquadro della finestra
        int w = getSize().width;
        int h = getSize().height;
        g.clearRect(0, 0, w, h);

        // Sposta l'origine delle coordinate  nel centro della finestra
        g.translate(w / 2, h / 2);

        // Disegna le figure, una alla volta
        for (Figura f : figure) 
            f.draw(g);

    }

    public static void main(String[] args) {

        int pi = (int) Math.PI;
        System.out.print(pi);

        // Crea le figure da disegnare
        Figura[] figure = { new Rettangolo(50, 50),
                            new Rettangolo(55, 60),
                            new Rettangolo(70, 65),
                            new Rettangolo(100, 150),
                            new Cerchio(150),
                            new RettangoloColorato(200, 200, Color.blue),
                            new PoligonoRegolare(100, 10, Color.green)};

        // Alloca in memoria la finestra (di partenza non visibile)
        Disegno frame = new Disegno(figure);
        
        // Specifica che il programma termina con la chiusura della finestra.
        // Se vengono create finestre con java.swing, il programma non terminerà 
        // con la fine del main().
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendi la finestra visibile a schermo
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}

