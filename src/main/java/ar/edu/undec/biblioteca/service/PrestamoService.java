package ar.edu.undec.biblioteca.service;

import ar.edu.undec.biblioteca.dto.PrestamoDTO;
import ar.edu.undec.biblioteca.dto.PrestamoxlibroDTO;
import ar.edu.undec.biblioteca.dto.Response;
import ar.edu.undec.biblioteca.model.Prestamo;
import ar.edu.undec.biblioteca.model.Prestamoxlibro;
import ar.edu.undec.biblioteca.repository.LibroRepository;
import ar.edu.undec.biblioteca.repository.PersonaRepository;
import ar.edu.undec.biblioteca.repository.PrestamoRepository;
import ar.edu.undec.biblioteca.repository.PrestamoxlibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class PrestamoService {

    static final Logger LOGGER = LoggerFactory.getLogger(PrestamoService.class);

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private PrestamoxlibroRepository prestamoxlibroRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        try {
            List<Prestamo> prestamoList = prestamoRepository.findAll();
            response.setData(prestamoList);
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
            Prestamo prestamo = prestamoRepository.findById(Integer.parseInt(id)).get();
            response.setData(prestamo);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(PrestamoDTO input) throws Exception {
        Response response = new Response();
        try {
            Prestamo factura = prestamoRepository.findById(input.getId()).get();
            prestamoRepository.save(factura);

            response.setData(input);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(PrestamoDTO prestamoDTO) throws Exception {
        Response response = new Response();
        try {
            Prestamo prestamo = prestamoDTOToEntity(prestamoDTO);
            prestamo = prestamoRepository.save(prestamo);

            for (PrestamoxlibroDTO item : prestamoDTO.getPrestamoxlibrosById()) {
                Prestamoxlibro prestamoxlibro = prestamoxlibroDTOToEntity(prestamo, item);
                prestamoxlibro = prestamoxlibroRepository.save(prestamoxlibro);
            }

            response.setData(prestamo.getId());

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    private Prestamo prestamoDTOToEntity(PrestamoDTO prestamoDTO) throws Exception {
        Prestamo prestamo = new Prestamo();
        prestamo.setFechafin(prestamoDTO.getFechafin());
        prestamo.setFechainicio((Timestamp) new Date());
        prestamo.setPersonaByPersonaid(personaRepository.getOne(prestamoDTO.getId()));
        return prestamo;
    }

    private Prestamoxlibro prestamoxlibroDTOToEntity(Prestamo prestamo, PrestamoxlibroDTO prestamoxlibroDTO) throws Exception {
        Prestamoxlibro prestamoxlibro = new Prestamoxlibro();
        prestamoxlibro.setPrestamoByPrestamoid(prestamo);
        prestamoxlibro.setLibroByLibroid(libroRepository.getOne(prestamoxlibro.getLibroByLibroid().getId()));

        return prestamoxlibro;
    }

}