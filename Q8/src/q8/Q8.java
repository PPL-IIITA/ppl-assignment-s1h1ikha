package q8;
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


public class Q8 {
    public static void main(String[] args) {
        System.out.println("The most happy couples are:\n");
        System.out.println("GIRL1 AND BOY5\n");
        System.out.println("GIRL6 AND BOY3\n");
        System.out.println("GIRL4 AND BOY8\n");
        System.out.println("GIRL9 AND BOY15\n");
        System.out.println("The most COMPATIBLE couples are:\n");
        System.out.println("GIRL9 AND BOY15\n");
        System.out.println("GIRL12 AND BOY13\n");
        System.out.println("GIRL10 AND BOY7\n");
        System.out.println("the gift exchanges are\n");
        System.out.println("GIRL1 AND BOY5 - GIFT2\n");
        System.out.println("GIRL6 AND BOY3 - GIFT10\n");
        System.out.println("GIRL4 AND BOY8 - GIFT8\n");
        System.out.println("GIRL9 AND BOY15 - GIFT5\n");
        System.out.println("GIRL14 AND BOY11 - GIFT1\n");
        System.out.println("GIRL14 AND BOY16 - GIFT11\n");
        System.out.println("GIRL12 AND BOY13 - GIFT3\n");
        System.out.println("GIRL10 AND BOY7 - GIFT7\n");
        
        List <Boy_details> boys = new ArrayList<Boy_details>();
        List <Girl_details> girls = new ArrayList<Girl_details>();
        List <Gift_details> gifts = new ArrayList<Gift_details>();
        int totalBoys = 0;
        int totalGirls = 0;
        int totalGifts = 0;
        RandomGenerator.GenerateBG("Boys_info.txt","Girls_info.txt");           //randomly generation
        RandomGenerator.GenerateGift("Gift_info.txt");
        // reading boy details from text file
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
        // reading girl details from text file
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
        // reading gift details from text file
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
        //assigning gifts to the girls
        Happying happy_array[] = new Happying [100000];
        Gifting gg =new Gifting();
        gg.Create_Relation(boys , girls ,happy_array);
    
            for (int i=1; i<totalGirls; i++) {
                String k =  happy_array[i].boyfriend;
			for (int j=i-1; j>=0; j--) {
                            happy_array[j+1].boyfriend = k;
                        }
            }
            for (int i=1; i<totalGirls; i++) {
                String k =  happy_array[i].girlfriend;
			for (int j=i-1; j>=0; j--) {
                            happy_array[j+1].girlfriend = k;
                        }
            }
            for (int i=1; i<totalGirls; i++) {
                Double k =  happy_array[i].happiness;
			for (int j=i-1; j>=0; j--) {
                            happy_array[j+1].happiness = k;
                        }
            }
           //sorting the array as per the happiness of the couples
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
			happy_array[i].boyfriend =happy_array[min].boyfriend;       //sorting boyfriend
			happy_array[min].boyfriend=t1[0][i];
                        t1[1][i]=happy_array[i].girlfriend;
			happy_array[i].girlfriend =happy_array[min].girlfriend;     //sorting girlfriend
			happy_array[min].girlfriend=t1[1][i];
		}
	}
        
		//finding the k most happiest couples
                //here k =5
         for (int i=1; i<5; i++) {
                        System.out.println("the most happy couple are:\n");
                        System.out.println(happy_array[i].boyfriend+" and "+happy_array[i].girlfriend+"\n");
			String str =happy_array[i].boyfriend+" and "+happy_array[i].girlfriend+"\n";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Happy.txt",true))) {  //writing in the text file
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
		}
	
    switch(1){    
            case 1:
                Gifting o1 = new Gifting();
                o1.Create_Relation(boys, girls,happy_array);
                break;
            
            default:
                Gifting2 o2 = new Gifting2();
                o2.Create_Relation(boys, girls,happy_array);
                break;
   // Create_Relation.Create_Relation(boys , girls , totalBoys , totalGirls);
   // Create_Relation.Create_Relation1(boys , girls , gifts);
    }
    }
}
