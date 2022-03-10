package controller;

import bussiness.arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import models.Contact;
import view.ShowContactListView;

public class ShowContactListController {
    public static void index(ArbolContactosEjecutivos<Contact>ejecutivos){
        
        ShowContactListView.index(ejecutivos );  
    }
    
}
