/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Image;
import javax.swing.ImageIcon;
import modele.Caisse;
import modele.Position;

public class ImCaisse extends Caisse{
    
    private Image caisse;
    private ImageIcon iconCaisse;
    
    public ImCaisse(Position p)
    {
        super(p);
        iconCaisse = new ImageIcon(getClass().getResource("../image/box.png"));
        this.caisse = this.iconCaisse.getImage();
    }
    
    public Image getCaisse(){
        return this.caisse;
    }
}
