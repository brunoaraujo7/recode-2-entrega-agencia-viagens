package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// Nome do usuário do mysql

	private static final String USERNAME = "root";

	// Senha do mysql

	private static final String PASSWORD = "recodepro123";

	// Dados de caminho, porta e nome da base de dados que irá ser feita a conexão

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/recode_viagens";

	// * Cria uma conexão com o banco de dados MySQL utilizando o nome de usuário e
	// senha fornecidos

	// * @param username

	// * @param senha

	// * @return uma conexão com o banco de dados

	// * @throws Exception
	public static Connection createConnectionToMySQL() throws Exception {

		// Faz com que a classe seja carregada pela JVM

		// Cria a conexão com o banco de dados
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;

	}

}