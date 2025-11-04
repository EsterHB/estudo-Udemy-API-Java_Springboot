package io.github.cursodsousa.arquiteturaspring.montadora;

import java.awt.*;

public class Carro {
    private String modelo;
    private Color cor;
    private Motor motor;
    private Montadora  montadora;


    //Carro depende de motor, ele precisa do motor, então deve-se fazer esse consturor
    //para indicar essa dependência do Carro para com o Motor.
    public Carro(Motor motor) {
        this.motor  = motor;
    }


    public String getModelo() {
        return modelo;
    }

    public Color getCor() {
        return cor;
    }

    public Motor getMotor() {
        return motor;
    }

    public Montadora getMontadora() {
        return montadora;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }

    public void setCor (Color cor) {
        this.cor = cor;
    }

    public void setMotor (Motor motor) {
        this.motor = motor;
    }

    public void setMontadora (Montadora montadora) {
        this.montadora = montadora;
    }

}
