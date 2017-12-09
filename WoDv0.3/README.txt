v0.0.4
- criei uma função em Jogo pra adicionar um "Aperte Enter para continuar", já que era muito texto de uma vez. O ideal seria chamar essa função depois de cada função principal do jogo.

- também comecei a mexer em algumas coisas da narrativa. a função gameStart (ou algo assim, esqueci) já tem uma descriçãozinha do ambiente.

- tava testando o sistema de skills de cada classe, mas preciso tirar algum tempo pra pensar melhor. coloquei uma skill pra cada uma das classes só como string mesmo, por enquanto.

v0.0.5

- criei a classe Dado pra rolar os valores da batalha and shit.

- movi a função de setar o nome do jogador pra classe Jogador (o que é estranho porque já deveria estar lá).

v0.0.6

- tratamento de erros na inserção do nome (ainda com alguns bugs, mas já dá pra ter uma ideia)

- método ataqueUm da classe abstrata mudado de void pra int(pra retornar o dano do ataque, essas coisas aí)

- dei uma mexida básica beeeeem por cima na parte da batalha, mas preciso parar pra fazer direito

v0.0.7

- batalha quase totalmente implementada :D

- adicionadas duas Strings ataqueUm e ataqueEspecial pra reutilizar o nome das skills ao longo do código (útil pra batalha funcionar pra todas as classes)

- coloquei os ataques especiais e setei somaDano pra ser o adicional de dano na rolagem

v0.0.8

- deu certo a batalha hehehehehehe
	- exibe o custo de mana do lado das habilidades
	- rola o dado de acordo com o atributo (só o clérigo, lembrar de mexer no resto)
	- falta colocar algo na morte e mostrar o inventário

v0.0.9

- reconfiguração da classe Dado para adaptar ao padrão Singleton
- atributos de combate implementados em todas as classes
- ajustes de encapsulamento dos métodos das classes Jogo e Jogador
- primeiros testes com a interface MonstroNew e o padrão Decorator

v0.1.0

- ajustes de interatividade nas classes do personagem
- remoção da classe Personagem (por ser desnecessária)
- abandono dos testes do Decorator para os monstros
- criada a superclasse Monstro e uma subclasse Goblin
- ajustes na rolagem do dado e na batalha (texto mais objetivo, maior retorno para o usuário)

v0.1.1

- início da implementação da narrativa
- ajustes na interatividade com a função Jogo.teclaSistema()
- ajustes nos diálogos na escolha de classe
- implementada classe Orc para testes futuros

v0.1.2

- continuação da narrativa
- desistindo do decorator nos monstros e começando a implementar os itens
- possível adoção do padrão Strategy

v0.2

- implementação do padrão Factory na criação e inicialização dos itens
- implementado um método para exibir os status a qualquer momento na classe jogador
- inventário implementado

v0.2.1

- implementação de métodos para consumo de itens através do inventário (fora de combate)
- consumo de itens dentro de combate ainda em desenvolvimento
- correções menores

v0.3

- avanço da narrativa. quase metade implementada
