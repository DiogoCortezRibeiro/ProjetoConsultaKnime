package automatiza.knime.controller.oracle.dto;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.oracle.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
	@Query(value = "SELECT P.CD_PESSOA AS CD_COLABORADOR\r\n" + 
			"                      ,P.NM_PESSOA AS NM_COLABORADOR\r\n" + 
			"                      ,PE.CD_UF\r\n" + 
			"                      ,PE.CIDADE\r\n" + 
			"                      ,COL.CD_EQUIPE\r\n" + 
			"                      ,E.DS_EQUIPE\r\n" + 
			"                  FROM PESSOA               P\r\n" + 
			"                      ,PESSOAENDERECO       PE\r\n" + 
			"                      ,COLABORADOR          COL \r\n" + 
			"                      ,EQUIPE E\r\n" + 
			"                 WHERE P.CD_PESSOA = PE.CD_PESSOA\r\n" + 
			"                   AND PE.BO_PRINCIPAL = 'S'\r\n" + 
			"                   AND PE.BO_ATIVO = 'S'\r\n" + 
			"                   AND COL.CD_COLABORADOR = P.CD_PESSOA\r\n" + 
			"                   AND P.BO_COLABORADOR = 'S'\r\n" + 
			"                   AND E.CD_EQUIPE(+) = COL.CD_EQUIPE",nativeQuery = true)
	List<Vendedor> getVendedores();
}
