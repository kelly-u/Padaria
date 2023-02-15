package br.recife.edu.ifpe.padaria.model.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<Cl, Key> {

	public void inserir(Cl cl) throws SQLException;

	public void alterar(Cl cl) throws SQLException;

	public Cl ler(Key k) throws SQLException;

	public void deletar(Key k) throws SQLException;

	public List<Cl> lerTudo() throws SQLException;

}
