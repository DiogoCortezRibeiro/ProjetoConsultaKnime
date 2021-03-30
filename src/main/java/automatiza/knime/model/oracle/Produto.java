package automatiza.knime.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO")
	private Integer id_produto;
	@Column(name = "CD_PRODUTO")
	private Integer cd_produto;
	@Column(name = "DS_PRODUTO")
	private String ds_produto;
	@Column(name = "CD_CATEGORIAPRODUTO")
	private Integer cd_categoriaproduto;
	@Column(name = "DS_CATEGORIAPRODUTO")
	private String ds_categoriaproduto;
	@Column(name = "CD_MARCA")
	private Integer cd_marca;
	@Column(name = "DS_MARCA")
	private String ds_marca;
	@Column(name = "TP_STATUS")
	private String tp_status;
	@Column(name = "CD_SUBCATEGORIAPRODUTO")
	private Integer cd_subcategoriaproduto;
	@Column(name = "DS_SUBCATEGORIAPRODUTO")
	private String ds_subcategoriaproduto;
	@Column(name = "NM_RESPONSAVEL_PRODUTO")
	private String nm_responsavel_produto;
	@Column(name = "CD_FORNECEDOR_PRINCIPAL")
	private String cd_fornecedor_principal;
	@Column(name = "RAZAO_SOCIAL")
	private String razao_social;

	public Integer getId_produto() {
		return id_produto;
	}

	public Integer getCd_produto() {
		return cd_produto;
	}

	public Integer getCd_categoriaproduto() {
		return cd_categoriaproduto;
	}

	public String getDs_produto() {
		return ds_produto;
	}

	public String getDs_categoriaproduto() {
		return ds_categoriaproduto;
	}
	
	public Integer getCd_marca() {
		return cd_marca;
	}

	public String getDs_marca() {
		return ds_marca;
	}

	public String getTp_status() {
		return tp_status;
	}
	
	public Integer getCd_subcategoriaproduto() {
		return cd_subcategoriaproduto;
	}

	public String getDs_subcategoriaproduto() {
		return ds_subcategoriaproduto;
	}

	public String getNm_responsavel_produto() {
		return nm_responsavel_produto;
	}

	public String getCd_fornecedor_principal() {
		return cd_fornecedor_principal;
	}

	public String getRazao_social() {
		return razao_social;
	}

}
