package rpg;

public class Potion implements Item{
    
    private final String nome;
    private int pontos;
    int tipo; //1 para potion de mana, 2 para potion de hp, 3 para poção alcoólica
    
    Potion(String nome, int pontos, int tipo){
        this.nome = nome;
        this.pontos = pontos;
        if(tipo < 0 || tipo > 3){
            System.out.println("[SISTEMA]: Tipo de poção inválido.");
        } else {
            this.tipo = tipo;
        }
    }
    
    @Override
    public int getPontos(){
        return this.pontos;
    }
    
    @Override
    public String getNome(){
        return this.nome;
    }
    
    @Override
    public void setPontos(int p){
        this.pontos = p;
    }
        
    @Override
    public void usar(Jogador j){
        if(this.tipo == 1){
            j.mana += pontos;
            System.out.println(this.nome + " consumida. Mana: " + j.mana + "/" + j.maxMana);
        } else if (this.tipo == 2){
            j.HP += pontos;
            System.out.println(this.nome + " consumida. HP: " + j.HP + "/" + j.maxHP);
        }
    }
}