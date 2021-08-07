package br.lippe.devaneios.devaneios.db;


import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CausoService {

	@Autowired
	private CausoRepository causoRepository;
	
	@Autowired
	private UserRepo usp;

	public Causo store(String nome_user, MultipartFile file) throws IOException {
		//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		//Causo causo = new Causo(fileName, file.getContentType(), file.getBytes());
		User_old us = new User_old ();
		us.setNome(nome_user);
		usp.save(us);

		Causo causo = new Causo(
			nome_user,
			33L,
			77L,
			file.getContentType(),
			"---descrição fixaaa---",
			us,
			file.getBytes()
		);

		//List<Causo> l = new ArrayList<>();
		//l.add(causo);
		//us.setCauso(l);
//		causoRepository.save(causo);
		

		return causoRepository.save(causo);
	}

	public Causo getFile(String id) {
		return causoRepository.findById(id).get();
	}

	public Stream<Causo> getAllFiles() {
		return causoRepository.findAll().stream();
	}

	public String deletFileById(String id) {
		if (causoRepository.existsById(id)) {
			causoRepository.deleteById(id);
			return "File has been successfully deleted";
		}
		return "File doesn't exist";
	}
}