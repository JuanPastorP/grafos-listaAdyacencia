public class ejercicio5 {
    public static void main(String[] args) {
        String[] arr = new String[11];
        arr[0]="words";
        arr[1]="cords";
        arr[2]="corps";
        arr[3]="coops";
        arr[4]="crops";
        arr[5]="drops";
        arr[6]="drips";
        arr[7]="grips";
        arr[8]="gripe";
        arr[9]="grape";
        arr[10]="graph";

        listaAdyacencia<String,Integer> grafo = new listaAdyacencia<String,Integer>();
        for(int i = 0; i<arr.length;i++){
            grafo.insertVertice(arr[i]);
        }
        for(int i = 0; i<arr.length;i++){
            for(int j = i+1; j<arr.length;j++){
                if(compararStrings(arr[i], arr[j])==1){
                    grafo.insertArista(arr[i], 0, arr[j]);
                }
            }
        }
        grafo.imprimir();
    }
    

    public static int compararStrings(String n, String m){
        int aux = 0;
        for(int i = 0; i<5; i++){
            if(n.charAt(i)!=m.charAt(i))
                aux+=1;
        }
        return aux;
    }
    
}
