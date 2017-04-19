package q7;

import java.util.List;
//import Boy_details.Boy_details;
//import Girl_details.Girl_details;
//import Create_Relation.Create_Relation;
//import RandomGenarator.RandomGenerator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class Q7{

    public static void main(String[] args) {
       
        List <Boy_details> boys = new ArrayList<Boy_details>();         //array list for boys and girls
        List <Girl_details> girls = new ArrayList<>();
        int totalBoys = 0;
        int totalGirls = 0;
        RandomGenerator.GenerateBG("Boys_info.txt","Girls_info.txt");
        try (BufferedReader R = Files.newBufferedReader(Paths.get("Boys_info.txt"), StandardCharsets.US_ASCII) )
        {
            String L = R.readLine();              //reading data from boy file
            while (L != null) {
                totalBoys++;
                String[] str = L.split(","); 
                Boy_details B = new Boy_details(str);
                L = R.readLine();
                boys.add(B);
            }
        }catch (IOException ioe) {  
            ioe.printStackTrace();
        }
        try (BufferedReader R = Files.newBufferedReader(Paths.get("Girls_info.txt"), StandardCharsets.US_ASCII) )
        {
            String L = R.readLine();            //reading data from girl file
            while (L != null) {
                totalGirls++;
                String[] str1 = L.split(",");
                Girl_details G = new Girl_details(str1);
                L = R.readLine();
                girls.add(G);
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //it can be 1 2 or 3 as per the case user wants
        // in this case it is already taken as 1
        //for the default case it will follow hash table implementation
        switch(1){    
            case 1:
                Array o1 = new Array();
                o1.array(boys, girls);
                break;
            case 2:
                SortedArray o2 = new SortedArray();
                o2.array(boys, girls);
                break;
            default:
                HashTable o3 = new HashTable();
                o3.array(boys, girls); 
        }
        /*Array o1 = new Array();
        o1.array(boys, girls);
        SortedArray o2 = new SortedArray();
        o2.array(boys, girls);
        HashTable o3 = new HashTable();
        o3.array(boys, girls);*/
                
                
          
                
                Create_Relation.Create_Relation(boys , girls , 10 , 5);
            if(totalBoys > 20){
       try{
           throw new NoBoy("girls");
       }
   
   catch(NoBoy ex){
           System.out.println("girl did nott get a boyfreind");
           ex.printStackTrace();
           }
   }
   if(totalGirls >15)
   {
       try{
           throw new NoGirl("boys");
       }
   catch(NoGirl ex){
           System.out.println("boy did nott get a girlfreind");
           ex.printStackTrace();
           }
   }
   try{
           throw new NoMoney("money");
       }
    catch(NoMoney ex){
           System.out.println("boy has no money");
           ex.printStackTrace();
           }     
    }
    
}
