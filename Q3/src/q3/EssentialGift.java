/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;

/**
 *
 * @author dell
 */
public class EssentialGift {
    double price, value;
	String giftName;
	int rating, difficulty;
	EssentialGift(String arr[]) {
                rating = Integer.parseInt(arr[0]);
		difficulty = Integer.parseInt(arr[1]);
		value = Double.parseDouble(arr[2]);
		price = Double.parseDouble(arr[3]);	
		giftName = arr[4];
	}
}
