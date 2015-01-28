import java.util.Scanner;

public class KnapsackRun {
//------------Variables------------------//
	int v[][];
	int keep[][];
	Scanner in=new Scanner(System.in);
	int w,i;
	int totalValue;
	int totalWeight;
	int result[];
//-------------------------------------//	
	
	public KnapsackRun(){
		setUp();
	}
	
	//----------------------------------Main Method--------------------------------------------------------------
	public void setUp(){
		 Items items=new Items();         //create new items object to store the input items
		 setInputs();                     //get inputs from the user
	     setItems(items);                 //get item inputs from the user and store them into the "items" object
	     System.out.println("===========User Inputs===========");
	     System.out.println(w);          //total capacity of the knapsack
	     items.displayItems();           //method to display the items linkedlist
	     for(int k=0;k<w;k++){           //make the top row of both linkedlists 0
	    	 v[0][k]=0;
	    	 keep[0][k]=0;
	     }
	     findOptimal(items);            //executing my algorithm and working out the optimal solutions
	     System.out.println("===========Results==============");
	     System.out.println(totalValue);  //total weight used
	     System.out.println(items.getTotalW());
		 items.displayResults();
		 System.out.println("===========V Graph==============");
		 printV();
		 System.out.println("===========Keep Graph===========");
	     printKeep();
	     System.out.println("================================");
	}
	//---------------------------------------------------------------------------------------------------------
	
	
	//--------------------------------------Algorithm---------------------------------------------
	public void findOptimal(Items items){
		  if(!items.checkIncOrder()&&!items.checkDecOrder()){
			  items.sortItems();
		  }
		  for(int row=1;row<i+1;row++){
		    	 for(int col=0;col<w;col++){
		    		 if(items.getList().get(row-1).getWeight()>col+1){      
		    			 v[row][col]=0;
		    			 keep[row][col]=0;
		    		 }
		    		 else if(items.getList().get(row-1).getWeight()==col+1){
		    			 if(items.getList().get(row-1).getValue()>v[row-1][col]){
		    				 v[row][col]=items.getList().get(row-1).getValue();
			    			 keep[row][col]=1;
		    			 }
		    			 else{
		    				 v[row][col]= v[row-1][col];
			    			 keep[row][col]=0;
		    			 }
		    		 }
		    		 else{
		    			 int a=items.getList().get(row-1).getValue();
		    			 int sum=a+v[row-1][col-items.getList().get(row-1).getWeight()];
		    			 if(sum<v[row-1][col]){
		    				v[row][col]=v[row-1][col];
		    				keep[row][col]=0;
		    			 }
		    			 else if(sum>v[row-1][col]){
		    				v[row][col]=sum;
		    				keep[row][col]=1;
		    			 }
		    			 else if(sum==v[row-1][col]){
		    				v[row][col]=sum;
			    			keep[row][col]=0;
		    			 }
		    		 }
		    	 }
		    	 
		     }
		  int tempI,tempW;
		  tempI=i;
		  tempW=w;
		 while(tempI>0){
				  if(keep[tempI][tempW-1]==1){
					  Item item=items.getList().get(tempI-1);
					 if(totalWeight+item.getWeight()==w){
						 totalValue+=item.getValue();
						 items.addResult(item);
						 break; 
					  }
					  else{
						  totalWeight+=item.getWeight();
						  totalValue+=item.getValue();
						  items.addResult(item);
						  tempI=tempI-1;
						  tempW=tempW-item.getWeight();
					  }
  
				  }
				  else if(keep[tempI][tempW-1]==0){
					  tempI=tempI-1;
				  }
			  }			 
	}
	//---------------------------------------------------------------------------------------------		  
	

	//------------------------Helper Methods----------------
	public void printV(){    //printing the V array
		 for (int n =0; n < i+1; n++) {
		     for (int m = 0; m < w; m++) {
		     System.out.print(" " + v[n][m]);
		     }
		     System.out.println("");
		     }
	}
	public void printKeep(){    //printing the Keep array
		 for (int n =0; n < i+1; n++) {
		     for (int m = 0; m < w; m++) {
		     System.out.print(" " + keep[n][m]);
		     }
		     System.out.println("");
		     }
	}
	public void setItems(Items items){
	     for(int j=1;j<i+1;j++){
	    	 int inputW,inputV;
	    	 System.out.println("Enter the value for item "+j);
	       	 inputV=in.nextInt();
	    	 System.out.println("Enter the weight for item "+j);
	    	 inputW=in.nextInt();
	    	 items.addItem(inputW, inputV);
	     }
	}
	public void setInputs(){
		 System.out.println("Enter the size of the Knapsack");
	     w = in.nextInt();
	     if(w==0||w<0){
	    	 System.out.println("The Knapsack cannot fit any items.");
	    	 System.exit(0);
	     }
	     System.out.println("Enter the number of items");
	     i=in.nextInt();
	     if(i==0||i<0){
	    	 System.out.println("There are no items.");
	    	 System.exit(0);
	     }
	     else{
	    	 v=new int[i+1][w];
		     keep=new int[i+1][w];
	     }
	}

	
	
	public static void main(String[] args){
		KnapsackRun a=new KnapsackRun();
	}
	//----------------------------------------------------
}
