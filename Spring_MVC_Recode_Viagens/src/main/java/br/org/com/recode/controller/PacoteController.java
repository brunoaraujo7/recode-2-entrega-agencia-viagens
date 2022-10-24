package br.org.com.recode.controller;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.org.com.recode.model.Pacote;
import br.org.com.recode.repository.DestinoRepository;
import br.org.com.recode.repository.PacoteRepository;

@Controller
@RequestMapping(path = "/admin/pacote")
public class PacoteController {

	private PacoteRepository pacoteRepository;

	private DestinoRepository destinoRepository;

	public PacoteController(PacoteRepository pacoteRepository, DestinoRepository destinoRepository) {
		super();
		this.pacoteRepository = pacoteRepository;
		this.destinoRepository = destinoRepository;
	}

	@GetMapping(path = "/select")
	public String select(Model model) {
		try {
			List<Pacote> pacotes = pacoteRepository.findAll();
			model.addAttribute("pacotes", pacotes);
			model.addAttribute("pacote", new Pacote());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cadastro-pacote";
	}

	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		try {
			pacoteRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/pacote/select";
	}

	@GetMapping(path = "/edit/{id}")
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		Pacote pacote = pacoteRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Pacote não encontrado"));
		model.addAttribute("pacote", pacote);
		return "alterar-pacote";
	}

	@PostMapping(path = "/insert")
	public String insert(@ModelAttribute Pacote pacote, @RequestParam(name = "id_destino") Long id_destino) {
		try {
			pacote.setDestino(destinoRepository.findById(id_destino).get());
			pacoteRepository.save(pacote);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/pacote/select";
	}

	@PostMapping(path = "/update")
	public String update(@ModelAttribute Pacote pacote, @RequestParam(name = "id_destino") Long id_destino)  {
		try {
			pacote.setDestino(destinoRepository.findById(id_destino).get());
			pacoteRepository.save(pacote);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/pacote/select";
	}

}
