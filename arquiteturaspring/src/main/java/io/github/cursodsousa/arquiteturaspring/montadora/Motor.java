package io.github.cursodsousa.arquiteturaspring.montadora;

public class Motor {
    private String modelo;
    private Integer cavalos;
    private Integer cilindros;
    private Double litragem;
    private TipoMotor tipo;


    public String getModelo() {
        return modelo;
    }

    public Integer getCavalos() {
        return cavalos;
    }

    public Integer getCilindros() {
        return cilindros;
    }

    public Double getLitragem() {
        return litragem;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }

    public void setCavalos (Integer cavalos) {
        this.cavalos = cavalos;
    }

    public void setCilindros (Integer cilindros) {
        this.cilindros = cilindros;
    }

    public void setLitragem (Double litragem) {
        this.litragem = litragem;
    }

    public void setTipo (TipoMotor tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "modelo='" + modelo + '\'' +
                ", cavalos=" + cavalos +
                ", cilindros=" + cilindros +
                ", litragem=" + litragem +
                ", tipo=" + tipo +
                '}';
    }
}
