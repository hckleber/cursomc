package com.kleberhc.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double desconto;
	private Integer quantidade;
	private Double preco;

	@JsonIgnore // como não queremos esta informação na serialização da classe pedido estamos ignorando esta informação aqui
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	
// Classe de associação não possui ID próprio
// O que identifica ela são os 2 objetos associados a ela
// VER CLASSE ItemPedidoPK (CLASSE AUXILIAR PARA GERAR O ID)
	
	public ItemPedido() {
		
	}


// ItemPdidoPK deve ser transparente para outros programadores, então deve ser substituído
// direto pelos seus itens na classe ItemPdidoPK com os setters
public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
	super();
	this.desconto = desconto;
	this.quantidade = quantidade;
	this.preco = preco;
	id.setPedido(pedido);
	id.setProduto(produto);
}

public double getSubTotal() {
	return (preco - desconto) * quantidade;
}

public Double getDesconto() {
	return desconto;
}


public void setDesconto(Double desconto) {
	this.desconto = desconto;
}


public Integer getQuantidade() {
	return quantidade;
}


public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
}


public Double getPreco() {
	return preco;
}


public void setPreco(Double preco) {
	this.preco = preco;
}


public ItemPedidoPK getId() {
	return id;
}


public void setId(ItemPedidoPK id) {
	this.id = id;
}

@JsonIgnore
public Pedido getPedido() {
	return id.getPedido();
}

public void setPedido(Pedido pedido) {
	id.setPedido(pedido);
}


public Produto getProduto() {
	return id.getProduto();
}

public void setProduto(Produto produto) {
	id.setProduto(produto);
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ItemPedido other = (ItemPedido) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

}
