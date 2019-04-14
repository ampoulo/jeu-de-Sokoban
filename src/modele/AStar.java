package modele;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class AStar {

    /*public static ArrayList resolutionNiveau(char[][] g){
        ArrayList<NoeudAStar> listeTonneau = listeElement(g,'$');
        ArrayList<NoeudAStar> listeArrive = listeElement(g,'.');

        switch (listeTonneau.size()){
            case 1:
                NoeudAStar depart = listeTonneau.get(0);
                NoeudAStar objectif = listeArrive.get(0);

                ArrayList<NoeudAStar> trajet = cheminPlusCourt(g,objectif,depart);

                for (NoeudAStar t:trajet) {
                    if(!(t.x == objectif.x && t.y == objectif.y)){

                    }
                }

                return trajet;

        }*/

        /*for (int i=0; i < listeTonneau.size(); i++){
            System.out.println(listeTonneau.get(i)[0] + " " + listeTonneau.get(i)[1]);
        }
        System.out.println();
        for (int i=0; i < listeArrive.size(); i++){
            System.out.println(listeArrive.get(i)[0] + " " + listeArrive.get(i)[1]);
        }*/

        /*ArrayList<NoeudAStar[]> listeCombi = combinaisonsPossibles(listeTonneau,listeArrive);

        for (NoeudAStar[] i: listeCombi) {
            for(int y=0;y<i.length;y++){
                System.out.print(i[y].x+" "+i[y].y+" - ");
            }
            System.out.println();
        }
*/
        /*return new ArrayList();
    }*/

    /*public static ArrayList<NoeudAStar[]> combinaisonsPossibles(ArrayList<NoeudAStar> listeTonneau, ArrayList<NoeudAStar> listeArrive){
        ArrayList<NoeudAStar[]> combi = new ArrayList<>();
        for (NoeudAStar i:listeTonneau) {
            for (NoeudAStar y:listeArrive) {
                    combi.add(new NoeudAStar[]{i,y});
            }
        }

        return combi;
    }*/

    public static ArrayList<NoeudAStar> listeElement(char[][] g,char elem){
        ArrayList<NoeudAStar> position = new ArrayList<>();
        for (int i=0; i < g.length; i++){
            for(int j=0; j < g[i].length; j++){
                if(g[i][j] == elem){
                    position.add(new NoeudAStar(i,j,0));
                }
            }
        }
        return position;
    }

    public static int distance(int x1,int y1,int x2,int y2){
        return (int) Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    /*public static int compare2Noeuds(NoeudAStar n1, NoeudAStar n2){
        if(n1.heuristique < n2.heuristique){
            return 1;
        } else if(n1.heuristique == n2.heuristique){
            return 0;
        } else {
            return -1;
        }
    }*/

    public static ArrayList cheminPlusCourt(char[][] g,NoeudAStar objectif, NoeudAStar depart){
        ArrayList<NoeudAStar> closedList = new ArrayList();
        ArrayList<NoeudAStar> openList = new ArrayList();
        openList.add(depart);
        boolean success = false;

        while(openList.size() != 0 && !success){
            NoeudAStar n = minimumDistance(openList,objectif,depart);
            if(n.x == objectif.x && n.y == objectif.y){
                success = true;
            } else {
                closedList.add(n);
                openList.remove(n);
                for ( NoeudAStar v: voisinsDuNoeud(g,n,objectif,depart)) {
                    if(verificationCout(v,closedList,openList)){
                        openList.add(v);
                        v.pere = n;
                        v.g = n.g+distance(v.x,v.y,n.x,n.y);
                    } else {
                        if(v.g > n.g+distance(v.x,v.y,n.x,n.y)){
                            v.pere = n;
                            v.g = n.g+distance(v.x,v.y,n.x,n.y);
                            if(findInList(closedList,v)){
                                closedList.remove(v);
                                openList.add(v);
                            }
                        }
                    }
                }
            }
        }

        // On récupère le chemin et on le met dans le bon sens dans une liste pour les déplacements //

        ArrayList<NoeudAStar> transitList = new ArrayList<>();
        transitList.add(objectif);
        NoeudAStar dernierPas = closedList.get(closedList.size()-1);
        transitList.add(dernierPas);
        while (dernierPas.pere != null){
            transitList.add(dernierPas.pere);
            dernierPas = dernierPas.pere;
        }

        ArrayList<NoeudAStar> finishList = new ArrayList<>();
        for(int p = transitList.size()-2;p > 0;p--){
            finishList.add(transitList.get(p));
        }
        finishList.add(objectif);
        return finishList;
    }

    public static boolean findInList(ArrayList<NoeudAStar> list,NoeudAStar v){
        for(NoeudAStar u : list){
            if(v.x == u.x && v.y == u.y){
                return true;
            }
        }
        return false;
    }

    public static NoeudAStar minimumDistance(ArrayList<NoeudAStar> list,NoeudAStar objectif,NoeudAStar depart){
        int count = 999999;
        NoeudAStar min = new NoeudAStar(0,0,0);
        for (NoeudAStar u:list) {
            if(distance(u.x,u.y,objectif.x,objectif.y)+distance(u.x,u.y,depart.x,depart.y) < count){
                count = distance(u.x,u.y,objectif.x,objectif.y)+distance(u.x,u.y,depart.x,depart.y);
                min = u;
            }
        }
        return min;
    }

    /*public static NoeudAStar depiler(ArrayList<NoeudAStar> list, int index) {

        if (index >= list.size()) {
            index = 0;
        }

        System.out.println(list.get(index).x + " "+list.get(index).y);
        return list.get(index);
    }*/

    public static boolean verificationCout(NoeudAStar v,ArrayList<NoeudAStar> closedList,ArrayList<NoeudAStar> openList){
        for(NoeudAStar u : closedList){
            if(v.x == u.x && v.y == u.y){
                //if(v.cout <= u.cout){
                    return false;
                //}
            }
        }
        for(NoeudAStar u : openList){
            if(v.x == u.x && v.y == u.y){
                //if(v.cout <= u.cout){
                    return false;
                //}
            }
        }
        return true;
    }

    public static ArrayList<NoeudAStar> voisinsDuNoeud(char[][] g,NoeudAStar u,NoeudAStar objectif,NoeudAStar depart){
        ArrayList<NoeudAStar> list = new ArrayList<>();
        int[][] potentielVoisins = {{u.x-1,u.y},{u.x,u.y+1},{u.x+1,u.y},{u.x,u.y-1}};

        for (int[] voisins : potentielVoisins) {
            if(g[voisins[0]][voisins[1]] == ' ' || g[voisins[0]][voisins[1]] == '.'){
                list.add(new NoeudAStar(voisins[0],voisins[1],distance(voisins[0],voisins[1],depart.x,depart.y)));
            }
        }
        return list;
    }
}
