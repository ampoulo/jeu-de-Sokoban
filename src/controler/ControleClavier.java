
 
package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import modele.PlateauDeJeu;
import modele.Player;
import modele.ReadFile;
import vue.ImPlateau;

public class ControleClavier implements KeyListener,ActionListener{
    
  PlateauDeJeu plateau;
  ImPlateau view;
 
  
 public ControleClavier(PlateauDeJeu plateau,ImPlateau view){
      this.plateau = plateau;
      this.view = view;
      listen();
  }
  public void listen(){
       view.getRelancer().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             plateau.relancerJeu();
             plateau.setScore(0);
          }
      });
       view.getNiveau().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                File f = plateau.pickMe();
                if(f!=null){
                    ReadFile r = new ReadFile(f);
                    char[][] mat = r.matrice();
                    plateau.setPlateau(mat);
                    plateau.setPlayer(new Player(r.positionPersonnage(mat)));
                    plateau.deplacement("");
                }
           }
       });
  }
  @Override()
  public void keyPressed(KeyEvent e){
      
  }
  @Override
  public void keyTyped(KeyEvent e) {
      
      if (this.plateau.isFinished() == false){
        switch(e.getKeyChar()){
                
            case 'd':                              
                plateau.deplacement("right");                
                plateau.afficheTableau();
                break;                
            case 'q': 
                                
                plateau.deplacement("left");                
                plateau.afficheTableau();
                break;
            
            case 'z':                 
                plateau.deplacement("top");                
                plateau.afficheTableau();
                break;
            
            case 's':                        
                plateau.deplacement("bot");                
                plateau.afficheTableau();
                break;
            }
        }if (this.plateau.isFinished() == true){ 
             view.getNextLevel().setVisible(true);
             view.getNextLevel().addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     plateau.setScore(0);
                     plateau.suivant();
                     view.getNextLevel().setVisible(false);
                     view.requestFocus();
                     }
             });        
        }
  }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
      
}
    
