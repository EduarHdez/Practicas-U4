/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class NodoG {
    char valor;
    NodoA a;
    NodoG ant, sig;
    
    public NodoG(char valor){
        this.valor=valor;
        ant=null;
        sig=null;
        a=null;
    }
}
