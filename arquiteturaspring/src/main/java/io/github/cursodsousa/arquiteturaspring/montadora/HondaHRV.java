package io.github.cursodsousa.arquiteturaspring.montadora;

import java.awt.*;

public class HondaHRV extends Carro {

    //Criar o construtor da classe super (Motor)
    public HondaHRV(Motor motor){
        super(motor);
        setModelo("HRV");
        setCor(Color.BLACK);
        setMontadora(Montadora.HONDA);
    }
}
