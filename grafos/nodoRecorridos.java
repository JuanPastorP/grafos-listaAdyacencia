public class nodoRecorridos<E,T> {
    private nodoVertice<E,T> vertice;
    private nodoRecorridos<E,T> next;
   

    public nodoRecorridos(nodoVertice<E,T> value) {
        this.vertice = value;
    }
  
    public nodoVertice<E,T> desencolar(){
        if(next != null){
            nodoVertice<E,T> aux = vertice;
            vertice = next.vertice;
            next = next.next;
            return aux;
        }
        else{
            nodoVertice<E,T> aux = vertice;
            vertice = null;
            return aux;
        }
    }
    public void setVertice(nodoVertice<E,T> vertice){this.vertice = vertice;}
    public nodoVertice<E,T> getVertice(){return vertice;}
    public void setNext(nodoRecorridos<E,T> next){this.next = next;}
    public nodoRecorridos<E,T> getNext(){return next;}
  
}
