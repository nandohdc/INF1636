package movimento;

public class MoveBitch {
	
	PinoEstruturado mPino;
	House[] mCaminho = new House[59];
	int mDado;
	
	public MoveBitch(){
		this.mPino = null;
		this.mCaminho = null;
		this.mDado = 0;
	}
	
	public MoveBitch(PinoEstruturado Pino, House[] Caminho, int Dado){
		this.mPino = Pino;
		this.mCaminho = Caminho;
		this.mDado = Dado;
	}
	
	public void JustDoIt(){
		int setCasa;
		
		// Criar Movimento Final -- Mateus
		if((mPino.getCasa()+this.mDado) > 59){
			
		}

		setCasa = this.mPino.getCasa() + this.mDado;
		this.mPino.setCasa(setCasa);
		

	}

}
