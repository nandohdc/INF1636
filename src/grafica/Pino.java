package grafica;

import java.awt.*;
import javax.swing.*;
import regras.*;

@SuppressWarnings("serial")
public class Pino extends JComponent{
	
	House[] Caminhooo = new House[59];
	int casa;
	int numero;
	Color cor;
	
	public Pino(House[] CaminhoColorido, PinoEstruturado pino){
		this.Caminhooo = CaminhoColorido;
		this.casa = pino.getCasa();
		this.numero = pino.getNumero();
		this.cor = pino.getColor();
	}
}
