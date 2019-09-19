package ar.edu.undec.biblioteca.service;

import ar.edu.undec.biblioteca.dto.Response;
import ar.edu.undec.biblioteca.model.Prestamoxlibro;
import ar.edu.undec.biblioteca.repository.PrestamoxlibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PrestamoxlibroService {

    static final Logger LOGGER = LoggerFactory.getLogger(PrestamoxlibroService.class);

    @Autowired
    private PrestamoxlibroRepository prestamoxlibroRepository;

    public Response findAll() throws Exception {

        Response response = new Response();
        try {
            List<Prestamoxlibro> prestamoxlibroList = prestamoxlibroRepository.findAll();
            response.setData(prestamoxlibroList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }



}