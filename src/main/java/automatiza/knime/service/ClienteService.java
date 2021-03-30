package automatiza.knime.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import automatiza.knime.controller.oracle.dto.ClienteRepository;
import automatiza.knime.model.oracle.Cliente;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	//@Scheduled(fixedDelay = 100000L)
	public void getClientes() {
		List<Cliente> clientes = clienteRepository.getClientes();
		String path = "C:\\temp\\clientes.csv";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("CD_PESSOA");
			bw.write(",NM_PESSOA");
			bw.write(",CD_UF");
			bw.write(",CIDADE");
			bw.write(",DS_RAMOATIVIDADE");
			bw.newLine();
			for(Cliente c : clientes) {
				bw.write(""+c.getCd_pessoa()+"");
				bw.write(",\""+c.getNm_pessoa().replace("\"", "")+"\"");
				bw.write(",\""+c.getCd_uf()+"\"");
				bw.write(",\""+c.getCidade()+"\"");
				bw.write(",\""+c.getDs_ramoatividade()+"\"");
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
