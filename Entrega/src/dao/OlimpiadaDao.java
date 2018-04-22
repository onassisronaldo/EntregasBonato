package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Olimpiada;

public class OlimpiadaDao {
	public int criar(Olimpiada olimpiada) {
		String sqlInsert = "INSERT INTO olimpiadas(ano, tipo) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, olimpiada.getId_ano());
			stm.setString(2, olimpiada.getTipo());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = (PreparedStatement) conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					olimpiada.setId_ano(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olimpiada.getId_ano();
	}

	public void atualizar(Olimpiada olimpiadas) {
		String sqlUpdate = "UPDATE olimpiadas SET ano=?, tipo=? WHERE id_olimpiadas=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, olimpiadas.getId_ano());
			stm.setString(2, olimpiadas.getTipo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM olimpiadas WHERE id_olimpiadas = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Olimpiada carregar(int id_ano) {
		Olimpiada olimpiada = new Olimpiada();; 
		olimpiada.setId_ano(id_ano);
		String sqlSelect = "SELECT  tipo FROM olimpiadas WHERE olimpiadas.id_ano = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, olimpiada.getId_ano());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olimpiada.setId_ano(rs.getInt("ano"));
					olimpiada.setTipo(rs.getString("tipo"));		
				} else {
					olimpiada.setId_ano(-1);
					olimpiada.setTipo(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return olimpiada;
	}
	
}
