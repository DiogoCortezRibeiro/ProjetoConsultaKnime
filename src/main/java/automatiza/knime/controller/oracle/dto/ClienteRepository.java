package automatiza.knime.controller.oracle.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.oracle.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	@Query(value = "SELECT P.CD_PESSOA\r\n" + 
			"                      ,P.NM_PESSOA\r\n" + 
			"                      ,PE.CD_UF\r\n" + 
			"                      ,PE.CIDADE\r\n" + 
			"                      ,RA.DS_RAMOATIVIDADE\r\n" + 
			"                 FROM PESSOA               P\r\n" + 
			"                     ,PESSOAENDERECO       PE\r\n" + 
			"                     ,CLIENTERAMOATIVIDADE CRA\r\n" + 
			"                     ,RAMOATIVIDADE        RA\r\n" + 
			"                WHERE P.CD_PESSOA = PE.CD_PESSOA\r\n" + 
			"                  AND P.CD_PESSOA = CRA.CD_CLIENTE\r\n" + 
			"                  AND PE.BO_PRINCIPAL = 'S'\r\n" + 
			"                  AND PE.BO_ATIVO = 'S'\r\n" + 
			"                  AND CRA.BO_PRINCIPAL = 'S'\r\n" + 
			"                  AND CRA.CD_RAMOATIVIDADE = RA.CD_RAMOATIVIDADE", nativeQuery = true)
	List<Cliente> getClientes();
}
