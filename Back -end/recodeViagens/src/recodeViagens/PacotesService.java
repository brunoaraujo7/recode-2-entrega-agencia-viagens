package recodeViagens;

import java.util.List;
import java.util.Scanner;

public class PacotesService {

	DestinoDAO destinoDAO = new DestinoDAO();

	PacoteDAO pacoteDAO = new PacoteDAO();

	public void listaPacotes() {

		for (Pacote p : pacoteDAO.select()) {
			System.out.println("");
			System.out.println("O destino do pacote: " + destinoDAO.selectNomeByID(p.getId_destino()));
			System.out.println("O valor do pacote: " + p.getValor());
			System.out.println("O total de diárias: " + p.getDiaria());
			System.out.println("O modal do pacote: " + p.getModal());
		}
		;
	}

	public void pesquisaPacotesByModais() {

		Scanner entrada = new Scanner(System.in);
		System.out.print("Insira o modal desejado: ");

		for (Pacote p : pacoteDAO.selectByModal(entrada.next())) {
			System.out.println("");
			System.out.println("O destino do pacote: " + destinoDAO.selectNomeByID(p.getId_destino()));
			System.out.println("O valor do pacote: " + p.getValor());
			System.out.println("O total de diárias: " + p.getDiaria());
			System.out.println("O modal do pacote: " + p.getModal());
		}
		;

		entrada.close();
	}

	public void pesquisaByNacionais() {

		List<Pacote> pacotes = pacoteDAO.selectByIdDestino(destinoDAO.selectNacional());

		for (Pacote p : pacotes) {
			System.out.println("");
			System.out.println("O destino do pacote: " + destinoDAO.selectNomeByID(p.getId_destino()));
			System.out.println("O valor do pacote: " + p.getValor());
			System.out.println("O total de diárias: " + p.getDiaria());
			System.out.println("O modal do pacote: " + p.getModal());
		}
	}

	public void pesquisaByInternacionais() {

		List<Pacote> pacotes = pacoteDAO.selectByIdDestino(destinoDAO.selectInternacional());

		for (Pacote p : pacotes) {
			System.out.println("");
			System.out.println("O destino do pacote: " + destinoDAO.selectNomeByID(p.getId_destino()));
			System.out.println("O valor do pacote: " + p.getValor());
			System.out.println("O total de diárias: " + p.getDiaria());
			System.out.println("O modal do pacote: " + p.getModal());
		}
	}
}
