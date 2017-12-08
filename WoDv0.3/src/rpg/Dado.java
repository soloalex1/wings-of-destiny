package rpg;

import java.util.Random;

public class Dado {
   private int num; //numero de lados do dado
   private static Dado instance = new Dado(); //instância privada do dado como objeto único (Singleton)
   
   private Dado(){} //construtor padrão privado
   
   public static Dado getDado(){
       return instance;
   }
   
   private void setNum(int num){
       this.num = num;
   }
      
   public int roll(int vezes, int n){
       this.setNum(n);
       System.out.println("[SISTEMA]: Rolando " + vezes + "d" + this.num);
       Random result = new Random();
       int atual; //variável auxiliar para armazenar o valor de cada rolagem
       int total = 0; //pra armazenar o valor da soma das rolagens
       for(int i = 1; i <= vezes; i++){
       atual = (int)((result.nextInt(this.num))) + 1;
       System.out.println("Dado " + i + ": " + atual);
       total += atual;
       }
       
       return total;
   }
}