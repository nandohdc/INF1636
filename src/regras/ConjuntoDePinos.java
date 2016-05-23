package regras;

import java.awt.Color;

public class ConjuntoDePinos {
	PinoEstruturado[] GreenPino = new PinoEstruturado[4];
	PinoEstruturado[] RedPino = new PinoEstruturado[4];
	PinoEstruturado[] BluePino = new PinoEstruturado[4];
	PinoEstruturado[] YellowPino = new PinoEstruturado[4];

	private static ConjuntoDePinos cpfirstInstance = null;
	
	public static ConjuntoDePinos getInstancce(){
		if(cpfirstInstance == null){
			
			cpfirstInstance = new ConjuntoDePinos();
		}
		
		return cpfirstInstance;
	}
	
	public ConjuntoDePinos(){
		for(int i = 1; i < 5; i++){
			this.GreenPino[i-1] = new PinoEstruturado(0, i, Color.green);
			this.RedPino[i-1] = new PinoEstruturado(0, i, Color.red);
			this.BluePino[i-1] = new PinoEstruturado(0, i, Color.blue);
			this.YellowPino[i-1] = new PinoEstruturado(0, i, Color.yellow);

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
