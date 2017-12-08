package rpg;

import java.util.Scanner;

abstract class Classe { //classe do personagem
        
        public String nomeClasse;
        public String pluralClasse;
        public String ataqueUm;
        public String ataqueEspecial;
        public int manaUm;
        public int manaEsp;
    
        Classe(){  
        }
        
        public abstract void increaseStats(Jogador j);
        public abstract int ataqueUm(Jogador j, Dado d);
        public abstract int ataqueEspecial(Jogador j, Dado d);
}
