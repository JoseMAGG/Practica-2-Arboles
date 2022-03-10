package view;

import java.io.IOException;
import java.util.Scanner;

import bussiness.arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import bussiness.avl.IdentificadorDeLlamadas;
import controller.MainController;
import models.Contact;
import view.constants.MainConstants;

public class Index {
    static Scanner read = new Scanner(System.in);

    public static void mainScreen(IdentificadorDeLlamadas identificador, ArbolContactosEjecutivos<Contact> ejecutivos) throws IOException {
        System.out.println(MainConstants.SUBTITLE);
        for (String author : MainConstants.AUTHORS)
            System.out.print(author);
        System.out.println("\n");

        char select;
        do {
            for (String option : MainConstants.MAIN_MENU_OPTIONS) {
                System.out.println(option);
            }

            select = read.next().charAt(0);
            MainController.index(select, identificador, ejecutivos);

        } while (select != '.');
    }
}