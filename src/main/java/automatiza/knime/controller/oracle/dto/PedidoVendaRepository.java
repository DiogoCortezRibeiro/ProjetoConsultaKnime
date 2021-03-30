package automatiza.knime.controller.oracle.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.oracle.PedidoVenda;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Integer>{
	@Query(value = "SELECT PV.CD_EMPRESA\r\n" + 
			"                       ,PV.CD_FILIAL\r\n" + 
			"                       ,PV.CD_PEDIDOVENDA\r\n" + 
			"                       ,DECODE(PV.TP_ORIGEM,\r\n" + 
			"                                'T',\r\n" + 
			"                                'Internet',\r\n" + 
			"                                'I',\r\n" + 
			"                                'Interno',\r\n" + 
			"                                'A',\r\n" + 
			"                                'Agrupador',\r\n" + 
			"                                'D',\r\n" + 
			"                                'Duplicado',\r\n" + 
			"                                PV.TP_ORIGEM) AS TP_ORIGEM\r\n" + 
			"                       ,TO_CHAR(PV.DT_PEDIDOVENDA, 'DD-MM-YYYY') AS DT_CADASTRO\r\n" + 
			"                       ,TO_CHAR(PV.DT_FATURAMENTO, 'DD-MM-YYYY') AS DT_FATURAMENTO\r\n" + 
			"                       ,TO_CHAR(PV.DT_CANCELAMENTO, 'DD-MM-YYYY') AS DT_CANCELAMENTO\r\n" + 
			"                       ,PV.CD_COLABORADOR\r\n" + 
			"                       ,COL.NM_PESSOA AS NM_COLABORADOR\r\n" + 
			"                       ,COLAB.CD_EQUIPE\r\n" + 
			"                       ,E.DS_EQUIPE\r\n" + 
			"                       ,COLAB.CD_CARGO\r\n" + 
			"                       ,PV.CD_SETORCOMERCIAL\r\n" + 
			"                       ,SC.DS_SETORCOMERCIAL\r\n" + 
			"                       ,PV.VL_TOTAL_LIQUIDO - PV.VL_FRETE AS VALOR_LIQUIDO\r\n" + 
			"                       ,F_DECODE_STATUS_PV(PV.TP_STATUS) AS TP_STATUS\r\n" + 
			"                       ,PV.CD_OPERACAO\r\n" + 
			"                       ,OP.DS_OPERACAO\r\n" + 
			"                       ,PV.CD_MOTIVOCANCELAMENTO\r\n" + 
			"                       ,MC.DS_MOTIVOCANCELAMENTO\r\n" + 
			"                       ,CLI.CD_PESSOA AS CD_CLIENTE\r\n" + 
			"                       ,CLI.NM_PESSOA AS NM_CLIENTE\r\n" + 
			"                       ,PV.TP_AGRUPAMENTO\r\n" + 
			"                   FROM PEDIDOVENDA PV\r\n" + 
			"                   JOIN PESSOA CLI\r\n" + 
			"                     ON (PV.CD_CLIENTE = CLI.CD_PESSOA)\r\n" + 
			"                   JOIN PESSOA COL\r\n" + 
			"                     ON (PV.CD_COLABORADOR = COL.CD_PESSOA)\r\n" + 
			"                   JOIN COLABORADOR COLAB\r\n" + 
			"                     ON (COL.CD_PESSOA = COLAB.CD_COLABORADOR)\r\n" + 
			"                   LEFT JOIN EQUIPE E\r\n" + 
			"                     ON (COLAB.CD_EQUIPE = E.CD_EQUIPE)\r\n" + 
			"                   LEFT JOIN MOTIVOCANCELAMENTO MC\r\n" + 
			"                     ON (PV.CD_MOTIVOCANCELAMENTO = MC.CD_MOTIVOCANCELAMENTO)\r\n" + 
			"                   JOIN OPERACAO OP\r\n" + 
			"                     ON (OP.CD_GRUPOOPERACAO = PV.CD_GRUPOOPERACAO AND\r\n" + 
			"                        OP.CD_OPERACAO = PV.CD_OPERACAO)\r\n" + 
			"                   JOIN SETORCOMERCIAL SC\r\n" + 
			"                     ON (SC.CD_SETORCOMERCIAL = PV.CD_SETORCOMERCIAL)\r\n" + 
			"                  WHERE OP.DS_OPERACAO NOT LIKE '%BONIFICA%'\r\n" + 
			"                    AND PV.CD_COLABORADOR NOT IN (6435,\r\n" + 
			"                                                11182,\r\n" + 
			"                                                28586,\r\n" + 
			"                                                1,\r\n" + 
			"                                                24673,\r\n" + 
			"                                                25190,\r\n" + 
			"                                                12498,\r\n" + 
			"                                                29948,\r\n" + 
			"                                                33459,\r\n" + 
			"                                                29335)\r\n" + 
			"                    AND PV.CD_CLIENTE NOT IN (1,\r\n" + 
			"                                            11299,\r\n" + 
			"                                            28586,\r\n" + 
			"                                            35590)\r\n" + 
			"                    AND PV.TP_AGRUPAMENTO <> 'A'\r\n" + 
			"                    AND PV.DT_PEDIDOVENDA > to_date('01/01/19', 'DD/MM/YY')", nativeQuery = true)
	List<PedidoVenda> getPedidosVenda();
}
