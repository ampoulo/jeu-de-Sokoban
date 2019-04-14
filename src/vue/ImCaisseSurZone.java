/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Image;
import javax.swing.ImageIcon;
import modele.Position;

/**
 *
 * @author cyrus
 */
public class ImCaisseSurZone extends ImCaisse{
    
    private Image caisse;
    private ImageIcon iconCaisse;
    
    public ImCaisseSurZone(Position p) {
        super(p);
        iconCaisse = new ImageIcon(getClass().getResource("../image/boxOk.png"));
        this.caisse = this.iconCaisse.getImage();
    }
    public Image getCaisse(){
        return caisse;
    }
    
}
