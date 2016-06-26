package movimento;

//This interface handles adding, deleting and updating all the observers
import movimento.Observer;

public interface Subject {

	public void register(Observer o); //add an observer
	public void unregister(Observer o); // delete an observer
	public void notifyObserver(); //notify all observer 

}
