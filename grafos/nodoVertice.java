
public class nodoVertice<E,T> {
    private nodoVertice<E,T> nextVertice;
    private nodoArista<E,T> adjacentArista;
    private E value;
    private boolean visitado = false;
    private int acumulado = 99999999;

    public nodoVertice(E value) {
        this.value = value;
    }
    public void setNextVertice(nodoVertice<E,T> nextVertice){this.nextVertice = nextVertice;}
    public nodoVertice<E,T> getNextVertice(){return nextVertice;}
    public void setAdjacentArista(nodoArista<E,T> adjacenteArista){this.adjacentArista = adjacenteArista;}
    public nodoArista<E,T> getAdjacentArista(){return adjacentArista;}
    public E getValue(){return value;}
    public void setValue(E value){this.value = value;}
    public boolean getVisitado(){return visitado;}
    public void setVisitado(boolean value){this.visitado = value;}
    public int getAcumulado(){return acumulado;}
    public void setAcumulado(int acumulado){this.acumulado = acumulado;}

}
