/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class NodoA {
    
    NodoG direccion;
    NodoA ant,sig;
    
    public NodoA(NodoG d){
        direccion=d;
        ant=null;
        sig=null;
    }
}
