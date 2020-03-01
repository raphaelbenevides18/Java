package service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Livro;
import persistence.LivroDao;

@Path("/livro")
public class LivroService {
	
	@GET
	public String getDados() {
		try {
			return new Gson().toJson(new LivroDao().findAll());
		} catch (Exception ex) {
			String dado = "[]";
			return dado;

		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String gravar(String livro) {
		try {
			// de String para Json e de Json para Obj
			Livro resp = new Gson().fromJson(livro, Livro.class);
			new LivroDao().create(resp);
			return new Gson().toJson(resp);
		} catch (Exception ex) {
			return "Error: " + ex.getMessage();
		}
	}
	
	@GET
	@Path("/{idLivro}")
	public String buscarCodigo(@PathParam("idLivro") String id) {
		try {
			Livro resp = new LivroDao().findById(new Integer(id));
			if (resp == null) {
				throw new Exception("Nao Encontrado ...");
			}
			return new Gson().toJson(resp);
		} catch (Exception ex) {
			Map<String,String> mapa = new HashMap<String,String>();
			mapa.put("error", "codigo nao encontrado");
			return new Gson().toJson(mapa);
		}

	}

}

