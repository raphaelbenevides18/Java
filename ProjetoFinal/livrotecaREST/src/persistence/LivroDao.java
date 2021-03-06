package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Livro;

public class LivroDao extends Dao{
	
	public List<Livro> findAll() throws Exception{
		open();
		stmt = con.prepareStatement("select * from livros");
		List <Livro> lista = new ArrayList<Livro>();
		rs = stmt.executeQuery();
		while (rs.next()) {
			Livro l = new Livro(rs.getInt(1),rs.getString(2),rs.getString(3), 
					rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			lista.add(l);
		}
		stmt.close();
		close();
		return lista;
	}
	
	public Livro findById(Integer cod) throws Exception{
		 open();
		   stmt = con.prepareStatement("select * from livros where idLivro = ?");
		   stmt.setInt(1, cod);
		   rs = stmt.executeQuery();
		   Livro l= null;
		   if (rs.next()) {
			   l =    new Livro(rs.getInt(1),rs.getString(2),rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
		   }
		 close();	
		 return l;
	}
	
	public void create(Livro l) throws Exception {
		open();
		stmt = con.prepareStatement("insert into livros values (null,?,?,?,?,?,?)");
		stmt.setString(1, l.getTitulo());
		stmt.setString(2, l.getAutor());
		stmt.setString(3, l.getCategoria());
		stmt.setString(4, l.getDescricao());
		stmt.setDouble(5, l.getNumPaginas());
		stmt.setString(6, l.getImagem());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public void delete(Integer cod) throws Exception {
		open();
		stmt = con.prepareStatement("delete from livros where idLivro = ?");
		stmt.setInt(1, cod);
		stmt.execute();
		close();
	}
	
	public void update(Livro l) throws Exception{
		open();
		stmt = con.prepareStatement("update livros set titulo = ?, autor =?, "
				+ "categoria = ?, descricao = ?, numPaginas = ?, imagem = ? where idLivro = ?");
		stmt.setString(1, l.getTitulo());
		stmt.setString(2, l.getAutor());
		stmt.setString(3, l.getCategoria());
		stmt.setString(4, l.getDescricao());
		stmt.setInt(5, l.getNumPaginas());
		stmt.setString(6, l.getImagem());
		stmt.setInt(7, l.getIdLivro());
		stmt.execute();
		stmt.close();
		close();
	}


}
