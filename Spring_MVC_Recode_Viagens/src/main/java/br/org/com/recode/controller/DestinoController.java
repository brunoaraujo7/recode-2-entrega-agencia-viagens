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

import br.org.com.recode.model.Destino;
import br.org.com.recode.repository.DestinoRepository;

@Controller
@RequestMapping(path = "/admin/destino")
public class DestinoController {

	private DestinoRepository destinoRepository;

	public DestinoController(DestinoRepository destinoRepository) {
	    this.destinoRepository = destinoRepository;
	}

	@GetMapping(path = "/select")
	public String select(Model model) {
		try {
			List<Destino> destinos = destinoRepository.findAll();
			model.addAttribute("destinos", destinos);
			model.addAttribute("destino", new Destino());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cadastro-destino";
	}

	@GetMapping(path = "/delete/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		try {
			destinoRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/destino/select";
	}

	@GetMapping(path = "/edit/{id}")
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		Destino destino = destinoRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Destino não encontrado"));
		model.addAttribute("destino", destino);
		return "alterar-destino";
	}

	@PostMapping(path = "/insert")
	public String insert(@ModelAttribute Destino destino) {
		try {
			destinoRepository.save(destino);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/destino/select";
	}

	@PostMapping(path = "/update")
	public String update(@ModelAttribute Destino destino) {
		try {
			destinoRepository.save(destino);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/destino/select";
	}
}
