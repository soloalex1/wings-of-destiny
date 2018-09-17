package rpg;

import java.util.Scanner;
import java.util.Random;

public class Jogo {
    
    private ItemFactory factory = new ItemFactory();
    private Scanner scan = new Scanner(System.in);
    
    private void teclaSistema(){
        System.out.println("[SISTEMA]: Aperte as teclas indicadas para prosseguir.");
    }
    
    private void exibirStatusCombate(Jogador j, Monstro m){
        System.out.print("- " + j.nome + " -" + "\t");
        System.out.println("- " + m.nome + " -");
        System.out.print("HP: " + j.HP + "/" + j.maxHP + "\t");
        System.out.println("HP: " + m.HP + "/" + m.maxHP);
        System.out.println("Mana: " + j.mana + "/" + j.maxMana);
    }
    
    private void mostraInventarioCombate(Jogador j){ //tem um jeito melhor de fazer isso, eu sei
        System.out.println("--- INVENTÁRIO ---");
        for(int i = 0; i < j.inventario.size(); i++){
            System.out.println("[" + i + "]" + j.inventario.get(i).getNome());
        }
        int select = scan.nextInt();
        switch(select){ 
            default:
                System.out.println("[SISTEMA]: Digite o número correspondente ao item escolhido.");
                mostraInventarioCombate(j);
            case 0:
                j.consomeItem(j.inventario.get(0));
                break;
            case 1:
                j.consomeItem(j.inventario.get(1));
                break;
            case 2:
                j.consomeItem(j.inventario.get(2));
                break;
            case 3:
                j.consomeItem(j.inventario.get(3));
                break;
            case 4:
                j.consomeItem(j.inventario.get(4));
                break;
            case 5:
                j.consomeItem(j.inventario.get(5));
                break;
            case 6:
                j.consomeItem(j.inventario.get(6));
                break;
            case 7:
                j.consomeItem(j.inventario.get(7));
                break;
            case 8:
                j.consomeItem(j.inventario.get(8));
                break;
            case 9:
                j.consomeItem(j.inventario.get(9));
                break;
        }
    }
    
    private void enterContinue(){ 
        System.out.println("[SISTEMA]: Aperte a tecla Enter para continuar...");
        try {
            System.in.read();
        } catch(Exception e){
        }  
 }
  
    private void gameStart(Jogador j){
        System.out.println();
        System.out.println("[...]");
        System.out.println("--- Você acorda em uma cabana. Sua visão está meio turva, e você sente uma leve tontura.");
        System.out.println("--- Ao se levantar da cama, você vê um homem ao pé da lareira. Pela janela, você percebe que chove forte lá fora.");
        System.out.println("--- O seu corpo treme de frio, e você se deita entre as cobertas uma vez mais. A perna direita está parcialmente dormente.");
        System.out.println("--- Então você sente a dor. Por baixo das vestes surradas - sujas de sangue, fuligem e suor - você vê as ataduras.");
        System.out.println("--- O homem percebe seu movimento. Ele se vira e vem na sua direção, e você percebe que é um homem mais velho, nos seus quarenta anos.");
        enterContinue();
        j.setName();
    }
    
