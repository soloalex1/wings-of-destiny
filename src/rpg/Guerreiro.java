package rpg;

public class Guerreiro extends Classe {
    
    Guerreiro(Jogador j){
        j.HP += 2;
        j.maxHP += 2;
        j.mana += 1;
        j.maxMana += 1;
        this.ataqueUm = "Impacto Esmagador";
        this.ataqueEspecial = "Lâmina Eterna";
        this.manaUm = 2;
        this.manaEsp = 4;
        j.somaDano = 2;
        if(j.gender == 1){
            this.nomeClasse = "guerreiro";
            this.pluralClasse = "guerreiros";
        } else {
            this.nomeClasse = "guerreira";
            this.pluralClasse = "guerreiras";  
        }
    }
    
    @Override
    public void increaseStats(Jogador j) { //esse sim é o método que precisa ser reescrito pra cada classe com valor diferente
            j.maxHP += 3;
            System.out.print("HP: + 3" + "\t");
            System.out.println("HP atual: " + j.HP + "/" + j.maxHP);
            j.maxMana += 1;
            System.out.println("Mana: +1" + "\t");
            System.out.println("Mana atual: " + j.mana + "/" + j.maxMana);
        }   
    
    @Override
    public int ataqueUm(Jogador j, Dado d){ //1A + somaDano
        int rolagem;
        if(j.mana < manaUm){
            System.out.println("[SISTEMA]: Mana insuficiente.");
            return 0;
        } else {
            j.mana -= manaUm;
            rolagem = d.roll(1, j.arma.getPontos());
            System.out.println("Dano causado: " + rolagem + " + " + j.somaDano + " = " + (rolagem + j.somaDano));
            return rolagem + j.somaDano;
        } 
    }
    
    @Override
    public int ataqueEspecial(Jogador j, Dado d){ //2A + somaDano
        int rolagem;
        if(j.mana < manaEsp){
            System.out.println("[SISTEMA]: Mana insuficiente.");
            return 0;
        } else {
            j.mana -= manaEsp;
            rolagem = d.roll(2, j.arma.getPontos());
            System.out.println("Dano causado: " + rolagem + " + " + j.somaDano + " = " + (rolagem + j.somaDano));
            return rolagem + j.somaDano;
        } 
    }
}