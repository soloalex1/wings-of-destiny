package rpg;

public class ItemFactory {
    
    public Item getPotion(String pot){
        if(pot == null){
            return null;
        }
        if(pot.equalsIgnoreCase("BASIC MANA POTION")){
            return new Potion("Poção de Mana", 5, 1);
        }
        if(pot.equalsIgnoreCase("BASIC HP POTION")){
            return new Potion("Poção de HP", 5, 2);
        }
        if(pot.equalsIgnoreCase("LARGE MANA POTION")){
            return new Potion("Poção de Mana Grande", 10, 1);
        }
        if(pot.equalsIgnoreCase("LARGE HP POTION")){
            return new Potion("Poção de HP Grande", 10, 2);
        }
        return null;
    }
    
    public Item getArma(String n){
        if(n == null){
            return null;
        }
        if(n.equalsIgnoreCase("ESPADA DO SOLDADO REAL")){
            return new Arma("Espada do Soldado Real", 6, 1);
        }
        if(n.equalsIgnoreCase("ESPADA LONGA")){
            return new Arma("Espada Longa", 8, 1);
        }
        if(n.equalsIgnoreCase("MACHADO DO CARRASCO")){
            return new Arma("Machado do Carrasco", 8, 1);
        }
        if(n.equalsIgnoreCase("CAJADO DE CARVALHO")){
            return new Arma("Cajado de Carvalho", 6, 2);
        }
        if(n.equalsIgnoreCase("CAJADO DO ANJO NEGRO")){
            return new Arma("Cajado do Anjo Negro", 8, 2);            
        }
        if(n.equalsIgnoreCase("VARINHA DE KUSKAARD")){
            return new Arma("Varinha de Kuskaard", 8, 2); 
        }
        if(n.equalsIgnoreCase("ARCO DO PATRULHEIRO")){
            return new Arma("Arco do Patrulheiro", 6, 3);
        }
        if(n.equalsIgnoreCase("ARCO ESTELAR")){
            return new Arma("Arco Estelar", 8, 3); 
        }
        if(n.equalsIgnoreCase("BESTA DA GUARDA REAL")){
            return new Arma("Besta da Guarda Real", 8, 3); 
        }
        if(n.equalsIgnoreCase("CLAVA DOS ELUNITAS")){
            return new Arma("Clava dos Elunitas", 6, 4);
        }
        if(n.equalsIgnoreCase("MARTELO DO INQUISIDOR")){
            return new Arma("Martelo do Inquisidor", 8, 4); 
        }
        if(n.equalsIgnoreCase("CLAVA CELESTIAL")){
            return new Arma("Clava Celestial", 8, 4); 
        }
        return null;
    }
}