    private void cabanaP1(Jogador j){ //primeiro diálogo na cabana
        System.out.println("--- Rudolph senta numa cadeira velha, ao lado da janela. Lá fora, a chuva não dá sinais de diminuir.");
        System.out.println("--- Você se sente um pouco melhor com o calor que vem da lareira. Sobre ela, um caldeirão solta uma fumaça que cheira a carne cozida.");
        System.out.println("[...]");
        System.out.println("[Rudolph]: Estou fazendo o jantar. Imagino que esteja com fome, então coma algo.");
        System.out.println("");
        if(j.gender == 1){
            System.out.println("[Z] \"Obrigado. Estou com muita fome. O cheiro está ótimo.\"");
            System.out.println("[X] \"Obrigado, mas estou bem.\"");
            System.out.println("[C] \"Obrigado, mas não quero incomodar. Você já me ajudou muito.\"");
            char ch = scan.next().charAt(0);
            if(ch == 'z' || ch == 'Z'){ //primeiro caso - o jogador aceita a comida
                System.out.println("[Rudolph]: Ah, está mesmo. É cocatriz ao molho, minha especialidade! E já está pronto, veja só!");
                System.out.println("[...]");
                System.out.println("--- Ele se levanta e tira o caldeirão do fogo. Ao remover a tampa, o ar quente se espalha pela cabana e você se sente melhor.");
                System.out.println("--- Rudolph enche um prato e traz até você, ainda na cama. Parece delicioso. Sem pensar duas vezes, você come.");
                System.out.println("--- Quase que imediatamente, você sente todo o seu corpo um pouco mais aquecido, apesar da chuva e do frio. Você consegue se sentar na cama.");
                this.enterContinue();
            } else if(ch == 'x' || ch == 'X'){ //segundo caso - o jogador recusa
                System.out.println("[Rudolph]: Tem certeza disso? Você precisa comer algo pra melhorar logo. Não vai conseguir ir muito longe sem comer.");
                System.out.println("");
                System.out.println("[Z] \"Sim, estou bem. Obrigado. Me perdoe se fui indelicado.\"");
                System.out.println("[X] \"Já que insiste, vou comer um pouco.\""); 
                char ch1 = scan.next().charAt(0);
                if(ch1 == 'z' || ch1 == 'Z'){  //caso alternativo - ele recusa novamente
                    System.out.println("[Rudolph]: Não se preocupe com isso. Fique o quanto quiser. Se não se importa, vou comer um pouco.");
                } else if(ch1 == 'x' || ch1 == 'X'){ //caso alternativo - ele aceita depois da insistência
                    System.out.println("[Rudolph]: Ah, me desculpe por isso. Mas você não vai se arrepender. É cocatriz ao molho, minha especialidade!");
                    System.out.println("E já está pronto, veja só!");
                    System.out.println("[...]");
                    System.out.println("--- Ele se levanta e tira o caldeirão do fogo. Ao remover a tampa, o ar quente se espalha pela cabana e você se sente melhor.");
                    System.out.println("--- Rudolph enche um prato e traz até você, ainda na cama. Parece delicioso. Sem pensar duas vezes, você come.");
                    System.out.println("--- Quase que imediatamente, você sente todo o seu corpo um pouco mais aquecido, apesar da chuva e do frio. Você consegue se sentar na cama.");
                    this.enterContinue();  
                } else { //caso o jogador aperte qualquer outra tecla
                    this.teclaSistema();
                    System.out.println("Você não parece bem. Durma mais um pouco. Quando acordar, estará melhor.");
                    System.out.println("[...]");
                    System.out.println("--- Você adormece uma outra vez, ainda exausto.");
                    this.cabanaP1(j);
                } 
            } else if(ch == 'c' || ch == 'C'){ //terceiro caso - o jogador não quer incomodar
                System.out.println("[Rudolph]: Não ligue pra isso. É bom ter alguém pra conversar, e você parece ter passado por poucas e boas.");
                System.out.println("[Rudolph]: Tem certeza disso? Você precisa comer algo pra melhorar logo. Não vai conseguir ir muito longe sem comer.");
                System.out.println("[Z] \"Sim, estou bem, obrigado. Sou grato por seus cuidados.\"");
                System.out.println("[X] \"Já que insiste, vou comer um pouco.\"");
                char ch2 = scan.next().charAt(0);
                if(ch2 == 'z' || ch2 == 'Z'){ //caso alternativo - ele recusa novamente
                    System.out.println("[Rudolph]: Não se preocupe com isso. Fique o quanto quiser. Se não se importa, vou comer um pouco.");
                } else if(ch2 == 'x' || ch2 == 'X'){ //caso alternativo - ele aceita depois da insistência
                    System.out.println("[Rudolph]: Ah, me desculpe por isso. Mas você não vai se arrepender. É cocatriz ao molho, minha especialidade! E já está pronto, veja só!");
                    System.out.println("[...]");
                    System.out.println("--- Ele se levanta e tira o caldeirão do fogo. Ao remover a tampa, o ar quente se espalha pela cabana e você se sente melhor.");
                    System.out.println("--- Rudolph enche um prato e traz até você, ainda na cama. Parece delicioso. Sem pensar duas vezes, você come.");
                    System.out.println("--- Quase que imediatamente, você sente todo o seu corpo um pouco mais aquecido, apesar da chuva e do frio. Você consegue se sentar na cama.");
                    this.enterContinue();
                } else { //caso o jogador aperte qualquer outra tecla
                    this.teclaSistema();
                    System.out.println("Você não parece bem. Durma mais um pouco. Quando acordar, estará melhor.");
                    System.out.println("[...]");
                    System.out.println("--- Você adormece uma outra vez, ainda exausto.");
                    this.cabanaP1(j);
                }  
            }
        } else {
            System.out.println("[Z] \"Obrigada. Estou com muita fome. O cheiro está ótimo.\"");
            System.out.println("[X] \"Obrigada, mas estou bem.\"");
            System.out.println("[C] \"Obrigada, mas não quero incomodar. Você já me ajudou muito.\"");
            char ch = scan.next().charAt(0);
            if(ch == 'z' || ch == 'Z'){ //primeiro caso - o jogador aceita a comida
                System.out.println("[Rudolph]: Ah, está mesmo. É cocatriz ao molho, minha especialidade! E já está pronto, veja só!");
                System.out.println("[...]");
                System.out.println("--- Ele se levanta e tira o caldeirão do fogo. Ao remover a tampa, o ar quente se espalha pela cabana e você se sente melhor.");
                System.out.println("--- Rudolph enche um prato e traz até você, ainda na cama. Parece delicioso. Sem pensar duas vezes, você come.");
                System.out.println("--- Quase que imediatamente, você sente todo o seu corpo um pouco mais aquecido, apesar da chuva e do frio. Você consegue se sentar na cama.");
                this.enterContinue();
            } else if(ch == 'x' || ch == 'X'){ //segundo caso - o jogador recusa
                System.out.println("[Rudolph]: Tem certeza disso? Você precisa comer algo pra melhorar logo. Não vai conseguir ir muito longe sem comer.");
                System.out.println("[Z] \"Sim, estou bem. Obrigada. Me perdoe se fui indelicada.\"");
                System.out.println("[X] \"Já que insiste, vou comer um pouco.\""); 
                char ch1 = scan.next().charAt(0);
                if(ch1 == 'z' || ch1 == 'Z'){  //caso alternativo - ele recusa novamente
                    System.out.println("[Rudolph]: Não se preocupe com isso. Fique o quanto quiser. Se não se importa, vou comer um pouco.");
                } else if(ch1 == 'x' || ch1 == 'X'){ //caso alternativo - ele aceita depois da insistência
                    System.out.println("[Rudolph]: Ah, me desculpe por isso. Mas você não vai se arrepender. É cocatriz ao molho, minha especialidade! E já está pronto, veja só!");
                    System.out.println();
                    System.out.println("[...]");
                    System.out.println("--- Ele se levanta e tira o caldeirão do fogo. Ao remover a tampa, o ar quente se espalha pela cabana e você se sente melhor.");
                    System.out.println("--- Rudolph enche um prato e traz até você, ainda na cama. Parece delicioso. Sem pensar duas vezes, você come.");
                    System.out.println("--- Quase que imediatamente, você sente todo o seu corpo um pouco mais aquecido, apesar da chuva e do frio. Você consegue se sentar na cama.");
                    this.enterContinue();  
                } else { //caso o jogador aperte qualquer outra tecla
                    this.teclaSistema();
                    System.out.println("Você não parece bem. Durma mais um pouco. Quando acordar, estará melhor.");
                    System.out.println("[...]");
                    System.out.println("--- Você adormece uma outra vez, ainda exausto.");
                    this.cabanaP1(j);
                } 
            } else if(ch == 'c' || ch == 'C'){ //terceiro caso - o jogador não quer incomodar
                System.out.println("[Rudolph]: Não ligue pra isso. É bom ter alguém pra conversar, e você parece ter passado por poucas e boas.");
                System.out.println("[Rudolph]: Tem certeza disso? Você precisa comer algo pra melhorar logo. Não vai conseguir ir muito longe sem comer.");
                System.out.println("[Z] \"Sim, estou bem. Obrigada. Sou grata por seus cuidados.\"");
                System.out.println("[X] \"Já que insiste, vou comer um pouco.\"");
                char ch2 = scan.next().charAt(0);
                if(ch2 == 'z' || ch2 == 'Z'){ //caso alternativo - ele recusa novamente
                    System.out.println("[Rudolph]: Não se preocupe com isso. Fique o quanto quiser. Se não se importa, vou comer um pouco.");
                } else if(ch2 == 'x' || ch2 == 'X'){ //caso alternativo - ele aceita depois da insistência
                    System.out.println("[Rudolph]: Ah, me desculpe por isso. Mas você não vai se arrepender. É cocatriz ao molho, minha especialidade! E já está pronto, veja só!");
                    System.out.println("[...]");
                    System.out.println("--- Ele se levanta e tira o caldeirão do fogo. Ao remover a tampa, o ar quente se espalha pela cabana e você se sente melhor.");
                    System.out.println("--- Rudolph enche um prato e traz até você, ainda na cama. Parece delicioso. Sem pensar duas vezes, você come.");
                    System.out.println("--- Quase que imediatamente, você sente todo o seu corpo um pouco mais aquecido, apesar da chuva e do frio. Você consegue se sentar na cama.");
                    this.enterContinue();
                } else { //caso o jogador aperte qualquer outra tecla
                    this.teclaSistema();
                    System.out.println("Você não parece bem. Durma mais um pouco. Quando acordar, estará melhor.");
                    System.out.println("[...]");
                    System.out.println("--- Você adormece uma outra vez, ainda exausto.");
                    this.cabanaP1(j);
                }  
            }
        }
    }
    
