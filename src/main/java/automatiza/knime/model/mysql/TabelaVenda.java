package automatiza.knime.model.mysql;

public class TabelaVenda {
	private String cd_vendedor;
	private String vl_meta;
	private Integer id_meta;
	private Integer cd_filial;
	private Integer cd_equipe;
	private String dt_ano;
	private String dt_mes;
	private Integer qt_dias_estimados;
	private Integer qt_dias_percorridos;
	private Integer qt_dias_faltantes;
	private String indice_meta;
	
	public String getCd_vendedor() {
		return cd_vendedor;
	}
	
	public void setCd_vendedor(String cd_vendedor) {
		this.cd_vendedor = cd_vendedor;
	}
	
	public String getVl_meta() {
		return vl_meta;
	}
	
	public void setVl_meta(String vl_meta) {
		this.vl_meta = vl_meta;
	}
	
	public Integer getId_meta() {
		return id_meta;
	}
	
	public void setId_meta(Integer id_meta) {
		this.id_meta = id_meta;
	}
	
	public Integer getCd_filial() {
		return cd_filial;
	}
	
	public void setCd_filial(Integer cd_filial) {
		this.cd_filial = cd_filial;
	}
	
	public Integer getCd_equipe() {
		return cd_equipe;
	}
	
	public void setCd_equipe(Integer cd_equipe) {
		this.cd_equipe = cd_equipe;
	}
	
	public String getDt_ano() {
		return dt_ano;
	}
	public void setDt_ano(String dt_ano) {
		this.dt_ano = dt_ano;
	}
	
	public String getDt_mes() {
		return dt_mes;
	}
	
	public void setDt_mes(String dt_mes) {
		this.dt_mes = dt_mes;
	}
	
	public Integer getQt_dias_estimados() {
		return qt_dias_estimados;
	}
	
	public void setQt_dias_estimados(Integer qt_dias_estimados) {
		this.qt_dias_estimados = qt_dias_estimados;
	}
	public Integer getQt_dias_percorridos() {
		return qt_dias_percorridos;
	}
	
	public void setQt_dias_percorridos(Integer qt_dias_percorridos) {
		this.qt_dias_percorridos = qt_dias_percorridos;
	}
	
	public Integer getQt_dias_faltantes() {
		return qt_dias_faltantes;
	}
	
	public void setQt_dias_faltantes(Integer qt_dias_faltantes) {
		this.qt_dias_faltantes = qt_dias_faltantes;
	}
	
	public String getIndice_meta() {
		return indice_meta;
	}
	
	public void setIndice_meta(String indice_meta_vendedor) {
		this.indice_meta = indice_meta_vendedor;
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
		TabelaVenda other = (TabelaVenda) obj;
		if (indice_meta == null) {
			if (other.indice_meta != null)
				return false;
		} else if (!indice_meta.equals(other.indice_meta))
			return false;
		return true;
	}
	
	
}
