package q3;
public class Girl_details extends Gifting{
      public String name;
	public int intelligence;
	public int attractivness;
	public int expenditure;
	public String boyfriend;
	public String relationship_status;
        public int type;
        public double happiness;
        
        public Girl_details(String str[]){  //input from txt file
            name=str[0];
            attractivness =Integer.parseInt(str[1]);
            expenditure=Integer.parseInt(str[2]);
            intelligence=Integer.parseInt(str[3]);
            boyfriend="no";
            relationship_status="single";
            type = Integer.parseInt(str[4]);
        }
        public boolean correct(int a,int e){
            if(this.expenditure<=e && this.attractivness>=a)
                return true;
            else
                return false;
        }
}
