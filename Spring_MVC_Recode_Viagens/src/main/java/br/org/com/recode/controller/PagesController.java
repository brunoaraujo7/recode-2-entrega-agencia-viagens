package br.org.com.recode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.com.recode.enums.RoleName;
import br.org.com.recode.model.Cargo;
import br.org.com.recode.model.Usuario;
import br.org.com.recode.repository.UsuarioRepository;
import br.org.com.recode.utils.PasswordEncoderUtils;

@Controller
@RequestMapping("/pages")
public class PagesController {

	private UsuarioRepository usuarioRepository;

	public PagesController(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping(path = "/signup")
	public String signup(@ModelAttribute Usuario usuario) {
		try {
			String passwordEncoder = PasswordEncoderUtils.encode(usuario.getPassword());
			usuario.setPassword(passwordEncoder);
			Cargo cargo = new Cargo();
			cargo.setId(1);
			cargo.setNome(RoleName.ROLE_ADMIN);
			usuario.setCargo(cargo);
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/pages/login";
	}

	@GetMapping({ "", "/", "/home" })
	public String home() {
		return "home";
	}

	@GetMapping("/destinos")
	public String destinos() {
		return "destinos";
	}

	@GetMapping("/promocoes")
	public String promocoess() {
		return "promocoes";
	}

	@GetMapping("/quemsomos")
	public String quemsomos() {
		return "quemsomos";
	}

	@GetMapping("/contatos")
	public String contatos() {
		return "contatos";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "signup";
	}
}
