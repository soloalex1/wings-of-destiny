package rpg;

public class Monstro {
    
    public String nome;
    public int level;
    protected int HP;
    protected int maxHP;
    protected int defesa;
    protected int exp;
    protected String ataqueUm;
    protected String ataqueDois;
    protected int dano;
    
    Monstro(){}
    
    public int getExp(){
        return this.exp;
    }
    
    public String getAtaqueUm(){
        return this.ataqueUm;
    }
    
    public String getAtaqueDois(){
        return this.ataqueDois;
    }
    
    public int getHP(){
        return this.HP;
    }
    
    public int getDefesa(){
        return this.defesa;
    }
    
    public int rollUm(Dado d){
        return d.roll(1, dano);
    }
    
    public int rollDois(Dado d){
        return d.roll(2, dano);
    }
    
}