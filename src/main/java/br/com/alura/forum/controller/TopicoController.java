package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topico")
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private CursoRepository cursoRepository;

//		@RequestMapping(value = "/topico", method = RequestMethod.GET)
		@GetMapping
		public List<TopicoDTO> lista(String nomeCurso) {
//			Topico topico = new Topico("Dúvida", "Duvida com Spring", new Curso("Spring", "Programação"));
			if(nomeCurso==null) {
				List<Topico> topicos = topicoRepository.findAll();
				return TopicoDTO.converter(topicos);
//				return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
			}else {
				List<Topico> topicos = topicoRepository.minhaChamada(nomeCurso);
				return TopicoDTO.converter(topicos);
//				return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
			}
		
	}
		@PostMapping
		public ResponseEntity<TopicoDTO> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
			Topico topico = form.converter(cursoRepository);
			topicoRepository.save(topico);
			URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
			return ResponseEntity.created(uri).body(new TopicoDTO(topico));
			
		}

		

}
