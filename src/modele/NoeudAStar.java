package modele;
public class NoeudAStar {

    public int x;
    public int y;
    public int g; // distance qui separe le noeud de depart
    public NoeudAStar pere;

    public NoeudAStar(int x,int y,int g){
        this.x = x;
        this.y = y;
        this.pere = null;
        this.g = g;
    }
}
