/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class GrafoDirigido {
    private NodoG ini, fin;
    private NodoG valorEliminado;
    
    public GrafoDirigido(){
        valorEliminado=null;
        ini=null;
        fin=null;
    }
    public boolean insertar(char dato){
        NodoG temp= new NodoG(dato);
        //1
        if(temp==null){
            return false;
        }
        //2
        if(ini==null && fin==null){
            ini=fin=temp;
            return true;
        }
        fin.sig=temp;
        temp.ant=fin;
        fin=temp;
        return true;
    }
    
    public boolean insertarA(char orig,char dest){
        NodoG origen= buscarNodo(orig);
        if(origen==null){
            return false;
        }
        NodoG destino= buscarNodo(dest);
        if(destino==null){
            return false;
        }
        
        NodoA temp=new NodoA(destino);
        
        if(temp==null){
            return false;
        }
        if(origen.a==null){
            origen.a=temp;
            return true;
        }
        
        NodoA t2=origen.a;
        while(t2.sig!=null){
          t2=t2.sig;  
        }
        t2.sig=temp;
        temp.ant=t2;
        
        return true;
    }

    private NodoG buscarNodo(char valor) {
        NodoG temp=ini;
        do{
            if(temp.valor==valor){
                return temp;
            }
            temp=temp.sig;
        }while(temp!=null);
        return temp;
    }
    
    public boolean eliminarArista(char orig,char dest){
        NodoG origen= buscarNodo(orig);
        if(origen==null){
            return false;
        }
        if(origen.a==null){
            return false;
        }
        NodoA temp= origen.a;
        do{
            if(temp.direccion.valor==dest){
                if(temp==origen.a){
                    origen.a=temp.sig;
                    temp.direccion=null;
                    temp.sig=null;
                    origen.a.ant=null;
                    return true;
                }else{
                    if(temp.sig==null){
                        temp.ant.sig=null;
                        temp.direccion=null;
                        temp.ant=null;
                        return true;
                    }
                    temp.ant.sig=temp.sig;
                    temp.sig.ant=temp.ant;
                    temp.ant=temp.sig=null;
                    temp.direccion=null;
                    return true;
                }
            }
            temp=temp.sig;
        }while(temp!=null);
        return false;
    }
    
    public boolean eliminar(char valor){
        if(ini==null && fin==null){
            return false;
        }
        NodoG nodoAEliminar=buscarNodo(valor);
        if(nodoAEliminar==null){
            return false;
        }
        if(nodoAEliminar.a!=null){
            return false;
        }
        for(NodoG temp=ini;temp!=null;temp=temp.sig){
            if(encontrarArista(temp,nodoAEliminar)==true){
                return false;
            }
        }
        if(ini==fin&&ini==nodoAEliminar){
            valorEliminado=nodoAEliminar;
            ini=fin=null;
            return true;
        }
        if(ini==nodoAEliminar){
            valorEliminado=ini;
            NodoG temp=ini.sig;
            ini.sig=null;
            temp.ant=null;
            ini=temp;
            return true;
        }
        if(fin==nodoAEliminar){
            valorEliminado=fin;
            NodoG temp=fin.ant;
            fin.ant=null;
            temp.sig=null;
            fin=temp;
            return true;
        }
        valorEliminado=nodoAEliminar;
        nodoAEliminar.ant.sig=nodoAEliminar.sig;
        nodoAEliminar.sig.ant=nodoAEliminar.ant;
        nodoAEliminar.sig=nodoAEliminar.ant=null;
        return true;
    }

    private boolean encontrarArista(NodoG temp, NodoG nodoAEliminar) {
        for(NodoA temp2=temp.a;temp2!=null;temp2=temp2.sig){
            if(temp2.direccion==nodoAEliminar){
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarA(char orig,char dest){
        NodoG origen= buscarNodo(orig);
        if(origen==null){
            return false;
        }
        NodoG destino= buscarNodo(dest);
        if(destino==null){
            return false;
        }
        for(NodoA temp=origen.a;temp!=null;temp=temp.sig){
            if(temp.direccion==destino){
                return true;
            }
        }
        
        return false;
    }
    public String mostrar(){
        if(ini==null){
            return "Sin nodos";
        }
        return mostrar(ini);
    }
    public String mostrar(NodoG temp){
        if(temp==null){
            return "";
        }
        return temp.valor+", "+mostrar(temp.sig);
    }
    public String mostrarA(char origen){
        NodoG temp=buscarNodo(origen);    
        if(temp.a==null){
            return "Sin Aristas";
        }
        NodoA t2=temp.a;
        return mostrarA(t2);
    }
    public String mostrarA(NodoA temp){
        if(temp==null){
            return "";
        }
        return temp.direccion.valor+", "+mostrarA(temp.sig);
    }

}
