package entity;

/**
 * Created by Agatino D'Agate on 28/06/2017.
 */
public class Modello {

    Integer id;
    String modello;

    public Modello() {
    }

    public Modello(Integer id, String modello) {
        this.id = id;
        this.modello = modello;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    @Override
    public String toString() {
        return "{" + this.id + "," + this.modello + "}";
    }
}
