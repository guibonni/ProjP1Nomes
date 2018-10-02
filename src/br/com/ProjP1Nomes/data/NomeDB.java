package br.com.ProjP1Nomes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ProjP1Nomes.model.Nome;
import br.com.ProjP1Nomes.util.Conexao;

public class NomeDB {
	private Connection connection;
	
	public NomeDB() {
		connection = Conexao.getConnection();
	}
	
	public boolean inserir(Nome n) throws SQLException {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("insert into nome (nome) values (?)");

			stmt.setString(1, n.getNome());
			
			stmt.execute();
			
			return true;
		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {
			connection.close();
		}
		
		return false;
	}
}
