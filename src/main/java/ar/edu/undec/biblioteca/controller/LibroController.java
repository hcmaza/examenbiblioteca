package ar.edu.undec.biblioteca.controller;

import ar.edu.undec.biblioteca.dto.Response;
import ar.edu.undec.biblioteca.model.Libro;
import ar.edu.undec.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping()
    public ResponseEntity<?> list() throws Exception {
        Response response = libroService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") int id) throws Exception {
        Response response = libroService.findOneById(String.valueOf(id));
        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<Response> create(@Valid @RequestBody Libro libro) throws Exception {
        Response response = libroService.save(libro);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable(value = "id") Integer libroId,
                                           @Valid @RequestBody Libro input) throws Exception {
        Response response = libroService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable(value = "id") Integer libroId) throws Exception  {
        Response response = libroService.delete(libroId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
