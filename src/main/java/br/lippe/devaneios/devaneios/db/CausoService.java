package br.lippe.devaneios.devaneios.db;


import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class CausoService {

	@Autowired
	private CausoRepository causoRepository;

	public Causo store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Causo causo = new Causo(fileName, file.getContentType(), file.getBytes());

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