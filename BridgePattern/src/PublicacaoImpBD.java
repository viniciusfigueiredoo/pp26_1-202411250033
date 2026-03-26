public class PublicacaoImpBD implements Implementador{
    public void getDados(Publicacao tipo){
        System.out.println("Lendo BD");
        tipo.getTitulo();
        tipo.getAutor(1);
        System.out.println();
    }
}
