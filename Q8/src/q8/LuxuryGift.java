/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q8;

/**
 *
 * @author dell
 */
public class LuxuryGift {
    double price, value;
	String giftName;
	LuxuryGift(String arr[]) {    //constructor
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

