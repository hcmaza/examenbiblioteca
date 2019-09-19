package ar.edu.undec.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prestamoxlibro implements Serializable {
    private Integer id;
    private Libro libroByLibroid;
    private Prestamo prestamoByPrestamoid;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamoxlibro that = (Prestamoxlibro) o;
        return id.equals(that.id) &&
                libroByLibroid.equals(that.libroByLibroid) &&
                prestamoByPrestamoid.equals(that.prestamoByPrestamoid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libroByLibroid, prestamoByPrestamoid);
    }

    @ManyToOne
    @JoinColumn(name = "libroid", referencedColumnName = "id")
    public Libro getLibroByLibroid() {
        return libroByLibroid;
    }

    public void setLibroByLibroid(Libro libroByLibroid) {
        this.libroByLibroid = libroByLibroid;
    }

    @ManyToOne
    @JoinColumn(name = "prestamoid", referencedColumnName = "id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    public Prestamo getPrestamoByPrestamoid() {
        return prestamoByPrestamoid;
    }

    public void setPrestamoByPrestamoid(Prestamo prestamoByPrestamoid) {
        this.prestamoByPrestamoid = prestamoByPrestamoid;
    }
}
