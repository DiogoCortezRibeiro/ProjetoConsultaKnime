package automatiza.knime.model.mysql;

import java.util.ArrayList;
import java.util.List;

public class MetaConvertida {
	private Integer id_meta;
	private Integer cd_filial;
	private Integer cd_equipe;
	private String dt_ano;
	private Integer dt_mes;
	private Integer qt_dias_estimados;
	private Integer qt_dias_perccorridos;
	private List<Meta> vl_meta = new ArrayList<>();
	
	public Integer getId_meta() {
		return id_meta;
	}
	
	public Integer getCd_filial() {
		return cd_filial;
	}
	
	public Integer getCd_equipe() {
		return cd_equipe;
	}
	
	public String getDt_ano() {
		return dt_ano;
	}
	
	public Integer getDt_mes() {
		return dt_mes;
	}
	
	public Integer getQt_dias_estimados() {
		return qt_dias_estimados;
	}
	
	public List<Meta> getVl_meta() {
		return vl_meta;
	}

	public void setId_meta(Integer id_meta) {
		this.id_meta = id_meta;
	}

	public void setCd_filial(Integer cd_filial) {
		this.cd_filial = cd_filial;
	}

	public void setCd_equipe(Integer cd_equipe) {
		this.cd_equipe = cd_equipe;
	}

	public void setDt_ano(String dt_ano) {
		this.dt_ano = dt_ano;
	}

	public void setDt_mes(Integer dt_mes) {
		this.dt_mes = dt_mes;
	}

	public void setQt_dias_estimados(Integer qt_dias_estimados) {
		this.qt_dias_estimados = qt_dias_estimados;
	}

	public void setVl_meta(List<Meta> meta) {
		this.vl_meta.addAll(meta);
	}

	public Integer getQt_dias_perccorridos() {
		return qt_dias_perccorridos;
	}

	public void setQt_dias_perccorridos(Integer qt_dias_perccorridos) {
		this.qt_dias_perccorridos = qt_dias_perccorridos;
	}

	public void apresentar() {
		System.out.println("id meta: " + this.id_meta);
		System.out.println("cd_filial: " + this.cd_filial);
		System.out.println("cd_equipe: " + this.cd_equipe);
		System.out.println("dt_ano: " + this.dt_ano);
		System.out.println("dt_mes: " + this.dt_mes);
		for(Meta mt : this.getVl_meta()) {
			System.out.println(mt);
		}
	}
}
