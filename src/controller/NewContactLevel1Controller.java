package controller;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import models.Contact;
import view.NewContactLevel1View;

public class NewContactLevel1Controller {
    
    public static void index(ArbolContactosEjecutivos<Contact> ejecutivos, IdentificadorDeLlamadas identificador){
        
        NewContactLevel1View.index(ejecutivos, identificador);  
    }
    
}
