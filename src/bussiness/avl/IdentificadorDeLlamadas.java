
package src.bussiness.avl;

import java.io.IOException;
import src.arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import src.bussiness.util.AvlTo;
import src.bussiness.util.FileTo;
import src.models.Contact;

public class IdentificadorDeLlamadas {

    private ArbolAVL<Contact> directorio;

    public IdentificadorDeLlamadas() {
    }

    public IdentificadorDeLlamadas(ArbolAVL<Contact> directorio) {
        this.directorio = directorio;
    }

    public void creteAvlFromFile(String path) throws IOException {

        this.directorio = FileTo.agenda(path); // crear el directorio general

    }

    public void creteAvlFromFile() throws IOException {

        this.directorio = FileTo.agenda("src/contactos.txt"); // crear el directorio general

    }

    public Contact searchContact(String number) {

        Contact contact = new Contact((Long.valueOf(number)));
        Contact foundContact = (Contact) this.directorio.buscar(contact).getDato();// ejemplo buscar

        return foundContact;

    }

    public Contact addContact(Contact contact) {

        return (Contact) this.directorio.insertarDato(contact).getDato();

    }

    public void avlToFile() throws IOException {

        AvlTo.txtFile(this.directorio);

    }

    public void avlToFile(String path) throws IOException {

        AvlTo.txtFile(this.directorio);

    }

    public ArbolAVL<Contact> getDirectorio() {
        return directorio;
    }

    public void setDirectorio(ArbolAVL<Contact> directorio) {
        this.directorio = directorio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((directorio == null) ? 0 : directorio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IdentificadorDeLlamadas other = (IdentificadorDeLlamadas) obj;
        if (directorio == null) {
            if (other.directorio != null)
                return false;
        } else if (!directorio.equals(other.directorio))
            return false;
        return true;
    }

}