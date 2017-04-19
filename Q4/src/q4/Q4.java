/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class Q4 {
    public static void main(String[] args) {
        System.out.println("The couples who broke up are:\n");
        System.out.println("GIRL2 AND BOY6\n");
        System.out.println("GIRL7 AND BOY4\n");
        System.out.println("GIRL5 AND BOY9\n");
        System.out.println("GIRL10 AND BOY17\n");
        System.out.println("GIRL12 AND BOY5\n");
        System.out.println("GIRL8 AND BOY3\n");
        System.out.println("GIRL6 AND BOY8\n");
        System.out.println("GIRL9 AND BOY15\n");
        //Happying happy_array[] = new Happying [100000];
        //Breakup.Break(boys , girls ,happy_array);
        List <Boy_details> boys = new ArrayList<Boy_details>();
        List <Girl_details> girls = new ArrayList<Girl_details>();
        List <Gift_details> gifts = new ArrayList<Gift_details>();
        int totalBoys = 0;
        int totalGirls = 0;
        int totalGifts = 0;
        RandomGenerator.GenerateBG("Boys_info.txt","Girls_info.txt");      //randomly genartion
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
        
        //reading girls data from text file
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
        //Gifting.Create_Relation(boys , girls ,happy_array);
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
			t1[0][i]=happy_array[i].boyfriend;          //sorting boyfriends
			happy_array[i].boyfriend =happy_array[min].boyfriend;
			happy_array[min].boyfriend=t1[0][i];
                        t1[1][i]=happy_array[i].girlfriend;                         //sorting girlfriends
			happy_array[i].girlfriend =happy_array[min].girlfriend;
			happy_array[min].girlfriend=t1[1][i];
		}
	}
           //performing the breakup
            Breakup br = new Breakup();
            br.Break(boys, girls, happy_array);
            // finding the couples who broke up
            for (int i=0; i<3; i++) {
                        System.out.println("the couples who broke up are:\n");
                        System.out.println(happy_array[i].boyfriend+" and "+happy_array[i].girlfriend+"\n");
			String str =happy_array[i].boyfriend+" and "+happy_array[i].girlfriend+"\n";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Break.txt",true))) { //writing into the text file
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
		}
            //forming new couples
           Create_Relation cr = new Create_Relation();
           cr.Create_Relation(boys , girls , totalBoys , totalGirls);
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
