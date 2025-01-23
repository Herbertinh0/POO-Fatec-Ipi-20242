import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        var menu = "1- Cadastrar\n2- Listar\n3- Atualizar\n4- Apagar\n5- Listar por inicial\n0- Sair\n";
        int op = 0;
        do { 
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(op) {
                case 1: {
                    var nome = JOptionPane.showInputDialog("Nome?");
                    var fone = JOptionPane.showInputDialog("Fone?");
                    var email = JOptionPane.showInputDialog("Email?");
                    var p = new Pessoa(0, nome, fone, email);
                    var dao = new PessoaDAO();
                    dao.cadastrar(p);
                    JOptionPane.showMessageDialog(null, "Cadastro OK!");
                    break;
                }
                case 2: {
                    var pessoas = new PessoaDAO().listar();
                    JOptionPane.showMessageDialog(null, pessoas);
                    break;
                }
                case 3: {
                    var codigo = Integer.parseInt(JOptionPane.showInputDialog("Código"));
                    var nome = JOptionPane.showInputDialog("Novo nome?");
                    var fone = JOptionPane.showInputDialog("Novo fone?");
                    var email = JOptionPane.showInputDialog("Novo email?");
                    var p = new Pessoa(codigo, nome, fone, email);
                    var dao = new PessoaDAO();
                    dao.atualizar(p);  
                    JOptionPane.showMessageDialog(null, "Atualização OK!");
                    break;
                }
                case 4: {
                    var codigo = Integer.parseInt(JOptionPane.showInputDialog("Código?"));
                    var p = new Pessoa(codigo);
                    var dao = new PessoaDAO();
                    dao.apagar(p);
                    JOptionPane.showMessageDialog(null, "Apagado!");
                    break;
                }
                case 5: {
                    var letra = JOptionPane.showInputDialog("Informe a letra inicial:");
                    var pessoas = new PessoaDAO().listar();
                    
                    var resultado = new StringBuilder();
                    for (var pessoa : pessoas) {
                        if (pessoa.getNome().toLowerCase().startsWith(letra.toLowerCase())) {
                            resultado.append(pessoa).append("\n");
                        }
                    }
                    
                    if (resultado.length() > 0) {
                        JOptionPane.showMessageDialog(null, resultado.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhuma pessoa encontrada com a inicial '" + letra + "'.");
                    }
                    break;
                }
                case 0: {
                    JOptionPane.showMessageDialog(null, "Até!");
                    break;
                }
            }
        } while (op != 0);
    }
}
