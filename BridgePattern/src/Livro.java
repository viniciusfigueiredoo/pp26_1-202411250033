public class Livro extends Publicacao {
    public Livro(Implementador imp){
        super(imp);
    }

    public void getISBN(){
        System.out.println("ISBN do livro: ...");
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
