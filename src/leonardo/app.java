package leonardo;

public class app {
    public static void main(String[] args){
        arbolnariobinario arbol = new arbolnariobinario();
        Nodo i6 = new Nodo(6,0);
        System.out.println(arbol.Agregar(i6).getNumero());

        Nodo i4 = new Nodo(4,6);
        Nodo i91 = new Nodo(91,0);
        System.out.println(arbol.Agregar(i4).getNumero());
        System.out.println(arbol.Agregar(i91).getNumero());

        Nodo i12 = new Nodo(12,4);
        Nodo i18 = new Nodo(18, 6);
        System.out.println(arbol.Agregar(i12).getNumero());
        System.out.println(arbol.Agregar(i18).getNumero());

        Nodo i1 = new Nodo(1,91);
        System.out.println(arbol.Agregar(i1).getNumero());

        Nodo i8 = new Nodo(8,12);
        System.out.println(arbol.Agregar(i8).getNumero());

        Nodo i9 = new Nodo(9,18);
        System.out.println(arbol.Agregar(i9).getNumero());

        Nodo i3 = new Nodo(3,91);
        System.out.println(arbol.Agregar(i3).getNumero());

        Nodo i16 = new Nodo(16,18);
        System.out.println(arbol.Agregar(i16).getNumero());

        Nodo i14 = new Nodo(14,18);
        System.out.println(arbol.Agregar(i14).getNumero());

        System.out.println("Nodo i8:\n"+arbol.imdes(i18));
    }
}
