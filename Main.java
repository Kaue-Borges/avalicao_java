package atividadeavaliativa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Robo> robos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do{

        System.out.println("cadastro de robos");
        System.out.println("1 Cadastrar robo");
        System.out.println("2 Lista dos robos");
        System.out.println("3 realizar combate");
         System.out.println("0 Sair");
        System.out.print("digite a opção: ");
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite o código do robo: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o nome do robo: ");
                String nome = scanner.nextLine();
                System.out.print("Informe o poder de ataque: ");
                int ataque = scanner.nextInt();
                System.out.print("informe o poder de defesa: ");
                int defesa = scanner.nextInt();
                if (ataque < 10 || ataque > 30 || defesa < 0 || defesa > 20) {
                    System.out.println("Ataque deve ser entre 10 e 30.");
                    System.out.println("Defesa deve ser entre 0 e 20.");
                    break;
                }

                Robo robo = new Robo(codigo, nome, ataque, defesa);
                robos.add(robo);
                System.out.println("Robo cadastrado.");
                break;
            case 2:
                System.out.println("lista dos robos:");
                for (Robo r : robos) {
                     r.exibirStatus();
                }
                break;
            case 3:
                System.out.println("digite o código do primeiro robo:");
                int codigo1 = scanner.nextInt();
                System.out.println("digite o código do segundo robo:");
                int codigo2 = scanner.nextInt();
                Robo robo1 = null;
                Robo robo2 = null;
                for(Robo r : robos){
                    if(r.codigo == codigo1){
                        robo1 = r;
                    }
                    if(r.codigo == codigo2){
                        robo2 = r;
                    }
                }
                if(robo1 == null || robo2 == null){
                    System.out.println("não consegui encontrar os robos.");
                    break;                   
                }
                if (codigo1 ==codigo2){
                    System.out.println("não tem ele lutar contra ele mesmo né cara.");
                    break;
                }
                if(robo1.energia_atual < 30 || robo2.energia_atual < 30){
                    System.out.println("o robo precisa ter pelo menos 30 de energia pra fazer o combate.");
                    break;
                }
                System.out.println("a luta vai ser entre " +robo1.nome + " e " + robo2.nome);
                Robo primeiro;
                Robo segundo;

                if(robo1.pontos < robo2.pontos || (robo1.pontos == robo2.pontos && robo1.codigo < robo2.codigo)){
                    primeiro = robo1;
                    segundo = robo2;
                }
                else{
                    primeiro = robo2;
                    segundo = robo1;
                }
                System.out.println("o robo " + primeiro.nome + " vai começar atacando.");
                for(int rodada = 1; rodada <=5; rodada++){
                    System.out.println("rodada " + rodada);
                    int dano = primeiro.calcularDano(segundo, rodada);
                    segundo.receberDano(dano);
                    System.out.println(primeiro.nome + " atacou " + segundo.nome);
                    System.out.println("dano: " + dano);
                    System.out.println("A energia do " + segundo.nome + " é: " + segundo.energia_atual);
                    if(segundo.energia_atual == 0){
                        System.out.println(segundo.nome + " finish him");
                        break;
                    }
                dano = segundo.calcularDano(primeiro, rodada);
                primeiro.receberDano(dano);
                System.out.println(segundo.nome + " atacou " + primeiro.nome);
                System.out.println("dano: " + dano);
                System.out.println("A energia do " + primeiro.nome + " é: " + primeiro.energia_atual);
                if(primeiro.energia_atual == 0){
                    System.out.println(primeiro.nome + " finish him");
                    break; 
                } 
                }
                if(primeiro.energia_atual > segundo.energia_atual){
                    System.out.println("o vencedor é " + primeiro.nome);
                    primeiro.registrarVitoria();
                    segundo.registrarDerrota();
                }
                else if(segundo.energia_atual > primeiro.energia_atual){
                    System.out.println("o vencedor é " + segundo.nome);
                    segundo.registrarVitoria();
                    primeiro.registrarDerrota();
                }
                else{
                    System.out.println("empate cada robo ganha só 1 ponto");
                    primeiro.registrarEmpate();
                    segundo.registrarEmpate();


                }
                break;  // DESISTO PAPO RETO

                        case 0:
                System.out.println("Saindo do programa.");
                break;

        } 
    } while (opcao != 0); 
        scanner.close();
    }
}
