package br.recife.edu.ifpe.padaria.model.repositories;

import java.sql.SQLException;
import java.util.List;

import br.recife.edu.ifpe.padaria.model.classes.Fornada;
import br.recife.edu.ifpe.padaria.model.classes.Padeiro;
import br.recife.edu.ifpe.padaria.model.classes.TipoPao;

public class Fachada {

	private static Fachada myself = null;

	private Repositorio<TipoPao, Integer> rTipoPao = null;
	private Repositorio<Padeiro, Integer> rPadeiro = null;
	private Repositorio<Fornada, Integer> rFornada = null;

	private Fachada() {

		this.rTipoPao = new RepositorioTipoPao();
		this.rPadeiro = new RepositorioPadeiro();
		this.rFornada = new RepositorioFornada();

	}

	public static Fachada getCurrentInstance() {

		if (myself == null)
			myself = new Fachada();

		return myself;

	}

	public void inserir(TipoPao tp) throws SQLException {
		this.rTipoPao.inserir(tp);
	}

	public void inserir(Padeiro p) throws SQLException {
		this.rPadeiro.inserir(p);
	}

	public void inserir(Fornada f) throws SQLException {
		this.rFornada.inserir(f);
	}

	public void alterar(TipoPao tp) throws SQLException {
		this.rTipoPao.alterar(tp);
	}

	public void alterar(Padeiro p) throws SQLException {
		this.rPadeiro.alterar(p);
	}

	public void alterar(Fornada f) throws SQLException {
		this.rFornada.alterar(f);
	}

	public TipoPao lerTipoPao(int codigo) throws SQLException {
		return this.rTipoPao.ler(codigo);
	}

	public Padeiro lerPadeiro(int codigo) throws SQLException {
		return this.rPadeiro.ler(codigo);
	}

	public Fornada lerFornada(int codigo) throws SQLException {
		return this.rFornada.ler(codigo);
	}

	public void deletarTipoPao(int codigo) throws SQLException {
		this.rTipoPao.deletar(codigo);
	}

	public void deletarPadeiro(int codigo) throws SQLException {
		this.rPadeiro.deletar(codigo);
	}

	public void deletarFornada(int codigo) throws SQLException {
		this.rFornada.deletar(codigo);
	}

	public List<TipoPao> lerTudoTipoPao() throws SQLException {
		return this.rTipoPao.lerTudo();
	}

	public List<Padeiro> lerTudoPadeiro() throws SQLException {
		return this.rPadeiro.lerTudo();
	}

	public List<Fornada> lerTudoFornada() throws SQLException {
		return this.rFornada.lerTudo();
	}

	/*
	 * area de filtros
	 *
	// # 4 o rLavagem é do tipo repositório (Interface)
	// # 4 então para fazer o filtro, foi necessário fazer o cast para
	// RepositorioFornada
	// # 4 e usei o filto
	// # 4 -> o cash -> (RepositorioFornada) this.rLavagem)
	// # 4 e depois usei o filtroPorPlaca de carro.
	public List<Fornada> filtroPorCodigo(String codigo) throws SQLException {
		return ((RepositorioFornada) this.rFornada).filtroPorCodigo(codigo);
	}

	// # 4 o rLavagem é do tipo repositório (Interface)
	// # 4 então para fazer o filtro, foi necessário fazer o cast para
	// RepositorioFornada
	// # 4 e usei o filto
	// # 4 -> o cash -> (RepositorioFornada) this.rLavagem)
	// # 4 e depois usei o filtroPorPlaca de carro.
	public List<Lavagem> filtroPorStatusNaoPronto() throws SQLException {
		return ((RepositorioFornada) this.rLavagem).filtroPorStatusNaoPronto();
	}*/
}
