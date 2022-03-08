package arbol.nario.binariolistaligada;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Stack;
import arbol.binario.listaligada.normal.*;

/**
 * @author 57300
 */
public class ArbolContactosEjecutivos<Contact extends Comparable> extends ArbolBinarioListaLigada<Contact> {

    public ArbolContactosEjecutivos(NodoBinarioGenerico<Contact> raiz) {
        super(raiz);
    }

    public void agregarContactoN1(Contact contacto) {
        if(buscarNodoContacto(contacto) != null){
            System.out.println("El contacto ya se encuentra guardado en el nivel 1");
            return;
        }
        agregarContacto(contacto);
        //TODO Agregar el contacto al arbol avl.
    }
    
    
    /** Agrega el contacto que se recibe como parámetro en el nivel 1 del arbol de contactos ejecutivos
     * 
     * @param contacto
     * @return Devuelve el nodo con el contacto agregado.
     */
    public NodoBinarioGenerico<Contact> agregarContacto(Contact contacto){
        NodoBinarioGenerico<Contact> nodo = new NodoBinarioGenerico<>(contacto);
        nodo.setLd(raiz.getLi());
        raiz.setLi(nodo);
        return nodo;
    }
 
    public void agregarContactoN2O3(Contact contactoAgregar, Contact referidoGuardado) {
        NodoBinarioGenerico<Contact> nodoReferido = buscarNodoContacto(referidoGuardado);
        if(nodoReferido == null){
            System.out.println("El contanto referido no se encuentra agregado en la base de " +
                    "datos de Contactos Ejecutivos");
            return;
        }
        agregarContactoAlReferido(contactoAgregar, nodoReferido);
        //TODO Agregar el contacto al arbol avl.
    }
    
    /** Agrega el contactoAgregar como hijo del nodoReferido.
     * 
     * @param contactoAgregar
     * @param nodoReferido 
     * @return  Devuelve el nodo con el contacto agregado
     */
    public NodoBinarioGenerico<Contact> agregarContactoAlReferido(Contact contactoAgregar,  NodoBinarioGenerico<Contact> nodoReferido){
        NodoBinarioGenerico<Contact> nodoNuevo = new NodoBinarioGenerico<>(contactoAgregar);
        nodoNuevo.setLd(nodoReferido.getLi());
        nodoReferido.setLi(nodoNuevo);
        return nodoNuevo;
    }

    public NodoBinarioGenerico<Contact> buscarNodoContacto(Contact contacto) {
        NodoBinarioGenerico<Contact> r = raiz;
        Stack<NodoBinarioGenerico<Contact>> migas = new Stack<>();
        r = r.getLi();
        while (!migas.isEmpty() || r != null) {
            if (r != null) {
                if(r.getDato().compareTo(contacto) == 0) return r;
                migas.add(r);
                r = r.getLi();
            } else {
                r = migas.pop();
                r = r.getLd();
            }
        }
        return null;
    }
    
    public NodoBinarioGenerico<Contact> buscarNodoContactoN1(Contact contacto) {
        NodoBinarioGenerico<Contact> r = raiz;
        r = r.getLi();
        while(r != null){
            if(r.getDato().compareTo(contacto) == 0) return r;
            r = r.getLd();
        }
        return null;
    }
    
    public String imprimirDescendencia(NodoBinarioGenerico<Contact> padre){
        if(padre == null){
            return "";
        }else {
            NodoBinarioGenerico<Contact> hijo =padre.getLi();
            String des =  ""+padre.getDato()+":("+imprimirDescendencia(hijo)+")";
            if(hijo != null){
                hijo = hijo.getLd();
                while (hijo!= null){
                    des+=";("+imprimirDescendencia(hijo)+")";
                    hijo = hijo.getLd();
                }
            }
            return des;
        }
    }

    public String imprimirDescendencia(NodoBinarioGenerico<Contact> padre){
        if(padre == null){
            return "";
        }else {
            NodoBinarioGenerico<Contact> hijo =padre.getLi();
            String des =  ""+padre.getDato()+":("+imprimirDescendencia(hijo)+")";
            if(hijo != null){
                hijo = hijo.getLd();
                while (hijo!= null){
                    des+=";("+imprimirDescendencia(hijo)+")";
                    hijo = hijo.getLd();
                }
            }
            return des;
        }
    }


    @Override
    public String toString(){
        StringBuilder mensaje = new StringBuilder();
        Stack<NodoBinarioGenerico> migas = new Stack<>();
        NodoBinarioGenerico<Contact> r = raiz.getLi();
        int nivel = 1;
        while(!migas.isEmpty() || r != null){
            if(r != null){
                migas.add(r.getLd());
                
                for(int i = 1; i<nivel; i++){
                    mensaje.append("\t");
                }
                
                mensaje.append(r.getDato() + "\n");
                r = r.getLi();
                nivel++;
            }else{
                r = migas.pop();
                nivel--;
            }
        }
        return mensaje.toString();
    }
    
    public void imprimirContactosDe(Contact contacto){
        NodoBinarioGenerico<Contact> r = buscarNodoContacto(contacto).getLi();
        StringBuilder mensaje = new StringBuilder();
        Stack<NodoBinarioGenerico> migas = new Stack<>();
        int nivel = 1;
        while(!migas.isEmpty() || r != null){
            if(r != null){
                migas.add(r.getLd());
                
                for(int i = 1; i<nivel; i++){
                    mensaje.append("\t");
                }
                
                mensaje.append(r.getDato() + "\n");
                r = r.getLi();
                nivel++;
            }else{
                r = migas.pop();
                nivel--;
            }
        }
        System.out.println(mensaje.toString());
    }
}
