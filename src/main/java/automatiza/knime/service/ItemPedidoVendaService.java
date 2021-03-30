package automatiza.knime.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import automatiza.knime.controller.oracle.dto.ItemPedidoVendaRepository;
import automatiza.knime.model.oracle.ItemPedidoVenda;

@Service
public class ItemPedidoVendaService {
	@Autowired
	ItemPedidoVendaRepository itemPedidoRepository;
	
	//@Scheduled(fixedDelay = 100000L)
	public void getItemPedidoVenda() {  
		List<ItemPedidoVenda> itemsPedido = itemPedidoRepository.getItemPedidosVenda();
		String path = "C:\\temp\\itemsPedidos.csv";
		DecimalFormat df = new DecimalFormat("###,###.00");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("CD_PRODUTO");
			bw.write(",QT_PEDIDO");
			bw.write(",VL_TOTAL_LIQUIDO");
			bw.write(",CD_EMPRESA");
			bw.write(",CD_FILIAL");
			bw.write(",CD_PEDIDOVENDA");
			bw.write(",CD_MOTIVOCANCELAMENTO");
			bw.write(",DT_CANCELAMENTO");
			bw.write(",DS_MOTIVOCANCELAMENTO");
			bw.newLine();
			for(ItemPedidoVenda pv : itemsPedido) {
				String valor = df.format(pv.getVl_total_liquido());
				bw.write(""+pv.getCd_produto()+"");
				bw.write(","+pv.getQt_pedido()+"");
				bw.write(",\""+valor+"\"");
				bw.write(","+pv.getCd_empresa()+"");
				bw.write(","+pv.getCd_filial()+"");
				bw.write(","+pv.getCd_pedidovenda()+"");
				bw.write(","+pv.getCd_motivocancelamento()+"");
				bw.write(",\""+pv.getDt_cancelamento()+"\"");
				bw.write(",\""+pv.getDs_motivocancelamento()+"\"");
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
