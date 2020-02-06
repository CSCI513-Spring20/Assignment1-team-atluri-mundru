import java.util.*;
public class StrategicSearch implements SearchStrategy{
	public int[] findingshipsefficient(int game[][]){
		int[] result=new int[4];
		int[] coordinates=new int[9];
		boolean carrierFound = false;
		boolean battleshipFound = false;
		int carrierStartIndex=0;
		boolean checkCarrier=false;
		boolean checkSubmarine=false;
		njmklm;
		int cells = 0;
//		int mid=game[12][12];
//		int count=0;
//		while(!checkCarrier && !checkSubmarine ){
//		// right side
//		if(count+12<=24){
//		if(game[12][count+12]==1 && !checkCarrier){
//			checkCarrier=true;
//			cells++;
//			result[0]=12;
//			result[1]=count+12;
//		}
//		if(game[12][count+12]==2  && !checkSubmarine){
//			checkSubmarine=true;
//			cells++;
//			result[2]=12;
//			result[3]=count+12;
//		}
//		} 
//		// left side 
//		if(12-count>=0){
//		if(game[12][12-count]==1 && !checkCarrier){
//			checkCarrier=true;
//			cells++;
//			result[0]=12;
//			result[1]=12-count;
//		}
//		if(game[12][12-count]==2  && !checkSubmarine){
//			checkSubmarine=true;
//			cells++;
//			result[2]=12;
//			result[3]=12-count;
//		}
//		}
//		// upper side 
//		if(12-count>=0){
//		if(game[12-count][12]==1 && !checkCarrier){
//			checkCarrier=true;
//			cells++;
//			result[1]=12;
//			result[0]=12-count;
//		}
//		if(game[12-count][12]==2  && !checkSubmarine){
//			checkSubmarine=true;
//			cells++;
//			result[2]=12-count;
//			result[3]=12;
//		}
//		}
//		// down side
//		if(count+12<=24){
//		if(game[count+12][12]==1 && !checkCarrier){
//			checkCarrier=true;
//			cells++;
//			result[0]=count+12;
//			result[1]=12;
//		}
//		if(game[count+12][12]==2  && !checkSubmarine){
//			checkSubmarine=true;
//			cells++;
//			result[2]=count+12;
//			result[3]=12;
//		}
//		}
//		// diagonal right down  
//		if(count+12<=24){
//		if(game[count+12][count+12]==1 && !checkCarrier){
//			checkCarrier=true;
//			cells++;
//			result[0]=count+12;
//			result[1]=count+12;
//		}
//		if(game[count+12][count+12]==2  && !checkSubmarine){
//			checkSubmarine=true;
//			cells++;
//			result[2]=count+12;
//			result[3]=count+12;
//		}
//		}
//		// diagonal right up row-- clo++
//		if(12-count>=0 && count+12<=24){
//		if(game[12-count][count+12]==1 && !checkCarrier){
//			checkCarrier=true;
//			cells++;
//			result[0]=12-count;
//			result[1]=count+12;
//		}
//		if(game[12-count][count+12]==2  && !checkSubmarine){
//			checkSubmarine=true;
//			cells++;
//			result[2]=12-count;
//			result[3]=count+12;
//		}
//		}
//		// diagonal left up row-- clo--
//		if(12-count>=0 && count+12<=24){
//		if(game[12-count][12-count]==1 && !checkCarrier){
//			checkCarrier=true;
//			cells++;
//		}if(game[12-count][12-count]==2  && !checkSubmarine){
//			checkSubmarine=true;
//			cells++;
//		}
//
//		// diagonal left down row++ clo--
//		if(12-count>=0 && count+12<=24){
//		if(game[12+count][12-count]==1 && !checkCarrier){
//			checkCarrier=true;
//			cells++;
//		}
//		if(game[12+count][12-count]==2 && !checkSubmarine ){
//			checkSubmarine=true;
//			cells++;
//		}
//		}
//
//
//		}
//count++;
//		}
//		checkCarrier=false;
//		checkSubmarine=false;
		
//		for(int i=0;i<25;i++) {
//			for(int j=0;j<25;j++) {
//				if(game[i][j]==1 && !carrierFound) {
//					result[0] = i;
//					result[1] = j;
//					carrierFound=true;
//					cells++;
//				}
//				if(game[i][j]==2 && !battleshipFound) {
//					result[2] = i;
//					result[3] = j;
//					battleshipFound=true;
//					cells++;
//				}
//				if(carrierFound&&battleshipFound)break;
//				cells++;
//			}
//		}
		while(!carrierFound) {
			Random random_number = new Random();
			int a = random_number.nextInt(25);
			int b = random_number.nextInt(25);
			if (game[a][b] == 1) {
				carrierFound = true;
				result[0] = a;
				result[1] = b;
				cells++;
				break;
			}
			cells++;
		}
		while(!battleshipFound) {
			Random number = new Random();
			int c = number.nextInt(25);
			int d = number.nextInt(25);
			if (game[c][d] == 2) {
				battleshipFound = true;
				result[2] = c;
				result[3] = d;
				cells++;
			}
				
			cells++;
			
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
						cells++;
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
						cells++;
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
						cells++;
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
						cells++;
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
							cells++;
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
							cells++;
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
							cells++;
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
							cells++;
							break;						
						}
					}
				}
				
			}

			 coordinates[8]=cells;
		return coordinates;
	}

	
}


