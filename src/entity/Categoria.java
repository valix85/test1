package entity;

/**
 * Created by alberti stefano on 28/06/2017.
 */
public class Categoria {

    Integer id;
    String categoria;

    public Categoria() {
    }

    public Categoria(Integer id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "{" +
                  id +
                ",'" + categoria  +
                '}';
    }
}
