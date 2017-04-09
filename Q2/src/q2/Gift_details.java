package q2;
public class Gift_details {
    public int luxuryRating = -1;
    public int difficultyToObtain = -1;
    public int utilityValue = -1;
    public int utilityClass = -1;

    public String name ;
    public int price ;
    public int value ;
    public int type ;
    
    
    public Gift_details(String str[]){  //constructor
            name=str[0];
            price =Integer.parseInt(str[1]);
            value=Integer.parseInt(str[2]);
            type=Integer.parseInt(str[3]);
        }
}

