package movimento;

import grafica.Dice;

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
		System.out.printf("cX: %d ----- cY:%d\n",cX, cY);
		
		if(GetOutDaWay.JustDoIt() == true){
			return true;
		}
		
		else{
			return false;
		}

	}
}
