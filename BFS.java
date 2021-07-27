//HW1 Elif Gökpinar
import java.io.*;
import java.util.*;
import java.text.*;
public class BFS {
	//variables of agent
	double x;
	double y;
	double r;
	int level;
	
	public BFS(double x,double y,double r,int level) {
		this.x=x;
		this.y=y;
		this.r=r;
		this.level=level;
	}
	
	
	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


	public static void main(String[] args) throws FileNotFoundException {
		
		//*******Read input by command argument******
		File fileInput= new File(args[0]);
		
		//Generate array
		BFS laptop[]=null;
		BFS laptop2[]=null;
		int count=0;
		int i=0;
		int sizeArray = 0;
		double hop=0;
					
			    //Read input file
			    Scanner input = new Scanner(fileInput); 
			  
			    while (input.hasNextLine()) { 
			      
			      String s=input.nextLine();
			      
			      if(count==0) {
			    	  sizeArray=Integer.parseInt(s);
			    	  laptop=new BFS[sizeArray];
			    	  laptop2=new BFS[sizeArray];
			    	  count++;
			      }
			      else {
			    	  
			    	  String[] splitS = s.split("\\s+");
			    	  if(splitS[0].isEmpty()) {
			    		  break;
			    	  }
			    	  BFS position = new BFS(Double.parseDouble(splitS[0]),
			    	  Double.parseDouble(splitS[1]),Double.parseDouble(splitS[2]),-1);
			    	  BFS position2 = new BFS(Double.parseDouble(splitS[0]),
					  Double.parseDouble(splitS[1]),Double.parseDouble(splitS[2]),-1);
			    	  
			    	  laptop[i]=position;
			    	  laptop2[i]=position2;
			    	  i++;
			      }
			  } 
			    
			    //Select the first element,ýt's hop distance is 0.
			    laptop[0].level=0;
			    laptop2[0].level=0;
			    
			    
			   int j=0;
			   int line=1;
			   int again=0;
			   int times=1;
			   int k=0;
			   for(i=0; i<laptop.length-1; i++) {
				   again=0;
				   
				   if(laptop[i].level!=-1) {
					   
					   for(j=i+1; j<laptop.length; j++) {
						   //If the agent is unvisited.
						   if(laptop[j].level==-1) {
							   //calculate the distance between agents.
							   hop=Math.sqrt((Math.pow(Math.abs(laptop[i].x-laptop[j].x), 2) + Math.pow(Math.abs(laptop[i].y-laptop[j].y), 2)));
							   
							   if(hop <= (laptop[i].r+laptop[j].r)) {
								   laptop[j].level=laptop[i].level+1;
								   
					   
								   double temp=laptop[j].x;
								   laptop[j].x=laptop[times].x;
								   laptop[times].x=temp;
								   
								   double temp1=laptop[j].y;
								   laptop[j].y=laptop[times].y;
								   laptop[times].y=temp1;
								   
								   double temp2=laptop[j].r;
								   laptop[j].r=laptop[times].r;
								   laptop[times].r=temp2;
								   
								   int temp3=laptop[j].level;
								   laptop[j].level=laptop[times].level;
								   laptop[times].level=temp3;
								   
								   again++;
								   times++;
							   } 
						   }
					   }
				   }
			   }
			   
		
			    //Find the correct position of agent.
			   for(i=1; i<laptop.length; i++) {
				   for(j=1; j<laptop.length; j++) {
					   
					  if(laptop[i].x==laptop2[j].x &&laptop[i].y==laptop2[j].y&&
							  laptop[i].r==laptop2[j].r ) {
						  
						  if(laptop[i].level==-1) {
							  laptop[i].level=0;
						  }
						  laptop2[j].level=laptop[i].level;
				   } 
					   
				   }
	  
			   }
			    
			   for(i=0; i<laptop.length; i++) {
				   //System.out.println(laptop[i].level+" "+laptop[i].x+" "+laptop[i].y+" "+laptop[i].r);
				   //System.out.println(laptop2[i].level+" "+laptop2[i].x+" "+laptop2[i].y+" "+laptop2[i]).r);
				   System.out.println(laptop2[i].level);
			   }
			    
			   //Write the informations in the output file.
			   try(PrintWriter output = new PrintWriter("output.txt"))
				{
					for(i=0; i<sizeArray; i++) {
						output.println(laptop2[i].level);
					}
					output.close();
				}
			    
	}

}
