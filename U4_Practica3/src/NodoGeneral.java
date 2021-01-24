/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class NodoGeneral {
    char valor;
    NodoLiga ini, fin;
    
    public NodoGeneral(char v){
        valor=v;
        ini=fin=null;
    }
    
    public boolean insertarLiga(NodoGeneral direccion){
        NodoLiga temp=new NodoLiga(direccion);
        if(temp==null){
            return false;
        }
        if(ini==null&&fin==null){
            ini=fin=temp;
            return true;
        }
        fin.sig=temp;
        temp.ant=fin;
        fin=temp;
        return true;
    }
    
    public boolean eliminarLiga(NodoGeneral direccion){
        if(ini==null&&fin==null){
            return false;
        }
        if(ini==fin && fin.direccion==direccion){
            ini=fin=null;
        }
        if(ini.direccion==direccion){
            NodoLiga temp=ini.sig;
            ini.sig=null;
            temp.ant=null;
            ini=temp;
            return true;
        }
        if(fin.direccion==direccion){
            NodoLiga temp=fin.ant;
            fin.ant=null;
            temp.sig=null;
            fin=temp;
            return true;
        }
        NodoLiga temp=ini.sig;
        do{
            if(temp.direccion==direccion){
                temp.ant.sig=temp.sig;
                temp.sig.ant=temp.ant;
                temp.ant=temp.sig=null;
                return true;
            }
            temp=temp.sig;
        }while(temp!=fin);
        return false;
    }
    public boolean esHoja(){
        return ini==null && fin==null;
    }
}
