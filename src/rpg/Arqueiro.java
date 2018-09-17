package rpg;

public class Arqueiro extends Classe {
    
    Arqueiro(Jogador j){
        j.HP += 1;
        j.maxHP += 1;
        j.mana += 1;
        j.maxMana += 1;
        this.manaUm = 2;
        this.manaEsp = 4;
        this.ataqueUm = "Tiro Certeiro";
        this.ataqueEspecial = "Chuva de Flechas";
        j.somaDano = 3;
        if(j.gender == 1){
            this.nomeClasse = "arqueiro";
            this.pluralClasse = "arqueiros";
        } else {
            this.nomeClasse = "arqueira";
            this.pluralClasse = "arqueiras";  
        }
    }
        
    @Override
    public void increaseStats(Jogador j) { //esse sim é o método que precisa ser reescrito pra cada classe com valor diferente
            j.maxHP += 2;
            System.out.print("HP: + 2" + "\t");
            System.out.println("-- HP atual: " + j.HP + "/" + j.maxHP);
            j.maxMana += 1;
            System.out.print("Mana: +1" + "\t");
            System.out.println("-- Mana atual: " + j.mana + "/" + j.maxMana);
        } 
    
    @Override
    public int ataqueUm(Jogador j, Dado d){ //2A + somaDano
        int rolagem;
        if(j.mana < manaUm){
            System.out.println("[SISTEMA]: Mana insuficiente.");
            return 0;
        } else {
            j.mana -= manaUm;
            rolagem = d.roll(2, j.arma.getPontos());
            System.out.println("Dano causado: " + rolagem + " + " + j.somaDano + " = " + (rolagem + j.somaDano));
            return rolagem + j.somaDano;
        } 
    }
    
    @Override
    public int ataqueEspecial(Jogador j, Dado d){ //3A + somaDano
        int rolagem;
        if(j.mana < manaEsp){
            System.out.println("[SISTEMA]: Mana insuficiente.");
            return 0;
        } else {
            j.mana -= manaEsp;
            rolagem = d.roll(3, j.arma.getPontos());
            System.out.println("Dano causado: " + rolagem + " + " + j.somaDano + " = " + (rolagem + j.somaDano));
            return rolagem + j.somaDano;
        } 
    }
}