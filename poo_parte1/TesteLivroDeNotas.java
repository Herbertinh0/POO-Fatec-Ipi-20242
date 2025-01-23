import javax.swing.JOptionPane;
public class TesteLivroDeNotas {
    public static void main(String...args){

        // construir um livro de notas        
        var meuLivro = new LivroDeNotas();
        
        // acionar o comportamento sobre ele
        var disciplina1 = JOptionPane.showInputDialog("Digite o nome da disciplina:");
        meuLivro.setNomeDisciplina(disciplina1);
        meuLivro.exibirMensagem();
        
        // construir um segundo livro de notas
        var disciplina2 = JOptionPane.showInputDialog("Digite o nome da disciplina 2:");
        var meuLivro2 = new LivroDeNotas();
        
        // e fazer com que ele exiba a mensagem
        meuLivro2.setNomeDisciplina(disciplina2);
        meuLivro2.exibirMensagem();
    }
}
