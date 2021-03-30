package automatiza.knime.model.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOVENDAITEM")
public class ItemPedidoVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PRODUTO")
	private Integer cd_produto;
	@Column(name = "QT_PEDIDO")
	private Integer qt_pedido;
	@Column(name = "VL_TOTAL_LIQUIDO")
	private Double vl_total_liquido;
	@Column(name = "CD_EMPRESA")
	private Integer cd_empresa;
	@Column(name = "CD_FILIAL")
	private Integer cd_filial;
	@Column(name = "CD_PEDIDOVENDA")
	private Integer cd_pedidovenda;
	@Column(name = "CD_MOTIVOCANCELAMENTO")
	private Integer cd_motivocancelamento;
	@Column(name = "DT_CANCELAMENTO")
	private String dt_cancelamento;
	@Column(name = "DS_MOTIVOCANCELAMENTO")
	private String ds_motivocancelamento;
	
	public Integer getCd_produto() {
		return cd_produto;
	}
	
	public Integer getQt_pedido() {
		return qt_pedido;
	}
	
	public Double getVl_total_liquido() {
		return vl_total_liquido;
	}
	public Integer getCd_empresa() {
		return cd_empresa;
	}
	
	public Integer getCd_filial() {
		return cd_filial;
	}
	
	public Integer getCd_pedidovenda() {
		return cd_pedidovenda;
	}
	
	public Integer getCd_motivocancelamento() {
		return cd_motivocancelamento;
	}
	
	public String getDt_cancelamento() {
		return dt_cancelamento;
	}
	
	public String getDs_motivocancelamento() {
		return ds_motivocancelamento;
	}
	
	
}
