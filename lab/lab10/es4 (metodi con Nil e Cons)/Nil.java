public class Nil extends List {
    public List insert(int n, int x) {
        if(n != 0){
            throw new IllegalArgumentException("Posizione illegale");
        }
        return new Cons(x,this);
    }

    public String toString() {
        return "";
    }
}