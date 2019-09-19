package ar.edu.undec.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Libro implements Serializable {
    private Integer id;
    private String titulo;
    private Integer cantidadpaginas;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapublicacion;
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
    @Column(name = "titulo", nullable = true, length = 60)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "cantidadpaginas", nullable = true)
    public Integer getCantidadpaginas() {
        return cantidadpaginas;
    }

    public void setCantidadpaginas(Integer cantidadpaginas) {
        this.cantidadpaginas = cantidadpaginas;
    }

    @Basic
    @Column(name = "fechapublicacion", nullable = true)
    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id) &&
                Objects.equals(titulo, libro.titulo) &&
                Objects.equals(cantidadpaginas, libro.cantidadpaginas) &&
                Objects.equals(fechapublicacion, libro.fechapublicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, cantidadpaginas, fechapublicacion);
    }

    @OneToMany(mappedBy = "libroByLibroid")
    @JsonIgnore
    public Collection<Prestamoxlibro> getPrestamoxlibrosById() {
        return prestamoxlibrosById;
    }

    public void setPrestamoxlibrosById(Collection<Prestamoxlibro> prestamoxlibrosById) {
        this.prestamoxlibrosById = prestamoxlibrosById;
    }
}
