package com.devmedia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Descricao", nullable = false, unique = false, length = 50)
	private String descricao;

	@Column(name = "DataCadastro", nullable = false, unique = false, length = 8)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Column(name = "DataValidade", nullable = false, unique = false, length = 8)
	@Temporal(TemporalType.DATE)
	private Date dataValidade;

	@Column(name = "Preco", nullable = false, unique = false, length = 15)
	private String preco;
	

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

}
