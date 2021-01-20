/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class OrdenamientoBQ {
    public int num[]=new int[25];

    
    OrdenamientoBQ(){
        CrearArreglo();
    }

    public void CrearArreglo() {
        for(int i=0;i<25;i++){
         num[i]=(int)(Math.random()*50)+1;
        }
    }
    public String mostrarArreglo(){
        String cadena="";
        for(int i=0;i<25;i++){
            cadena+=num[i]+", ";
        }
        return cadena;
    }
    public void burbuja(){
        int Aux=0;
        for(int i=0;i<25;i++){
            for(int j=i+1;j<25;j++){
                if(num[j]<num[i]){
                    Aux=num[i];
                    num[i]=num[j];
                    num[j]=Aux;
                }
            }
        }
    }
    
    public void Quicksort(){
        Quicksort(num, 0, num.length -1);
    }
    
    private void Quicksort(int numeros[], int primero, int ultimo){
        int pivote = numeros[primero];
        int i = primero; 
        int j = ultimo; 
        int aux;

        while(i<j){
           while (numeros[i] <= pivote && i < j) i++;

           while (numeros[j] > pivote) j--;   

           if (i<j){                                     
               aux = numeros[i];                  
               numeros[i]= numeros[j];
               numeros[j]=aux;
           }
        }
         numeros[primero] = numeros[j]; 
         numeros[j] = pivote;

         if (primero < j-1)
            Quicksort(numeros,primero,j-1);

         if (j+1 < ultimo)
            Quicksort(numeros,j+1,ultimo);
    }
}
