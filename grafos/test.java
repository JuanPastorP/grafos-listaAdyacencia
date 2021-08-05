
public class test {
    public static void main(String[] args) {
        listaAdyacencia<String,Integer> grafo = new listaAdyacencia<String,Integer>();
        grafo.insertVertice("Juan");
        grafo.insertVertice("Pedro");
        grafo.insertVertice("Vidal");
        grafo.insertVertice("Pastor");
        grafo.insertVertice("Antonio");
        grafo.insertArista("Pastor", 5, "Pedro");
        grafo.insertArista("Vidal", 5, "Pastor");
        grafo.insertArista("Juan", 5, "Pedro");
        grafo.insertArista("Vidal", 7, "Pedro");
        grafo.insertArista("Vidal", 7, "Antonio");
        grafo.imprimir();

        System.out.println("\n");
        grafo.recorridoBFS();
        grafo.vaciarVisitas();

        System.out.println("\n");
        grafo.recorridoDFS();
        grafo.vaciarVisitas();
        
        System.out.println("\n");
        grafo.realizarDijstra();
        grafo.imprimirDijstra();
    }
}
