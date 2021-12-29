/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question_2;

import java.io.IOException;

/**
 *
 * @author Dell
 */
public class test
{
    public static void main(String[] args) throws IOException 
    {
        String adres_of_docindex="C:\\Users\\Dell\\Desktop\\part2 ir\\doc_index.txt";
        making_inverseIndex obj1=new making_inverseIndex();
        obj1.inversing(adres_of_docindex);
    }
    
}
