package movimento;

import grafica.Dice;

public class FacadeMovimento {
	private int CoordinateX;
	private int CoordinateY;
	Dice dice;
	
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
	
	public void setClickedCoordinates(int cX, int cY){
		setCoordinateX(cX);
		setCoordinateY(cY);
		MoveBitch GetOutDaWay = new MoveBitch(cX, cY, dice.getRandNum());
		GetOutDaWay.JustDoIt();
		System.out.printf("cX: %d ----- cY:%d\n",cX, cY);
	}	
}
