/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class ArbolGeneral {
    NodoGeneral raiz;
    
    public ArbolGeneral(){
        raiz=null;
    }
    
    public boolean insertarNodo(String path, char valor){
        if(path.isEmpty()){
            if(raiz==null){
                raiz=new NodoGeneral(valor);
                return true;
            }
            return false;
        }
        NodoGeneral padre= buscarNodo(path);
        if(padre==null){
            return false;
        }
        NodoGeneral buscarHijo =buscarNodo(path+"/"+valor);
        if(buscarHijo!=null){
            return false;
        }
        NodoGeneral hijo= new NodoGeneral(valor);
        if(hijo==null){
            return false;
        }
        
        return padre.insertarLiga(hijo);
    }
    private NodoGeneral buscarNodo(String path){
        if(path.isEmpty()){
            return null;
        }
        path=path.substring(1);
        String[] vector=path.split("/");
        
        if(raiz.valor == vector[0].charAt(0)){
            if(vector.length==1){
                return raiz;
            }
            for(NodoLiga temp=raiz.ini;temp!=null;temp=temp.sig){
                if(temp.direccion.valor==vector[1].charAt(0)){
                    if(vector.length==2){
                        return temp.direccion;
                    }
                    return buscarNodo(temp.direccion,path.substring(3));
                }
            }
        }
        return null;
    }
    private NodoGeneral buscarNodo(NodoGeneral nodoEncontrado,String path){
        if(path.isEmpty()){
            return nodoEncontrado;
        }
        path=path.substring(1);
        String vector[];
        if(path.length()==1){
            vector=new String[1];
            vector[0]=path;
        }else{
            vector=path.split("/");
        }
        for(NodoLiga temp=nodoEncontrado.ini;temp!=null;temp=temp.sig){
            if(temp.direccion.valor==vector[0].charAt(0)){
                buscarNodo(temp.direccion,path.substring(1));
            }
        }
        return null;
    }
    public boolean eliminarNodoGeneral(String path){
        NodoGeneral hijo =buscarNodo(path);
        if(hijo==null){
            return false;
        }
        if(hijo==raiz){
            if(raiz.esHoja()){
                raiz=null;
                return true;
            }
            return false;
        }
        String pathPadre= obtenerPathPadre(path);
        NodoGeneral padre= buscarNodo(pathPadre);
        
        if(padre==null){
            return false;
        }
        if(hijo.esHoja()){
            return padre.eliminarLiga(hijo);
        }
        return false;
    }

    private String obtenerPathPadre(String pathHijo) {
        int posicionUltimaDiagonal= pathHijo.lastIndexOf("/")-1;
        return pathHijo.substring(0, posicionUltimaDiagonal);
    }
}
