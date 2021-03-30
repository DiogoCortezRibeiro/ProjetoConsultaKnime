package automatiza.knime.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PESSOA")
	private Integer cd_pessoa;
	@Column(name = "NM_PESSOA")
	private String nm_pessoa;
	@Column(name = "CD_UF")
	private String cd_uf;
	@Column(name = "CIDADE")
	private String cidade;
	@Column(name = "DS_RAMOATIVIDADE")
	private String ds_ramoatividade;
	
	public Integer getCd_pessoa() {
		return cd_pessoa;
	}
	
	public String getNm_pessoa() {
		return nm_pessoa;
	}
	
	public String getCd_uf() {
		return cd_uf;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getDs_ramoatividade() {
		return ds_ramoatividade;
	}
}
