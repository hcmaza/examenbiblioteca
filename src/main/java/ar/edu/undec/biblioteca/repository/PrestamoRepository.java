package ar.edu.undec.biblioteca.repository;

import ar.edu.undec.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}