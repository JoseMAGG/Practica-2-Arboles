package leonardo;

public class arbolnariobinario {
    private Nodo raiz = new Nodo(0,0);

    public Nodo getRaiz() {
        return raiz;
    }

    public Nodo Buscar(int target){
        return  this.Buscar(this.raiz, target);
    }

    // busca en el arbol de raiz root un nodo cuyo numero sea igual a target

    public  Nodo Buscar(Nodo root, int target){
        if(root == null){
            return null;
        }else if(root.getNumero() == target){
            return root;
        }else {
            Nodo a = Buscar(root.getLigaizquierda(),target);
            if(a != null){
                return a;
            }else {
                return Buscar(root.getLigaderecha(),target);
            }
        }
    }
    //busca el hijo con numero numHijo en un padre, se limita a buscar en la rama de los hijos
    //la busqueda no se hace en nietos ni hermanos del padre como si lo hace el metodo Buscar(Nodo root, int target)
    public  Nodo BuscarHijo(Nodo padre, int numHijo){
        if(padre == null){
            return null;
        }else {
            Nodo hijo = padre.getLigaizquierda();
            if(hijo == null){
                return null;
            }else {
                while (hijo != null){
                    if(hijo.getNumero() == numHijo){
                        return hijo;
                    }
                    hijo = hijo.getLigaderecha();
                }
                return null;
            }
        }
    }

    public Nodo Agregar(Nodo p){
        return this.Agregar(this.raiz, p);
    }
    //agrega el Nodo p como hijo del nodo padre con numero p.numeroPadre, devuelve el Nodo padre si p es agregado.
    // si p es agregado y no hay ningun padre, es decir, el arbol con raiz root estaba vacio, entonces p se agrega como
    //raiz y se devuelve p.
    //si p ya existe no se agrega ni devuelve nada.
    public  Nodo Agregar(Nodo root, Nodo p){
        if(root == null){
            root = p;
            return root;
        }else {
            Nodo padreP = Buscar(root, p.getNumeroPadre());
            if(padreP != null){
                if(padreP.getLigaizquierda()==null){
                    padreP.setLigaizquierda(p);
                }else {
                    Nodo hijo = BuscarHijo(padreP,p.getNumero());
                    if(hijo == null){//el hijo no existe, se agrega
                        hijo = padreP.getLigaizquierda();
                        while (hijo.getLigaderecha()!= null){
                            hijo = hijo.getLigaderecha();
                        }
                        hijo.setLigaderecha(p);
                    }else {//elhijo existe, no se agrega
                        return null;
                    }
                }
                return padreP;
            }
            return null;
        }
    }

    //la descendencia
    String imdes(Nodo padre){
        if(padre == null){
            return "";
        }else {
            Nodo hijo =padre.getLigaizquierda();
            String des =  ""+padre.getNumero()+":("+imdes(hijo)+")";
            if(hijo != null){
                hijo = hijo.getLigaderecha();
                while (hijo!= null){
                    des+=";("+imdes(hijo)+")";
                    hijo = hijo.getLigaderecha();
                }
            }
            return des;
        }
    }

}
