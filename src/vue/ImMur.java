/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import modele.Mur;
import modele.Position;

/**
 *
 * @author cyrus
 */
public class ImMur extends Mur{
    
     /**
     * variable image du jeu
     */
    private Image mur; 
    private ImageIcon iconMur;
    
    public ImMur(Position p) {
       super(p);
       iconMur = new ImageIcon(getClass().getResource("../image/mur.png"));
       this.mur = this.iconMur.getImage();
    }
    
    public Image getMur(){
        return this.mur;
    }
}
