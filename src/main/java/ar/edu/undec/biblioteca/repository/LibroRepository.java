package ar.edu.undec.biblioteca.repository;

import ar.edu.undec.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepository extends JpaRepository<Libro, Integer> {
}