package automatiza.knime.controller.oracle.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.oracle.ColaboradorVenda;

public interface ColaboradorVendaRepository extends JpaRepository<ColaboradorVenda, Integer> {
	@Query(value = "SELECT PV.CD_EMPRESA \r\n" + 
			"                      ,PV.CD_FILIAL  \r\n" + 
			"                      ,PV.CD_COLABORADOR\r\n" + 
			"                      ,COL.NM_PESSOA AS NM_COLABORADOR\r\n" + 
			"                      ,E.CD_EQUIPE\r\n" + 
			"                      ,E.DS_EQUIPE\r\n" + 
			"                      ,TO_CHAR(PV.DT_FATURAMENTO, 'YYYY-MM') AS MES_FATURAMENTO\r\n" + 
			"                      ,sum(PV.VL_TOTAL_LIQUIDO - PV.VL_FRETE) as VALOR_LIQUIDO\r\n" + 
			"                      ,TO_CHAR(PV.DT_FATURAMENTO, 'YYYY') || '-' || TO_CHAR(PV.DT_FATURAMENTO, 'MM')||'-'||PV.CD_COLABORADOR as indice_meta_vendedor\r\n" + 
			"                      ,TO_CHAR(PV.DT_FATURAMENTO, 'YYYY-MM-DD') AS DT_FATURAMENTO\r\n" + 
			"                 FROM PEDIDOVENDA PV\r\n" + 
			"                 JOIN PESSOA CLI\r\n" + 
			"                   ON (PV.CD_CLIENTE = CLI.CD_PESSOA)\r\n" + 
			"                 JOIN PESSOA COL\r\n" + 
			"                   ON (PV.CD_COLABORADOR = COL.CD_PESSOA)\r\n" + 
			"                 JOIN COLABORADOR COLAB\r\n" + 
			"                   ON (COL.CD_PESSOA = COLAB.CD_COLABORADOR)\r\n" + 
			"                 LEFT JOIN EQUIPE E\r\n" + 
			"                   ON (COLAB.CD_EQUIPE = E.CD_EQUIPE)\r\n" + 
			"                 LEFT JOIN MOTIVOCANCELAMENTO MC\r\n" + 
			"                   ON (PV.CD_MOTIVOCANCELAMENTO = MC.CD_MOTIVOCANCELAMENTO)\r\n" + 
			"                 JOIN OPERACAO OP\r\n" + 
			"                   ON (OP.CD_GRUPOOPERACAO = PV.CD_GRUPOOPERACAO AND\r\n" + 
			"                        OP.CD_OPERACAO = PV.CD_OPERACAO)\r\n" + 
			"                 JOIN SETORCOMERCIAL SC\r\n" + 
			"                   ON (SC.CD_SETORCOMERCIAL = PV.CD_SETORCOMERCIAL)\r\n" + 
			"                WHERE OP.DS_OPERACAO NOT LIKE '%BONIFICA%'\r\n" + 
			"                  AND PV.CD_COLABORADOR NOT IN (6435,\r\n" + 
			"                                            11182,\r\n" + 
			"                                            28586,\r\n" + 
			"                                            1,\r\n" + 
			"                                            24673,\r\n" + 
			"                                            25190,\r\n" + 
			"                                            12498,\r\n" + 
			"                                            29948,\r\n" + 
			"                                            33459,\r\n" + 
			"                                            29335)\r\n" + 
			"                  AND PV.CD_CLIENTE NOT IN (1,\r\n" + 
			"                                        11299,\r\n" + 
			"                                        28586,\r\n" + 
			"                                        35590)\r\n" + 
			"                  AND PV.TP_AGRUPAMENTO <> 'A'\r\n" + 
			"                  and PV.DT_PEDIDOVENDA > TO_DATE('01/01/19', 'DD/MM/YY/')\r\n" + 
			"                  AND PV.DT_FATURAMENTO IS NOT NULL\r\n" + 
			"                GROUP BY PV.CD_EMPRESA\r\n" + 
			"                        ,PV.CD_FILIAL\r\n" + 
			"                        ,PV.CD_COLABORADOR\r\n" + 
			"                        ,COL.NM_PESSOA \r\n" + 
			"                        ,E.CD_EQUIPE\r\n" + 
			"                        ,E.DS_EQUIPE\r\n" + 
			"                        ,TO_CHAR(PV.DT_FATURAMENTO, 'YYYY-MM')\r\n" + 
			"                        ,TO_CHAR(PV.DT_FATURAMENTO, 'YYYY') || '-' || TO_CHAR(PV.DT_FATURAMENTO, 'MM')||'-'||PV.CD_COLABORADOR\r\n" + 
			"                        ,TO_CHAR(PV.DT_FATURAMENTO, 'YYYY-MM-DD')                  \r\n" + 
			"                 ORDER BY mes_faturamento",nativeQuery = true)
	List<ColaboradorVenda> getVendasColaborador();

}
