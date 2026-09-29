package atividadeavaliativa;
public class Robo{

    public int codigo;
    public String nome;
    public int ataque;
    public int defesa;
    public int energia_atual = 100;
    public int vitorias = 0;
    public int derrotas = 0;
    public int pontos = 0;

    public Robo(int codigo, String nome, int ataque, int defesa) {
        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
    }
    
    public void receberDano(int dano) {
        if (dano > 0) {
            this.energia_atual = this.energia_atual - dano;
            if (this.energia_atual < 0) {
                this.energia_atual = 0;
            }
        }
    }
    public int calcularDano(Robo adversario, int rodada){
        int dano = this.ataque - adversario.defesa;
        if (dano < 5) {
            dano = 5;
        }

        if (rodada % 2 == 0) {
            dano += 5;
        }
        return dano;
    }
    public int combatesRealizados = 0;
    public void registrarVitoria() {
        this.vitorias++;
        this.pontos += 3;
        this.combatesRealizados++;
    }
    public void registrarDerrota() {
        this.derrotas++;
        this.combatesRealizados++;
    }
    public void registrarEmpate() {
        this.pontos ++;
        this.combatesRealizados++;
    }
    public void exibirStatus() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Defesa: " + this.defesa);
        System.out.println("Energia atual: " + this.energia_atual);
        System.out.println("Vitórias: " + this.vitorias);
        System.out.println("Derrotas: " + this.derrotas);
        System.out.println("Pontos: " + this.pontos);
        System.out.println("Combates realizados: " + this.combatesRealizados);

        if (this.energia_atual >= 30) {
            System.out.println("pode usar o robo");
        } else { 
            System.out.println("bota essa merda carregar");
        }

    } // EU NÃO TENHO CAPACIDADE DE FAZER MAIS ISSO AQUI.
    
}