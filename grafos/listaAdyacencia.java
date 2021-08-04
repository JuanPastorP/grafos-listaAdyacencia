public class listaAdyacencia <E,T> {
    private nodoVertice<E,T> root;
    private nodoVertice<E,T> ultimo;

    public listaAdyacencia(nodoVertice<E,T> root){
        this.root = root;
        ultimo = root;
    }
    public listaAdyacencia(){}

    public boolean isEmpty() {return this.root == null;}
    public nodoVertice<E,T> buscarVertice(E value){
        return buscarVertice(value, root);
    }
    public nodoVertice<E,T> buscarVertice(E value, nodoVertice<E,T> root){
        if(root.getValue()==value){
            return root;
        }
        else if (root.getNextVertice()==null)
            return null;
        else
            return buscarVertice(value, root.getNextVertice());
    }

    public void insertVetice(E value){
        if (this.isEmpty()){
            root = new nodoVertice<E,T>(value);
            ultimo = root;
        }
        else{
            nodoVertice<E,T> nuevo = new nodoVertice<E,T>(value);
            insertVetice(nuevo);
        }
    }
    public void insertVetice(nodoVertice<E,T> nuevo){
        ultimo.setNextVertice(nuevo);
        ultimo = nuevo;
    }
    public void insertArista(E name1, T valor, E name2){
        insertArista(buscarVertice(name1), valor, buscarVertice(name2));
    }
    public void insertArista(nodoVertice<E,T> primero, T valor, nodoVertice<E,T> segundo){
        nodoArista<E,T> nueva = new nodoArista<E,T>(valor);
        insertArista(primero, segundo, nueva);
        insertArista(segundo, primero, nueva);
    }
    public void insertArista(nodoVertice<E,T> primero, nodoVertice<E,T> segundo, nodoArista<E,T> nueva){
        nueva.setDireccionVertice(segundo);
        if (primero.getAdjacentArista() == null){
            primero.setAdjacentArista(nueva);
        }
        else{
            nueva.setSiguiente(primero.getAdjacentArista()); 
            primero.setAdjacentArista(nueva);
        }
    }
    public void imprimir(){
        imprimir(root, root.getAdjacentArista(), root);
    }
    public void imprimir(nodoVertice<E,T> n, nodoArista<E,T> next, nodoVertice<E,T> aux){
        System.out.print("----"+n.getValue());
        if(next != null)
            imprimir(next.getDireccionVertice(),next.getSiguiente(), aux);
        else if (aux.getNextVertice()!=null){
            System.out.println("\n");
            imprimir(aux.getNextVertice(),aux.getNextVertice().getAdjacentArista(),aux.getNextVertice());
        }
        
    }
    



    


}