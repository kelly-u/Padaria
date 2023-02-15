package br.recife.edu.ifpe.padaria.model.repositories;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.recife.edu.ifpe.padaria.model.classes.Padeiro;
import br.recife.edu.ifpe.padaria.model.classes.TipoPao;
//import br.recife.edu.ifpe.padaria.model.repositories.ConnectionManager;
//import br.recife.edu.ifpe.padaria.model.repositories.Fachada;
import br.recife.edu.ifpe.padaria.model.classes.Fornada;

public class RepositorioFornada implements Repositorio<Fornada, Integer> {
	
/////////////////////////////// OK /////////////////////////////////////////

	RepositorioFornada() { }

	//cpf_padeiro varchar(),
	//cod_tipopao int
	
	
	@Override
	public void inserir(Fornada fl) throws SQLException {

		String sql = "insert into fornada(horario, qntdpao, observacao, cod_padeiro, cod_tipopao) values (?,?,?,?,?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setDate(1, new Date(fl.getHorario()));
		pstm.setInt(2, fl.getQntdPao());
		pstm.setString(3, fl.getObservacao());
		pstm.setInt(4, fl.getPadeiro().getCodigo());
		pstm.setInt(5, fl.getTipoPao().getCodigo());

		pstm.execute();

	}


	
	@Override
	public void alterar(Fornada fl) throws SQLException {

		String sql = "update fornada set horario=?, qntdpao=?, observacao=? where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setDate(1, new Date(fl.getHorario()));
		pstm.setInt(2, fl.getQntdPao());
		pstm.setString(3, fl.getObservacao());

		pstm.setInt(4, fl.getCodigo());

		pstm.execute();

	}


	
	@Override
	public Fornada ler(Integer k) throws SQLException {

		String sql = "select * from fornada where codigo=?";
		// Ao invé de fazer o join pegando o carro e a lavagem, #1

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		ResultSet result = pstm.executeQuery();

		Fornada f = null;

		if (result.next()) {

			// #1 Criei a fornada,
			f = new Fornada();

			f.setCodigo(k);
			f.setHorario(result.getDate("horario").getTime());
			f.setQntdPao(result.getInt("qntdpao"));
			f.setObservacao(result.getString("observacao"));
			
			// #1 Aqui se passa o codigo de padeiro
			int codigoP = result.getInt("cod_padeiro");
			// #1 Aqui se passa o codigo de tipo de pao
			int codigoTP = result.getInt("cod_tipopao");
			
			// #1 Recupero o padeiro pelo codigo
			Padeiro p = Fachada.getCurrentInstance().lerPadeiro(codigoP);
			// #1 Recupero o tipo de pao pelo codigo
			TipoPao tp = Fachada.getCurrentInstance().lerTipoPao(codigoTP);
			
			f.setPadeiro(p);
			f.setTipoPao(tp);
		}
		
		// #1 Retorna a fornalha
		return f;

	}


	
	// Iplementando os métodos da Interface Repositorio
	@Override
	public void deletar(Integer k) throws SQLException {
		
		String sql = "delete from fornada where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);
		
		pstm.execute();

	}
	

	
		@Override
		public List<Fornada> lerTudo() throws SQLException {

			String sql = "select * from fornada";

			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

			ResultSet result = pstm.executeQuery();

			List<Fornada> fornada = new ArrayList<Fornada>();

			while (result.next()) {

				Fornada f = new Fornada();
				
				f.setCodigo(result.getInt("codigo"));
				f.setHorario(result.getDate("horario").getTime());
				f.setQntdPao(result.getInt("qntdpao"));				
				f.setObservacao(result.getString("observacao"));
				
				int codigoP = result.getInt("cod_padeiro");
				int codigoTP = result.getInt("cod_tipopao");
				
				Padeiro p = Fachada.getCurrentInstance().lerPadeiro(codigoP);
				TipoPao tp = Fachada.getCurrentInstance().lerTipoPao(codigoTP);
				
				f.setPadeiro(p);
				f.setTipoPao(tp);

				fornada.add(f);
				
			}

			return fornada;
		}
	
		
/////////////////////////////// OK /////////////////////////////////////////

		
/////////////////////////////// FALTA /////////////////////////////////////////
		// FILTRO - FAZER OLHANDO O REPOSITÓRIO LAVAGEM DO LAVAJATO
		// NÃO FIZ PORQUE NÃO SABIA QUAL FILTRO IRIA USAR NEM PRA QUÊ
/////////////////////////////// FALTA /////////////////////////////////////////

}