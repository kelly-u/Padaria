package br.recife.edu.ifpe.padaria.controller.fornada;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.recife.edu.ifpe.padaria.model.classes.Fornada;
import br.recife.edu.ifpe.padaria.model.classes.Padeiro;
import br.recife.edu.ifpe.padaria.model.classes.TipoPao;
import br.recife.edu.ifpe.padaria.model.repositories.Fachada;

/*
 * Crud de Fornada
 */

@RestController
public class FornadaRestController {

/////////////////////////////// OK /////////////////////////////////////////
	
	@PostMapping("/Fornada/{codigoPadeiro}/{codigoTipoPao}") 
	public ResponseEntity<?> inserir(@RequestBody Fornada f, @PathVariable("codigoPadeiro") int codigoP, @PathVariable("codigoTipoPao") int codigoTP) {

		TipoPao tp;
		Padeiro p;
		try {
			p = Fachada.getCurrentInstance().lerPadeiro(codigoP);
			tp = Fachada.getCurrentInstance().lerTipoPao(codigoTP);
			f.setPadeiro(p);
			f.setTipoPao(tp);
			Fachada.getCurrentInstance().inserir(f);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (SQLException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
/////////////////////////////// OK /////////////////////////////////////////
	
	@PutMapping("/Fornada")
	 public void alterar(@RequestBody Fornada f) {
		 try {
			Fachada.getCurrentInstance().alterar(f);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao alterar o registro");
		}
	 }
	
/////////////////////////////// OK /////////////////////////////////////////
	
	@GetMapping("/Fornada/{codigo}")
	public ResponseEntity<Fornada> ler (@PathVariable("codigo") int codigo){
		try {
			Fornada f = Fachada.getCurrentInstance().lerFornada(codigo);
			return new ResponseEntity<Fornada>(f, HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler");
		}
		
	}
	
/////////////////////////////// OK /////////////////////////////////////////

	@DeleteMapping("/Fornada/{codigo}")
	public void delete(@PathVariable("codigo") int codigo) {
		try {
			Fachada.getCurrentInstance().deletarFornada(codigo);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar");
		}
	}
	
/////////////////////////////// OK /////////////////////////////////////////
	
	@GetMapping("/Fornada")
	public ResponseEntity<List<Fornada>> lerTudo(){
		try {
			return new ResponseEntity<List<Fornada>>(Fachada.getCurrentInstance().lerTudoFornada(), HttpStatus.OK);
		} catch (SQLException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler");
		}
		
	}
	
	
}
