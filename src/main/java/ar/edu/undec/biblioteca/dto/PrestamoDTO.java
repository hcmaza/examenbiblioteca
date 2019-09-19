package ar.edu.undec.biblioteca.dto;

import ar.edu.undec.biblioteca.model.Persona;
import ar.edu.undec.biblioteca.model.Prestamoxlibro;

import java.sql.Timestamp;
import java.util.Collection;


public class PrestamoDTO {

	private Integer id;
	private Timestamp fechainicio;
	private Timestamp fechafin;
	private Persona personaByPersonaid;
	private Collection<PrestamoxlibroDTO> prestamoxlibrosById;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Timestamp getFechafin() {
		return fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Persona getPersonaByPersonaid() {
		return personaByPersonaid;
	}

	public void setPersonaByPersonaid(Persona personaByPersonaid) {
		this.personaByPersonaid = personaByPersonaid;
	}

	public Collection<PrestamoxlibroDTO> getPrestamoxlibrosById() {
		return prestamoxlibrosById;
	}

	public void setPrestamoxlibrosById(Collection<PrestamoxlibroDTO> prestamoxlibrosById) {
		this.prestamoxlibrosById = prestamoxlibrosById;
	}
}
