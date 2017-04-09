/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q6;

/**
 *
 * @author dell
 */
public class Boy_details {
     public String name;
	public int intelligence;
	public int attractivness;
	public int minimum_attraction_req;
	public int b_budget;
	public String girlfriend;
	public String relationship_status;
        public int income;
        public double happiness;
        public int type;
        //public int happiness;
        public Boy_details(String str[]){  //input from txt file
            name=str[0];
            attractivness =Integer.parseInt(str[1]);
            b_budget=Integer.parseInt(str[2]);
            intelligence=Integer.parseInt(str[3]);
            minimum_attraction_req=Integer.parseInt(str[4]);
            
            girlfriend="no";
            relationship_status="single";
            income =Integer.parseInt(str[5]);
            type = Integer.parseInt(str[6]);
        }
        public boolean correct(int a,int e){
            if(this.b_budget>=e && this.minimum_attraction_req<=a)
                    return true;
            else
                    return false;
        }
    
}
