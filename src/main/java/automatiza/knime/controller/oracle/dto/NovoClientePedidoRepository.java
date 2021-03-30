package automatiza.knime.controller.oracle.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.oracle.NovoClientePedidos;

public interface NovoClientePedidoRepository extends JpaRepository<NovoClientePedidos, Integer> {
	@Query(value = "SELECT CD_COLABORADOR\r\n" + 
			"                       ,NM_PESSOA AS NM_COLABORADOR\r\n" + 
			"                       ,CD_CLIENTE\r\n" + 
			"                       ,TO_CHAR(DT_EMISSAO, 'DD-MM-YYYY') AS DT_EMISSAO\r\n" + 
			"                  FROM (SELECT P.CD_COLABORADOR\r\n" + 
			"                               ,P.DT_EMISSAO\r\n" + 
			"                               ,P.CD_CLIENTE\r\n" + 
			"                               ,COUNT(1) OVER(PARTITION BY P. CD_CLIENTE ORDER BY P.DT_EMISSAO ASC ROWS BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING) AS QT_VENDAS_ANTERIORES\r\n" + 
			"                          FROM DICOMP_FATURAMENTO P\r\n" + 
			"                         WHERE P.EQUIPE IN (19, 20)\r\n" + 
			"                           AND P.CD_SETORCOMERCIAL NOT IN (1,34244)) P\r\n" + 
			"                       ,PESSOA P\r\n" + 
			"                WHERE P.QT_VENDAS_ANTERIORES = 0\r\n" + 
			"                  AND P.DT_EMISSAO > to_date('01/01/18', 'DD/MM/YY')\r\n" + 
			"                  AND CD_COLABORADOR = P.CD_PESSOA",nativeQuery = true)
	List<NovoClientePedidos> getNovosClientesPedidos();
}
