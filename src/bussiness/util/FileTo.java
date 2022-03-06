package src.bussiness.util;

import java.io.*;

import src.arbol.binario.listaligada.busqueda.avl.ArbolAVL;

import src.models.Contact;


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

                fields[0]=fields[0].replaceAll(" ","");

                Contact tempContact = new Contact();
                tempContact.setPhoneNumber(Long.parseLong(fields[0]));
                tempContact.setName(fields[1]);
                directorio.insertarDato(tempContact);
;

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

    
}