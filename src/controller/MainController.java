package controller;

import java.io.IOException;

import bussiness.arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import models.Contact;

public class MainController {
   

    /** 
     * @param select
     * @throws IOException
     */
    public static void index(char select, IdentificadorDeLlamadas identificador, ArbolContactosEjecutivos<Contact> ejecutivos) throws IOException {
        switch (select) {
        case '1':SearchByNumberController.index(identificador);                    
            break;
        case '2':ShowContactListController.index(ejecutivos);
             break;
         case '3':NewContactLevel1Controller.index(ejecutivos, identificador);
             break;
        case '4':NewContactLevel2_3Controller.index(ejecutivos, identificador);
             break;
         case '5':NewContacIdCallController.index(identificador);
             break;
        case '6':SaveController.index(identificador, ejecutivos);
            break;
        case '.':
            break;
        default:
            System.out.println("error");

        }

    

}
    
}
