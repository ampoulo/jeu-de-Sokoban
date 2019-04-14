/**
 * 
 */
import controler.ControleClavier;
import java.io.IOException;
import javax.swing.JFrame;
import modele.*;
import vue.*;

public class Sokoban extends JFrame{

    
    public static void main(String[] args) throws IOException {
        
        ReadFile reader = new ReadFile("niveau1.sok");
        char matrice[][] = reader.matrice();
  
        Position p = reader.positionPersonnage(matrice);
        Player player = new Player(p);
           
          
        PlateauDeJeu plateau = new PlateauDeJeu(matrice , player);

        
        plateau.afficheTableau();  
        
       
        ImPlateau view = new ImPlateau(plateau);
        Fenetre fen = new Fenetre(view, plateau);
 
           
         ControleClavier ctr = new ControleClavier(plateau,view);
         view.addKeyListener(ctr);  
          
    }
}