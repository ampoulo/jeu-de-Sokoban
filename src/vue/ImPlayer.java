/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Image;
import javax.swing.ImageIcon;
import modele.Player;
import modele.Position;

/**
 *
 * @author cyrus
 */
public class ImPlayer extends Player{

    private Image personnage;
    private ImageIcon iconPersonnage;

    public ImPlayer (Position position) {
       super(position);
       iconPersonnage = new ImageIcon(getClass().getResource("../image/personnage.png"));
       this.personnage = this.iconPersonnage.getImage();
    }
    
    public Image getPersonnage(){
        return this.personnage;
    }
}
