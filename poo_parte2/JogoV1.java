public class JogoV1 {
    public static void main(String [] args) {
        //construir um objeto Personagem
        var p1 = new Personagem();
        //atribuir um nome a ele
        p1.nome = "Steve";
        //colocar o personagem para        
        p1.cacar();
        //colocar o personagem para
        p1.comer();
        //colocar o personagem para
        p1.dormir();
    }
}
