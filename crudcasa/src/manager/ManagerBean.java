package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Cliente;
import persistence.ClienteDao;

@ManagedBean(name = "mb")
@RequestScoped
public class ManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Cliente> clientes;

	public ManagerBean() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		try {
			clientes = new ClienteDao().findAll();

		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return clientes;
	}
	
	{
		cliente= new Cliente();
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new ClienteDao().create(cliente);
			cliente = new Cliente();
			fc.addMessage("form1", new FacesMessage("Dados Gravados!!"));
		} catch (Exception ex) {
			fc.addMessage("form1", new FacesMessage("Erro:" + ex.getMessage()));
		}
	}

	public void excluir() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new ClienteDao().delete(cliente.getId());
			cliente = new Cliente();
			fc.addMessage("form2", new FacesMessage("Registro Excluido!!"));

		} catch (Exception ex) {
			fc.addMessage("form2", new FacesMessage("Erro:" + ex.getMessage()));
		}
	}
	
	public void alterar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			new ClienteDao().update(cliente);
			cliente = new Cliente();
			fc.addMessage(null, new FacesMessage("Dados Alterados!!"));
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("Erro:" + ex.getMessage()));
		}
	}

}
