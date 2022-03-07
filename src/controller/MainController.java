package controller;

import arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import models.Contact;

public class MainController {
   

    /** 
     * @param select
     */
    public static void index(char select, IdentificadorDeLlamadas identificador, ArbolContactosEjecutivos<Contact> ejecutivos) {
        switch (select) {
        case '1':SearchByNumberController.index(identificador);                    
            break;
        // case '2':ShowContactListController.index();
        //     break;
         case '3':NewContactLevel1Controller.index(ejecutivos);
             break;
        // case '4':NewContactLevel2_3Controller.index();
        //     break;
         case '5':NewContacIdCallController.index(identificador);
             break;
        //case '6':SaveController.index();
        //    break;
        case '.':
            break;
        default:
            System.out.println("error");

        }

    

}
    
}
