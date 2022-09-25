package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void insert(Destino x) {

		String sql = "INSERT INTO destino(cidade, pais)" + " VALUES(?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, x.getCidade());

			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, x.getPais());

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

	public void updateById(Destino destino) {

		String sql = "UPDATE destino SET cidade = ? , pais = ? WHERE id = ?";
		try {

			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getCidade());
			pstm.setString(2, destino.getPais());
			pstm.setInt(3, destino.getId());

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

	public boolean deleteById(int id) {

		String sql = "DELETE FROM destino WHERE id = ?";
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

	public List<Destino> select() {

		String sql = "SELECT * FROM destino";
		ResultSet rset = null;
		List<Destino> destinos = new ArrayList<>();
		try {

			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino destino = new Destino();
				destino.setId(rset.getInt("id"));
				destino.setCidade(rset.getString("cidade"));
				destino.setPais(rset.getString("pais"));
				destinos.add(destino);
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

		return destinos;
	}

	public String selectNomeByID(int id_destino) {

		String sql = "SELECT * FROM destino where id = ?";
		ResultSet rset = null;
		String nome_destino = null;
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_destino);
			rset = pstm.executeQuery();

			if (rset.next()) {
				nome_destino = rset.getString("cidade");
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

		return nome_destino;
	}

	public Destino selectById(int id_destino) {

		String sql = "SELECT * FROM destino where id = ?";
		ResultSet rset = null;
		Destino destino = new Destino();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_destino);
			rset = pstm.executeQuery();

			if (rset.next()) {
				destino.setId(rset.getInt("id"));
				destino.setCidade(rset.getString("cidade"));
				destino.setPais(rset.getString("pais"));
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

		return destino;
	}
	// Busca o IDs dos destinos nacionais
	public ArrayList<Integer> selectNacional() {

		String sql = "SELECT * FROM destino where pais = ?";
		ResultSet rset = null;
		ArrayList<Integer> ids_nacionais = new ArrayList<Integer>();

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "Brasil");
			rset = pstm.executeQuery();

			while (rset.next()) {
				ids_nacionais.add(rset.getInt("id"));

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

		return ids_nacionais;
	}

	// Busca o IDs dos destinos internacionais
	public ArrayList<Integer> selectInternacional() {

		String sql = "SELECT * FROM destino where pais != ?";
		ResultSet rset = null;
		ArrayList<Integer> ids_internacionais = new ArrayList<Integer>();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "Brasil");
			rset = pstm.executeQuery();

			while (rset.next()) {

				ids_internacionais.add(rset.getInt("id"));
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

		return ids_internacionais;
	}
}