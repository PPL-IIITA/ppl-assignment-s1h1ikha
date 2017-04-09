package q5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Create_Relation {
     public static void Create_Relation(List <Boy_details> boys , List <Girl_details> girls , int Nb , int Ng){
        //Date date = new Date();
        int i=0;
        if(i%2 == 0){
        girls.forEach((item) -> {
            for(Boy_details boy : boys){
                if(item.expenditure <= boy.b_budget && boy.relationship_status =="single" && item.relationship_status=="single"){
                        Date date = new Date();
                        String str = "New couple :" + boy.name + "and" + item.name + " is formed ." + " at time instance: " + date;;
                        System.out.println("New couple :" + boy.name + "and" + item.name + " is formed .");
                        boy.girlfriend = item.name;
                        boy.relationship_status =  "inRelation";
                        item.boyfriend = boy.name;
                        item.relationship_status = "inRelation";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Log.txt",true))) {
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
                }
            }
        });
        i++;
        }
        else{
        for(Boy_details boy : boys){
        girls.forEach((item) -> {
            //for(Boy_details boy : boys){
                if(boy.minimum_attraction_req <= item.attractivness && boy.relationship_status =="single" && item.relationship_status=="single"){
                        Date date = new Date();
                        String str = "New couple :" + boy.name + "and" + item.name + " is formed ." + " at time instance: " + date;;
                        System.out.println("New couple :" + boy.name + "and" + item.name + " is formed .");
                        boy.girlfriend = item.name;
                        boy.relationship_status =  "inRelation";
                        item.boyfriend = boy.name;
                        item.relationship_status = "inRelation";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Log.txt",true))) {
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
                }
            });
        }
        i++;
        }
    }
}

