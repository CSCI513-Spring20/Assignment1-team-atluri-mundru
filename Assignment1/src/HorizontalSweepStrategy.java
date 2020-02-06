/*
 Class Name: Horizontal Sweep Strategy
 Interface: SearchShips
 Purpose: This class implements the Horizontal Strategy which means it implements the linear search for finding the submarine and the 
 		  carriers and prints the number of cells searched for finding out the total submarines and carriers.
 */
import java.util.*;

public class HorizontalSweepStrategy implements SearchStrategy{
	
	/*
	 function name: findships
	 arguments: game[][]
	 purpose: It is a functions which overrides the function of the Interface search ships.
	 */
	public void search(int game[][]) {
		int counter =0; // total number of cells searched
		//int count = 0;
		//int count1=0;
		//String carrierh=""; 
		//String carrieri[]=new String[30];// concatinating the carrier strings.
		//String submarineh = ""; 
		//String submarinei[]=new String[30];// concatinating the submarines strings.
		//System.out.println("Horizontal is implemented"+ game);
		//int i =0;
		//int j= 0;
		boolean carrierFound=false;
		boolean battleshipFound=false;
		boolean checkCarrier = false;
		boolean checkSubmarine = false;
		int carrierStartIndex;
		int[] result=new int[4];
		int[] coordinates=new int[9];
		for(int i=0;i<25;i++) {
			for(int j=0;j<25;j++) {
				if(game[i][j]==1 && !carrierFound) {
					result[0] = i;
					result[1] = j;
					carrierFound=true;
					counter++;
				}
				if(game[i][j]==2 && !battleshipFound) {
					result[2] = i;
					result[3] = j;
					battleshipFound=true;
					counter++;
				}
			if(carrierFound&&battleshipFound)break;
				counter++;
			}
			
		}
		if (result[1]+1<=24) {
			if(game[result[0]][result[1]+1] == 1) {
				for(int i=0;i<25;i++) {
					if(game[result[0]][i]==1) {
						carrierStartIndex=i;
						coordinates[0]=result[0];
						coordinates[1]=i;
						coordinates[2]=result[0];
						coordinates[3]=i+4;
						counter++;
						checkCarrier=true;
						break;
						
					}
				}
			}
		}

		 if ( result[1]-1 >= 0 ) {
			if(game[result[0]][result[1]-1] == 1) {
				for(int i=0;i<25;i++) {
					if(game[result[0]][i]==1) {
						carrierStartIndex=i;
						coordinates[0]=result[0];
						coordinates[1]=i;
						coordinates[2]=result[0];
						coordinates[3]=i+4;
						counter++;
						checkCarrier=true;
						break;
						
					}
				}
			}
		}
		 if ( result[0]+1<=24) {

			 if(game[result[0]+1][result[1]] == 1) {
				for(int i=0;i<25;i++) {
					if(game[i][result[1]]==1) {
						carrierStartIndex=i;
						coordinates[0]=i;
						counter++;
						coordinates[1]=result[1];
						coordinates[2]=i+4;
						coordinates[3]=result[1];
						checkCarrier=true;
						break;						
					}
				}
			}
			
		}
		 if ( result[0]-1>=0 ) {
				//System.out.println("here");

			if(game[result[0]-1][result[1]] == 1) {
				for(int i=0;i<25;i++) {
					if(game[i][result[1]]==1) {
						carrierStartIndex=i;
						coordinates[0]=i;
						counter++;
						coordinates[1]=result[1];
						coordinates[2]=i+4;
						coordinates[3]=result[1];
						checkCarrier=true;
						break;						
					}
				}
			}
			
		}
					
		 if (result[3]+1<=24) {
				if(game[result[2]][result[3]+1] == 2) {
					for(int i=0;i<25;i++) {
						if(game[result[2]][i]==2) {
							carrierStartIndex=i;
							coordinates[4]=result[2];
							coordinates[5]=i;
							coordinates[6]=result[2];
							coordinates[7]=i+2;
							counter++;
							checkSubmarine=true;
							break;
							
						}
					}
				}
			}

			 if ( result[3]-1 >= 0) {
				if(game[result[2]][result[3]-1] == 2) {
					for(int i=0;i<25;i++) {
						if(game[result[2]][i]==2) {
							carrierStartIndex=i;
							coordinates[4]=result[2];
							coordinates[5]=i;
							coordinates[6]=result[2];
							coordinates[7]=i+2;
							counter++;
							checkSubmarine=true;
							break;
							
						}
					}
				}
			}
			 if ( result[2]+1<=24) {
				if(game[result[2]+1][result[3]] == 2) {
					for(int i=0;i<25;i++) {
						if(game[i][result[3]]==2) {
							carrierStartIndex=i;
							coordinates[4]=i;
							coordinates[5]=result[3];
							coordinates[6]=i+2;
							coordinates[7]=result[3];
							counter++;
							checkSubmarine=true;
							break;						
						}
					}
				}
				
			}
			 if ( result[2]-1>=0) {
				if(game[result[2]-1][result[3]] == 2) {
					for(int i=0;i<25;i++) {
						if(game[i][result[3]]==2) {
							carrierStartIndex=i;
							coordinates[4]=i;
							coordinates[5]=result[3];
							coordinates[6]=i+2;
							coordinates[7]=result[3];
							checkSubmarine=true;
							counter++;
							break;						
						}
					}
				}
				
			}

			 coordinates[8]=counter-2;
		
		System.out.println("Strategy: Horizontal Sweep");
		System.out.println("Number of cells searched: "+coordinates[8]);
		System.out.print("Carrier Found:"+"("+coordinates[0]+","+coordinates[1]+")"+"to"+"("+coordinates[2]+","+coordinates[3]+")");
		System.out.print(" SubMarine Found:"+"("+coordinates[4]+","+coordinates[5]+")"+"to"+"("+"("+coordinates[6]+","+coordinates[7]+")");
		
	}
	
}