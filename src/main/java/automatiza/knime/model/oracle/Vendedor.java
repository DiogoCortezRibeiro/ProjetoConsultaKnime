package automatiza.knime.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_COLABORADOR")
	private Integer cd_pessoa;
	@Column(name = "NM_COLABORADOR")
	private String nm_pessoa;
	@Column(name = "CD_UF")
	private String cd_uf;
	@Column(name = "CIDADE")
	private String cidade;
	@Column(name = "CD_EQUIPE")
	private Integer cd_equipe;
	@Column(name = "DS_EQUIPE")
	private String ds_equipe;
	
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
	
	public Integer getCd_equipe() {
		return cd_equipe;
	}
	
	public String getDs_equipe() {
		return ds_equipe;
	}
}
