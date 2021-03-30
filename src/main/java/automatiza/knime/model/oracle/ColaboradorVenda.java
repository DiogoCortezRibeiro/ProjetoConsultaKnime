package automatiza.knime.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOVENDA")
public class ColaboradorVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_COLABORADOR")
	private Integer cd_colaborador;
	@Column(name = "CD_EMPRESA")
	private Integer cd_empresa;
	@Column(name = "CD_FILIAL")
	private Integer cd_filial;
	@Column(name = "NM_COLABORADOR")
	private String nm_colaborador;
	@Column(name = "CD_EQUIPE")
	private Integer cd_equipe;
	@Column(name = "DS_EQUIPE")
	private String ds_equipe;
	@Column(name = "MES_FATURAMENTO")
	private String mes_faturamento;
	@Column(name = "VALOR_LIQUIDO")
	private Double valor_liquido;
	@Column(name = "indice_meta_vendedor")
	private String indice_meta;
	@Column(name = "DT_FATURAMENTO")
	private String dt_faturamento;
	
	public Integer getCd_colaborador() {
		return cd_colaborador;
	}
	
	public Integer getCd_empresa() {
		return cd_empresa;
	}
	
	public Integer getCd_filial() {
		return cd_filial;
	}
	
	public String getNm_colaborador() {
		return nm_colaborador;
	}
	
	public Integer getCd_equipe() {
		return cd_equipe;
	}
	
	public String getDs_equipe() {
		return ds_equipe;
	}
	
	public String getMes_faturamento() {
		return mes_faturamento;
	}
	
	public Double getValor_liquido() {
		return valor_liquido;
	}
	
	public String getIndice_meta() {
		return indice_meta;
	}
	
	public String getDt_faturamento() {
		return dt_faturamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indice_meta == null) ? 0 : indice_meta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColaboradorVenda other = (ColaboradorVenda) obj;
		if (indice_meta == null) {
			if (other.indice_meta != null)
				return false;
		} else if (!indice_meta.equals(other.indice_meta))
			return false;
		return true;
	}
	
	
}