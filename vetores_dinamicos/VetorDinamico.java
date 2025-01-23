
public class VetorDinamico {
    private int qtde;
    private int cap;
    private int [] elementos;
    private static final int CAPACIDADE_MINIMA = 4;
    
    private void adicionar(int e){
        if (estaCheio()){
            aumentarCapacidade(e);
        }
        elementos[qtde++] = e; 
    }

    private void redimensionar(double fator){
        int [] aux;
        aux = new int [(int) (cap * fator)];
        for (int i = 0; i < qtde; i++) {
            aux [i] = elementos[i];
        }
        cap = (int) (cap * fator);
        elementos = aux;
    }

    private void aumentarCapacidade() {
        // 1. Verificar se o vetor está cheio
        if (qtde >= cap) {
            // Alocar um novo vetor chamado "aux" com o dobro da capacidade atual
            int[] aux = new int[cap * 2];
            // Fazer um for para copiar todos os elementos para "aux"
            for (int i = 0; i < qtde; i++) {
                aux[i] = elementos[i]; // Considerando que "vetor" é o vetor original
            }
            // Ajustar as variáveis cap e qtde apropriadamente
            cap *= 2; 
            elementos = aux; // Atualizar o vetor original para apontar para "aux"
        }
    }

    private void reduzirCapacidade(){
        //declarar um vetor auxuliar chamado "aux" com a metade da cap 
        //copiar todos do elementos para o "aux"
        //alusto elementos para que ele aponte para o "aux"
        //corto o cap na metade
    }

    public void remover(){
       if (!estaVazio()){
            qtde--;
       }
       if (estaUmQuartoCheio() && cap > CAPACIDADE_MINIMA){
        redimensionar(0.5);
       }
    }
    private boolean estaUmQuartoCheio(){
        return qtde <= cap / 4;
    }
    public boolean estaCheio(){
        return qtde == cap;
    }
    public boolean estaVazio(){
        return qtde == 0;   
    }

    public VetorDinamico(int cap){
        if (cap >= 4){
            elementos = new int[cap];
            this.cap = cap;
        }
        else{
            elementos = new int[4];
            this.cap = 4;
        }
        //elementos = cap >= 4 ? new int[cap] : new int[4];
    }

    public String toString() {
    //qtde; 2, cap: 4
    //5, 4
    var sb = new StringBuilder("");
    sb.append("qtde: ").append(", cap: " ).append(cap).append("\n");
    for(var i = 0; i < qtde; i++){
        sb.append(elementos[i]).append(" ");
    }
    return sb.toString();
    }
}
