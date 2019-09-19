package ar.edu.undec.biblioteca.controller;

import ar.edu.undec.biblioteca.dto.Response;
import ar.edu.undec.biblioteca.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") int id) throws Exception {
        Response response = personaService.findOneById(String.valueOf(id));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    public ResponseEntity<?> list() throws Exception {
        Response response = personaService.findAll();
        return ResponseEntity.ok().body(response);
    }

}
