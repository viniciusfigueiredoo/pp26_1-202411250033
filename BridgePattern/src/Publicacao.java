public abstract class Publicacao {
    private Implementador imp;

    public Publicacao(Implementador imp){
        this.imp = imp;
    }

    public void obterDados(Publicacao tipo){
        imp.getDados(this);
    }
    public abstract void getTitulo();
    public abstract void getAutor(int id);
}
