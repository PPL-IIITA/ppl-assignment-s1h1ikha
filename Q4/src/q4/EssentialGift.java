/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;

/**
 *
 * @author dell
 */
public class EssentialGift {
    double price, value;
	String giftName;
	int rating, difficulty;
	EssentialGift(String arr[]) {       //constructor
                value = Double.parseDouble(arr[2]);
		price = Double.parseDouble(arr[3]);	
		giftName = arr[4];
	}
        public boolean correct(int a,int e){
            if(this.value>=e && this.price<=a)
                    return true;
            else
                    return false;
        }
}
