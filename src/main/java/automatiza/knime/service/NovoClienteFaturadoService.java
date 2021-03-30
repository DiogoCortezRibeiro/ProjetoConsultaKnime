package automatiza.knime.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import automatiza.knime.controller.oracle.dto.NovoClienteFaturadoRepository;
import automatiza.knime.model.oracle.NovoClienteFaturado;

@Service
public class NovoClienteFaturadoService {
	@Autowired
	NovoClienteFaturadoRepository novoClienteFaturadoRepository;
	
	//@Scheduled(fixedDelay = 100000L)
	public void getFaturados() {
		List<NovoClienteFaturado> novosFaturados = novoClienteFaturadoRepository.getNovosClientesFaturados();
		String path = "C:\\temp\\novosFaturados.csv";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("IDENTIFICADOR");
			bw.write(",DS_OPERADOR");
			bw.write(",DH_CADASTRO");
			bw.write(",DH_CONCLUSAO");
			bw.write(",CD_PESSOA");
			bw.write(",NM_PESSOA");
			bw.write(",CD_OPERADOR");
			bw.write(",CD_ACAO");
			bw.write(",DS_ACAO");
			bw.write(",CD_RESULTADOACAO");
			bw.write(",DS_RESULTADOACAO");
			bw.write(",ID_PROTOCOLO");
			bw.write(",STATUS");
			bw.write(",RESULTADO");
			bw.newLine();
			for(NovoClienteFaturado ncf : novosFaturados) {
				bw.write(""+ncf.getId_contatopessoa()+"");
				bw.write(",\""+ncf.getDs_operador()+"\"");
				bw.write(",\""+ncf.getDh_cadastro()+"\"");
				bw.write(",\""+ncf.getDh_conclusao()+"\"");
				bw.write(",\""+ncf.getCd_pessoa()+"\"");
				bw.write(",\""+ncf.getNm_pessoa()+"\"");
				bw.write(","+ncf.getCd_operador()+"");
				bw.write(","+ncf.getCd_acao()+"");
				bw.write(",\""+ncf.getDs_Acao()+"\"");
				bw.write(","+ncf.getCd_resultadoacao()+"");
				bw.write(",\""+ncf.getDs_resultadoacao()+"\"");
				bw.write(",\""+ncf.getId_protocolo()+"\"");
				bw.write(",\""+ncf.getTp_status()+"\"");
				bw.write(",\""+((ncf.getResultado() != null) ? ncf.getResultado().replaceAll("\n","").replaceAll("\r","") : "")+"\"");
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
