package br.com.rlb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rlb.entity.Filme;
import br.com.rlb.repository.FilmeRepository;

@Controller
public class FilmeController {
	
	@Autowired
	private FilmeRepository dao;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("msgInit", "Bem-Vindo ao Sistema de Spring Boot");
		mv.addObject("msg", "Sistema Spring Boot");
		mv.addObject("lista", dao.findAll());
		return mv;
	}
	
	@GetMapping("/editar")
	public ModelAndView editar(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		session = request.getSession(true);
		ModelAndView mv = new ModelAndView("editar");
		mv.addObject("msgInit", "Bem-Vindo a Filmoteca MVC");
		mv.addObject("msg", "Sistema Filmoteca MVC");
		mv.addObject("lista", dao.findAll());
		mv.addObject("filme", session.getAttribute("passefilme"));
		return mv;
	}
	
	@PostMapping(value = "/filmesweb/salvar", 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public void salvar(
			@RequestParam String titulo,
			@RequestParam String categoria,
			@RequestParam String diretor,
			@RequestParam String imagem,
			@RequestParam String trailer, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		
		session = request.getSession(true);
		try {
			//ModelAndView mv = new ModelAndView("index");
			Filme filme = new Filme(titulo, categoria, diretor, imagem, trailer);
			dao.save(filme);
			session.setAttribute("msgInit", "Bem-Vindo a Filmoteca MVC");
			session.setAttribute("msg", "Dados Gravados com sucesso!");
			session.setAttribute("lista", dao.findAll());
			response.sendRedirect("/");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
			
	}
	@GetMapping(value = "/filmesexcluir/{idFilme}")
	public void excluir(@PathVariable("idFilme") Long idFilme, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		session = request.getSession(true);
		try {
			Filme filme = dao.findById(idFilme).get();
			dao.delete(filme);
			session.setAttribute("msgInit", "Programa de Exclusao");
			session.setAttribute("lista", "Sistema Filmoteca MVC");
			session.setAttribute("msg", dao.findAll());
			response.sendRedirect("/");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	//apontando para pagina de editar
	@GetMapping(value = "/filmeseditar/{idFilme}")
	public void editar(@PathVariable("idFilme") Long idFilme, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		session = request.getSession(true);
		try {
			Filme filme = dao.findById(idFilme).get();
			session.setAttribute("msgInit", "Programa de Edicao");
			session.setAttribute("lista", "gravacao com jsp");
			session.setAttribute("msg", dao.findAll());
			session.setAttribute("passefilme", filme);
			response.sendRedirect("/editar");
		}catch (Exception ex) {
			ex.printStackTrace();
	}
	}
	
	//agora sim alterando dados
	@PostMapping(value = "/filmesweb/alterar", 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public void alterar(
			@RequestParam String idFilme,
			@RequestParam String titulo,
			@RequestParam String categoria,
			@RequestParam String diretor,
			@RequestParam String imagem,
			@RequestParam String trailer, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		
		session = request.getSession(true);
		try {
			Filme filme = new Filme(new Long(idFilme),titulo, categoria, diretor, imagem, trailer);
			dao.save(filme);
			session.setAttribute("msgInit", "Bem-Vindo a Filmoteca MVC");
			session.setAttribute("msg", "Dados Gravados com sucesso!");
			session.setAttribute("lista", dao.findAll());
			response.sendRedirect("/");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
