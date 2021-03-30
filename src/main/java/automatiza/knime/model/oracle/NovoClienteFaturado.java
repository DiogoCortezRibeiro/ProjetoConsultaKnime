package automatiza.knime.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRM_CONTATOPESSOA")
public class NovoClienteFaturado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENTIFICADOR")
	private Integer id_contatopessoa;
	@Column(name = "DS_OPERADOR")
	private String ds_operador;
	@Column(name = "DH_CADASTRO")
	private String dh_cadastro;
	@Column(name = "DH_CONCLUSAO")
	private String dh_conclusao;
	@Column(name = "CD_PESSOA")
	private Integer cd_pessoa;
	@Column(name = "NM_PESSOA")
	private String nm_pessoa;
	@Column(name = "CD_OPERADOR")
	private Integer cd_operador;
	@Column(name = "CD_ACAO")
	private Integer cd_acao;
	@Column(name = "DS_ACAO")
	private String ds_Acao;
	@Column(name = "CD_RESULTADOACAO")
	private Integer cd_resultadoacao;
	@Column(name = "DS_RESULTADOACAO")
	private String ds_resultadoacao;
	@Column(name = "ID_PROTOCOLO")
	private Integer id_protocolo;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "RESULTADO")
	private String resultado;
	
	public Integer getId_contatopessoa() {
		return id_contatopessoa;
	}
	
	public String getDs_operador() {
		return ds_operador;
	}
	
	public String getDh_cadastro() {
		return dh_cadastro;
	}
	
	public String getDh_conclusao() {
		return dh_conclusao;
	}
	
	public Integer getCd_pessoa() {
		return cd_pessoa;
	}
	
	public String getNm_pessoa() {
		return nm_pessoa;
	}
	
	public Integer getCd_operador() {
		return cd_operador;
	}
	
	public Integer getCd_acao() {
		return cd_acao;
	}
	
	public String getDs_Acao() {
		return ds_Acao;
	}
	public Integer getCd_resultadoacao() {
		return cd_resultadoacao;
	}
	
	public String getDs_resultadoacao() {
		return ds_resultadoacao;
	}
	
	public Integer getId_protocolo() {
		return id_protocolo;
	}
	
	public String getTp_status() {
		return status;
	}
	
	public String getResultado() {
		return resultado;
	}
}
