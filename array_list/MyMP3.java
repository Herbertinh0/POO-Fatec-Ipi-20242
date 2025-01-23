import java.util.ArrayList;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
public class MyMP3 {
    public static void main(String[] args){
        var musicas = new ArrayList<Musica>();
        //1 - Cadastrar uma música
        //2 - Visualizar lista de músicas
        //3 - Remover Música
        //0 - Sair
        int op;
        var menu  = "1 - Cadastrar uma música\n2 - listar músicas\n3 - Remover Música\n0 - Sair";
        do{
            op = parseInt(showInputDialog(menu));
            switch (op) {
                case 1:{
                    var titulo = showInputDialog("Qual o Titulo?");
                    var musica = new Musica(titulo);
                    musicas.add(musica);
                    showMessageDialog(null, "Música adicionada!");
                break;
                }
                case 2:{
                    //verificar se o arraylist musicas tem pelo menos uma musica
                        if(!musicas.isEmpty()){
                            var sb = new StringBuilder("");
                            for (var m : musicas){
                                sb.append(m.getTitulo()).append("\n");
                            } 
                            showMessageDialog(null, sb.toString());
                        }
                    break;
                }
                case 3:{
                    var titulo = showInputDialog("Titulo?");
                    musicas.remove(new Musica(titulo));
                    break;
                }

                case 0:{
                    showMessageDialog(null, "Até mais!");
                    break;
                }
                default:
                    break;
            }
        }while (op != 0);
    }
}