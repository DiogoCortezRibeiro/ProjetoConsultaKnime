package automatiza.knime.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import automatiza.knime.controller.oracle.dto.ColaboradorVendaRepository;
import automatiza.knime.model.oracle.ColaboradorVenda;

@Service
public class ColaboradorVendaService {
	@Autowired
	ColaboradorVendaRepository colaboradorVendaRepository;
	
	@Scheduled(fixedDelay = 100000L)
	public void getVendasColaboradores() {
		List<ColaboradorVenda> vendasColaboradores = colaboradorVendaRepository.getVendasColaborador();
		String path = "C:\\temp\\vendasColaboradores.csv";
		DecimalFormat df = new DecimalFormat("###,###.00");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("CD_EMPRESA");
			bw.write(",CD_FILIAL");
			bw.write(",CD_COLABORADOR");
			bw.write(",NM_COLABORADOR");
			bw.write(",CD_EQUIPE");
			bw.write(",DS_EQUIPE");
			bw.write(",MES_FATURAMENTO");
			bw.write(",VALOR_LIQUIDO");
			bw.write(",indice_meta_vendedor");
			bw.write(",DT_FATURAMENTO");
			bw.newLine();
			for(ColaboradorVenda cv : vendasColaboradores) {
				String valor = df.format(cv.getValor_liquido());
				bw.write(""+cv.getCd_empresa()+"");
				bw.write(","+cv.getCd_filial()+"");
				bw.write(","+cv.getCd_colaborador()+"");
				bw.write(",\""+cv.getNm_colaborador()+"\"");
				bw.write(","+cv.getCd_equipe()+"");
				bw.write(",\""+cv.getDs_equipe()+"\"");
				bw.write(",\""+cv.getMes_faturamento()+"\"");
				bw.write(",\""+valor+"\"");
				bw.write(",\""+cv.getIndice_meta()+"\"");
				bw.write(",\""+cv.getDt_faturamento()+"\"");
				bw.newLine();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
