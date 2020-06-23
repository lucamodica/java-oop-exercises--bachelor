import java.util.Arrays;

//Classe MAtrix, con i vari metodi
class Matrix {

    //Dati matrice
    int[][] matr;
    int m;
    int n;

    //Costruttore
    public Matrix (int m, int n){
        this.m = m;
        this.n = n;
        matr = new int[m][n];
    }

    //Costruttore per copiare una matrix in un'altra
    public Matrix (Matrix another){
        this.m = another.getM();
        this.n = another.getN();
        this.matr = getMatr();
    }

    //Metodi getter/seetter
    public int getM (){ return m; }
    public int getN (){ return n; }
    public void setMatr (int[][] matr){ this.matr = matr; }
    public int[][] getMatr (){ return matr; }
    public int getEl (int r, int c){ return matr[r][c]; }
    public void setEl (int el, int r, int c){ matr[r][c] = el; }


    //Stampa dati matrice
    public void stampaDati (){

        System.out.println("Righe: " + m);
        System.out.println("Colonne: " + n);
        System.out.println("Matrice:");

        for (int i=0;i<m;i++){
            System.out.println(Arrays.toString(matr[i]));
        }

        System.out.println("\n");

    }

    //Somma fra matrici
    public int[][] add (Matrix matrr){

        //Matrice dove verrà inserito il risultato
        int[][] sm = new int[m][n]; 

        //Svolgimento somma
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                sm[i][j] = getEl(i, j) + matrr.getEl(i, j);
            }
        }

        return sm;

    }

    //Prodotto fra matrici
    public int[][] mul (Matrix matrr){

        //Colonna dell'altra matrice
        int cols = matrr.getN();
        //Matrice dove verrà inserito il risultato
        int[][] pm = new int[m][cols];  

        //System.out.println(n);

        //Svolgimento prodotto
        for (int i=0;i<m;i++){
            for (int j=0;j<cols;j++){

                for(int l=0;l<n;l++){
                    //System.out.print(getEl(i, l) + " , " + matrr.getEl(l, cols));
                    pm[i][j] += getEl(i, l)*matrr.getEl(l, j);
                }
                
            }
        }

        return pm;

    }

    //Elevamento a potenza di una matrice
    public int[][] pow (int e){
        
        //int[][] res = new int[m][n];
        Matrix res = new Matrix(m,n);
        res.setMatr(matr);


        //Gestione caso in cui e = 0
        if (e==0){
            for (int l=0;l<getM();l++){
                res.setEl(1, l, l);
            }
        }

        //Elevamento a potenza (prodotto della stessa matrice "e" volte)
        for (int l=0;l<e-1;l++){
            res.setMatr(mul(res));
        }
        
        return res.getMatr();

    }


}


//Classe di testing di Matrix
public class MatrixDemo {

    //Mistero...
    public static int mistero (int e){

        //Matrice del mistero...
        Matrix my1 = new Matrix(2, 2);
        Matrix my2 = new Matrix(2, 2);
        int[][] myMatr = {{1,1},{1,0}};
        my1.setMatr(myMatr);
        my2.setMatr(myMatr);

        //Gestione caso in cui e = 0
        if (e==0){
            for (int l=0;l<my1.getM();l++){
                my1.setEl(1, l, l);
            }
        }

        //Elevamento a potenza (prodotto della stessa matrice "e" volte)
        for (int l=0;l<e-1;l++){
            my1.setMatr(my1.mul(my2));
        }

        //Return dell'elemento in posizione (0,0)
        return my1.getEl(0, 0);
    }


    public static void main(String[] args) {
        
        //Inizializzazione matrici
        Matrix A = new Matrix(3, 2);
        Matrix B = new Matrix(3, 2);
        Matrix C = new Matrix(2, 3);
        Matrix D = new Matrix(2,2);

        int[][] ma = {{1,2},{3,4},{5,6}};
        int[][] mb = {{1,2},{3,4},{5,6}};
        int[][] mc = {{1,2,3},{4,5,6}};
        int[][] md = {{2,3},{5,6}};


        A.setMatr(ma);
        B.setMatr(mb);
        C.setMatr(mc);
        D.setMatr(md);


        //Stampa dati
        System.out.println("Dati matrix A:");
        A.stampaDati();
        System.out.println("Dati matrix B:");
        B.stampaDati();
        System.out.println("Dati matrix C:");
        C.stampaDati();
        System.out.println("Dati matrix D:");
        D.stampaDati();


        //Somma fra le matrici A e B
        System.out.println("A + B: ");
        assert A.getM() == B.getM() && A.getN() == B.getN(): "Dimensioni delle 2 matrici non uguali!";
        int[][] sum = A.add(B);
        for (int i=0;i<A.getM();i++){
            System.out.println(Arrays.toString(sum[i]));
        }
        System.out.println('\n');


        //Prodotto fra le matrici C e B
        System.out.println("C * B: ");
        assert C.getN() == B.getM() : "Numero di colonne della prima matrice non corrisponde alla seconda!";
        int prod[][] = C.mul(B);
        for (int i=0;i<C.getM();i++){
            System.out.println(Arrays.toString(prod[i]));
        }
        System.out.println('\n');

        //Elevamento a potenza di D
        System.out.println("D^2: ");
        assert D.getM() == D.getN(): "Numero di righe diverso da quello delle colonne!";
        int pow[][] = D.pow(2);
        for (int i=0;i<D.getM();i++){
            System.out.println(Arrays.toString(pow[i]));
        }
        System.out.println('\n');

        //Esecuzione di mistero....elevato a n
        System.out.println("Cifra di coordinate (0,0) nella matrice mistero...: " + mistero(5));

    }
    
}