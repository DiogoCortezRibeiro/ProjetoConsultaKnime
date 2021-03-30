package automatiza.knime.controller.oracle.dto;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.oracle.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	@Query(value = "SELECT P.ID_PRODUTO\r\n" + 
			"                       ,P.CD_PRODUTO\r\n" + 
			"                       ,P.DS_PRODUTO\r\n" + 
			"                       ,P.CD_CATEGORIAPRODUTO\r\n" + 
			"                       ,CP.DS_CATEGORIAPRODUTO\r\n" + 
			"                       ,P.CD_MARCA\r\n" + 
			"                       ,M.DS_MARCA\r\n" + 
			"                       ,F_CLI_DECODE_TPSTATUS_PROD(P.TP_STATUS) AS TP_STATUS\r\n" + 
			"                       ,P.CD_SUBCATEGORIAPRODUTO\r\n" + 
			"                       ,SC.DS_SUBCATEGORIAPRODUTO\r\n" + 
			"                       ,P.NM_RESPONSAVEL_PRODUTO\r\n" + 
			"                       ,P.CD_FORNECEDOR_PRINCIPAL\r\n" + 
			"                       ,FORN.RAZAO_SOCIAL\r\n" + 
			"                  FROM PRODUTO             P\r\n" + 
			"                       ,CATEGORIAPRODUTO    CP\r\n" + 
			"                       ,SUBCATEGORIAPRODUTO SC\r\n" + 
			"                       ,MARCA               M\r\n" + 
			"                       ,PESSOA              FORN\r\n" + 
			"                 WHERE P.CD_CATEGORIAPRODUTO = CP.CD_CATEGORIAPRODUTO\r\n" + 
			"                   AND P.CD_MARCA = M.CD_MARCA\r\n" + 
			"                   AND P.CD_CATEGORIAPRODUTO = SC.CD_CATEGORIAPRODUTO\r\n" + 
			"                   AND P.CD_SUBCATEGORIAPRODUTO = SC.CD_SUBCATEGORIAPRODUTO\r\n" + 
			"                   AND P.CD_FORNECEDOR_PRINCIPAL = FORN.CD_PESSOA(+)", nativeQuery = true)
	List<Produto> getProdutos();
}