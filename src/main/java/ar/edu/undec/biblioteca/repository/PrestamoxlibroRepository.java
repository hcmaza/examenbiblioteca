package ar.edu.undec.biblioteca.repository;

import ar.edu.undec.biblioteca.model.Prestamoxlibro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrestamoxlibroRepository extends JpaRepository<Prestamoxlibro, Integer> {
}