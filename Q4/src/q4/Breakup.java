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
public class Breakup extends Q4 {       //Breakup class inherits Q4
    public void Break(List <Boy_details> boys , List <Girl_details> girls ,Happying happy_array[]){
        int i=0;
        String bf,gf;
        List <Gift_details> gifts = new ArrayList<>();
        Object b[] = boys.toArray();
        Object g[] = girls.toArray();
        int length = happy_array.length;
        length --;
        // finding the least happy couples and performing breakups
        while(i<3){
            bf = happy_array[length-i].boyfriend;
            gf = happy_array[length-i].girlfriend;
            for(Girl_details girl: girls){
                if(girl.name.equals(gf))
                    girl.boyfriend="no";
                    girl.relationship_status="single";
            }
            for(Boy_details boy: boys){
                if(boy.name.equals(gf))
                    boy.girlfriend="no";
                    boy.relationship_status="single";
            }
            i++;
        }
    }
}
        //Happying happy_array[] = new Happying [100000];
        //Gifting.Create_Relation(boys , girls ,happy_array);
        
        
    

