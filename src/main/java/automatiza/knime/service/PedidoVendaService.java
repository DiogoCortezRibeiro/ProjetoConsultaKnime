package automatiza.knime.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import automatiza.knime.controller.oracle.dto.PedidoVendaRepository;
import automatiza.knime.model.oracle.PedidoVenda;

@Service
public class PedidoVendaService {
	@Autowired
	PedidoVendaRepository pedidoVendaRepository;
	
	//@Scheduled(fixedDelay = 100000L)
	public void getPedidos() {
		List<PedidoVenda> pedidosVenda = pedidoVendaRepository.getPedidosVenda();
		String path = "C:\\temp\\pedidosVendas.csv";
		DecimalFormat df = new DecimalFormat("###,###.00");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("CD_EMPRESA");
			bw.write(",CD_FILIAL");
			bw.write(",CD_PEDIDOVENDA");
			bw.write(",TP_ORIGEM");
			bw.write(",DT_CADASTRO");
			bw.write(",DT_FATURAMENTO");
			bw.write(",DT_CANCELAMENTO");
			bw.write(",CD_COLABORADOR");
			bw.write(",NM_COLABORADOR");
			bw.write(",CD_EQUIPE");
			bw.write(",DS_EQUIPE");
			bw.write(",CD_CARGO");
			bw.write(",CD_SETORCOMERCIAL");
			bw.write(",DS_SETORCOMERCIAL");
			bw.write(",VALOR_LIQUIDO");
			bw.write(",TP_STATUS");
			bw.write(",CD_OPERACAO");
			bw.write(",DS_OPERACAO");
			bw.write(",CD_MOTIVOCANCELAMENTO");
			bw.write(",DS_MOTIVOCANCELAMENTO");
			bw.write(",CD_CLIENTE");
			bw.write(",NM_CLIENTE");
			bw.write(",TP_AGRUPAMENTO");
			bw.newLine();
			for(PedidoVenda pv : pedidosVenda) {
				String valor = df.format(pv.getValor_liquido());
				bw.write(""+pv.getCd_empresa()+"");
				bw.write(","+pv.getCd_filial()+"");
				bw.write(","+pv.getCd_pedidovenda()+"");
				bw.write(",\""+pv.getTp_status()+"\"");
				bw.write(",\""+pv.getDt_cadastro()+"\"");
				bw.write(",\""+pv.getDt_faturamento()+"\"");
				bw.write(",\""+pv.getDt_cancelamento()+"\"");
				bw.write(","+pv.getCd_colaborador()+"");
				bw.write(",\""+pv.getNm_colaborador()+"\"");
				bw.write(","+pv.getCd_equipe()+"");
				bw.write(",\""+pv.getDs_equipe()+"\"");
				bw.write(","+pv.getCd_cargo()+"");
				bw.write(","+pv.getCd_setorcomercial()+"");
				bw.write(",\""+pv.getDs_setorcomercial()+"\"");
				bw.write(",\""+valor+"\"");
				bw.write(",\""+pv.getTp_status()+"\"");
				bw.write(","+pv.getCd_operacao()+"");
				bw.write(",\""+pv.getDs_operacao()+"\"");
				bw.write(","+pv.getCd_motivocancelamento()+"");
				bw.write(",\""+pv.getDs_motivocancelamento()+"\"");
				bw.write(","+pv.getCd_cliente()+"");
				bw.write(",\""+pv.getNm_cliente()+"\"");
				bw.write(",\""+pv.getTp_agrupamento()+"\"");
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
