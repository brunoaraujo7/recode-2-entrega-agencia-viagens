package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacoteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void insert(Pacote x) {

		String sql = "INSERT INTO pacote(modal, diaria, valor, id_destino)" + " VALUES(?,?,?,?)";

		try {

			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, x.getModal());

			// Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, x.getDiaria());

			// Adicionar o valor do terceiro parâmetro da sql
			pstm.setDouble(3, x.getValor());

			// Adicionar o valor do quarto parâmetro da sql
			pstm.setInt(4, x.getId_destino());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void updateById(Pacote pacote) {

		String sql = "UPDATE pacote SET modal = ?,diaria = ?, valor = ?, id_destino = ? WHERE id = ?";
		try {

			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pacote.getModal());
			pstm.setInt(2, pacote.getDiaria());
			pstm.setDouble(3, pacote.getValor());
			pstm.setInt(4, pacote.getId_destino());
			pstm.setInt(4, pacote.getId_destino());
			pstm.setInt(5, pacote.getId());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public List<Pacote> select() {

		String sql = "SELECT * FROM pacote";
		ResultSet rset = null;
		List<Pacote> pacotes = new ArrayList<>();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(rset.getInt("id"));
				pacote.setModal(rset.getString("modal"));
				pacote.setDiaria(rset.getInt("diaria"));
				pacote.setValor(rset.getDouble("valor"));
				pacote.setId_destino(rset.getInt("id_destino"));
				pacotes.add(pacote);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// Fecha as conexões
			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return pacotes;
	}

	public  Pacote selectById(int id) {

		String sql = "SELECT * FROM pacote where id=?";
		ResultSet rset = null;
		Pacote pacote = new Pacote();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			if (rset.next()) {
				
				pacote.setId(rset.getInt("id"));
				pacote.setModal(rset.getString("modal"));
				pacote.setDiaria(rset.getInt("diaria"));
				pacote.setValor(rset.getDouble("valor"));
				pacote.setId_destino(rset.getInt("id_destino"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// Fecha as conexões
			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return pacote;
	}

	public boolean deleteById(int id) {

		String sql = "DELETE FROM pacote WHERE id = ?";
		boolean result = false;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Pacote> selectByModal(String modal) {

		String sql = "SELECT * FROM pacote where modal = ?";
		ResultSet rset = null;
		List<Pacote> pacotes = new ArrayList<>();

		try {

			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, modal);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(rset.getInt("id"));
				pacote.setId_destino(rset.getInt("id_destino"));
				pacote.setModal(rset.getString("modal"));
				pacote.setDiaria(rset.getInt("diaria"));
				pacote.setValor(rset.getDouble("valor"));
				pacotes.add(pacote);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// Fecha as conexões

			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return pacotes;
	}

	// Select By ID destino
	public List<Pacote> selectByIdDestino(ArrayList<Integer> id_destino) {

		String sql = "SELECT * FROM pacote where id_destino = ?";
		ResultSet rset = null;
		List<Pacote> pacotes = new ArrayList<>();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			for (int i = 0; i < id_destino.size(); i++) {

				pstm.setInt(1, id_destino.get(i));
				rset = pstm.executeQuery();

				while (rset.next()) {
					Pacote pacote = new Pacote();
					pacote.setId(rset.getInt("id"));
					pacote.setId_destino(rset.getInt("id_destino"));
					pacote.setModal(rset.getString("modal"));
					pacote.setDiaria(rset.getInt("diaria"));
					pacote.setValor(rset.getDouble("valor"));
					pacotes.add(pacote);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// Fecha as conexões

			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return pacotes;
	}
}