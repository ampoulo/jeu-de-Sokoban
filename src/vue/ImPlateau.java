
package vue;

import java.awt.BorderLayout;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import modele.PlateauDeJeu;
import modele.Position;

public class ImPlateau extends JPanel implements Observer{

    /**
     * Constante d'espacement des objet
     */
    private int indiceX;
    private int indiceY;
    private int espace = 45;
    /**
     * variables image du jeu
     */
    private ImMur mur;
    private ImCaisse caisse;
    private ImPlayer personnage;
    private ImZoneRangement zoneRangement;
    private ImCaisseSurZone caisseSurZone;
   
    private PlateauDeJeu plateau;      
   /**
    * barre de la fenêtre et composants
    */
    private JMenuBar menuBar=new JMenuBar();
    private JMenu menu1=new JMenu();
    private JMenuItem niveau = new JMenuItem();
    private JMenuItem relancer=new JMenuItem();
    private JPanel footer = new JPanel();
    private JLabel label = new JLabel("Score : "+0);
    private JButton nextLevel = new JButton("Next Level");   
   /**
    *liste des position des objets 
    */
    private ArrayList<ImMur> listeMur;
    private ArrayList<ImCaisse> listeCaisse;
    private ArrayList<ImZoneRangement> listeDestination;
    private ArrayList<ImCaisseSurZone> listeCaisseSurZone;
    /**
     * getters et setters
     */  
    public JMenuItem getNiveau(){
        return this.niveau;
    }
    public JMenuItem getRelancer(){
        return this.relancer;
    }
    public JButton getNextLevel(){
        return this.nextLevel;
    }
    /**
     * Constructeur
     * @param PlateauDeJeu
     */
     public ImPlateau(PlateauDeJeu plateau){
         this.plateau = plateau;
         this.plateau.addObserver(this);          
         footer.setBackground(Color.GREEN);
         nextLevel.setVisible(false);                       
     
         menuBar.setBackground(Color.GREEN);
         menu1.setText("Options");
         niveau.setText("Importer niveaux");
         relancer.setText("Relancer");
         menu1.add(niveau);
         menu1.add(relancer);
         menuBar.add(menu1);
         footer.add(label);
         footer.add(nextLevel);
         this.setLayout(new BorderLayout());         
         this.add(menuBar , BorderLayout.NORTH);
         this.add(footer , BorderLayout.SOUTH);
         //boutton qui permet de passer au niveau suivant
          footer.add(nextLevel);
     }
     
     public void init(){             
         indiceX = 100;
         indiceY = 100;
         
         listeMur=new ArrayList<>();
         listeCaisse=new ArrayList<>();
         listeDestination=new ArrayList<>();
         listeCaisseSurZone = new ArrayList<>();                  
         
        for(int i=0;i<plateau.getPlateau().length;i++){
          for(int j=0;j<plateau.getPlateau().length;j++){
                
            switch(plateau.getPlateau()[i][j]){                            
                case '#':{
                    //on a un mur
                    mur=new ImMur(new Position(indiceX,indiceY));
                    listeMur.add(mur);
                    indiceX=indiceX+espace;
                }break;
                
                case '$':{
                    //on a une caisse
                    caisse=new ImCaisse(new Position(indiceX,indiceY));
                    listeCaisse.add(caisse);
                    indiceX=indiceX+espace;
                }break;
                
                case '@':{
                    //personnage du jeu
                    personnage=new ImPlayer(new Position(indiceX,indiceY));
                    indiceX=indiceX+espace;
                }break;
                case '.':{
                    //zone rangement
                    zoneRangement=new ImZoneRangement(new Position(indiceX,indiceY));
                    listeDestination.add(zoneRangement);
                    indiceX=indiceX+espace;
                }break;
                case '+':
                    //personnage sur zone de rangement
                    personnage=new ImPlayer(new Position(indiceX,indiceY));
                    indiceX=indiceX+espace;
                    break;
                case '*':
                    //caisse sur zone de rangement
                    caisseSurZone = new ImCaisseSurZone(new Position(indiceX,indiceY));
                    listeCaisseSurZone.add(caisseSurZone);
                    indiceX=indiceX+espace;
                    break;
     
                case ' ':{
                    indiceX=indiceX+espace;
                }break;
            }
          }
          indiceX=100;
          indiceY=indiceY+41;
        }
       this.label.setText("score : "+this.plateau.getScore());
    }
 
     //on dessine les objets
     
    public void paintComponent(Graphics g){
         g.clearRect(30, 30, 600, 600);
         this.init();
         
        //mur
        for(int i=0;i<listeMur.size();i++){
             g.drawImage(this.mur.getMur(),listeMur.get(i).getPosition().getX(),listeMur.get(i).getPosition().getY(),this);
        }
        //caisse
        for(int i=0;i<listeCaisse.size();i++){
            g.drawImage(this.caisse.getCaisse(),listeCaisse.get(i).getPosition().getX(),listeCaisse.get(i).getPosition().getY(),this);
        }
        //zone de rangement
        for(int i=0;i<listeDestination.size();i++){
            g.drawImage(this.zoneRangement.getdestination(),listeDestination.get(i).getPosition().getX(),listeDestination.get(i).getPosition().getY(),this);
        }
        //caisse sur zone
        for(int i=0;i<listeCaisseSurZone.size();i++){
            g.drawImage(this.caisseSurZone.getCaisse(), listeCaisseSurZone.get(i).getPosition().getX(), listeCaisseSurZone.get(i).getPosition().getY(), this);
        }
        //listeCaseVide.add(this.personnage.getPosition());
        g.drawImage(this.personnage.getPersonnage(),this.personnage.getPosition().getX(),this.personnage.getPosition().getY() , this);
    }   

    @Override
    public void update(Observable o, Object arg) {
       repaint(); 
    }

   
    
}
