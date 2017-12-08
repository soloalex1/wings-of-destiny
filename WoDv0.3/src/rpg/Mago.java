package rpg;

public class Mago extends Classe {
    
    Mago(Jogador j){
        j.HP += 1;
        j.maxHP += 1;
        j.mana += 2;
        j.maxMana += 2;
        this.manaUm = 3;
        this.manaEsp = 5;
        this.ataqueUm = "Raio Congelante";
        this.ataqueEspecial = "Meteoro";
        j.somaDano = 3;
        if(j.gender == 1){
            this.nomeClasse = "mago";
            this.pluralClasse = "magos";
        } else {
            this.nomeClasse = "maga";
            this.pluralClasse = "magas";  
        }
    }
    
    @Override
    public void increaseStats(Jogador j) { //esse sim é o método que precisa ser reescrito pra cada classe com valor diferente
            j.maxHP += 2;
            System.out.print("HP: + 2" + "\t");
            System.out.println("HP atual: " + j.HP + "/" + j.maxHP);
            j.maxMana += 3;
            System.out.println("Mana: + 3" + "\t");
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
    public int ataqueEspecial(Jogador j, Dado d){ //4A + somaDano
        int rolagem;
        if(j.mana < manaEsp){
            System.out.println("[SISTEMA]: Mana insuficiente.");
            return 0;
        } else {
            j.mana -= manaEsp;
            rolagem = d.roll(4, j.arma.getPontos());
            System.out.println("Dano causado: " + rolagem + " + " + j.somaDano + " = " + (rolagem + j.somaDano));
            return rolagem + j.somaDano;
        } 
    }
}