package movimento;

import grafica.Dice;
import grafica.DrawingBoard;

public class FacadeMovimento{
	private int CoordinateX;
	private int CoordinateY;
	Dice dice;
	
private static FacadeMovimento fmfirstInstance = null;
	
	public static FacadeMovimento getInstance(){
		if(fmfirstInstance == null){
			
			fmfirstInstance = new FacadeMovimento();
		}
		
		return fmfirstInstance;
	}
	
	public FacadeMovimento(){
		setCoordinateX(-1);
		setCoordinateY(-1);
		dice = Dice.getInstance();
	}
	
	public void RollDice(){
		dice.generatingRandomNumberDice();
	}
	
	public int getCoordinateY() {
		return CoordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		CoordinateY = coordinateY;
	}

	public int getCoordinateX() {
		return CoordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		CoordinateX = coordinateX;
	}
	
	public boolean setClickedCoordinates(int cX, int cY){
		setCoordinateX(cX);
		setCoordinateY(cY);
		MoveBitch GetOutDaWay = new MoveBitch(cX, cY, dice.getRandNum());
		
		if(GetOutDaWay.JustDoIt() == true){
			//Update os valores de Score
			Score.getInstancce().updateScore();
			//System.out.println("Red: " + Score.getInstancce().getScoreRed());
			//System.out.println("Blue: " + Score.getInstancce().getScoreBlue());
			//System.out.println("Yellow: " + Score.getInstancce().getScoreYellow());
			//System.out.println("Green: " + Score.getInstancce().getScoreGreen());
			return true;
		}
		
		else{
			return false;
		}

	}
	
	public static void FacadeRegistraObserver(Subject PinoEstruturado){
		DrawingBoard.getInstancce().addTabuleiro(PinoEstruturado);
	}
}
