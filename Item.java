
public class Item {
	
	private int id;
	private int weight;
	private int value;
	private int prevId;
	private boolean trigger=false;
	public Item(int inputID,int inputWeight,int inputValue){
		setID(inputID);
		setWeight(inputWeight);
		setValue(inputValue);
	}
	
	public void setID(int a){
		id=a;
	}
	public int getID(){
		return id;
	}
	public void setWeight(int a){
		weight=a;
	}
	public int getWeight(){
		return weight;
	}
	public void setValue(int a){
		value=a;
	}
	public int getValue(){
		return value;
	}
	public void setPrevId(int a){
		prevId=a;
	}
	public int getPrevId(){
		return prevId;
	}
	public void setTrigger(boolean a){
		trigger=a;
	}
	public boolean getTrigger(){
		return trigger;
	}
}
