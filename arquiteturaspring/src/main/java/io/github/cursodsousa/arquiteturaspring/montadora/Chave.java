package io.github.cursodsousa.arquiteturaspring.montadora;

public class Chave {
    private Montadora montadora;
    private String tipo;



    public Montadora getMontadora () {
        return montadora;
    }

    public String getTipo () {
        return tipo;
    }

    public void setMontadora (Montadora montadora) {
        this.montadora = montadora;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }


}
