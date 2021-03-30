package automatiza.knime.controller.mysql.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import automatiza.knime.model.mysql.MetaVendedores;

public interface MetaVendedoresRepository extends JpaRepository<MetaVendedores, Integer> {
	@Query(value = "SELECT\r\n" + 
			"                      id_meta,\r\n" + 
			"                      s.cd_filial,\r\n" + 
			"                      s.cd_equipe,\r\n" + 
			"                      dt_ano,\r\n" + 
			"                      dt_mes,\r\n" + 
			"                      qt_dias_estimados,\r\n" + 
			"                      qt_dias_percorridos,\r\n" + 
			"                      qt_dias_faltantes,\r\n" + 
			"                      vl_meta\r\n" + 
			"                 FROM\r\n" + 
			"                     vendas_meta m,\r\n" + 
			"                     sd_empresa s\r\n" + 
			"                WHERE\r\n" + 
			"                     s.id_empresa = m.id_empresa", nativeQuery = true)
	List<MetaVendedores> getMetasVendedores();
}
