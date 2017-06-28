package entity;

/**
 * Created by stefano.marzani on 28/06/2017.
 */
public class Colore {
    Integer id;
    String nome;

    public Colore() {
    }

    public Colore(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{" +
                id +
                "," + nome +
                '}';
    }
}
