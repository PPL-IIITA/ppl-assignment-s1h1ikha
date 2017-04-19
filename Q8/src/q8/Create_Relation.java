package q8;
//import Boy_details.Boy_details;
//import Girl_details.Girl_details;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
public class Create_Relation {
    public static void Create_Relation(List <Boy_details> boys , List <Girl_details> girls , int Nb , int Ng){
        //Date date = new Date();
        //making couples who are fulfilling the requirements
        girls.forEach((item) -> {
            for(Boy_details boy : boys){
                if(boy.correct(item.attractivness,item.expenditure) && item.correct(boy.minimum_attraction_req,boy.b_budget) && boy.relationship_status =="single" && item.relationship_status=="single"){
                        Date date = new Date();
                        String str = "New couple :" + boy.name + "and" + item.name + " is formed ." + " at time instance: " + date;;
                        System.out.println("New couple :" + boy.name + "and" + item.name + " is formed .");
                        boy.girlfriend = item.name;
                        boy.relationship_status =  "inRelation";
                        item.boyfriend = boy.name;
                        item.relationship_status = "inRelation";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Log.txt",true))) {  //writing into the log file
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
                }
            }
        });
        
    }
    public static void Create_Relation1(List <Boy_details> boys , List <Girl_details> girls , List<Gift_details> gifts ,int ng, int bg){
        //Date date = new Date();
        girls.forEach((item) -> {
            for(Boy_details boy : boys){
                for(Gift_details gift : gifts){
                if(boy.correct(item.attractivness,item.expenditure) && item.correct(boy.minimum_attraction_req,boy.b_budget) && boy.relationship_status =="single" && item.relationship_status=="single"){
                        Date date = new Date();
                        String str = "New couple :" + boy.name + "and" + item.name + " is formed ." + " at time instance: " + date + "and gifts" + gift.name ;;
                        System.out.println("New couple :" + boy.name + "and" + item.name + " is formed .");
                        boy.girlfriend = item.name;
                        boy.relationship_status =  "inRelation";
                        item.boyfriend = boy.name;
                        item.relationship_status = "inRelation";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Gift.txt",true))) {
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
                }
            }
            }
        });
        
    }
    
    
}
