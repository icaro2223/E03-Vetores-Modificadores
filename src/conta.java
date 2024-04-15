import java.util.*;
class Conta {
   private int NumConta; // Número da conta
   private Cliente DonoConta; // Objeto Cliente que é o dono da conta
   private double SaldoConta; // Saldo da conta
   private double LimiteConta; // Limite da conta
   private Operacao[] operacoes;
   private int proximaOperacao;
   private static int totalContas = 0;


   // Construtor padrão da classe Conta
   public Conta(int numero, Cliente dono, double saldo, double limite) {
       this.NumConta = numero; // Inicializa o número da conta com -1
       this.DonoConta = dono; // Instanciando um novo objeto Cliente
       this.SaldoConta = slado; // Inicializa o saldo como 0
       this.LimiteConta = limite; // Inicializa o limite como 0

      this.operacoes = new Operacao[1000];
        this.proximaOperacao = 0;

        Conta.totalContas++;
   }


   // Classe interna Cliente
   class Cliente {
       String Nome; // Nome do cliente
       String CPF; // CPF do cliente
       String Endereço; // Endereço do cliente
       int Idade; // Idade do cliente
       char Sexo; // Sexo do cliente
   }


   // Classe interna Operacao
   public static class Operacao {
       private Date data;
       private char tipo;
       private double valor;


       public Operacao(char tipo, double valor) {
           this.tipo = tipo;
           this.valor = valor;
           data = new Date();
       }
   }

   
   public void AdicionaOperacao(char tipo, double valor) {
       // Encontrar a primeira posição vazia no array
       int indiceVazio = 0;
       while (indiceVazio < operacoes.length && operacoes[indiceVazio] != null) {
           indiceVazio++;
       }


       // Adicionar uma nova operação na primeira posição vazia encontrada
       if (indiceVazio < operacoes.length) {
           operacoes[indiceVazio] = new Operacao(tipo, valor);
       } else {
           System.out.println("Não há espaço suficiente para adicionar mais operações.");
       }
   }


   // Método para realizar um depósito
   public void deposito(double valor) {
       this.SaldoConta = this.SaldoConta + valor; // Adiciona o valor ao saldo
   }


   // Método para realizar um saque
   public boolean saque(double valor) {
       if (valor <= this.SaldoConta) { // Verifica se há saldo suficiente para o saque
           this.SaldoConta = this.SaldoConta - valor; // Subtrai o valor do saldo
           return true; // Retorna verdadeiro indicando que o saque foi realizado com sucesso
       } else {
           return false; // Retorna falso indicando que o saque não foi possível
       }
   }


   // Método para transferir um valor para outra conta
   public boolean transferir(Conta contaDestino, double valor) {
       boolean retirar = this.saque(valor); // Tenta realizar o saque na conta de origem


       if (retirar) { // Se o saque foi realizado com sucesso
           contaDestino.deposito(valor); // Deposita o valor na conta de destino
           return true; // Retorna verdadeiro indicando que a transferência foi realizada com sucesso
       } else {
           return false; // Retorna falso indicando que a transferência não foi possível
       }
   }
   
   // Método para imprimir os detalhes de uma conta
   public void imprimir(Conta contaQualquer) {
       System.out.println(contaQualquer.NumConta); // Imprime o número da conta
       System.out.println(contaQualquer.DonoConta.Nome); // Imprime o nome do dono da conta
       System.out.println(contaQualquer.SaldoConta); // Imprime o saldo da conta
       System.out.println(contaQualquer.LimiteConta); // Imprime o limite da conta
   }


       public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.NumConta + "======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                atual.imprimir();
            }
        }
        System.out.println("====================");
    }

   
   //setter e getter de NumConta    
  public int getNumConta() {
        return numero;
    }

    public Cliente getDonoConta() {
        return dono;
    }

    public double getSaldoConta() {
        return saldo;
    }

    public double getLimiteConta() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;

        this.limite = limite;
    }

}
// Classe principal do programa
public class conta{


   public static void main(String[] args) {


       // Criando instâncias das contas
       Scanner entrada = new Scanner(System.in);


       Conta conta1 = new Conta();
       Conta conta1 = new Conta();


       // Criando instâncias dos clientes e associando às contas
       Conta.Cliente cliente1 = conta1.new Cliente();
       cliente1.setDonoConta("Icaro");
       conta1.DonoConta = cliente1;


       Conta.Cliente cliente2 = conta2.new Cliente();
       cliente2.setDonoConta("Maria");
       conta2.DonoConta = client2;




       // Imprimindo saldo e dono da conta de Icaro
       System.out.println(conta1.getSaldoConta);
       System.out.println(conta1.getDonoConta);


       System.out.println();


       // Definindo os detalhes das contas
       conta1.setNumConta(15);
       conta1.setDonoConta(cliente1);
       conta1.setSaldoConta(15000.0);
       conta1.setLimiteConta(25000.0);


       conta2.setNumConta(25);
       conta2.setDonoConta(cliente2);
       conta2.getSaldoConta();
       conta2.setLimiteConta(45000.0);


       if(conta1.setNumConta() == conta2.setNumConta()){
           System.out.println("Sao iguais!");


       }else{
           System.out.println("Sao diferentes!");
       }


       // Imprimindo detalhes das contas
       System.out.println("Dono da conta 1: " + conta1.getDonoConta(Nome));
       System.out.println("Dono da conta 2: " + conta2.getDonoConta(Nome));


       System.out.println("Saldo icaro: " + conta1.SaldoConta);
       System.out.println("Saldo Maria: " + conta1.SaldoConta);


       System.out.println();


       // Realizando operações na conta de Icaro
       conta1.deposito(700.0);
       System.out.println("Novo saldo: " + conta1.SaldoConta);


       boolean saqueRealizado = conta1.saque(800);


       if(saqueRealizado){
           System.out.println("Saque realizado com sucesso!");
           System.out.printf("Sacando %d reais...\n", 800);
           System.out.println("novo Saldo: " + conta1.SaldoConta);
       }else{
           System.out.println("Nao foi possivel fazer o saque!");
       }


       System.out.println();


       // Transferindo valor da conta de Icaro para a conta de Maria
       conta1.transferir(conta1, 3100);
       System.out.println("Saldo de conta 1: " + conta1.SaldoConta);
       System.out.println("Novo saldo de conta 2: " + conta2.SaldoConta);


       // Imprimindo detalhes da conta 1
       conta1.imprimir(conta1);


       conta1.deposito(1780.0);
       conta1.deposito(600.0);
       conta1.saque(400.0);
       conta1.saque(1780.0);
       conta1.deposito(150.0);

       System.out.println("Qual conta? I = icaro || M = Maria");
       char letra = entrada.next().charAt(0);
       
       if(letra == 'I'){
            System.out.println("Imprimindo extrato da conta de Icaro:");
            conta1.ImprimirExtrato(conta1.operacoes);
       }if(letra == 'M'){
           System.out.println("Imprimindo extrato da conta de Maria:");
            conta1.ImprimirExtrato(conta1.operacoes);
       }

   }
}
