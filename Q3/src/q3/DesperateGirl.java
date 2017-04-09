/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;

import java.util.List;

/**
 *
 * @author dell
 */
public class DesperateGirl extends Girl_details{

    public DesperateGirl(String[] str) {
        super(str);
    }
    public void happiness(List <Boy_details> boys , List <Girl_details> girls ,Happying happy_array[]){
   int sum_cost = 0;
     //for(Boy_details bb : boys){
         for(Girl_details gg : girls){
         gg.happiness = Math.exp(sum_cost);
         sum_cost = sum_cost +100;
        }
    }
}
