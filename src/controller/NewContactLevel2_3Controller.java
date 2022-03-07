package controller;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import models.Contact;
import view.NewContactLevel2_3View;

public class NewContactLevel2_3Controller { 
    public static void index(ArbolContactosEjecutivos<Contact> ejecutivos){
        
        NewContactLevel2_3View.index(ejecutivos);  
}
    
}
