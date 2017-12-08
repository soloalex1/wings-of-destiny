package rpg;

import java.util.Scanner;
import java.util.ArrayList;

public class Jogador {
        public String nome; //nome do bixim
        public int level; //nível dele
        public int maxHP; //hp máximo e hp atual
        public int HP;
        public int defesa; //defesa (atualmente inútil)
	public int mana; //mana atual e mana máxima
        public int maxMana;
	public Classe classe; //busquem conhecimento - a classe classe está chegando
	public int gender; //did you just assume my gender?
        public int somaDano; //atributo de danos
        private int xp; //xp do maluco
        public Arma arma; //nome autoexplicativo
        ArrayList<Item> inventario; //inventário do maluco
        private final int invConst; //quem souber morre
        
        Jogador(){
            this.level = 1;
            this.maxHP = 20;
            this.HP = 20;
            this.defesa = 1;
            this.mana = 10;
            this.maxMana = 10;
            this.somaDano = 1;
            this.xp = 0;
            invConst = 10;
            inventario = new ArrayList(invConst);
            setGender();
        }
              
        //métodos de gerenciamento de XP e leveling
        public void ganharXP(int xp){
            this.xp += xp; 
            System.out.println("SISTEMA: XP Adquirido: " + xp);
            if(this.xp >= 100){ //setei o xp/level em 100 pra todos os levels, por enquanto
                levelUp(); //se atingir o 100, eu chamo a função de levelUp e faço a diferença
                this.xp -= 100;
            }
    }
        
        private void levelUp(){ //assim que a função é chamada, incrementa o nível e dá um retorno pro jogador
            this.level++;
            System.out.println("[SISTEMA]: Subiu de nivel! Nivel atual: " + this.level);
            this.somaDano++;
            classe.increaseStats(this);  //aqui ela chama o método abstrato reescrito
        }
        
        //métodos de gerenciamento de itens e do inventário        
        public void insereItem(Item i){
            this.inventario.add(i);
            System.out.println(i.getNome() + " adicionado ao inventário!");
        }
        
        public void mostraInventario(){
            System.out.println("--- INVENTÁRIO ---");
            for(int p = 0; p < inventario.size(); p++){
                if(inventario.get(p) != null){
                System.out.println("[" + (p + 1) + "] " + inventario.get(p).getNome());
            } else {
                System.out.println("[" + (p + 1) + "] -- vazio --");    
                }
            }
        }
         
        public void consomeItem(Item i){
            if(this.inventario.contains(i)){
                i.usar(this);
                this.inventario.remove(i);
                this.inventario.add(null); //pra manter o tamanho do arraylist
            }
        }
        
        public void setGender(){ //por favor
            Scanner scan = new Scanner(System.in);
            System.out.println("[SISTEMA]: Antes de começar, escolha o gênero do seu personagem:");
            System.out.print("[Z] Masculino" + "\t");
            System.out.println("[X] Feminino");
            char ch = scan.next().charAt(0);
            switch(ch){
                case 'z':
                    this.gender = 1;
                    break;
                case 'x':
                    this.gender = 0;
                    break;
                case 'Z':
                    this.gender = 1;
                    break;
                case 'X':
                    this.gender = 0;
                    break;
                default:
                System.out.println("[SISTEMA]: Use as teclas indicadas para responder.");
                setGender();
            }
        }
        	
	public void setName(){
        System.out.println("[...]");
        Scanner scan = new Scanner(System.in);
	System.out.println("[Velho]: Ah, você acordou. Cheguei a achar que tivesse morrido.");
        System.out.println("Não, não levante ainda. Descanse. Vai fazer bem.");
        System.out.println("[...]");
        System.out.println("Consegue falar? Qual é o seu nome?");
        String n = scan.nextLine();
        if(n == null || n.trim().isEmpty()){
            System.out.println("[SISTEMA]: Nome vazio.");
            System.out.println("[Velho]: Vejo que não está em condições de conversar, mas não tem problema. Volte a dormir.");
            System.out.println("[...]");
            setName();
        }
	System.out.println("Então seu nome é " + n +"?");
	System.out.print("[Z] SIM" + "\t");
	System.out.println("[X] NÃO");
            char ch = scan.next().charAt(0);
            if(ch == 'z' || ch == 'Z') {
                this.nome = n;
                System.out.println("Bem, " + this.nome + ", pelo menos você não perdeu a memória.");
            } else if (ch == 'x' || ch == 'X') {
                System.out.println("[Velho]: Vejo que não está em condições de conversar, mas não tem problema. Volte a dormir.");
                System.out.println("[...]");
                setName();
            } else {
                System.out.println("[SISTEMA]: Use as teclas indicadas para escolher.");
                System.out.println("Vejo que não está em condições de conversar, mas não tem problema. Volte a dormir.");
                System.out.println("[...]");
                setName();
            }
    }
	
