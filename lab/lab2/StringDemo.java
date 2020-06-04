

//Classe di prova String, con i metodi richiesti
public class StringDemo{

    //Metodo 1: ritorna la stringa più lunga da un array di stringhe
    public static String longest (String[] stringArr){

        //Indice dell'elemento con la lunghezza maggiore
        int ind = 0;

        //Ricerca stringa più lunga
        for(int i=0;i<stringArr.length;i++){
            if(stringArr[i].length() > stringArr[ind].length()){
                ind = i;
            }
        }

        return stringArr[ind];

    }

    //Metodo 2: ritorna la concatenazione di tutte le stringhe in un array
    public static String concatAll (String[] stringArr){

        //Stringa che conterrà la concatenazione
        String conc = "";

        //concatenazione
        for(int i=0;i<stringArr.length;i++){
            conc = conc.concat(stringArr[i]);
        }

        return conc;

    }

    //Metodo 3: rimuove tutti gli spazi iniziali e finali in una stringa
    public static String trim (String str){

        //Stringa dove verrà messa quella senza spazi
        String ris = "";

        //Rimozione degli spazi
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='*'){
                ris += str.substring(i,i+1);
            }
        }

        return ris;

    }

    public static void main(String[] args) {
        
        String[] arr = {"ciaoooo","coome","stai","?"};
        String s = "**ciao***come*stai*?*";

        System.out.println("La stringa piu' lunga e': " + longest(arr));

        System.out.println("Concatenazione di tutte le stringhe: " + concatAll(arr));

        System.out.println("Stringa senza gli spazi '*' :" + trim(s));

    }

} 