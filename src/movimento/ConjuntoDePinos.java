package movimento;

import java.awt.Color;

public class ConjuntoDePinos {
	public static PinoEstruturado[] GreenPino = new PinoEstruturado[4];
	public static PinoEstruturado[] RedPino = new PinoEstruturado[4];
	public static PinoEstruturado[] BluePino = new PinoEstruturado[4];
	public static PinoEstruturado[] YellowPino = new PinoEstruturado[4];
	public static int verde6;
	public static int vermelho6;
	public static int azul6;
	public static int amarelo6;

	private static ConjuntoDePinos cpfirstInstance = null;

	public static ConjuntoDePinos getInstancce(){
		if(cpfirstInstance == null){

			cpfirstInstance = new ConjuntoDePinos();
		}

		return cpfirstInstance;
	}

	public ConjuntoDePinos(){
		verde6=0;vermelho6=0;azul6=0;amarelo6=0;
		for(int i = 1; i < 5; i++){
			if( i == 1 ){
				this.GreenPino[i-1] = new PinoEstruturado(1, i, Color.green);
				this.RedPino[i-1] = new PinoEstruturado(1, i, Color.red);
				this.BluePino[i-1] = new PinoEstruturado(1, i, Color.blue);
				this.YellowPino[i-1] = new PinoEstruturado(1, i, Color.yellow);
			}
			
			else{
				this.GreenPino[i-1] = new PinoEstruturado(0, i, Color.green);
				this.RedPino[i-1] = new PinoEstruturado(0, i, Color.red);
				this.BluePino[i-1] = new PinoEstruturado(0, i, Color.blue);
				this.YellowPino[i-1] = new PinoEstruturado(0, i, Color.yellow);
			}
		}
	}

	public PinoEstruturado getGreen(int numero){
		return this.GreenPino[numero-1];
	}

	public PinoEstruturado getRed(int numero){
		return this.RedPino[numero-1];
	}

	public PinoEstruturado getBlue(int numero){
		return this.BluePino[numero-1];
	}

	public PinoEstruturado getYellow(int numero){
		return this.YellowPino[numero-1];
	}

}
