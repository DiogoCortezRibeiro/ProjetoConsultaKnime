package automatiza.knime.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import automatiza.knime.controller.oracle.dto.VendedorRepository;
import automatiza.knime.model.oracle.Vendedor;

@Service
public class VendedorService {
	@Autowired
	VendedorRepository vendedorRepository;
	
	//@Scheduled(fixedDelay = 100000L)
	public void getVendedores() {
		List<Vendedor> vendedores = vendedorRepository.getVendedores();
		String path = "C:\\temp\\vendedores.csv";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("CD_COLABORADOR");
			bw.write(",NM_COLABORADOR");
			bw.write(",CD_UF");
			bw.write(",CIDADE");
			bw.write(",CD_EQUIPE");
			bw.write(",DS_EQUIPE");
			bw.newLine();
			for (Vendedor v : vendedores) {
				bw.write(""+v.getCd_pessoa()+"");
				bw.write(",\""+v.getNm_pessoa()+"\"");
				bw.write(",\""+v.getCd_uf()+"\"");
				bw.write(",\""+v.getCidade()+"\"");
				bw.write(","+v.getCd_equipe()+"");
				bw.write(",\""+v.getDs_equipe()+"\"");
				bw.newLine();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
