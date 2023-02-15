package br.recife.edu.ifpe.padaria.controller.padeiro;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.recife.edu.ifpe.padaria.model.classes.Padeiro;
import br.recife.edu.ifpe.padaria.model.repositories.Fachada;

/*
 * Crud de Carro
 */

@RestController
public class PadeiroRestController {
	
/////////////////////////////// OK /////////////////////////////////////////

	@PostMapping("/Padeiro")
	public String inserir(@RequestBody Padeiro padeiro) {
		
		try {
			Fachada.getCurrentInstance().inserir(padeiro);
			return "Padeiro cadastrado com sucesso!";
			
		} catch (SQLException e) {
			return "Falha ao cadastrar padeiro!";
		}
	}
	
/////////////////////////////// OK /////////////////////////////////////////
	
	@PutMapping("/Padeiro")
	public String alterar(@RequestBody Padeiro padeiro) {
		try {
			Fachada.getCurrentInstance().alterar(padeiro);
			return "Padeiro atualizado com sucesso!";
			
		} catch (SQLException e) {
			return "Falha ao atualizar padeiro!";
		}
	}
	

/////////////////////////////// OK /////////////////////////////////////////
	
	@GetMapping("Padeiro/{codigo}")
	public Padeiro ler(@PathVariable("codigo") int codigo) {
		try {
			return Fachada.getCurrentInstance().lerPadeiro(codigo);
		} catch (SQLException e) {
			return null;
		}
	}

/////////////////////////////// OK /////////////////////////////////////////
	
	@DeleteMapping("Padeiro/{codigo}")
	public String delete(@PathVariable("codigo") int codigo) {
		
		try {
			Fachada.getCurrentInstance().deletarPadeiro(codigo);
			return "Padeiro deletado com sucesso!";
			
		} catch (SQLException e) {
			return "Falha ao deletar padeiro!";
		}
		
	}
	
/////////////////////////////// OK /////////////////////////////////////////
	
	@GetMapping("Padeiro")
	public List<Padeiro> lerTodos(){
		try {
			return Fachada.getCurrentInstance().lerTudoPadeiro();
			
		} catch (SQLException e) {
			return null;
			
		}
	}
	
	
	


}
