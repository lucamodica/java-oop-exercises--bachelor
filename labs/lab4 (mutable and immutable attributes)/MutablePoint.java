// rappresenta un punto sul piano
public class MutablePoint {

    // coordinate cartesiane
    private double x;
    private double y;

    public MutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { 
        return x;
    }

    public double getY() { 
        return y;
    }

    // sposta il punto di (+dx, +dy) sul piano
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    // ruota il punto di @angle radianti, in senso antiorario
    public void rotate(double angle) {
        double nx = x * Math.cos(angle) - y * Math.sin(angle);
        double ny = x * Math.sin(angle) + y * Math.cos(angle);
        x = nx;
        y = ny;
    }

    // distanza Euclidea tra questo punto e il punto @p
    public double distance(MutablePoint p) {
        assert p != null;
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
    
}
