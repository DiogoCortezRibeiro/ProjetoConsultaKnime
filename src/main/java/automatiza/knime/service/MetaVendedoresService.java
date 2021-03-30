package automatiza.knime.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import automatiza.knime.controller.mysql.dto.MetaVendedoresRepository;
import automatiza.knime.controller.oracle.dto.ColaboradorVendaRepository;
import automatiza.knime.model.mysql.Meta;
import automatiza.knime.model.mysql.MetaConvertida;
import automatiza.knime.model.mysql.MetaVendedores;
import automatiza.knime.model.mysql.TabelaVenda;
import automatiza.knime.model.oracle.ColaboradorVenda;
import automatiza.knime.model.oracle.RelatorioVendaMeta;

@Service
public class MetaVendedoresService {
	@Autowired
	MetaVendedoresRepository metaVendedoresRepository;
	
	@Autowired
	ColaboradorVendaRepository colaboradorVendaRepository;
	
	@SuppressWarnings("unchecked")
	@Scheduled(fixedDelay = 100000L)
	public void getItemPedidoVenda() {  
		List<MetaVendedores> metaVendedores = metaVendedoresRepository.getMetasVendedores();
		List<MetaConvertida> metaConvertida = new ArrayList<>();
		metaConvertida = this.converteJsonMetas(metaVendedores);
		
		List<TabelaVenda> tabelaMysql = new ArrayList<>();
		tabelaMysql = this.getVendas(metaConvertida);
		List<ColaboradorVenda> tabelaOracle =  colaboradorVendaRepository.getVendasColaborador();
		
		
		
		Set<RelatorioVendaMeta> relatorio = new HashSet<>();
		
		for(ColaboradorVenda oracle : tabelaOracle) {
			for(TabelaVenda mysql : tabelaMysql) {
				if(mysql.getIndice_meta().equals(oracle.getIndice_meta())){
					RelatorioVendaMeta rv = new RelatorioVendaMeta();
					rv.setVl_meta(mysql.getVl_meta());
					rv.setDt_faturamento(oracle.getDt_faturamento());
					rv.setCd_colaborador(oracle.getCd_colaborador());
					rv.setIndice_meta(mysql.getIndice_meta());
					relatorio.add(rv);
				}
			}
		}
		
	}
	
	public List<TabelaVenda> getVendas(List<MetaConvertida> metas) {
		List<TabelaVenda> tabelaMysql = new ArrayList<>();
		
		for(MetaConvertida mt : metas) {
			for(Meta meta : mt.getVl_meta()) {
				if(!meta.getValor_meta().equals("0,00")) {
					TabelaVenda aux = new TabelaVenda();
					aux.setDt_mes((mt.getDt_mes() < 10 ? 0 +""+ mt.getDt_mes() : ""+mt.getDt_mes()));
					aux.setCd_vendedor(meta.getCd_colaborador());
					aux.setVl_meta(meta.getValor_meta());
					aux.setId_meta(mt.getId_meta());
					aux.setCd_filial(mt.getCd_filial());
					aux.setCd_equipe(mt.getCd_equipe());
					aux.setDt_ano(mt.getDt_ano());
					aux.setDt_mes((mt.getDt_mes() < 10 ? 0 +""+ mt.getDt_mes() : ""+mt.getDt_mes()));
					aux.setQt_dias_estimados(mt.getQt_dias_estimados());
					aux.setQt_dias_percorridos(mt.getQt_dias_perccorridos());
					aux.setQt_dias_faltantes(aux.getQt_dias_estimados() - aux.getQt_dias_percorridos());
					aux.setIndice_meta(mt.getDt_ano() + '-' + (mt.getDt_mes() < 10 ? 0 +""+ mt.getDt_mes() : ""+mt.getDt_mes()) + '-' + meta.getCd_colaborador());
					tabelaMysql.add(aux);
				}
			}
		}
		return tabelaMysql;
	}
	
	public List<MetaConvertida> converteJsonMetas(List<MetaVendedores> metas) {
		List<MetaConvertida> metaConvertida = new ArrayList<>();
		
		for(MetaVendedores m : metas) {
			MetaConvertida aux = new MetaConvertida();
			aux.setId_meta(m.getId_meta());
			aux.setCd_filial(m.getCd_filial());
			aux.setCd_equipe(m.getCd_equipe());
			aux.setDt_ano(m.getDt_ano());
			aux.setDt_mes(m.getDt_mes());
			aux.setQt_dias_estimados(m.getQt_dias_estimados());
			aux.setQt_dias_perccorridos(m.getQt_dias_percorridos());
			
			Gson gson = new Gson();
			Map<String,Object> map = new HashMap<String,Object>();
			map = (Map<String,Object>) gson.fromJson(m.getVl_meta(), map.getClass());
			List<Meta> listaMeta = new ArrayList<>();
			
			for (Map.Entry<String,Object> map1 : map.entrySet()) {
				Meta meta = new Meta();
				meta.setCd_colaborador(map1.getKey());
				meta.setValor_meta((String) map1.getValue());
				listaMeta.add(meta);
			}
			aux.setVl_meta(listaMeta);
			listaMeta.clear();
			metaConvertida.add(aux);
		}
		
		return metaConvertida;
	}
	
	public List<HashMap> normalizarListaRevendas(List<TabelaVenda> listaDB1, List<ColaboradorVenda> listaVI){
        if(listaDB1 != null){
            return listaDB1.stream().map( item -> {
				HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("indice_meta", item.getIndice_meta());
​
                return hashMap;
            }).collect(Collectors.toList());
        } else {
            return listaVI.stream().map(item -> {
            	HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("indice_meta", item.getIndice_meta());
​
                return hashMap;
            }).collect(Collectors.toList());
        }
    }
}
