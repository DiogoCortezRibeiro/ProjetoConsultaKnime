package automatiza.knime.controller.oracle.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.oracle.NovoClienteFaturado;

public interface NovoClienteFaturadoRepository extends JpaRepository<NovoClienteFaturado, Integer> {
	@Query(value = "SELECT CCP.ID_CONTATOPESSOA AS IDENTIFICADOR\r\n" + 
			"                       ,CO.DS_OPERADOR\r\n" + 
			"                       ,CCP.DH_CADASTRO\r\n" + 
			"                       ,CCP.DH_CONCLUSAO\r\n" + 
			"                       ,CCP.CD_PESSOA\r\n" + 
			"                       ,CCP.NM_PESSOA\r\n" + 
			"                       ,CCP.CD_OPERADOR\r\n" + 
			"                       ,CA.CD_ACAO\r\n" + 
			"                       ,CA.DS_ACAO\r\n" + 
			"                       ,CCP.CD_RESULTADOACAO\r\n" + 
			"                       ,CCR.DS_RESULTADOACAO\r\n" + 
			"                       ,CCP.ID_PROTOCOLO\r\n" + 
			"                       ,DECODE(CCP.TP_STATUS,\r\n" + 
			"                                'G',\r\n" + 
			"                                'AGUARDANDO',\r\n" + 
			"                                'P',\r\n" + 
			"                                'PENDENTE',\r\n" + 
			"                                'R',\r\n" + 
			"                                'PRORROGADO',\r\n" + 
			"                                'E',\r\n" + 
			"                                'ENCAMINHADO',\r\n" + 
			"                                'C',\r\n" + 
			"                                'CONCLUIDO') AS STATUS\r\n" + 
			"                       ,CAST(CCP.INF_COMPL_RESULTADO as VARCHAR2(80)) AS RESULTADO\r\n" + 
			"                   FROM CRM_CONTATOPESSOA CCP\r\n" + 
			"                        ,CRM_ACAO          CA\r\n" + 
			"                        ,CRM_RESULTADOACAO CCR\r\n" + 
			"                        ,CRM_OPERADOR      CO\r\n" + 
			"                  WHERE CCP.CD_RESULTADOACAO = CCR.CD_RESULTADOACAO\r\n" + 
			"                    AND CA.ID_ACAO = CCP.ID_ACAO\r\n" + 
			"                    AND CA.CD_OBJETIVOACAO = 10\r\n" + 
			"                    AND CCP.CD_OPERADOR <> 239\r\n" + 
			"                    AND CCP.CD_OPERADOR = CO.CD_OPERADOR", nativeQuery = true)
	List<NovoClienteFaturado> getNovosClientesFaturados();
}
