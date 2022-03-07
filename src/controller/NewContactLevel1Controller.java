package controller;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import models.Contact;
import view.NewContactLevel1View;

public class NewContactLevel1Controller {
    
    public static void index(ArbolContactosEjecutivos<Contact> ejecutivos){
        
        NewContactLevel1View.index(ejecutivos);  
    }
    
}