	public void setClass() {
            Scanner scan = new Scanner(System.in);
            if(this.gender == 0){
                System.out.println("[Velho]: Você esteve bem perto da morte, moça. Meu nome é Rudolph.");
                System.out.println("[Rudolph]: Seja lá o que for que aconteceu, já passou. Encontrei você boiando no riacho aqui perto, coberta de sangue.");
                System.out.println("Aparentemente você foi trazida com a correnteza. Mas esse riacho vem das Montanhas Azuis, e são várias milhas de lá até aqui.");
            } else {
                System.out.println("[Velho]: Você esteve bem perto da morte, filho. Meu nome é Rudolph.");
                System.out.println("[Rudolph]: Seja lá o que for que aconteceu, já passou. Encontrei você boiando no riacho aqui perto, coberto de sangue.");
                System.out.println("Aparentemente você foi trazido com a correnteza. Mas esse riacho vem das Montanhas Azuis, e são várias milhas de lá até aqui.");
            }
            System.out.println("Quer me contar um pouco mais? O que você faz da vida?");
            if(this.gender == 1) {
                System.out.print("[1] Sou um guerreiro." + "\t");
                System.out.println("[2] Sou um mago.");
                System.out.print("[3] Sou um arqueiro." + "\t");
                System.out.println("[4] Sou um clérigo.");
                int job = scan.nextInt();
                switch(job) {
                default:
                    System.out.println("Quer um tempo pra se recuperar antes de falar?");
                case (1):
                    this.classe = new Guerreiro(this);
                    this.arma = new Arma("ESPADA DO SOLDADO REAL", 6, 1);
                    System.out.println("Ah, um guerreiro! Eu imaginei quando vi sua espada, mas não gosto de tirar conclusões precipitadas.");
                    System.out.println("Não se preocupe, sua espada está embaixo da cama. Estava molhada, então coloquei aí pra secar.");
                    break;
                case (2):
                    this.classe = new Mago(this);
                    this.arma = new Arma("CAJADO DE CARVALHO", 6, 2);
                    System.out.println("Ah, um mago! Eu imaginei quando vi seu cajado, mas não gosto de tirar conclusões precipitadas.");
                    System.out.println("Não se preocupe, seu cajado está embaixo da cama. Estava molhado, então coloquei aí pra secar.");
                    break;
                case (3):
                    this.classe = new Arqueiro(this);
                    this.arma = new Arma("ARCO DO PATRULHEIRO", 6, 4);
                    System.out.println("Ah, um arqueiro! Eu imaginei quando vi seu arco, mas não gosto de tirar conclusões precipitadas.");
                    System.out.println("Não se preocupe, suas flechas estão embaixo da cama. Estavam molhadas, então coloquei aí pra secar.");
                    break;
                case (4):
                    this.classe = new Clerigo(this);
                    this.arma = new Arma("CLAVA DOS ELUNITAS", 6, 3);
                    System.out.println("Ah, um clérigo! Eu imaginei quando vi seu porrete, mas não gosto de tirar conclusões precipitadas.");
                    System.out.println("Não se preocupe, sua clava está embaixo da cama. Estava molhada, então coloquei aí pra secar.");
                    break;
                    }
            } else {
                System.out.print("[1] Sou uma guerreira." + "\t");
                System.out.println("[2] Sou uma maga.");
                System.out.print("[3] Sou uma arqueira." + "\t");
                System.out.println("[4] Sou uma clériga.");
                int job = scan.nextInt();
                switch(job) {
                default:
                    System.out.println("Quer um tempo pra se recuperar antes de falar?");
                case (1):
                    this.classe = new Guerreiro(this);
                    this.arma = new Arma("ESPADA DO SOLDADO REAL", 6, 1);
                    System.out.println("Ah, uma guerreira! Eu imaginei quando vi sua espada, mas não gosto de tirar conclusões precipitadas.");
                    System.out.println("Não se preocupe, sua espada está embaixo da cama. Estava molhada, então coloquei aí pra secar.");
                    break;
                case (2):
                    this.classe = new Mago(this);
                    this.arma = new Arma("CAJADO DE CARVALHO", 6, 2);
                    System.out.println("Ah, uma maga! Eu imaginei quando vi seu cajado, mas não gosto de tirar conclusões precipitadas.");
                    System.out.println("Não se preocupe, seu cajado está embaixo da cama. Estava molhado, então coloquei aí pra secar.");
                    break;
                case (3):
                    this.classe = new Arqueiro(this);
                    this.arma = new Arma("ARCO DO PATRULHEIRO", 6, 4);
                    System.out.println("Ah, uma arqueira! Eu imaginei quando vi seu arco, mas não gosto de tirar conclusões precipitadas.");
                    System.out.println("Não se preocupe, suas flechas estão embaixo da cama. Estavam molhadas, então coloquei aí pra secar.");
                    break;
                case (4):
                    this.classe = new Clerigo(this);
                    this.arma = new Arma("CLAVA DOS ELUNITAS", 6, 3);
                    System.out.println("Ah, uma clériga! Eu imaginei quando vi seu porrete, mas não gosto de tirar conclusões precipitadas.");
                    System.out.println("Não se preocupe, sua clava está embaixo da cama. Estava molhada, então coloquei aí pra secar.");
                    break;
                }
            }
        }
        
        public void stats(){
            System.out.println("STATUS:");
            System.out.println("- " + this.nome + " -" + "\t");
            System.out.println("HP: " + this.HP + "/" + this.maxHP + "\t");
            System.out.println("Mana: " + this.mana + "/" + this.maxMana);
        }
    }