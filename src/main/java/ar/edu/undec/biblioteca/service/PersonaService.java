package ar.edu.undec.biblioteca.service;

import ar.edu.undec.biblioteca.dto.Response;
import ar.edu.undec.biblioteca.model.Persona;
import ar.edu.undec.biblioteca.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonaService {

    static final Logger LOGGER = LoggerFactory.getLogger(PersonaService.class);

    @Autowired
    private PersonaRepository personaRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        try {
            List<Persona> personaList = personaRepository.findAll();
            response.setData(personaList);
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
            Persona persona = personaRepository.findById(Integer.parseInt(id)).get();
            response.setData(persona);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

}