package entity;

/**
 * Created by Valerio on 28/06/2017.
 */
public class Rel_marca_categoria {

    Integer id_relazione;
    Integer fk_modello;
    Integer fk_marca;
    Integer fk_categoria;

    public Rel_marca_categoria() {}

    public Rel_marca_categoria(Integer id_relazione, Integer fk_modello, Integer fk_marca, Integer fk_categoria) {
        this.id_relazione = id_relazione;
        this.fk_modello = fk_modello;
        this.fk_marca = fk_marca;
        this.fk_categoria = fk_categoria;
    }

    public Integer getId_relazione() {
        return id_relazione;
    }

    public void setId_relazione(Integer id_relazione) {
        this.id_relazione = id_relazione;
    }

    public Integer getFk_modello() {
        return fk_modello;
    }

    public void setFk_modello(Integer fk_modello) {
        this.fk_modello = fk_modello;
    }

    public Integer getFk_marca() {
        return fk_marca;
    }

    public void setFk_marca(Integer fk_marca) {
        this.fk_marca = fk_marca;
    }

    public Integer getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(Integer fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    @Override
    public String toString() {
        return "{"
                + this.id_relazione + ","
                + this.fk_modello + ","
                + this.fk_marca + ","
                + this.fk_categoria +
                "}";
    }
}
