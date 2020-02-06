// Class Name - RandomSearchStrategy implementing SearchStrategy interfaces search method
//
// Search method will take a random number generator and will find the coordinates of the submarine and carrier
//
//


import java.util.*;
public class RandomSearchStrategy implements SearchStrategy{
public void search(int game[][]) {
int count =0;
int count1 = 0;
int cellssearched=0;
String carrier="";
String submarine = "";
Random rand = new Random(); // object for Random Number Class.
while(count!=5 || count1!=3) {
int a = rand.nextInt(25); // for generating numbers for searching.
int b = rand.nextInt(25); // for generating numbers for searching.
String c ="";
if(game[a][b]==1) {
c = "("+a+","+b+")";
if(!carrier.contains(c)) {
carrier = carrier.concat(c);
count++;
}
/*else {
carrier = carrier.concat(c);
count++;
}*/
}
if(game[a][b]==2) {
c = "("+a+","+b+")";
if(!submarine.contains(c)) {
submarine = submarine.concat(c);
count1++;
}
/*else {
submarine = submarine.concat(c);
count1++;
}*/
}


cellssearched++;
}
System.out.println();
System.out.println("Strategy: Random Sweep");
System.out.println("Number of cells searched: "+cellssearched);
System.out.print("Found Carrier at "+carrier+";");
System.out.println(" Found Sub at "+submarine);
}

}


