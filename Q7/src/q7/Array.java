package q7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Array extends Q7{
    public void array(List <Boy_details> boys , List <Girl_details> girls){
        int j=0,k=0;
        String[] committed_boy =new String[20];
        String[] girlfriend_boy =new String[20];
        for(Boy_details boy : boys){
            if(boy.relationship_status.equals("inRelation")){
                committed_boy[j] = boy.name;                   //storing committed boys in an array
                girlfriend_boy[k] = boy.girlfriend;
            System.out.println("girlfriend of" + committed_boy[k] + "is" + girlfriend_boy[k]  );
                k++;
                j++;
            }
        }
       for (int i=0; i<10; i++) {
                        
                        String str =committed_boy[i]+" and "+girlfriend_boy[i]+"\n";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Array.txt",true))) {
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
		}
    }
}
