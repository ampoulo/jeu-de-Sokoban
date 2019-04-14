package modele;

public abstract class Objet {

    public Position position;

    public Objet(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
    
    
}
