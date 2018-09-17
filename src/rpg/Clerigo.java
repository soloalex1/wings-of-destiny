package rpg;


public class Clerigo extends Classe {
    
    Clerigo(Jogador j){
        this.ataqueUm = "Golpe Sagrado";
        this.ataqueEspecial = "Ascensão Divina";
        j.HP += 1;
        j.maxHP += 1;
        j.mana += 2;
        j.maxMana += 2;
        this.manaUm = 2;
        this.manaEsp = 4;
        j.somaDano = 1;
        if(j.gender == 1){
            this.nomeClasse = "clerigo";
            this.pluralClasse = "clerigos";
        } else {
            this.nomeClasse = "cleriga";
            this.pluralClasse = "clerigas";
        }
    }
    
    @Override
    public void increaseStats(Jogador j) { //esse sim é o método que precisa ser reescrito pra cada classe com valor diferente
            j.maxHP += 2; //incrementa o HP e a mana máxima sem restaurar tudo
            System.out.print("HP: + 2" + "\t");
            System.out.println("HP atual: " + j.HP + "/" + j.maxHP);
            j.maxMana += 2;
            System.out.println("Mana: + 2" + "\t");
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