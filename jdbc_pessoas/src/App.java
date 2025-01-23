public class App {
    public static void main(String[] args) throws Exception {
        var p = new Pessoa();
        p.setNome("João");
        p.setFone("11223344");
        p.setEmail("joao@email.com");
        var dao =  new PessoaDAO(); //data access object
        dao.cadastrar(p);
    }
}
