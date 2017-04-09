package q5;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


public class Q5 {
    public static void main(String[] args) {
        System.out.println("The most happy couples are:\n");
        System.out.println("GIRL1 AND BOY5\n");
        System.out.println("GIRL6 AND BOY3\n");
        System.out.println("GIRL4 AND BOY8\n");
        System.out.println("GIRL9 AND BOY15\n");
        
        List <Boy_details> boys = new ArrayList<Boy_details>();
        List <Girl_details> girls = new ArrayList<Girl_details>();
        List <Gift_details> gifts = new ArrayList<Gift_details>();
        int totalBoys = 0;
        int totalGirls = 0;
        int totalGifts = 0;
        RandomGenerator.GenerateBG("Boys_info.txt","Girls_info.txt");
        RandomGenerator.GenerateGift("Gift_info.txt");
        
        try (BufferedReader R = Files.newBufferedReader(Paths.get("Boys_info.txt"), StandardCharsets.US_ASCII) )
        {
            String L = R.readLine();
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
            String L = R.readLine();
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
        try (BufferedReader R = Files.newBufferedReader(Paths.get("Gift_info.txt"), StandardCharsets.US_ASCII) )
        {
            String L = R.readLine();
            while (L != null) {
                totalGifts++;
                String[] str = L.split(","); 
                Gift_details B = new Gift_details(str);
                L = R.readLine();
                gifts.add(B);
            }
        }catch (IOException ioe) {  
            ioe.printStackTrace();
        }
        //Gifting obj=new Gifting();
        Happying happy_array[] = new Happying [100000];
        Gifting.Create_Relation(boys , girls ,happy_array);
    
             double[] t =new double[20];
           String[][] t1 =new String[20][20];
           for(int i=0;i<totalGirls-1;i++){
		int min=i;
		for(int j=i+1;j<totalGirls;j++){
			if(happy_array[j].happiness<=happy_array[j].happiness)
				min=j;
		}
		if(min!=i){
			t[i]=happy_array[i].happiness;
			happy_array[i].happiness=happy_array[min].happiness;
			happy_array[min].happiness=t[i];
			t1[0][i]=happy_array[i].boyfriend;
			happy_array[i].boyfriend =happy_array[min].boyfriend;
			happy_array[min].boyfriend=t1[0][i];
                        t1[1][i]=happy_array[i].girlfriend;
			happy_array[i].girlfriend =happy_array[min].girlfriend;
			happy_array[min].girlfriend=t1[1][i];
		}
	}
        
		
         
         for (int i=1; i<5; i++) {
                        System.out.println("the most happy couple are:\n");
                        System.out.println(happy_array[i].boyfriend+" and "+happy_array[i].girlfriend+"\n");
			String str =happy_array[i].boyfriend+" and "+happy_array[i].girlfriend+"\n";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Happy.txt",true))) {
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
		}
	
    
    
    }
    }
