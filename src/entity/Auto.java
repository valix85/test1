package entity;

import java.time.LocalDate;

/**
 * Created by Rivolta Fabio on 28/06/2017.
 */
public class Auto {
    Integer id;
    String numeroTelaio;
    String targa;
    Integer kilometri;
    Boolean noleggiata;
    LocalDate data_scadenza_assicurazione;
    double prezzoGiornaliero;
    Integer n_Porte;
    Integer fk_rel_marca_categoria;
    Integer fk_colore;

    public Auto() {
    }

    public Auto(Integer id, String numeroTelaio, String targa, Integer kilometri, Boolean noleggiata, LocalDate data_scadenza_assicurazione, Integer prezzoGiornaliero, Integer n_Porte, Integer fk_rel_marca_categoria, Integer fk_colore) {
        this.id = id;
        this.numeroTelaio = numeroTelaio;
        this.targa = targa;
        this.kilometri = kilometri;
        this.noleggiata = noleggiata;
        this.data_scadenza_assicurazione = data_scadenza_assicurazione;
        this.prezzoGiornaliero = prezzoGiornaliero;
        this.n_Porte = n_Porte;
        this.fk_rel_marca_categoria = fk_rel_marca_categoria;
        this.fk_colore = fk_colore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroTelaio() {
        return numeroTelaio;
    }

    public void setNumeroTelaio(String numeroTelaio) {
        this.numeroTelaio = numeroTelaio;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Integer getKilometri() {
        return kilometri;
    }

    public void setKilometri(Integer kilometri) {
        this.kilometri = kilometri;
    }

    public Boolean isNoleggiata() {
        return noleggiata;
    }

    public void setNoleggiata(Boolean noleggiata) {
        this.noleggiata = noleggiata;
    }

    public LocalDate getData_scadenza_assicurazione() {
        return data_scadenza_assicurazione;
    }

    public void setData_scadenza_assicurazione(LocalDate data_scadenza_assicurazione) {
        this.data_scadenza_assicurazione = data_scadenza_assicurazione;
    }

    public Double getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    public void setPrezzoGiornaliero(Double prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    public Integer getN_Porte() {
        return n_Porte;
    }

    public void setN_Porte(Integer n_Porte) {
        this.n_Porte = n_Porte;
    }

    public Integer getFk_rel_marca_categoria() {
        return fk_rel_marca_categoria;
    }

    public void setFk_rel_marca_categoria(Integer fk_rel_marca_categoria) {
        this.fk_rel_marca_categoria = fk_rel_marca_categoria;
    }

    public Integer getFk_colore() {
        return fk_colore;
    }

    public void setFk_colore(Integer fk_colore) {
        this.fk_colore = fk_colore;
    }

    @Override
    public String toString() {
        return "{"+id+","
                +numeroTelaio+","
                +targa+","
                +kilometri+","
                +noleggiata+","+
                data_scadenza_assicurazione +","
                + prezzoGiornaliero+","+
                n_Porte+","+
                fk_rel_marca_categoria+","
                +fk_colore+
                "}";
    }
}
