package bussiness.util;

import java.io.*;
import java.util.Stack;

import bussiness.arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import bussiness.arbol.binario.listaligada.busqueda.avl.NodoAVL;
import bussiness.arbol.binario.listaligada.normal.NodoBinarioGenerico;
import bussiness.arbol.nario.binariolistaligada.ArbolContactosEjecutivos;
import models.Contact;

public class FileTo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";
    public static final String COLON_SEPARATOR = ":";

    /**
     * @param filePath
     * @return MatrizEnTripleta
     * @throws IOException
     */

    public static ArbolAVL<Contact> agenda(String filePath) throws IOException {

        BufferedReader br = null;

        try {

            ArbolAVL<Contact> directorio = new ArbolAVL<Contact>();

            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();

            while (null != line) {

                String[] fields = line.split(COLON_SEPARATOR);

                fields[0] = fields[0].replaceAll(" ", "");

                Contact tempContact = new Contact();
                tempContact.setPhoneNumber(Long.parseLong(fields[0]));
                tempContact.setName(fields[1]);
                directorio.insertarDato(tempContact);

                line = br.readLine();
            }
            return directorio;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (null != br) {
                br.close();
            }
        }
    }

    public static ArbolContactosEjecutivos<Contact> contactosEjecutivos(String filePath, ArbolAVL<Contact> directorio)
            throws IOException {
        BufferedReader br = null;
        // System.out.println("Creando arbol de contactos ejecutivos");
        try {
            ArbolContactosEjecutivos<Contact> contEje = new ArbolContactosEjecutivos<>(new NodoBinarioGenerico<>(null));

            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();

            Contact padre = null, hijo = null, nieto = null;
            NodoAVL<Contact> nodoAuxAVL;
            Stack<NodoBinarioGenerico<Contact>> nodosCont = new Stack();
            Contact contAux;
            while (null != line) {

                String[] fields = line.split(COLON_SEPARATOR);
                fields[0] = fields[0].replaceAll(" ", "");
                char nivel = fields[0].charAt(0);
                switch (nivel) {
                    case '1':
                        nodosCont.clear();
                        padre = new Contact(Long.parseLong(fields[1]));
                        NodoBinarioGenerico<Contact> nodoPadre = contEje.buscarNodoContactoN1(padre);
                        if (nodoPadre != null) {
                            nodosCont.add(nodoPadre);
                        } else {
                            nodoAuxAVL = directorio.buscar(padre);
                            padre = nodoAuxAVL != null ? (Contact) nodoAuxAVL.getDato()
                                    : padre;
                            nodosCont.add(contEje.agregarContacto(padre));
                        }

                        hijo = new Contact(Long.parseLong(fields[2]));
                        nodoAuxAVL = directorio.buscar(hijo);
                        hijo = nodoAuxAVL != null ? (Contact) nodoAuxAVL.getDato()
                                : hijo;

                        nodosCont.add(contEje.agregarContactoAlReferido(hijo,
                                nodosCont.peek()));
                        break;

                    case '2':
                        while (nodosCont.size() > 2) {
                            nodosCont.pop();
                        }

                        nieto = new Contact(Long.parseLong(fields[2]));
                        nodoAuxAVL = directorio.buscar(nieto);
                        nieto = nodoAuxAVL != null ? (Contact) nodoAuxAVL.getDato()
                                : nieto;
                        nodosCont.add(contEje.agregarContactoAlReferido(nieto,
                                nodosCont.peek()));
                        break;

                    case '3':
                        contAux = new Contact(Long.parseLong(fields[2]));
                        nodoAuxAVL = directorio.buscar(contAux);
                        contAux = nodoAuxAVL != null ? (Contact) nodoAuxAVL.getDato()
                                : contAux;
                        contEje.agregarContactoAlReferido(contAux, nodosCont.peek());
                        break;
                }
                line = br.readLine();
            }

            return contEje;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("El archivo no tiene el formato para la base de datos de contactos ejecutivos");
            return null;
        } catch (Exception e) {
            System.out.println("No se ha encontrado el archivo de texto \n" + e);
            return null;

        } finally {
            if (null != br) {
                br.close();
            }
        }
    }
}