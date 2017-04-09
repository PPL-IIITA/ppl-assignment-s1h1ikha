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
public class MiserBoy extends Boy_details {

    public MiserBoy(String[] str) {
        super(str);
    }
    public void happiness(List <Boy_details> boys , List <Girl_details> girls ,Happying happy_array[]){
    int sum_cost = 0;
     for(Boy_details bb : boys){
         bb.happiness = bb.b_budget - sum_cost;
         sum_cost = sum_cost +100;
        }
    }
}

