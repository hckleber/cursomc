package com.kleberhc.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kleberhc.cursomc.domain.Categoria;
import com.kleberhc.cursomc.domain.Cidade;
import com.kleberhc.cursomc.domain.Cliente;
import com.kleberhc.cursomc.domain.Endereco;
import com.kleberhc.cursomc.domain.Estado;
import com.kleberhc.cursomc.domain.ItemPedido;
import com.kleberhc.cursomc.domain.ItemPedidoPK;
import com.kleberhc.cursomc.domain.Pagamento;
import com.kleberhc.cursomc.domain.PagamentoComBoleto;
import com.kleberhc.cursomc.domain.PagamentoComCartao;
import com.kleberhc.cursomc.domain.Pedido;
import com.kleberhc.cursomc.domain.Produto;
import com.kleberhc.cursomc.enums.EstadoPagamento;
import com.kleberhc.cursomc.enums.TipoCliente;
import com.kleberhc.cursomc.repositories.CategoriaRepository;
import com.kleberhc.cursomc.repositories.CidadeRepository;
import com.kleberhc.cursomc.repositories.ClienteRepository;
import com.kleberhc.cursomc.repositories.EnderecoRepository;
import com.kleberhc.cursomc.repositories.EstadoRepository;
import com.kleberhc.cursomc.repositories.ItemPedidoRepository;
import com.kleberhc.cursomc.repositories.PagamentoRepository;
import com.kleberhc.cursomc.repositories.PedidoRepository;
import com.kleberhc.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {


	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
//	Implements CommandLineRuner permite implementar 
//	método auxiliar para executar alguma ação quando a aplicação iniciar
	@Override
	public void run(String... args) throws Exception {
	
		
	}
	
	
	
}


