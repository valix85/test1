package entity;

/**
 * Created by nextre0029 on 28/06/2017.
 */
public class Marca {
    Integer id;
    String marca;

    public Marca() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Marca(Integer id, String marca) {

        this.id = id;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "{"+ this.id + ","
                + this.marca + "}" ;
    }
}
