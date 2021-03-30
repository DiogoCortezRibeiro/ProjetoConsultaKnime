package automatiza.knime.controller.oracle.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.oracle.ItemPedidoVenda;

public interface ItemPedidoVendaRepository extends JpaRepository<ItemPedidoVenda, Integer>{
	@Query(value = "SELECT PVI.NR_TABELAPRECOITEM AS CD_PRODUTO\r\n" + 
			"                       ,PVI.QT_PEDIDO\r\n" + 
			"                       ,PVI.VL_TOTAL_LIQUIDO\r\n" + 
			"                       ,PVI.CD_EMPRESA\r\n" + 
			"                       ,PVI.CD_FILIAL\r\n" + 
			"                       ,PVI.CD_PEDIDOVENDA\r\n" + 
			"                       ,PVI.CD_MOTIVOCANCELAMENTO\r\n" + 
			"                       ,CASE\r\n" + 
			"                           WHEN PVI.CD_MOTIVOCANCELAMENTO IS NULL THEN\r\n" + 
			"                            NULL\r\n" + 
			"                        ELSE\r\n" + 
			"                            TO_CHAR(PVI.DH_ULTIMA_ALTERACAO, 'DD-MM-YYYY')\r\n" + 
			"                        END AS DT_CANCELAMENTO\r\n" + 
			"                        ,MC.DS_MOTIVOCANCELAMENTO\r\n" + 
			"                        FROM PEDIDOVENDAITEM    PVI\r\n" + 
			"                            ,MOTIVOCANCELAMENTO MC\r\n" + 
			"                        WHERE PVI.CD_MOTIVOCANCELAMENTO = MC.CD_MOTIVOCANCELAMENTO(+)\r\n" + 
			"                          AND EXTRACT(YEAR FROM PVI.DH_ULTIMA_ALTERACAO) > '2019'", nativeQuery = true)
	List<ItemPedidoVenda> getItemPedidosVenda();
}
