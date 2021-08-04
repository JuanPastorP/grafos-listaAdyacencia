
public class test {
    public static void main(String[] args) {
        listaAdyacencia<String,Integer> grafo = new listaAdyacencia<String,Integer>();
        grafo.insertVetice("Juan");
        grafo.insertVetice("Pedro");
        grafo.insertArista("Juan", 5, "Pedro");
        grafo.imprimir();
    }
}
