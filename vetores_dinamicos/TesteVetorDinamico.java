import java.util.Random;
public class TesteVetorDinamico {
    public static void main(String[] args) throws Exception{
        var teste =  new VetorDinamico(8);
        var gerador = new Random();
        while (true) {
            var valor = gerador.nextInt(10)+ 1;
            var oQueFazer =gerador.nextDouble();
            if (oQueFazer <= 0.5){
                System.out.println("Removendo...");
                
            }
            teste.adicionar(valor);
            System.out.println(teste);
            System.out.println("=====================");
            Thread.sleep(5000);
        }
    }
}
