package automatiza.knime.model.oracle;


public class RelatorioVendaMeta {
	private Integer cd_empresa;
	private Integer cd_filial;
	private Integer cd_colaborador;
	private String nm_colaborador;
	private Integer cd_equipe;
	private String ds_equipe;
	private Double vl_atingido;
	private String dt_faturamento;
	private String vl_meta;
	private Integer qt_dias_estimados;
	private Integer qt_dias_percorridos;
	private Integer qt_dias_faltantes;
	private Double vl_tendencia;
	private String indice_meta;
	
	
	public String getIndice_meta() {
		return indice_meta;
	}

	public void setIndice_meta(String indice_meta) {
		this.indice_meta = indice_meta;
	}

	public Integer getCd_empresa() {
		return cd_empresa;
	}
	
	public void setCd_empresa(Integer cd_empresa) {
		this.cd_empresa = cd_empresa;
	}
	
	public Integer getCd_filial() {
		return cd_filial;
	}
	
	public void setCd_filial(Integer cd_filial) {
		this.cd_filial = cd_filial;
	}
	
	public Integer getCd_colaborador() {
		return cd_colaborador;
	}
	
	public void setCd_colaborador(Integer cd_colaborador) {
		this.cd_colaborador = cd_colaborador;
	}
	
	public String getNm_colaborador() {
		return nm_colaborador;
	}
	
	public void setNm_colaborador(String nm_colaborador) {
		this.nm_colaborador = nm_colaborador;
	}
	
	public Integer getCd_equipe() {
		return cd_equipe;
	}
	
	public void setCd_equipe(Integer cd_equipe) {
		this.cd_equipe = cd_equipe;
	}
	
	public String getDs_equipe() {
		return ds_equipe;
	}
	
	public void setDs_equipe(String ds_equipe) {
		this.ds_equipe = ds_equipe;
	}
	
	public Double getVl_atingido() {
		return vl_atingido;
	}
	
	public void setVl_atingido(Double vl_atingido) {
		this.vl_atingido = vl_atingido;
	}
	
	public String getDt_faturamento() {
		return dt_faturamento;
	}
	
	public void setDt_faturamento(String dt_faturamento) {
		this.dt_faturamento = dt_faturamento;
	}
	
	public String getVl_meta() {
		return vl_meta;
	}
	
	public void setVl_meta(String vl_meta) {
		this.vl_meta = vl_meta;
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
	
	public Double getVl_tendencia() {
		return vl_tendencia;
	}
	
	public void setVl_tendencia(Double vl_tendencia) {
		this.vl_tendencia = vl_tendencia;
	}

	public void apresentar() {
		System.out.println("Vl_atingido: " + this.vl_atingido);
		System.out.println("Dt_faturamento: " + this.dt_faturamento);
		System.out.println("Valor meta: " + this.vl_meta);
		System.out.println("Indice: " + this.indice_meta);
	}
}