    private void cabanaP2(Jogador j, Dado d){
        System.out.println("");
        System.out.println("[...]");
        System.out.println("[Rudolph]: Veja só, " + j.nome + ", o tempo está abrindo. Muito em breve você poderá voltar pra sua casa.");
        System.out.println("--- Ao olhar, pela janela, você percebe que a chuva está diminuindo. Mas também se dá conta de que não lembra de ter uma casa.");
        System.out.println("--- Rudolph percebe uma mudança na sua expressão, e fala em voz baixa:");
        System.out.println("[Rudolph]: Seus amigos devem estar procurando por você. Se precisar, posso lhe dar um pouco mais de cocatriz para a viagem.");
        System.out.println("");
        System.out.println("[Z] \"Não será necessário. Posso me virar na floresta.\"");
        System.out.println("[X] \"Aceito seu presente.\"");
        char ch = scan.next().charAt(0);
        switch (ch) {
            case 'z':
            case 'Z':
                System.out.println("[Rudolph]: Oh, como quiser, então. Mas leve um pouco de água, coloquei um cantil aí na cabeceira da cama.");
                System.out.println("[Rudolph]: Pode pegar suas coisas aí embaixo da cama enquanto eu arrumo a mesa.");
                break;
            case 'x':
            case 'X':
                System.out.println("[Rudolph]: Parece que você gostou mesmo. Vou pegar um dos meus potes. Beba um pouco de água.");
                System.out.println("[Rudolph]: Pode pegar suas coisas aí embaixo da cama enquanto eu preparo tudo.");
                Potion cocatriz = new Potion("Cocatriz ao Molho", 10, 2);
                j.inventario.add(cocatriz);
                break;
            default:
                teclaSistema();
                break;
        }
        enterContinue();
        System.out.println("[...]");
        System.out.println("--- Subitamente, o céu escurece, e o som do bater de asas enormes rasga os ventos da floresta.");
        System.out.println("--- O vento forte começa a levar algumas tábuas do assoalho da cabana. O telhado é completamente arrancado.");
        System.out.println("--- Você se segura na janela, mas ela também quebra com o vendaval. Rudolph é jogado violentamente contra a lareira.");
        System.out.println("--- Ao seu redor, a cabana começa a desabar.");
        if(j.gender == 1){
            System.out.println("--- Seu corpo se choca contra a parede oposta, atravessando-a. Ao ser jogado pra fora da cabana, seu corpo fica pesado.");
        } else {
            System.out.println("--- Seu corpo se choca contra a parede oposta, atravessando-a. Ao ser jogada pra fora da cabana, seu corpo fica pesado.");
        }
        enterContinue();
        System.out.println("--- Quando o vento diminui e você consegue se levantar, os escombros da cabana estão espalhados pelo descampado ao seu redor.");
        System.out.println("--- Nem mesmo a lareira, feita de tijolos, resistiu à força dos ventos.");
        System.out.println("--- Alguns metros adiante, você encontra sua arma.");
        j.inventario.add(j.arma);
        Arma amuleto = new Arma("Amuleto Brilhante", 0, 5);
        System.out.println("--- O corpo de Rudolph está sob os escombros, e você vê alguma coisa brilhando nos destroços próximos a ele.");
        System.out.println("");
        System.out.println("[Z] \"Deve ser algo valioso. Vou pegar, já que ele não vai mais precisar.\"");
        System.out.println("[X] \"Não vou roubar um homem que me ajudou em vida.\"");
        System.out.println("[C] \"Vou levar e manter em segurança. Saqueadores podem vir atacar os escombros.\"");
        char ch1 = scan.next().charAt(0);
        switch (ch) {
            case 'z':
            case 'Z':
                System.out.println("--- Você mexe no entulho e encontra um amuleto. Há algumas runas gravadas nele, emitindo uma fraca luz azulada.");
                j.inventario.add(amuleto);
                break;
            case 'x':
            case 'X':
                System.out.println("--- Você vira as costas e vai embora. Mas... de onde veio aquela coisa?");  
                break;
            case 'c':
            case 'C':
                System.out.println("--- Você mexe no entulho e encontra um amuleto. Ele emite uma fraca luz azulada, então você o enrola em suas vestes e mantém ele escondido.");
                j.inventario.add(amuleto);
                break;
            default:
                teclaSistema();
                break;
        }
        System.out.println("--- O vento veio da direção da floresta. Há um riacho entre você e a floresta, e nenhum sinal de vida por perto.");
        System.out.println("");
        System.out.println("[Z] \"Vou seguir naquela direção. Talvez seja a única maneira de conseguir respostas.\"");
        System.out.println("[X] \"Rudolph disse que eu fui trazido com a correnteza. A criatura não me diz respeito. Preciso saber o que aconteceu comigo.\"");
        System.out.println("[C] \"Seja lá o que tenha acontecido, vou pra longe daquele demônio gigante voador. Vou para a cidade, ver o que consigo por lá.\"");
        char ch2 = scan.next().charAt(0);
        switch(ch2){
            default:
                teclaSistema();
                break;
            case 'z':
            case 'Z':
                System.out.println("--- Você atravessa o riacho a pé, e ainda com as vestes molhadas, entra na floresta.");
                enterContinue();
                System.out.println("");
                this.caminhoFloresta(j, d);
                break;
            case 'x':
            case 'X':
                System.out.println("--- Você ajeita a mochila nas costas e começa a seguir, acompanhando o rio. As Montanhas Azuis são sombras através do nevoeiro a nordeste.");
                System.out.println("");
                this.caminhoRio(j, d);
                break;
            case 'c':
            case 'C':
                System.out.println("--- Virando as costas para a floresta e as montanhas, você toma a direção da estrada de terra que pode ser vista mais adiante.");
        }
        System.out.println("");
    }
    
