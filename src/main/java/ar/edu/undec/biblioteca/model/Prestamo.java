package ar.edu.undec.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prestamo implements Serializable {
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechainicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechafin;
    private Persona personaByPersonaid;
    private Collection<Prestamoxlibro> prestamoxlibrosById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fechainicio", nullable = true)
    public Timestamp getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Basic
    @Column(name = "fechafin", nullable = true)
    public Timestamp getFechafin() {
        return fechafin;
    }

    public void setFechafin(Timestamp fechafin) {
        this.fechafin = fechafin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(id, prestamo.id) &&
                Objects.equals(fechainicio, prestamo.fechainicio) &&
                Objects.equals(fechafin, prestamo.fechafin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechainicio, fechafin);
    }

    @ManyToOne
    @JoinColumn(name = "personaid", referencedColumnName = "id")
    public Persona getPersonaByPersonaid() {
        return personaByPersonaid;
    }

    public void setPersonaByPersonaid(Persona personaByPersonaid) {
        this.personaByPersonaid = personaByPersonaid;
    }

    @OneToMany(mappedBy = "prestamoByPrestamoid")
    public Collection<Prestamoxlibro> getPrestamoxlibrosById() {
        return prestamoxlibrosById;
    }

    public void setPrestamoxlibrosById(Collection<Prestamoxlibro> prestamoxlibrosById) {
        this.prestamoxlibrosById = prestamoxlibrosById;
    }
}
