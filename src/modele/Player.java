package modele;

public class Player extends ObjetMobile{


    public Player(Position p) {
        super(p);
    }
    
  public Position getPosition(){
      return this.position;
  }
}

