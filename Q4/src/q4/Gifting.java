package q4;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
//import java.util.List;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class Gifting {
    public static void Create_Relation(List <Boy_details> boys , List <Girl_details> girls ,Happying happy_array[]){
        int i, j=0, totalGifts=0;
        
        List <Gift_details> gifts = new ArrayList<>();
        Object b[] = boys.toArray();
        Object g[] = girls.toArray();
        for(Girl_details girl: girls){
        for(Boy_details boy : boys) {
			if (boy.correct(girl.expenditure,boy.attractivness)== true) {
                                int sum_cost = 0;
				while (sum_cost <= boy.b_budget) {
                                    RandomGenerator.GenerateGift("Gift_info.txt");    //randomly generating gifts
                                    // reading gift details from text flie
                                    try (BufferedReader R = Files.newBufferedReader(Paths.get("Gift_info.txt"), StandardCharsets.US_ASCII) )
                                    {
                                        String L = R.readLine();
                                        while (L != null) {
                                            totalGifts++;
                                            String[] str = L.split(","); 
                                            Gift_details G = new Gift_details(str);
                                            L = R.readLine();
                                            gifts.add(G);
                                        }
                                    }catch (IOException ioe) {  
                                        ioe.printStackTrace();
                                    }
                                    Create_Relation cr = new Create_Relation();
                                    cr.Create_Relation(boys , girls , 20 , 10);
				}
				for(Boy_details bb : boys){
                                    if(bb.relationship_status != "single"){   
                                        if (bb.type == 1)
                                            bb.happiness = bb.b_budget - sum_cost;  //miser
                                        else if (bb.type == 2)
                                            bb.happiness = bb.happiness;            //generous
                                        else 
                                            boy.happiness = bb.intelligence;        //geeek
                                    
                                    }
                                }
                                for(Girl_details gg : girls){
                                    if(gg.relationship_status != "single"){         
                                        if (gg.type == 1)                       //normal
                                            gg.happiness = boy.b_budget;
                                        else if (gg.type == 2)                   //choosy
                                            gg.happiness = Math.log(boy.b_budget/sum_cost);
                                        else                                     //desperate
                                            gg.happiness = Math.exp(boy.b_budget/sum_cost);
                                        
                                    }
                                }
                                //array storing couple-wise happiness
				happy_array[j++] = new Happying(boy.name, girl.name, boy.happiness + girl.happiness);
			}
        }
	}
    }

}
