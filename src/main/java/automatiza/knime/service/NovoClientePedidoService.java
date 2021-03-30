package automatiza.knime.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import automatiza.knime.controller.oracle.dto.NovoClientePedidoRepository;
import automatiza.knime.model.oracle.NovoClientePedidos;

@Service
public class NovoClientePedidoService {
	@Autowired
	NovoClientePedidoRepository novoClientePedidoRepository;
	
	@Scheduled(fixedDelay = 100000L)
	public void getNovosClientePedidos() throws ParseException {
		List<NovoClientePedidos> novosClientes = novoClientePedidoRepository.getNovosClientesPedidos();
		String path = "C:\\temp\\novosClientesPedidos.csv";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("CD_COLABORADOR");
			bw.write(",NM_COLABORADOR");
			bw.write(",CD_CLIENTE");
			bw.write(",DT_EMISSAO");
			bw.newLine();
			for(NovoClientePedidos nc : novosClientes) {
				bw.write(""+nc.getCd_colaborador()+"");
				bw.write(",\""+nc.getNm_colaborador()+"\"");
				bw.write(","+nc.getCd_cliente()+"");
				bw.write(",\""+nc.getDt_emissao()+"\"");
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
