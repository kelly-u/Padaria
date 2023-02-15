package br.recife.edu.ifpe.padaria.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.recife.edu.ifpe.padaria.model.classes.Padeiro;

public class RepositorioPadeiro implements Repositorio<Padeiro, Integer> {

/////////////////////////////// OK /////////////////////////////////////////
	
	RepositorioPadeiro() { }

	@Override
	public void inserir(Padeiro pl) throws SQLException {

		String sql = "insert into padeiro(nome,contato) values (?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, pl.getNome());
		pstm.setString(2, pl.getContato());

		pstm.execute();

	}
	
	
	
	@Override
	public void alterar(Padeiro pl) throws SQLException {

		String sql = "update padeiro set nome=?, contato=? where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, pl.getNome());
		pstm.setString(2, pl.getContato());
		
		pstm.setInt(3, pl.getCodigo());

		pstm.execute();
	}
	
	
	
	@Override
	public Padeiro ler(Integer k) throws SQLException {

		String sql = "select * from padeiro where codigo = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		ResultSet result = pstm.executeQuery();

		Padeiro p = null;

		if (result.next()) {

			p = new Padeiro();

			p.setCodigo(k);
			p.setNome(result.getString("nome"));
			p.setContato(result.getString("contato"));
			
		}

		return p;
	}
	
	
	
	@Override
	public void deletar(Integer k) throws SQLException {

		String sql = "delete from padeiro where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		pstm.execute();
	}
	

	
	@Override
	public List<Padeiro> lerTudo() throws SQLException {

		String sql = "select * from padeiro";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<Padeiro> pad = new ArrayList<Padeiro>();

		while (result.next()) {

			Padeiro p = new Padeiro();
			
			p.setCodigo(result.getInt("codigo"));
			p.setNome(result.getString("nome"));
			p.setContato(result.getString("contato"));
			
			
			pad.add(p);

		}

		return pad;
	}

}

/////////////////////////////// OK /////////////////////////////////////////
