package automatiza.knime.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class NovoClientePedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_COLABORADOR")
	private Integer cd_colaborador;
	@Column(name = "NM_COLABORADOR")
	private String nm_colaborador;
	@Column(name = "CD_CLIENTE")
	private Integer cd_cliente;
	@Column(name = "DT_EMISSAO")
	private String dt_emissao;
	
	public Integer getCd_colaborador() {
		return cd_colaborador;
	}
	
	public String getNm_colaborador() {
		return nm_colaborador;
	}
	
	public Integer getCd_cliente() {
		return cd_cliente;
	}
	
	public String getDt_emissao() {
		return dt_emissao;
	}
}	