    private void ganhaPot1(Jogador j){
        for(int i = 0; i < j.inventario.size(); i++){
            if(j.inventario.get(i).getNome().equalsIgnoreCase("COCATRIZ AO MOLHO")){
                System.out.println("--- O que é estranho, pois você não lembra de ter colocado nada lá além da comida de Rudolph.");
            } 
        }
        System.out.println("--- O que é estranho, pois você não lembra de ter colocado nada lá.");
        System.out.println("--- Ao abrir a mochila, você encontra dois frascos arredondados, contendo duas bebidas nas cores vermelha e azul, respectivamente.");
        System.out.println("--- Imediatamente você as identifica como poções de vitalidade e mana.");
        enterContinue();
        Item manaPot = factory.getPotion("BASIC MANA POTION");
        j.insereItem(manaPot);
        Item lifePot = factory.getPotion("BASIC HP POTION");
        j.insereItem(lifePot);
        enterContinue();
    }
    
    private void caminhoFloresta(Jogador j, Dado d){
        int dir = 0;
        System.out.println("--- Com algum tempo de caminhada floresta adentro, você percebe que alguma coisa está na sua mochila...");
        ganhaPot1(j);
        System.out.println("--- Você ouve alguns ruídos mais adiante. Parecem grunhidos de goblins, mas você não tem certeza.");
        System.out.println("");
        System.out.println("[Z] Aproximar-se cuidadosamente");
        System.out.println("[X] Esconder-se");
        System.out.println("[C] Mudar de direção");
        System.out.println("[V] Olhar ao redor");
        char ch = scan.next().charAt(0);
        switch (ch) {
            case 'z': //aproximar cuidadosamente
            case 'Z':
                System.out.println("--- Ao se esgueirar por entre alguns arbustos, você consegue se aproximar silenciosamente.");
                System.out.println("--- Os ruídos parecem mais próximos. Você tem certeza que é um goblin, mas não consegue se lembrar como aprendeu isso.");
                System.out.println("--- O goblin se aproxima da posição na qual você estava quando o ouviu. É um goblin comum, com duas adagas de ossos.");
                System.out.println("--- Ele começa a farejar. Aparentemente, ele sentiu o seu cheiro antes de você conseguir ouvi-lo.");
                enterContinue();
                System.out.println("--- O goblin está parado a alguns metros de você. Ele não sabe que você está no arbusto, mas está se aproximando pelo seu cheiro.");
                System.out.println("");
                System.out.println("[Z] Atacar");
                System.out.println("[X] Fugir");
                ch = scan.next().charAt(0);
                if(ch == 'z' || ch == 'Z'){ //atacar depois de aproximar
                    System.out.println("--- Você investe na direção do goblin, e ele se assusta com seu ataque repentino.");
                    enterContinue();
                    Goblin g1 = new Goblin();
                    this.batalha(j, g1, d);
                } else if(ch == 'x' || ch == 'X'){ //fugir depois de aproximar
                    System.out.println("--- Você respira fundo e levanta rapidamente, correndo na direção que você seguia antes disso acontecer.");
                    System.out.println("--- Alguns instantes depois, um urro lhe dá a certeza de que o goblin está perseguindo você.");
                    System.out.println("--- Para alguém que estava acamado algumas horas atrás, você está se saindo muito bem. O goblin começa a ser deixado para trás.");
                    System.out.println("--- Alguns metros adiante, a floresta começa a abrir. Você sente o vento contra o seu rosto e percebe um rio caudaloso.");
                    enterContinue();
                    System.out.println("");
                    System.out.println("[Z] Tentar pular por sobre o rio");
                    System.out.println("[X] Pular no rio");
                    ch = scan.next().charAt(0);
                    if(ch == 'z' || ch == 'Z'){ //pular depois de fugir depois de aproximar
                        System.out.println("--- Você pula por sobre o rio. Para sua surpresa, você aterrissa na outra margem sem nenhum problema.");
                        if(j.gender == 1){
                        System.out.println("--- Suas memórias não estão completamente nítidas, mas você começa a acreditar que não é um simples " + j.classe.nomeClasse + ".");
                    } else {
                        System.out.println("--- Suas memórias não estão completamente nítidas, mas você começa a acreditar que não é uma simples " + j.classe.nomeClasse + ".");
                    }
                    } else if(ch == 'x' || ch == 'X'){ //mergulhar depois de fugir depois de aproximar
                        if(j.gender == 1){
                        System.out.println("--- Você pula no rio. O impacto na água deixa você tonto por alguns segundos, mas logo você emerge e consegue nadar até a margem oposta.");
                        } else {
                        System.out.println("--- Você pula no rio. O impacto na água deixa você tonta por alguns segundos, mas logo você emerge e consegue nadar até a margem oposta.");    
                        }
                        System.out.println("--- Da outra margem, é possível ver o goblin rosnando na sua direção. Ele joga algumas adagas, mas nenhuma chega até você.");
                        System.out.println("--- Com esse perigo deixado pra trás, você sacode as suas vestes e prossegue. Aparentemente, esse rio é o mesmo riacho que passava perto da cabana.");
                        enterContinue();
                    } else { //nenhuma nas opções do rio
                        teclaSistema();
                    }
                } else { //nenhuma nas opções de aproximar
                    teclaSistema();
                }
                break;
            case 'x': //esconder
            case 'X':
                System.out.println("--- Você se esconde atrás de um arbusto próximo, e os sons parecem estar se aproximando.");
                System.out.println("--- O goblin se aproxima da posição na qual você estava quando o ouviu. É um goblin comum, com duas adagas de ossos.");
                System.out.println("--- Ele começa a farejar. Aparentemente, ele sentiu o seu cheiro antes de você conseguir ouvi-lo.");
                enterContinue();
                System.out.println("--- O goblin encontra você. Ele dá um grunhido bem mais alto - está chamando os outros.");
                System.out.println("[Z] Atacá-lo antes que ele consiga companhia");
                System.out.println("[X] Correr e tentar despistá-lo - e todos os outros");
                ch = scan.next().charAt(0);
                if(ch == 'z'|| ch == 'Z'){ //atacar depois de esconder
                    System.out.println("--- Antes que ele possa gritar mais, você empurra o goblin numa árvore próxima. Ele saca as adagas e parte pro combate.");
                    System.out.println("");
                    Goblin g1 = new Goblin();
                    batalha(j, g1, d);
                    enterContinue();
                    System.out.println("");
                    System.out.println("--- O goblin cai morto no chão, mas você ouve alguns outros grunhidos ao longe e decide prosseguir correndo.");
                    System.out.println("");
                } else if(ch == 'x' || ch == 'X'){ //fugir depois de esconder
                    System.out.println("--- Você empurra o goblin no chão e sai correndo pro outro lado. Ele se levanta e começa a correr atrás de você.");
                } else { //nenhuma das opções de esconder
                    teclaSistema();
                }
                break;
            case 'c': //mudar de direção
            case 'C':
                System.out.println("");
                System.out.println("--- Para qual direção você vai?");
                System.out.println("[Z] Continuar em frente (Leste)");
                System.out.println("[X] Seguir pela esquerda (Norte)");
                System.out.println("[C] Seguir pela direita (Sul)");
                ch = scan.next().charAt(0);
                if(ch == 'z' || ch == 'Z'){ //continua em frente
                    dir = 0;
                    System.out.println("--- Você continua seguindo adiante, mas com o passo mais apressado. Os grunhidos se aproximam um pouco, mas logo ficam para trás.");
                } else if(ch == 'x' || ch == 'X'){ //muda pra esquerda
                    dir = 1;
                    System.out.println("--- Você decide fazer um desvio pelo norte da floresta, para evitar aquela área com goblins. Nessas condições é bom evitar lutas.");
                    System.out.println("--- Além disso, como você começa a lembrar, a estrada principal fica ao norte dali, o que significa que você pode encontrar estalagens.");
                } else if(ch == 'c' || ch == 'C'){ //muda pra direita
                    dir = 2;
                    System.out.println("--- Você decide fazer um desvio pelo sul da floresta, para evitar a área com goblins. Nessas condições é melhor evitar lutas.");
                    System.out.println("--- Além disso, como você começa a lembrar, a estrada principal fica ao norte dali, o que significa que você pode ir pelo sul sem ser visto.");
                } else {
                    teclaSistema();
            }
                enterContinue(); //mudando de direção
                System.out.println("");
                System.out.println("--- Ao mudar de direção, você sente que o goblin percebeu você. Grunhidos mais altos vêm da direção dos primeiros ruídos, e você ouve passos rápidos.");
                System.out.println("--- Você começa a correr, esperando que ele não esteja próximo o suficiente para te alcançar.");
                System.out.println("--- Você ouve um grito bem mais alto - ele está chamando mais goblins.");
                enterContinue();
                System.out.println("--- O goblin está correndo na sua direção, mas você ainda não vê outros goblins. Ele continua gritando.");
                System.out.println("[Z] \"Vou matar esse infeliz antes que ele atraia seus amigos pra cá.\"");
                System.out.println("[X] \"Preciso sair daqui antes que os outros cheguem.\"");
                ch = scan.next().charAt(0);
                if(ch == 'z' || ch == 'Z'){ //atacar depois de mudar de direção
                    System.out.println("--- Você empunha sua arma ainda na corrida, e para de repente, enquanto o goblin avança com velocidade. No susto, ele chega perto demais.");
                    Goblin g1 = new Goblin();
                    batalha(j, g1, d);
                    enterContinue();
                    System.out.println("--- Com o goblin morto, você ouve alguns gritos altos de outros goblins se aproximando. São goblins demais pra matar.");
                    System.out.println("--- Na fuga, você consegue evitar os outros goblins. Você vê algumas adagas fincadas nas árvores - os outros goblins estão atacando.");
                    System.out.println("--- Para alguém que estava acamado algumas horas atrás, você está se saindo muito bem. Os goblins começam a ser deixados para trás.");
                    enterContinue();
                } else if(ch == 'x' || ch == 'X'){ //fugir depois de mudar de direção
                    System.out.println("--- Com as pernas pequenas, o goblin não consegue alcançar você. Você vê algumas adagas fincadas nas árvores - os outros goblins estão atacando.");
                    System.out.println("--- Para alguém que estava acamado algumas horas atrás, você está se saindo muito bem. Os goblins começam a ser deixados para trás.");
                    if(dir == 0){ //se tiver continuado em frente
                        enterContinue();
                    } else if(dir == 1){ //se tiver virado à esquerda
                        System.out.println("--- Os ruídos ficam mais distantes. Você despistou os goblins com sucesso. A floresta começa a ficar menos densa, depois de algum tempo.");
                        System.out.println("--- Cerca de meia hora depois, você chega na estrada principal, mas não há nenhum sinal de vida. Você não consegue ver estalagens próximas.");
                        System.out.println("--- Você decide seguir para leste, na direção das montanhas, mas desta vez pela estrada.");
                        enterContinue();
                    } else if(dir == 2){ //se tiver virado à direita
                        System.out.println("--- Passado algum tempo, você chega no caminho que tinha em mente: a Passagem Reclusa.");
                        System.out.println("--- Esse caminho era largamente utilizado nos grandes dias de Karuel, mas atualmente está abandonado.");
                        System.out.println("--- Logo, é muito utilizado por qualquer pessoa que queira cruzar o território sem ser incomodado.");
                        enterContinue();
                    }
                } else {
                    teclaSistema();
                }
                break;
            case 'v': //batata
            case 'V':
                System.out.println("--- Você para e olha ao redor. Ouvindo mais atentamente, você pode ouvir os grunhidos vindos da sua esquerda.");
                System.out.println("--- Provavelmente é um goblin sozinho, mas eles não costumam andar muito distantes uns dos outros.");
                System.out.println("--- Ele percebe você, parado na clareira. Sacando as duas adagas, ele investe na sua direção.");
                Goblin g1 = new Goblin();
                batalha(j, g1, d);
                enterContinue();
                System.out.println("");
                if(g1.HP <= 0){
                    System.out.println("--- O goblin cai morto no chão e você avança, com cuidado, para não atrair outras criaturas.");
                } else {
                    System.out.println("--- Você foge do goblin: aparentemente lutar não foi uma boa ideia.");
                    System.out.println("--- Com as pernas pequenas, o goblin não consegue alcançar você. Os gritos ficam mais distantes. Você despistou a criatura.");
                }
                System.out.println("[...]");
            default: //nenhuma das opções da floresta
                teclaSistema();
                break;
        }
        System.out.println("--- Algumas horas depois, você se depara com um caminho de pedra: É a passagem inferior do Reino de Karuel, na encosta das Montanhas Azuis.");
        System.out.println("--- Você tem a certeza de que está no caminho certo, e decide descansar em algum lugar das ruínas. Está anoitecendo.");
        System.out.println("[...]");
        enterContinue();
        System.out.println("--- O caminho de pedra dá numa ponte de pedra. Por baixo dela passa uma correnteza tranquila. Deve ser o mesmo rio que passava do lado da cabana.");
        System.out.println("--- Talvez alguém em Karuel saiba o que aconteceu com você. Com esse pensamento em mente, você atravessa a ponte.");
        enterContinue();
    }
    
