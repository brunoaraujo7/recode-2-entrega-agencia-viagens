package recodeViagens;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);

		PacotesService pacotesService = new PacotesService();

		int opcao;

		do {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                                 Recode Viagens                                 ");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(" 1 - Lista de Pacotes");
			System.out.println(" 2 - Pesquisar Pacotes por Modal");
			System.out.println(" 3 - Pesquisar Pacotes Nacionais");
			System.out.println(" 4 - Pesquisar Pacotes por Internacionais");
			System.out.println(" 0 - Sair");

			System.out.println("___");
			System.out.print("Digite: ");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1 -> {
				pacotesService.listaPacotes();
				break;
			}
			case 2 -> {
				pacotesService.pesquisaPacotesByModais();
				break;
			}

			case 3 -> {

				pacotesService.pesquisaByNacionais();
				break;
			}
			case 4 -> {
				pacotesService.pesquisaByInternacionais();

				break;
			}
			}
		} while (opcao != 0);
		entrada.close();
	}

}
