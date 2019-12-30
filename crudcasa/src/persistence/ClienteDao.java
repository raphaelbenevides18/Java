package persistence;


import java.util.ArrayList;
import java.util.List;

import entity.Cliente;

public class ClienteDao extends Dao {
	
	public void create (Cliente c) throws Exception{
		open();
		stmt = con.prepareStatement("insert into cliente values(null,?,?)");
		stmt.setString(1,c.getNome());
		stmt.setString(2, c.getCpf());
		stmt.execute();
		close();
	}
	
	public void delete (Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("delete from cliente where id = ?");
		stmt.setInt(1, cod);
		stmt.execute();
		close();
	}
	
	public void update(Cliente c) throws Exception{
		open();
		stmt = con.prepareStatement("update cliente set nome = ?, cpf = ? where id = ?");
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getCpf());
		stmt.setInt(3, c.getId());
		stmt.execute();
		close();
		
	}
	
	public List<Cliente> findAll() throws Exception{
		open();
		stmt = con.prepareStatement("select * from cliente");
		List<Cliente> lista = new ArrayList<Cliente>();
		rs = stmt.executeQuery();
		while(rs.next()){
			Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3));
			lista.add(c);
		}
		stmt.close();
		close();
		return lista;
		
	}
	
	public Cliente findByCode(Integer cod) throws Exception {
		open();
		stmt = con.prepareStatement("select * from cliente where id=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		Cliente c = null;
		if (rs.next()) {
		c = new Cliente();
		c.setId(rs.getInt(1));
		c.setNome(rs.getString(2));
		c.setCpf(rs.getString(3));
		}
		stmt.close();
		close();
		return c;
		}

}
