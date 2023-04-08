package com.devmedia.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.devmedia.model.Produto;

@ManagedBean(name = "Cadastro")
@ViewScoped
public class CadastrarManagedBean {

	private Produto produto = new Produto();

	public String gravar() {
		if (produto.getDescricao().trim().length() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Descriçao: Erro de validação: o valor é necessário.", "Cadastro!"));
			return null;
		} else {
			produto.setDescricao(produto.getDescricao().trim());
		}
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtos");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(produto);
			em.getTransaction().commit();

			em.close();
			emf.close();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!", "Cadastro!"));
			return null;
		} catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Houve um erro ao realizar o cadastro!: " + e, "Cadastro!"));
			return null;
		}
		

	}
	
	public String limpar() {
		produto = new Produto();
		return null;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
