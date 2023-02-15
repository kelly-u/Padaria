package br.recife.edu.ifpe.padaria.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.recife.edu.ifpe.padaria.model.classes.TipoPao;

public class RepositorioTipoPao implements Repositorio<TipoPao, Integer> {

/////////////////////////////// OK /////////////////////////////////////////
	
	RepositorioTipoPao() {}

	@Override
	public void inserir(TipoPao pl) throws SQLException {

		String sql = "insert into tipopao(nome, descricao) values (?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, pl.getNome());
		pstm.setString(2, pl.getDescricao());

		pstm.execute();
	}


	
	@Override
	public void alterar(TipoPao pl) throws SQLException {

		String sql = "update tipopao set nome=?, descricao=? where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, pl.getNome());
		pstm.setString(2, pl.getDescricao());

		pstm.setInt(3, pl.getCodigo());

		pstm.execute();
	}
	
	

	@Override
	public TipoPao ler(Integer k) throws SQLException {

		String sql = "select * from tipopao where codigo = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		ResultSet result = pstm.executeQuery();

		TipoPao tPao = null;

		if (result.next()) {

			tPao = new TipoPao();

			tPao.setCodigo(k);
			tPao.setNome(result.getString("nome"));
			tPao.setDescricao(result.getString("descricao"));
		}

		return tPao;
	}

	
	
	@Override
	public void deletar(Integer k) throws SQLException {

		String sql = "delete from tipopao where codigo = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		pstm.execute();

	}
	
	
	
	@Override
	public List<TipoPao> lerTudo() throws SQLException {

		String sql = "select * from tipopao";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<TipoPao> tipos = new ArrayList<TipoPao>();

		while (result.next()) {

			TipoPao tPao = new TipoPao();

			tPao.setCodigo(result.getInt("codigo"));
			tPao.setNome(result.getString("nome"));
			tPao.setDescricao(result.getString("descricao"));

			tipos.add(tPao);

		}

		return tipos;
	}

}

/////////////////////////////// OK /////////////////////////////////////////

