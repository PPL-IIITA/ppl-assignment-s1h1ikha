package q7;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HashTable extends Q7{
    public void array(List <Boy_details> boys , List <Girl_details> girls){
        int j=0,i=0;
        String[] committed_boy =new String[20];
        String[] girlfriend_boy =new String[20];
        for(Boy_details boy : boys){
            if(boy.relationship_status.equals("inRelation")){
                committed_boy[j] = boy.name;
                girlfriend_boy[i] = boy.girlfriend;
                int h =hash_value(committed_boy[j]);            //hash value
                System.out.println("hash value of boyfriend = " + h);
            //System.out.println("girlfriend of" + committed_boy[i] + "is" + girlfriend_boy[i]  );
                i++;
                j++;
            }
        }
        for (int ii=0; ii<10; ii++) {
                        
                        //System.out.println(committed_boy[i]+" and "+girlfriend_boy[i]+"\n");
			String str =committed_boy[ii]+" and "+girlfriend_boy[ii]+"\n";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Hash.txt",true))) {
			bw.write(str);
                        bw.newLine();
                        } catch (IOException e) {
			e.printStackTrace();
                    }
		}
       
    }

    public int hash_value(String b){        //to calculate the hash value
        int i,hash=1;
        for(i=0;i<b.length();i++){
            hash = (b.charAt(i))%i;
        }
        return hash;
    }
    
}
