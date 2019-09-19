package ar.edu.undec.biblioteca.repository;

import ar.edu.undec.biblioteca.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}