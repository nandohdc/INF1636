package regras;

import movimento.PinoEstruturado;

public class RegrasFacade {
	private int nFDado;
	private PinoEstruturado mFPino;
	
	RegraTiraCinco RTC;
	RegraCaptura RC; 
	
	public RegrasFacade(int nDado, PinoEstruturado mPino){
		nFDado = nDado;
		mFPino = mPino;
		RTC = new RegraTiraCinco();
		RC = new RegraCaptura();
	}
	
	
}
