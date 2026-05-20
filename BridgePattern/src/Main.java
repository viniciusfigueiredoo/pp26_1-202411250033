public class Main {
    public static void main(String[] args){
        PublicacaoImpBD impBD1 = new PublicacaoImpBD();
        Livro livro1 = new Livro(impBD1);
        livro1.obterDados(livro1);

        PublicacaoImpBD impBD2 = new PublicacaoImpBD();
        Revista revista1 = new Revista(impBD2);
        revista1.obterDados(revista1);

        PublicacaoImpXML impXML1 = new PublicacaoImpXML();
        Livro livro2 = new Livro(impXML1);
        livro2.obterDados(livro2);

        PublicacaoImpXML impXML2 = new PublicacaoImpXML();
        Revista revista2 = new Revista(impXML2);
        revista2.obterDados(revista2);
    }
}