    private void caminhoRio(Jogador j, Dado d){
        int dir = 0;
        System.out.println("--- Com algumas horas de caminhada junto à margem direita do rio, você percebe que alguma coisa está na sua mochila...");
        ganhaPot1(j);
        System.out.println("--- O rio dobra para a esquerda depois de algum tempo, e você o acompanha numa descida longa. A correnteza se torna um pouco mais forte.");
        System.out.println("--- Na outra margem, você vê alguns goblins. Eles gritam quando percebem a sua presença, e atiram algumas adagas de ossos.");
        System.out.println("--- As adagas caem no rio, dada a distância. Nenhuma chegou perto de atingir você.");
        System.out.println("--- Você segue adiante, enquanto os goblins continuam a fazer ruídos altos.");
        System.out.println("");
        System.out.println("[Z] \"Não preciso parar por causa de dois goblins. Vou continuar.\"");
        System.out.println("[X] \"Se continuarem a gritar, podem chamar goblins nessa margem do rio. Preciso sair daqui. \"");
        System.out.println("[C] \"Será que eu consigo jogar algo neles pra distrair?\"");
        char ch = scan.next().charAt(0);
        switch (ch) {
            case 'z': //ignorar os goblins
            case 'Z':
                System.out.println("--- Você ignora os goblins e prossegue. Os ruídos ficam para trás, e a correnteza fica mais forte à medida que você avança.");
                System.out.println("--- É possível ouvir urros ecoando da floresta. Provavelmente são orcs.");
                System.out.println("--- Ainda que não saiba como aprendeu isso, você sabe que orcs da floresta não atacam a menos que você os incomode");
                System.out.println("--- Os ruídos se mantém na mesma distância, o que significa que ele está se movimentando na mesma direção que você.");
                enterContinue();
                System.out.println("--- Alguns metros adiante, você consegue ver o orc indo até o leito do rio para beber água. Ele parece irritado.");
                System.out.println("");
                System.out.println("[Z] \"É melhor evitar esse orc, estando nessas condições.\"");
                System.out.println("[X] \"Não posso sair da margem, ou corro o risco de me perder na floresta.\"");
                System.out.println("[C] \"Vou atacá-lo enquanto ele não notou a minha presença. É o único jeito de passar.\"");
                ch = scan.next().charAt(0);
                if(ch == 'z' || ch == 'Z'){ //evitar o orc depois de ignorar os goblins
                    System.out.println("--- Você desvia para a direita, entrando numa parte mais fechada da floresta.");
                    System.out.println("--- Depois de andar por cerca de uma meia hora, você se depara com uma parede.");
                    System.out.println("--- A parede de pedra se estende do rio até onde os seus olhos podem ver, em ambas as direções. Possui uns vinte metros de altura.");
                    System.out.println("[Z] Voltar para a margem");
                    System.out.println("[X] Tentar escalar");
                    ch = scan.next().charAt(0);
                    if(ch == 'z' || ch == 'Z'){ //voltar pra margem depois de evitar o orc depois de ignorar os goblins
                        System.out.println("--- Você volta para a margem e vê algumas pedras nas quais pode subir andando. Você sobe sem nenhum problema.");
                    } else if(ch == 'x' || ch == 'X'){ //escalar depois de evitar o orc depois de ignorar os goblins
                        System.out.println("--- Com um pouco de esforço, você consegue escalar a parede, segurando em algumas pedras salientes.");
                    } else {
                        teclaSistema();
                    }
                    enterContinue();
                } else if(ch == 'x' || ch == 'X'){ //continuar na margem depois de ignorar os goblins
                    System.out.println("--- Você respira fundo e continua andando na direção do orc, seguindo a margem do rio.");
                    System.out.println("--- O orc não percebe você até que você chegue bem perto. Em fúria, ele investe contra você.");
                    System.out.println("--- Ao sacar a sua arma, você percebe que ele está com uma ferida enorme no peito, da qual vaza um líquido negro.");
                    enterContinue();
                    Orc o1 = new Orc();
                    batalha(j, o1, d);
                    enterContinue();
                    if(o1.HP <= 0){
                        System.out.println("--- Você dá o golpe de misericórdia no orc e continua sua viagem.");
                    } else {
                        System.out.println("--- Você empurra o orc no rio. Na queda, ele parece piorar o estado da ferida e fica atordoado pela dor.");
                        System.out.println("--- Aproveitando esse tempo, você foge.");
                    }
                    System.out.println("--- Depois de andar por cerca de uma meia hora, você se depara com uma parede.");
                    System.out.println("--- A parede de pedra se estende do rio até onde os seus olhos podem ver, em ambas as direções. Possui uns vinte metros de altura.");
                    System.out.println("--- Contudo, há uma escadaria de pedra bem próxima do leito do rio, e você sobe sem problemas.");
                    enterContinue();
                } else if(ch == 'c' || ch == 'C'){ //atacar o orc depois de ignorar os goblins
                    System.out.println("--- O orc não percebe a sua presença até você estar bem próximo. Em fúria, ele investe contra você.");
                    System.out.println("--- Ao sacar a sua arma, você percebe que ele está com uma ferida enorme no peito, da qual vaza um líquido negro.");
                    enterContinue();
                    Orc o1 = new Orc();
                    batalha(j, o1, d);
                    enterContinue();
                    System.out.println("--- Depois de andar por cerca de uma meia hora, você se depara com uma parede.");
                    System.out.println("--- A parede de pedra se estende do rio até onde os seus olhos podem ver, em ambas as direções. Possui uns vinte metros de altura.");
                    System.out.println("--- Contudo, há uma escadaria de pedra bem próxima do leito do rio, e você sobe sem problemas.");
                    enterContinue();
                } else { //nenhuma das opções do orc e da margem
                    teclaSistema();
                }
            case 'x': //fugir dos gritos
            case 'X':
                if(j.gender == 1){
                    System.out.println("--- Você começa a correr, um pouco mais afastado da margem. O suficiente para se esconder dos goblins.");
                } else {
                    System.out.println("--- Você começa a correr, um pouco mais afastada da margem. O suficiente para se esconder dos goblins.");
                }
                System.out.println("--- Os gritos ficam mais distantes, mas você se depara com um orc ferido. Ele parece seguir na direção do rio.");
                System.out.println("--- Não percebeu a sua presença, talvez por estar urrando em agonia.");
                System.out.println("[Z] \"Não tenho porque me incomodar com esse orc. Preciso sair dessa floresta.\"");
                System.out.println("[X] \"Ele foi chamado pelos goblins pra me matar. Vou atacá-lo antes que me veja.\"");
                ch = scan.next().charAt(0);
                if(ch == 'z'|| ch == 'Z'){ //ignorar o orc depois de fugir dos gritos
                    System.out.println("--- O orc segue o caminho até a margem, e você continua a correr.");
                } else if(ch == 'x' || ch == 'X') {//atacar o orc depois de fugir dos gritos
                    System.out.println("--- Você empunha sua arma e corre atrás do orc. Ele não percebe a sua presença até você chegar bem perto.");
                    Orc o1 = new Orc();
                    batalha(j, o1, d);
                    enterContinue();
                } else { //nenhuma das opções do orc depois de fugir dos gritos
                    teclaSistema();
                }
                System.out.println("");
                System.out.println("--- Depois de andar por cerca de uma meia hora, você se depara com uma parede.");
                System.out.println("--- A parede de pedra se estende do rio até onde os seus olhos podem ver, em ambas as direções. Possui uns vinte metros de altura.");
                System.out.println("[Z] Voltar para a margem");
                System.out.println("[X] Tentar escalar");
                ch = scan.next().charAt(0);
                if(ch == 'z' || ch == 'Z'){ //voltar pra margem depois de evitar o orc depois de ignorar os goblins
                    System.out.println("--- Você volta para a margem e vê algumas pedras nas quais pode subir andando. Você sobe sem nenhum problema.");
                } else if(ch == 'x' || ch == 'X'){ //escalar depois de evitar o orc depois de ignorar os goblins
                    System.out.println("--- Com um pouco de esforço, você consegue escalar a parede, segurando em algumas pedras salientes.");
                } else {
                    teclaSistema();
                }
            case 'c': //jogar algo nos goblins
            case 'C':
                System.out.println("");
                System.out.println("--- Você vê uma pedra bem grande no leito do rio. Ao pegar, você cogita atravessar o rio a pé.");
                System.out.println("--- Porém, talvez seja possível pular para a outra margem e resolver isso pessoalmente.");
                System.out.println("[Z] Jogar a pedra");
                System.out.println("[X] Tentar pular pra outra margem");
                System.out.println("[C] Atravessar o rio a pé");
                ch = scan.next().charAt(0);
                if(ch == 'z' || ch == 'Z'){ //jogar a pedra nos goblins
                    System.out.println("--- Você joga a pedra na cabeça do goblin mais próximo. Nocauteado, ele cai no rio e é levado pela correnteza.");
                    System.out.println("--- O outro goblin se agita e recua. Seus problemas acabaram, por enquanto.");
                    System.out.println("--- Você continua acompanhando a margem do rio tranquilamente.");
                    enterContinue();
                } else if(ch == 'x' || ch == 'X'){ //pular pra outra margem
                    System.out.println("--- Você pula por sobre o rio. Para sua surpresa, você aterrissa na outra margem sem nenhum problema.");
                    if(j.gender == 1){
                        System.out.println("--- Suas memórias não estão completamente nítidas, mas você começa a acreditar que não é um simples " + j.classe.nomeClasse + ".");
                    } else {
                        System.out.println("--- Suas memórias não estão completamente nítidas, mas você começa a acreditar que não é uma simples " + j.classe.nomeClasse + ".");
                    }
                    enterContinue();   
                    System.out.println("");
                    System.out.println("--- Você cai chutando um goblin na cara. Enquanto ele cai, o outro investe contra você.");
                    Goblin g1 = new Goblin();
                    batalha(j, g1, d);
                    enterContinue();
                    if(g1.HP <= 0){
                        System.out.println("--- Você passa por cima do cadáver do primeiro goblin e investe contra o segundo.");
                    } else {
                        System.out.println("--- Você empurra o primeiro goblin no rio e investe contra o segundo.");
                    }
                    Goblin g2 = new Goblin();
                    batalha(j, g2, d);
                    enterContinue();
                    if(g2.HP <= 0){
                        System.out.println("--- O segundo goblin cai morto. Você volta a pé através do rio.");
                    } else {
                        System.out.println("--- Você também joga o segundo goblin no rio. Assim como o anterior, ele é levado pela correnteza.");
                    }
                    System.out.println("--- Depois de andar por cerca de uma meia hora, você se depara com uma parede.");
                    System.out.println("--- A parede de pedra se estende do rio até onde os seus olhos podem ver, em ambas as direções. Possui uns vinte metros de altura.");
                    System.out.println("--- Contudo, há uma escadaria de pedra bem próxima do leito do rio, e você sobe sem problemas.");
                    enterContinue();
                } else if(ch == 'c' || ch == 'C'){ //atravessa o rio a pé depois de parar pros goblins
                    System.out.println("--- Você atravessa o rio a pé, com uma certa dificuldade. O primeiro goblin avança contra você.");
                    System.out.println("");
                    Goblin g1 = new Goblin();
                    batalha(j, g1, d);
                    enterContinue();
                    if(g1.HP <= 0 ){
                        System.out.println("--- Ao derrotar o primeiro goblin, o segundo tenta fugir, mas você o persegue.");
                    } else {
                        System.out.println("--- Você joga o goblin rio abaixo e ele é arrastado pela correnteza.");
                        System.out.println("--- O outro goblin investe contra você.");
                    }
                    Goblin g2 = new Goblin();
                    batalha(j, g2, d);
                    enterContinue();
                    if(g2.HP <= 0){
                        System.out.println("--- Depois de matar os dois goblins, você volta pra outra margem.");
                        System.out.println("--- É melhor estar longe dos corpos caso outros goblins cheguem.");
                    } else {
                        System.out.println("--- Você pega o goblin pela cabeça e joga no rio. Assim como o outro, ele é levado pela correnteza.");
                        System.out.println("--- Depois de se livrar dos dois goblins, você volta pra outra margem.");                        
                    }
                    enterContinue();
                    System.out.println("--- Depois de andar por cerca de uma meia hora, você se depara com uma parede.");
                    System.out.println("--- A parede de pedra se estende do rio até onde os seus olhos podem ver, em ambas as direções. Possui uns vinte metros de altura.");
                    System.out.println("[Z] Voltar para a margem");
                    System.out.println("[X] Tentar escalar");
                    ch = scan.next().charAt(0);
                    if(ch == 'z' || ch == 'Z'){ //voltar pra margem depois de evitar o orc depois de ignorar os goblins
                        System.out.println("--- Você volta para a margem e vê algumas pedras nas quais pode subir andando. Você sobe sem nenhum problema.");
                    } else if(ch == 'x' || ch == 'X'){ //escalar depois de evitar o orc depois de ignorar os goblins
                        System.out.println("--- Com um pouco de esforço, você consegue escalar a parede, segurando em algumas pedras salientes.");
                    } else {
                        teclaSistema();
                    } 
                } else {
                    teclaSistema();
                }  
        }
        System.out.println("");
        System.out.println("--- A parede não era bem uma parede - você só estava em um desnível.");
        System.out.println("--- A correnteza do rio está bem forte. Alguns metros adiante, você vê pilares com algumas marcações rúnicas.");
        System.out.println("--- A estrutura dos pilares lembra as construções do reino de Karuel, na encosta das Montanhas Azuis.");
        System.out.println("--- Algumas horas depois, você se depara com uma ponte de pedra: É a passagem inferior do Reino de Karuel.");
        System.out.println("--- Talvez alguém em Karuel saiba o que aconteceu com você. Com esse pensamento em mente, você segue adiante.");
        System.out.println("--- Você tem a certeza de que está no caminho certo, e decide descansar em algum lugar das ruínas. Está anoitecendo.");
        System.out.println("[...]");
        enterContinue();
    }
    
