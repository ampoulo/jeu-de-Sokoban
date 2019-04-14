package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {
    
    
    //Création de l'objet File
    String repertoire="../src/niveaux/";
    FileReader fr = null;
    public ReadFile(String nomFichier){
        String chemin = repertoire+nomFichier;
        File f = new File(chemin); 
        System.out.println("path : "+f.getAbsolutePath());
        try{
            fr = new FileReader(f.getAbsolutePath());
        }catch (FileNotFoundException e) {
            System.out.println("fichier non trouvé");
        }
    }
    
    public ReadFile(File f){

        try{
            fr=new FileReader(f);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     *
     * @return matrice de caracteres qui represente le modele du niveau
     */
     public char[][] matrice(){
        char[][] matrice=new char[100][100];
        int i=0;
        int j=0;
        try{
            int c = fr.read();
            while(c!=-1){
                if((char)c!='\n'){
                    matrice[i][j] = (char)c;
                    j++;
                }
                if((char)c=='\n'){
                    matrice[i][j] = (char)c;
                    j=0;
                    i++;
                }
                c=fr.read();
            }
        }catch(IOException e){
            System.out.println("Erreur de lecture");
        }
          return matrice;
      }
    public Position positionPersonnage(char[][] maMatrice){
       Position position=null;
       for(int i=0;i<maMatrice.length;i++){
           for(int j=0;j<maMatrice.length;j++){
               if(maMatrice[i][j]=='@')
                   position = new Position(j,i);
           }
       }
       return position;
   }

   
}
