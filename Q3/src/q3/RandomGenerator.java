package q3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomGenerator {
        public static void GenerateBG(String boysFile , String girlsFile){      //randomly generates girls and boys
            for(int i=1 ; i<=20 ; i++){
                Random rand = new Random();
                String str = "BOY" + i + "," + (rand.nextInt((10 - 2) + 1) + 2) + "," + (rand.nextInt((20000 - 15000) + 1) + 15000) + "," + (rand.nextInt((10 - 2) + 1) + 2) + "," + (rand.nextInt((8 - 0) + 1) + 0) + "," + (rand.nextInt((50000 - 15000) + 1) + 15000) +","+ (rand.nextInt((3 - 1) + 1) + 1);
                try(BufferedWriter R = new BufferedWriter(new FileWriter(boysFile,true))){
                    R.write(str);
                    R.newLine();
                }catch (IOException e) {
		e.printStackTrace();
                }
            }
            for(int i=1 ; i<=8 ; i++){
                Random rand = new Random();
                String str = "GIRL" + i + "," + (rand.nextInt((10 - 2) + 1) + 2) + "," + (rand.nextInt((20000 - 15000) + 1) + 15000) + "," + (rand.nextInt((10 - 2) + 1) + 2) + "," + (rand.nextInt((3 - 1) + 1) + 1);
                try(BufferedWriter R = new BufferedWriter(new FileWriter(girlsFile,true))){
                    R.write(str);
                    R.newLine();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }   
        public static void GenerateGift(String giftFile){                       //randomly generates gifts
            for(int i=1 ; i<=20 ; i++){
                Random rand = new Random();
                String str = "GIFT" + i + "," + (rand.nextInt((10 - 2) + 1) + 2) + "," + (rand.nextInt((2000 - 1500) + 1) + 1500) + "," + (rand.nextInt((10 - 2) + 1) + 2) + "," + (rand.nextInt((3 - 1) + 1) + 1);
                try(BufferedWriter R = new BufferedWriter(new FileWriter(giftFile,true))){
                    R.write(str);
                    R.newLine();
                }catch (IOException e) {
		e.printStackTrace();
                }
            }
        }
        }
        
