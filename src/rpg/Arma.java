
package rpg;


public class Arma implements Item {
    public String nome;
    private int dano;
    private int tipo; 
    
    /*
    Tipos de Armas:
    
    [1]: Armas Cortantes e Perfurantes - Espada, Machado, Lança (Guerreiro)
    [2]: Armas Mágicas - Cajado, Varinha (Mago)
    [3]: Armas à Distância - Arco, Besta (Arqueiro)
    [4]: Armas Contundentes - Martelo, Clava (Clérigo)
    [5]: Amuletos Mágicos
    */
    
    Arma(String nome, int dano, int tipo){
        this.nome = nome;
        this.dano = dano;
        if(tipo < 0 || tipo > 5){
            System.out.println("[SISTEMA]: Tipo de arma inválido.");
        } else {
            this.tipo = tipo;
        }
    }
    
    @Override
    public int getPontos(){
        return this.dano;
    }
    
    @Override
    public void setPontos(int p){
        this.dano = p;
    }
    
    @Override
    public String getNome(){
        return this.nome;
    }
    
    @Override
    public void usar(Jogador j){
        System.out.println();
    }
    
}