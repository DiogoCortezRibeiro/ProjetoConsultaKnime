package automatiza.knime.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOVENDA")
public class PedidoVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PEDIDOVENDA")
	private Integer cd_pedidovenda;
	@Column(name = "CD_FILIAL")
	private Integer cd_filial;
	@Column(name = "CD_EMPRESA")
	private Integer cd_empresa;
	@Column(name = "TP_ORIGEM")
	private String tp_origem;
	@Column(name = "DT_CADASTRO")
	private String dt_cadastro;
	@Column(name = "DT_FATURAMENTO")
	private String dt_faturamento;
	@Column(name = "DT_CANCELAMENTO")
	private String dt_cancelamento;
	@Column(name = "CD_COLABORADOR")
	private Integer cd_colaborador;
	@Column(name = "NM_COLABORADOR")
	private String nm_colaborador;
	@Column(name = "CD_EQUIPE")
	private Integer cd_equipe;
	@Column(name = "DS_EQUIPE")
	private String ds_equipe;
	@Column(name = "CD_CARGO")
	private Integer cd_cargo;
	@Column(name = "CD_SETORCOMERCIAL")
	private Integer cd_setorcomercial;
	@Column(name = "DS_SETORCOMERCIAL")
	private String ds_setorcomercial;
	@Column(name = "VALOR_LIQUIDO")
	private Double valor_liquido;
	@Column(name = "TP_STATUS")
	private String tp_status;
	@Column(name = "CD_OPERACAO")
	private Integer cd_operacao;
	@Column(name = "DS_OPERACAO")
	private String ds_operacao;
	@Column(name = "CD_MOTIVOCANCELAMENTO")
	private Integer cd_motivocancelamento;
	@Column(name = "DS_MOTIVOCANCELAMENTO")
	private String ds_motivocancelamento;
	@Column(name = "CD_CLIENTE")
	private Integer cd_cliente;
	@Column(name = "NM_CLIENTE")
	private String nm_cliente;
	@Column(name = "TP_AGRUPAMENTO")
	private String tp_agrupamento;
	
	public Integer getCd_pedidovenda() {
		return cd_pedidovenda;
	}
	
	public Integer getCd_filial() {
		return cd_filial;
	}
	
	public Integer getCd_empresa() {
		return cd_empresa;
	}
	
	public String getTp_origem() {
		return tp_origem;
	}
	
	public String getDt_cadastro() {
		return dt_cadastro;
	}
	
	public String getDt_faturamento() {
		return dt_faturamento;
	}
	
	public String getDt_cancelamento() {
		return dt_cancelamento;
	}
	
	public Integer getCd_colaborador() {
		return cd_colaborador;
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
	
	public Integer getCd_cargo() {
		return cd_cargo;
	}
	
	public Integer getCd_setorcomercial() {
		return cd_setorcomercial;
	}
	
	public String getDs_setorcomercial() {
		return ds_setorcomercial;
	}
	
	public Double getValor_liquido() {
		return valor_liquido;
	}
	
	public String getTp_status() {
		return tp_status;
	}
	
	public Integer getCd_operacao() {
		return cd_operacao;
	}
	
	public String getDs_operacao() {
		return ds_operacao;
	}
	
	public Integer getCd_motivocancelamento() {
		return cd_motivocancelamento;
	}
	
	public String getDs_motivocancelamento() {
		return ds_motivocancelamento;
	}
	
	public Integer getCd_cliente() {
		return cd_cliente;
	}
	
	public String getNm_cliente() {
		return nm_cliente;
	}
	
	public String getTp_agrupamento() {
		return tp_agrupamento;
	}
}
