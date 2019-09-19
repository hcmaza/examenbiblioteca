package ar.edu.undec.biblioteca.controller;

import ar.edu.undec.biblioteca.dto.PrestamoDTO;
import ar.edu.undec.biblioteca.dto.Response;
import ar.edu.undec.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

	@Autowired
	private PrestamoService prestamoService;

	@PostMapping
    public ResponseEntity<?> save(@RequestBody PrestamoDTO prestamoDTO) throws Exception {
        Response response = prestamoService.save(prestamoDTO);
        return ResponseEntity.ok().body(response);
    }

	@GetMapping("/{id}")
	public ResponseEntity<Response> get(@PathVariable("id") int id) throws Exception {
		Response response = prestamoService.findOneById(String.valueOf(id));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping()
	public ResponseEntity<?> list() throws Exception {
		Response response = prestamoService.findAll();
		return ResponseEntity.ok().body(response);
	}

}
