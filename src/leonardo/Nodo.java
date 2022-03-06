package leonardo;

public class Nodo {
    private int numero;
    private int numeroPadre;

    private Nodo ligaizquierda;
    private Nodo ligaderecha;

    public Nodo(int numero, int numeroPadre){
        this.numero = numero;
        this.ligaderecha = null;
        this.ligaizquierda = null;
        this.numeroPadre = numeroPadre;
    }

    public int getNumero() {
        return numero;
    }

    public int getNumeroPadre() {
        return numeroPadre;
    }

    public Nodo getLigaizquierda() {
        return ligaizquierda;
    }

    public void setLigaizquierda(Nodo ligaizquierda) {
        this.ligaizquierda = ligaizquierda;
    }

    public Nodo getLigaderecha() {
        return ligaderecha;
    }

    public void setLigaderecha(Nodo ligaderecha) {
        this.ligaderecha = ligaderecha;
    }
}
