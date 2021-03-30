package automatiza.knime.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import automatiza.knime.controller.oracle.dto.ProdutoRepository;
import automatiza.knime.model.oracle.Produto;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	//@Scheduled(fixedDelay = 10000L)
	public void getProdutos() {
		List<Produto> produtos = produtoRepository.getProdutos();
		String path = "C:\\temp\\produtos.csv";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("ID_PRODUTO");
			bw.write(",CD_PRODUTO");
			bw.write(",DS_PRODUTO");
			bw.write(",CD_CATEGORIAPRODUTO");
			bw.write(",DS_CATEGORIAPRODUTO");
			bw.write(",CD_MARCA");
			bw.write(",DS_MARCA");
			bw.write(",TP_STATUS");
			bw.write(",CD_SUBCATEGORIAPRODUTO");
			bw.write(",DS_SUBCATEGORIAPRODUTO");
			bw.write(",NM_RESPONSAVEL_PRODUTO");
			bw.write(",CD_FORNECEDOR_PRINCIPAL");
			bw.write(",RAZAO_SOCIAL");
			bw.newLine();
			for (Produto p : produtos) {
				bw.write(""+p.getId_produto()+"");
				bw.write(","+p.getCd_produto()+"");
				bw.write(",\""+p.getDs_produto()+"\"");
				bw.write(","+p.getCd_categoriaproduto()+"");
				bw.write(",\""+p.getDs_categoriaproduto()+"\"");
				bw.write(","+p.getCd_marca()+"");
				bw.write(",\""+p.getDs_marca()+"\"");
				bw.write(",\""+p.getTp_status()+"\"");
				bw.write(","+p.getCd_subcategoriaproduto()+"");
				bw.write(",\""+p.getDs_subcategoriaproduto()+"\"");
				bw.write(",\""+p.getNm_responsavel_produto()+"\"");
				bw.write(","+p.getCd_fornecedor_principal()+"");
				bw.write(",\""+p.getRazao_social()+"\"");
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
