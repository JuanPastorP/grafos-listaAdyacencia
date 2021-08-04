public class nodoArista <E,T>{
        private nodoArista<E,T>  siguiente;
        private nodoVertice<E,T> direccionVertice;
        private T value;

    public nodoArista(T value) {
        this.value = value;
    }
    public void setSiguiente(nodoArista<E,T> siguiente){this.siguiente = siguiente;}
    public nodoArista<E,T> getSiguiente(){return siguiente;}
    public void setDireccionVertice(nodoVertice<E,T> direccion){this.direccionVertice = direccion;}
    public nodoVertice<E,T> getDireccionVertice(){return direccionVertice;}
    public T getValue(){return value;}
    public void setValue(T value){this.value = value;}
}
