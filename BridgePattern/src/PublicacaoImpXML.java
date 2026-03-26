public class PublicacaoImpXML implements Implementador{
    public void getDados(Publicacao tipo){
        System.out.println("Lendo XML");
        tipo.getTitulo();
        tipo.getAutor(1);
        System.out.println();
    }
}