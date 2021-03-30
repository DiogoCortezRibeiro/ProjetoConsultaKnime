package automatiza.knime.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendas_meta")
public class MetaVendedores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_meta")
	private Integer id_meta;
	@Column(name = "cd_filial")
	private Integer cd_filial;
	@Column(name = "cd_equipe")
	private Integer cd_equipe;
	@Column(name = "dt_ano")
	private String dt_ano;
	@Column(name = "dt_mes")
	private Integer dt_mes;
	@Column(name = "qt_dias_estimados")
	private Integer qt_dias_estimados;
	@Column(name = "qt_dias_percorridos")
	private Integer qt_dias_percorridos;
	@Column(name = "qt_dias_faltantes")
	private Integer qt_dias_faltantes;
	@Column(name = "vl_meta")
	private String vl_meta;
	
	public Integer getId_meta() {
		return id_meta;
	}
	
	public Integer getCd_filial() {
		return cd_filial;
	}
	
	public Integer getCd_equipe() {
		return cd_equipe;
	}
	
	public String getDt_ano() {
		return dt_ano;
	}
	
	public Integer getDt_mes() {
		return dt_mes;
	}
	
	public Integer getQt_dias_estimados() {
		return qt_dias_estimados;
	}
	
	public Integer getQt_dias_percorridos() {
		return qt_dias_percorridos;
	}
	
	public Integer getQt_dias_faltantes() {
		return qt_dias_faltantes;
	}
	
	public String getVl_meta() {
		return vl_meta;
	}
}
