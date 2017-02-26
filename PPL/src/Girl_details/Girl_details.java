/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Girl_details;

public class Girl_details {
       
        public String name;
	public int intelligence;
	public int attractivness;
	public int expenditure;
	public String boyfriend;
	public String relationship_status;
        
        public Girl_details(String str[]){  //input from txt file
            name=str[0];
            attractivness =Integer.parseInt(str[1]);
            expenditure=Integer.parseInt(str[2]);
            intelligence=Integer.parseInt(str[3]);
            boyfriend="no";
            relationship_status="single";
        }
        public boolean correct(int a,int e){
            if(this.expenditure<=e && this.attractivness>=a)
                return true;
            else
                return false;
        }
}
