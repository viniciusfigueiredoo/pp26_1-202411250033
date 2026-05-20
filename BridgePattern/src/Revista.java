public class Revista extends Publicacao {
    public Revista(Implementador imp){
        super(imp);
    }

    public void getArtigo(){
        System.out.println("Artigo da revista: ...");
    }
    @Override
    public void getTitulo(){
        System.out.println("Titulo: ...");
    }
    @Override
    public void getAutor(int id){
        System.out.println("Autor referente ao ID: ...");
    }
}
