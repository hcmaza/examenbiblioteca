package ar.edu.undec.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Persona implements Serializable {
    private Integer id;
    private String apellido;
    private String nombre;
    private String direccion;
    private String telefono;
    private Collection<Prestamo> prestamosById;

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
    @Column(name = "apellido", nullable = true, length = 30)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 60)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "direccion", nullable = true, length = 80)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "telefono", nullable = true, length = 20)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id) &&
                Objects.equals(apellido, persona.apellido) &&
                Objects.equals(nombre, persona.nombre) &&
                Objects.equals(direccion, persona.direccion) &&
                Objects.equals(telefono, persona.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellido, nombre, direccion, telefono);
    }

    @OneToMany(mappedBy = "personaByPersonaid")
    @JsonIgnore
    public Collection<Prestamo> getPrestamosById() {
        return prestamosById;
    }

    public void setPrestamosById(Collection<Prestamo> prestamosById) {
        this.prestamosById = prestamosById;
    }
}
