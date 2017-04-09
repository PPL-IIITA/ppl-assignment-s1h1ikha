package q7;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Create_Relation {
    
    public static void Create_Relation(List <Boy_details> boys , List <Girl_details> girls , int Nb , int Ng){
        //Date date = new Date();
        girls.forEach((item) -> {
            for(Boy_details boy : boys){
                if(boy.correct(item.attractivness,item.expenditure) && item.correct(boy.minimum_attraction_req,boy.b_budget) && boy.relationship_status =="single" && item.relationship_status=="single"){
                        Date date = new Date();
                        String str = "girlfriend of " + boy.name + "is" + item.name ;;
                        System.out.println("girlfriend of " + boy.name + "is" + item.name );  //couples formed
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
}