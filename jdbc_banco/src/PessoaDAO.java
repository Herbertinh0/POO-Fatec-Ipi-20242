//Data Access Object
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    public void cadastrar(Pessoa p) throws Exception
    {
        //1. especificar o comando SQL (INSERT)
        var sql  = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?, ?, ?)";
        //2. estabelecer conexão com o banco
        var conexao = ConnectionFactory.conectar();
        //3. preparar o comando
        var ps = conexao.prepareStatement(sql);
        //4. substituir os eventuais placeholders
        ps.setString(1, p.getNome());
        ps.setString(2, p.getFone());
        ps.setString(3, p.getEmail());
        //5. executar o comando
        ps.execute();
        //6. fechar a conexao
        ps.close();
    }

    public void apagar(Pessoa p) throws Exception{
        var sql = "DELETE FROM tb_pessoa WHERE cod_pessoa = ?";
        var conexao = ConnectionFactory.conectar();
        var ps = conexao.prepareStatement(sql);
        ps.setInt(1, p.getCodigo());
        ps.execute();
        ps.close();
        // by Isabel Santos
    }

    public List <Pessoa> listar() throws Exception{
        var pessoas = new ArrayList<Pessoa>();
        var sql = "SELECT * FORM tb_pessoa";
        //7+: try-with-resources
        try(var conexao = ConnectionFactory.conectar()){
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            var codigo = rs.getInt("codigo");
            var nome = rs.getString("nome");
            var fone = rs.getString("fone");
            var email = rs.getString("email");
            var p =  new Pessoa(codigo, nome, fone, email);
            pessoas.add(p);            
        }
        return pessoas;
    }
}
