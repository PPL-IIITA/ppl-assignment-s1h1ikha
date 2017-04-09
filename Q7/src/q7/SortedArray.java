package q7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class SortedArray extends Q7{
    public void array(List <Boy_details> boys , List <Girl_details> girls){
        int j=0,i=0;
        String[] committed_boy =new String[20];
        String[] girlfriend_boy =new String[20];
        for(Boy_details boy : boys){
            if(boy.relationship_status.equals("inRelation")){
                committed_boy[j] = boy.name;              //storing committed boys in an array
                girlfriend_boy[i] = boy.girlfriend;
            System.out.println("girlfriend of" + committed_boy[i] + "is" + girlfriend_boy[i]  );
                i++;
                j++;
            }
        }
       for (int ii=1; ii<10; ii++) {
                String k =  committed_boy[ii];           //sorting the committed boys of the array
			for (int jj=i-1; jj>=0; jj--) {
                            committed_boy[jj] = k;
                        }
            }
       for (int ii=0; ii<10; ii++) {
                        //System.out.println("the couples who broke up are:\n");
                        //System.out.println(committed_boy[i]+" and "+girlfriend_boy[i]+"\n");
			String str =committed_boy[ii]+" and "+girlfriend_boy[ii]+"\n";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("SortedArray.txt",true))) {
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
		}
    }
}
