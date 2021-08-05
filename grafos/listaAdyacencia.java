public class listaAdyacencia <E,T> {
    private nodoVertice<E,T> root;
    private nodoVertice<E,T> ultimo;
    private int orden = 0;

    public listaAdyacencia(nodoVertice<E,T> root){
        this.root = root;
        ultimo = root;
    }
    public listaAdyacencia(){}

    public nodoVertice<E,T> getRoot(){return root;}

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

    public void insertVertice(E value){
        orden = orden+1;
        if (this.isEmpty()){
            root = new nodoVertice<E,T>(value);
            ultimo = root;
        }
        else{
            nodoVertice<E,T> nuevo = new nodoVertice<E,T>(value);
            insertVertice(nuevo);
        }
    }
    public void insertVertice(nodoVertice<E,T> nuevo){
        ultimo.setNextVertice(nuevo);
        ultimo = nuevo;
    }
    public void insertArista(E name1, T valor, E name2){
        insertArista(buscarVertice(name1), valor, buscarVertice(name2));
    }
    public void insertArista(nodoVertice<E,T> primero, T valor, nodoVertice<E,T> segundo){
        nodoArista<E,T> nueva = new nodoArista<E,T>(valor);
        nodoArista<E,T> nueva2 = new nodoArista<E,T>(valor);
        insertArista(primero, segundo, nueva);
        insertArista(segundo, primero, nueva2);
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

    //Funciones para BFS


    public void encolar(nodoVertice<E,T> nuevo, nodoRecorridos<E,T> base){
        if(base.getNext() == null){
            base.setNext(new nodoRecorridos<E,T>(nuevo));
        }
        else
            encolar(nuevo, base.getNext());
    }
    public void añadirVerticesACola(nodoVertice<E,T> n, nodoRecorridos<E,T> cola){
        if(n.getAdjacentArista()!=null){
            añadirVerticesACola(n.getAdjacentArista(), cola);
        }
    }
    public void añadirVerticesACola(nodoArista<E,T> n, nodoRecorridos<E,T> cola){
        if(n.getDireccionVertice().getVisitado()!=true){
            encolar(n.getDireccionVertice(),cola);
            n.getDireccionVertice().setVisitado(true);
        }
        if(n.getSiguiente()!=null){
            añadirVerticesACola(n.getSiguiente(),cola);
        }
    }
    public void recorridoBFS(){
        nodoRecorridos<E,T> cola = new nodoRecorridos<E,T>(root);
        root.setVisitado(true);
        recorridoBFS(cola);
    }
    public void recorridoBFS(nodoVertice<E,T> n){
        nodoRecorridos<E,T> cola = new nodoRecorridos<E,T>(n);
        n.setVisitado(true);
        recorridoBFS(cola);
    }
    public void recorridoBFS(nodoRecorridos<E,T> cola){
        try{
            añadirVerticesACola(cola.getVertice(), cola);
            System.out.println(cola.desencolar().getValue());
            if(cola!=null)
                recorridoBFS(cola);
            }
        catch(Exception e){System.out.println("\nFin");}
    }
    

    //Finalizan funciones para bfs

   

    // Funciones para DFS

    public void empilar(nodoVertice<E, T> nuevo, nodoRecorridos<E, T> base) {
        nodoRecorridos<E,T> aux = new nodoRecorridos<E,T>(base.getVertice());
        aux.setNext(base.getNext());
        base.setVertice(nuevo);
        base.setNext(aux);
    }

    public void añadirVerticesAColaDFS(nodoVertice<E,T> n, nodoRecorridos<E,T> cola){
        if(n.getAdjacentArista()!=null){
            añadirVerticesAColaDFS(n.getAdjacentArista(), cola);
        }
    }
    public void añadirVerticesAColaDFS(nodoArista<E,T> n, nodoRecorridos<E,T> cola){
        if(n.getDireccionVertice().getVisitado()!=true){
            empilar(n.getDireccionVertice(),cola);
            n.getDireccionVertice().setVisitado(true);
        }
        if(n.getSiguiente()!=null){
            añadirVerticesAColaDFS(n.getSiguiente(),cola);
        }
    }
   

    public void recorridoDFS() {
        nodoRecorridos<E, T> cola = new nodoRecorridos<E, T>(root);
        root.setVisitado(true);
        recorridoDFS(cola,cola.getVertice());
    }

    public void recorridoDFS(nodoVertice<E, T> n) {
        nodoRecorridos<E, T> cola = new nodoRecorridos<E, T>(n);
        n.setVisitado(true);
        recorridoDFS(cola, cola.getVertice());
    }

    public void recorridoDFS(nodoRecorridos<E, T> cola, nodoVertice<E,T> vertice) {
        try {
            System.out.println(cola.desencolar().getValue());
            añadirVerticesAColaDFS(vertice, cola);     
            if (cola != null)
                recorridoDFS(cola,cola.getVertice());
        } catch (Exception e) {
            System.out.println("\nFin");
        }
    }

    // Finalizan funciones para BFS

    //Funciones para Dijstra

    public void realizarDijstra(){
        root.setAcumulado(0);
        realizarDijstra(root);
    }

    public void realizarDijstra(nodoVertice<E, T> root) {
        if (root.getAdjacentArista() != null) {
            if (root.getAdjacentArista().getDireccionVertice().getAcumulado() == 0
                    || (Integer) root.getAdjacentArista().getDireccionVertice().getAcumulado() > root.getAcumulado()
                            + (Integer) (root.getAdjacentArista().getValue())) {

                root.getAdjacentArista().getDireccionVertice()
                        .setAcumulado(root.getAcumulado() + (Integer) root.getAdjacentArista().getValue());

                realizarDijstra(root.getAdjacentArista().getDireccionVertice());
            }
            realizarDijstra(root.getAdjacentArista());
        }
    }
 
    public void realizarDijstra(nodoArista<E, T> root) {
        if (root.getSiguiente() != null) {
            if (root.getSiguiente().getDireccionVertice().getAcumulado() == 0
                    || (Integer) root.getSiguiente().getDireccionVertice().getAcumulado() > root.getDireccionVertice()
                            .getAcumulado() + (Integer) (root.getSiguiente().getValue())) {

                root.getSiguiente().getDireccionVertice().setAcumulado(
                        root.getDireccionVertice().getAcumulado() + (Integer) root.getSiguiente().getValue());

                realizarDijstra(root.getSiguiente().getDireccionVertice());
            }
            realizarDijstra(root.getSiguiente());
        }
    }

    public void imprimirDijstra(){
        root.setAcumulado(0);
        imprimirDijstra(root, root.getAdjacentArista(), root);
    }
    public void imprimirDijstra(nodoVertice<E,T> n, nodoArista<E,T> next, nodoVertice<E,T> aux){
        System.out.print("--"+n.getValue()+"("+n.getAcumulado()+")");
        if (aux.getNextVertice()!=null){
            System.out.println("\n");
            imprimirDijstra(aux.getNextVertice(),aux.getNextVertice().getAdjacentArista(),aux.getNextVertice());
        }
        
    }

    // Finalizan funciones para Dijstra

   
    //Funciones para hallar si es subgrafo

    public int compararArreglosGrafo(String[] arr1, String[] arr2){
        int contador = 0;
        int contador2 = 0;
        for(int i = 0; i<arr1.length;i++){
            if(arr2[i]!= null){
                contador2++;
            }
        }
        for(int i = 1; i<arr1.length;i++){
            for(int j = 1 ; j < arr2.length ; j++){
                if(arr1[i]!=null && arr2[j]!=null){
                    if(arr1[i].equals(arr2[j]))
                        contador++;
                }
            }
        }
        return contador-contador2;
    }
    public boolean compararArreglosGrafo(String[][] arreglo1, String[][] arreglo2){
        int contador = 0;
        for(int i = 0; i<arreglo1.length;i++){
            for(int j = 0 ; j < arreglo2.length ; j++){
                if(arreglo1[i][0]!=null && arreglo2[j][0]!=null){
                    contador=contador+compararArreglosGrafo(arreglo1[i], arreglo2[j]);
                }
            }
        }
        return contador==0;
    }
    public boolean verificarSubgrafo(listaAdyacencia<E,T> n){
        String[][] grafo1 = this.convertirGrafoaArreglo(this);
        String[][] grafo2 = n.convertirGrafoaArreglo(n);
        return compararArreglosGrafo(grafo1, grafo2);
    }

    public String[][] convertirGrafoaArreglo(listaAdyacencia<E,T> n){
        String[][] lista= new String[orden][orden];
        convertirGrafoaArreglo(n.root, lista, 0, 0);
        return lista;
    }
    public void convertirGrafoaArreglo(nodoVertice<E,T> base, String[][] lista, int contador1, int contador2){
        lista[contador1][contador2] = (String)base.getValue();
        if(base.getAdjacentArista()!=null){
            convertirGrafoaArreglo(base.getAdjacentArista(), lista, contador1, contador2+1);
        }
        if(base.getNextVertice()!=null){
            convertirGrafoaArreglo(base.getNextVertice(), lista, contador1+1, contador2);
        }
    }
    public void convertirGrafoaArreglo(nodoArista<E,T> base, String[][] lista, int contador1, int contador2){
        lista[contador1][contador2] = (String)base.getDireccionVertice().getValue();
        if(base.getSiguiente()!=null){
            convertirGrafoaArreglo(base.getSiguiente(), lista, contador1, contador2+1);
        }
    }

    // Finalizan funciones para Dijstra

    public void vaciarVisitas(){
        vaciarVisitas(root, root.getAdjacentArista(), root);
    }
    public void vaciarVisitas(nodoVertice<E,T> n, nodoArista<E,T> next, nodoVertice<E,T> aux){
        n.setVisitado(false);;
        if(next != null){
            vaciarVisitas(next.getDireccionVertice(),next.getSiguiente(), aux);
        }
        else if (aux.getNextVertice()!=null){
            vaciarVisitas(aux.getNextVertice(),aux.getNextVertice().getAdjacentArista(),aux.getNextVertice());
        }        
    }
    public void imprimir(){
        imprimir(root, root.getAdjacentArista(), root);
    }
    public void imprimir(nodoVertice<E,T> n, nodoArista<E,T> next, nodoVertice<E,T> aux){
        System.out.print("-->"+n.getValue());
        if(next != null){
            System.out.print("<--"+next.getValue());
            imprimir(next.getDireccionVertice(),next.getSiguiente(), aux);
        }
        else if (aux.getNextVertice()!=null){
            System.out.println("\n");
            imprimir(aux.getNextVertice(),aux.getNextVertice().getAdjacentArista(),aux.getNextVertice());
        }
        
    }
}