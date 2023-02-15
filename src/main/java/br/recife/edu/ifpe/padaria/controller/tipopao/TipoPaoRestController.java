package br.recife.edu.ifpe.padaria.controller.tipopao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.recife.edu.ifpe.padaria.model.classes.TipoPao;
import br.recife.edu.ifpe.padaria.model.repositories.Fachada;

@RestController
public class TipoPaoRestController {

	/*
	 * Crud de TipoPao
	 */

	/////////////////////////////// OK /////////////////////////////////////////

	@PostMapping("/TipoPao")
	public String inserir(@RequestBody TipoPao tipo) {

		try {
			Fachada.getCurrentInstance().inserir(tipo);
			return "Tipo de pão cadastrado com sucesso!";

		} catch (SQLException e) {
			return "Falha ao cadastrar tipo de pão!";
		}
	}

	/////////////////////////////// OK /////////////////////////////////////////

	@PutMapping("/TipoPao")
	public String alterar(@RequestBody TipoPao tipo) {
		try {
			Fachada.getCurrentInstance().alterar(tipo);
			return "Tipo de pão atualizado com sucesso!";

		} catch (SQLException e) {
			return "Falha ao atualizar tipo de pão!";
		}
	}

	/////////////////////////////// OK /////////////////////////////////////////

	@GetMapping("TipoPao/{codigo}")
	public TipoPao ler(@PathVariable("codigo") int codigo) {
		try {
			return Fachada.getCurrentInstance().lerTipoPao(codigo);
		} catch (SQLException e) {
			return null;
		}
	}

	/////////////////////////////// OK /////////////////////////////////////////

	@DeleteMapping("TipoPao/{codigo}")
	public String delete(@PathVariable("codigo") int codigo) {

		try {
			Fachada.getCurrentInstance().deletarTipoPao(codigo);
			return "Tipo de pão deletado com sucesso!";

		} catch (SQLException e) {
			return "Falha ao deletar tipo de pão!";
		}

	}

	/////////////////////////////// OK /////////////////////////////////////////

	@GetMapping("TipoPao")
	public List<TipoPao> lerTodos() {
		try {
			return Fachada.getCurrentInstance().lerTudoTipoPao();

		} catch (SQLException e) {
			return null;

		}
	}

}