    private void caminhoEstrada(Jogador j, Dado d){
        System.out.println("[SISTEMA]: Não implementado.");
        System.exit(1);
    }
    
    private void batalha(Jogador j, Monstro m, Dado d){
        Random rand = new Random();
        System.out.println("[SISTEMA]: Combate iniciado! " + j.nome + " contra " + m.nome + "!");
        while(m.getHP() >= 0 && j.HP >= 0){ 
            System.out.print("[Z] LUTAR" + "\t");
            System.out.println("[X] ITENS");
            System.out.println("[C] FUGIR");
            char ch = scan.next().charAt(0);
            if(ch == 'z' || ch == 'Z'){
                int result = rand.nextInt(2);
                if(result == 0){
                    System.out.println(m.nome + " usou " + m.getAtaqueUm() + "!");
                    int danoTotal = m.rollUm(d);
                    j.HP -= (danoTotal - j.defesa);
                    System.out.println("Dano recebido: " + danoTotal + " - " + j.defesa + " = " + (danoTotal - j.defesa));
                } else {
                    System.out.println(m.nome + " usou " + m.getAtaqueDois() + "!");
                    int danoTotal = m.rollDois(d);
                    j.HP -= (danoTotal - j.defesa);
                    System.out.println("Dano recebido: " + danoTotal + " - " + j.defesa + " = " + (danoTotal - j.defesa));
                }
                System.out.println("");
                exibirStatusCombate(j, m);
                System.out.print("[1] Ataque Básico - 0 Mana" + "\t");
                System.out.print("[2] " + j.classe.ataqueUm + " - " + j.classe.manaUm + " Mana" + "\t");
                System.out.println("[3] " + j.classe.ataqueEspecial + " - " + j.classe.manaEsp + " Mana");
                int n = scan.nextInt();
                switch(n){
                    case 1:
                        System.out.println(j.nome + " usou Ataque Básico! Dano causado: " + j.somaDano + " - " + m.defesa + " = " + (j.somaDano - m.defesa));
                        m.HP -= j.somaDano;
                        break;
                    case 2:
                        System.out.println(j.nome + " usou " + j.classe.ataqueUm + "!");
                        m.HP -= j.classe.ataqueUm(j, d);
                        break;
                    case 3:
                        System.out.println(j.nome + " usou " + j.classe.ataqueEspecial + "!");
                        m.HP -= j.classe.ataqueEspecial(j, d);
                        break;
                    default:
                        this.teclaSistema();
                }      
            } else if(ch == 'x' || ch == 'X'){
                mostraInventarioCombate(j);
            } else if(ch == 'c' || ch == 'C'){
                System.out.println("[" + j.nome + "]: Não posso perder tempo com essa batalha. Preciso seguir em frente.");
                break;
                }
            if(m.HP <= 0){
                System.out.println("");
                System.out.print("Você matou " + m.nome + "!" + "\t");
                j.ganharXP(m.getExp());
                break;
            } else if(j.HP <= 0){
                System.out.println("[SISTEMA]: Você morreu.");
                enterContinue();
                break;
            }
        }      
    }

    public static void main(String[] args) {
            Jogo game = new Jogo();
            Dado d = Dado.getDado(); 
            Jogador tutu = new Jogador();
            game.gameStart(tutu);
            game.enterContinue();
            tutu.setClass();
            game.enterContinue();
            game.cabanaP1(tutu);
            game.cabanaP2(tutu, d);
        }
}