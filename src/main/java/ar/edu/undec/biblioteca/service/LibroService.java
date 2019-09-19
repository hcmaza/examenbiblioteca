package ar.edu.undec.biblioteca.service;

import ar.edu.undec.biblioteca.dto.Response;
import ar.edu.undec.biblioteca.model.Libro;
import ar.edu.undec.biblioteca.repository.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibroService {

    static final Logger LOGGER = LoggerFactory.getLogger(LibroService.class);

    @Autowired
    private LibroRepository libroRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        try {
            List<Libro> libroList = libroRepository.findAll();
            response.setData(libroList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }
    public Response findOneById(String id) throws Exception {
        Response response = new Response();
        try {
            Libro libro = libroRepository.findById(Integer.parseInt(id)).get();
            response.setData(libro);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }


    public Response update(Libro input) throws Exception {
        Response response = new Response();
        try {
            Libro libro = libroRepository.findById(input.getId()).get();
            libro.setTitulo(input.getTitulo());
            libro.setCantidadpaginas(input.getCantidadpaginas());
            libro.setFechapublicacion(input.getFechapublicacion());
            libroRepository.save(libro);

            response.setData(input);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(Libro libro) throws Exception {
        Response response = new Response();
        try {

            libroRepository.save(libro);

            response.setData(libro);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(Integer id) throws Exception {
        Response response = new Response();
        try {
            Libro libro = libroRepository.getOne(id);
            libroRepository.delete(libro);
            response.setData(libro);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }



}