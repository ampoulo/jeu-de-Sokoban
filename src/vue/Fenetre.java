/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ControleClavier;
import java.awt.Color;
import javax.swing.JFrame;
import modele.PlateauDeJeu;


public class Fenetre extends JFrame{
    
    ImPlateau view;
    PlateauDeJeu plateau;
    ControleClavier ctr ;
    
    public Fenetre(ImPlateau view, PlateauDeJeu plateau){
        this.plateau = plateau;
        this.view = view;
        ctr = new ControleClavier(plateau,view);
        
        this.setContentPane(view);
        this.setBackground(Color.WHITE);
        this.setTitle("SOKOBAN");
        this.view = view;
        this.plateau = plateau;
        this.setSize(700,700);
        this.addKeyListener(ctr);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
