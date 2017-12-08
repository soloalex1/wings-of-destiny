package rpg;

public interface Item { 
    
    /*fiz como classe abstrata pra poder colocar o método setPontos como privado,
    e também pra poder colocar o nome logo aqui */
    
    public String getNome();
    public int getPontos();
    abstract void setPontos(int p);
    abstract void usar(Jogador j);
}