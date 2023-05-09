import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Qual o nome do cliente? ");
		String nome = sc.nextLine();

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		Conta contaCorrente = new ContaCorrente(cliente);
		Conta contaPoupanca = new ContaCorrente(cliente);

		System.out.println("Deseja realizar qual Operação?");
		int operacao = 0;
		while (operacao != 5) {

			System.out.println("Digite 1 para Depositos ");
			System.out.println("Digite 2 paraSaques");
			System.out.println("Digite 3 para Transferencias");
			System.out.println("Digite 4 para Imprimir o Extrato");
			System.out.println("Digite 5 para Finalizar");
			operacao = sc.nextInt();

			if (operacao == 1) {
				System.out.print("Qual o valor de Deposito? ");
				double valor = sc.nextDouble();
				contaCorrente.depositar(valor);
			}
			if (operacao == 2) {
				System.out.print("Qual o valor do Saque? ");
				double valor = sc.nextDouble();
				contaCorrente.sacar(valor);
			}
			if (operacao == 3) {
				System.out.print("Qual valor de Transferencia");
				double valor = sc.nextDouble();
				contaCorrente.transferir(valor, contaPoupanca);
			}
			if (operacao == 4) {
				contaCorrente.imprimirExtrato();
				System.out.println();
				contaPoupanca.imprimirExtrato();
				System.out.println();
			}
			System.out.println();
		}

		System.out.println("Obrigado. Volte sempre!");

		sc.close();
	}

}
