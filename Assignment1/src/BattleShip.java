import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class BattleShip {
	
		
	int carrier = 1;
	int submarine = 2;
	
	
	String line;
	List<int[][]> a_list = new ArrayList<int[][]>(); 
	int[][] game = new int[25][25];
	static SearchStrategy searchS;
	
	

	public void strategy_implementation(SearchStrategy s_strategy){
		searchS = s_strategy;
	}	
	
	public List<int[][]> grid_alignment(String fileName){
		  try {
			  FileReader i_file = new FileReader(fileName);
			  BufferedReader buffer_reader = new BufferedReader(i_file);
			  for(int i=0;i<=2;i++) {
					String l = buffer_reader.readLine();
					StringTokenizer token = new StringTokenizer(l,"()");
					
					for(int j=0;j<8;j++) {
						
						String element = token.nextToken();
						StringTokenizer token_firstc = new StringTokenizer(element,",");
						int a = Integer.parseInt(token_firstc.nextToken());
						int b = Integer.parseInt(token_firstc.nextToken());
						if(j<5) {
							game[a][b] = carrier;
						}
						else {
							game[a][b] = submarine;
							
							
						}
			  }
					
					
						   
					//for (int row = 0; row < game.length; row++) {
						//   for (int column = 0; column < game.length; column++) {
						      //System.out.print(game[row][column]+" ");
						  // }
						   //System.out.println();
						//}
					// Creating object and calling method of random search strategy
					RandomSearchStrategy random_strategy = new RandomSearchStrategy();
					random_strategy.search(game);
					//  Creating object and calling method of Strategic Search
					StrategicSearch strategy = new StrategicSearch();
					int result[]=strategy.findingshipsefficient(game);
					//for(int s=0;s<8;s++) {
						//System.out.print(result[s]+"    ");
						
					//} 
					System.out.println("Strategy:Strategic Search");
					System.out.println("Number of Cells Searched:"+result[8]);
					System.out.print("Carrier Found:"+"("+result[0]+","+result[1]+")"+"to"+"("+"("+result[2]+","+result[3]+")");
					System.out.println(" SubMarine Found:"+"("+result[4]+","+result[5]+")"+"to"+"("+"("+result[6]+","+result[7]+")");
					//System.out.println("-------------------------------------------------");
					for (int row = 0; row < game.length; row++) {
						   for (int column = 0; column < game.length; column++) {
						      game[row][column]=0;
						   }
						}
			  }
			  buffer_reader.close();
			  }
		  catch(Exception e) {
		  System.out.println("Exception is "+e);
		  }
			return a_list;
		}
	public void reading_from_input(){
		a_list = grid_alignment("src/input.txt");
//		System.out.println(mylist);
	}
	
	
	public static void main(String[] args) {
		BattleShip battleship = new BattleShip();
		
	battleship.reading_from_input();

	}
}