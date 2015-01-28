import java.util.Collections;
import java.util.LinkedList;


public class Items {
	int id=0;
	LinkedList<Item> Items=new LinkedList<Item>();        //LinkedList to store the input items
	LinkedList<Item> Results=new LinkedList<Item>();      //Another LinkedList to store the optimal items
	
	

	public void addItem(int weight,int value){ //To add an item to the Items list
		Item item=new Item(++id,weight,value);
		Items.add(item);
	}
	public void addResult(Item item){       //To add an item to the Results list
		Results.add(item);
	}
	
	public void displayItems(){            //Displays items
		for(Item item : Items){
			System.out.println(item.getID()+" : "+item.getValue()+" "+item.getWeight());
		}	
	}
	public void displayResults(){          //Displays the solution
		for(int i=Results.size()-1;i>-1;i--){
			if(Results.get(i).getTrigger()){
				System.out.println(Results.get(i).getPrevId()+" : "+Results.get(i).getValue()+" "+Results.get(i).getWeight());
			}
			else{
				System.out.println(Results.get(i).getID()+" : "+Results.get(i).getValue()+" "+Results.get(i).getWeight());
			}
		}
	}

	public LinkedList<Item> getList(){
		return Items;
	}
	public LinkedList<Item> getResultList(){
		return Results;
	}
	public int getTotalW(){                //returning the total weight for the optimized solution
		int i=0;
		for(Item item : Results){
			i+=item.getWeight();
		}	
		return i;
	}
	public boolean checkIncOrder(){
		for(int i=0;i<Items.size()-1;i++){
			if(Items.get(i).getWeight()>Items.get(i+1).getWeight()){
				return false;
			}
		}
		return true;
	}
	public boolean checkDecOrder(){
		for(int i=0;i<Items.size()-1;i++){
			if(Items.get(i).getWeight()<Items.get(i+1).getWeight()){
				return false;
			}
		}
		return true;
	}
	public void sortItems(){
		while(!checkIncOrder()){
			for(int i=0;i<Items.size()-1;i++){
				if(Items.get(i).getWeight()>Items.get(i+1).getWeight()){
					int a,b;
					a=Items.get(i).getID();
					b=Items.get(i+1).getID();
					if(!Items.get(i).getTrigger()){
						Items.get(i).setPrevId(a);
					}
					if(!Items.get(i+1).getTrigger()){
						Items.get(i+1).setPrevId(b);
					}
						Items.get(i).setID(b);
						Items.get(i+1).setID(a);
						Collections.swap(Items, i, i+1);
				}
			}
		}
	}
}
