/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Image;
import javax.swing.ImageIcon;
import modele.Position;
import modele.ZoneRangement;

/**
 *
 * @author cyrus
 */
public class ImZoneRangement extends ZoneRangement{

    private Image destination;
    private ImageIcon iconDestination;
    
    public ImZoneRangement(Position position) {
        super(position);
       iconDestination = new ImageIcon(getClass().getResource("../image/destination.png"));
       this.destination = this.iconDestination.getImage();
    }
   
    public Image getdestination(){
        return this.destination;
    }
    
}
