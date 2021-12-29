/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class making_inverseIndex {
    public void term_info(String term_index_file) throws IOException
    {
        BufferedWriter term_index = new BufferedWriter(new FileWriter("term_info.txt", true));
         String splited_term_index = new String(Files.readAllBytes(Paths.get(term_index_file)));
          String[] info_of_oneterm = splited_term_index.split("\n");
          //System.out.print("length"+info_of_oneterm.length);
          //File readFile = new File("/your/file/here");
          //BufferedReader reader = null;
          double total_bytes=0;
          double t=0;
          int term_count=1;
          System.out.print(info_of_oneterm.length);
          for(int i=0;i<info_of_oneterm.length-1;i++)
          {
             // System.out.println((i+1)+"    ");
              term_index.append((term_count)+"    ");
              term_index.append(total_bytes+"    ");
              t=total_bytes;
              byte[] b = info_of_oneterm[i].getBytes(StandardCharsets.UTF_8);
              int len=b.length;
              total_bytes=len+total_bytes+3;////two bytes for two endline characters plus one to go next line
              String[] one_docinfo = info_of_oneterm[i].split("    ");
              int num_of_docs_exist=(one_docinfo.length-1);
              int total_count=0;
              if(term_count==330)
                  {
                      int cc=0;
                      cc=1;
                  }
              for (int term_num = 1; term_num < one_docinfo.length; term_num++)
              {
                  String[] count_of_one_term = one_docinfo[term_num].split(":");
                  
                  total_count=total_count+Integer.parseInt(count_of_one_term[1]);   
              }
              i=i+1;////to ignore one extra "\n"
              System.out.println((term_count)+"    "+t+"    "+num_of_docs_exist+"    "+total_count+"\n");
              t=total_bytes;
              term_index.append(num_of_docs_exist+"    "+total_count+"\n"); 
              term_count++;
          }
         
        
    }

    
    public void inversing(String adres_of_docindex) throws IOException 
    {
        System.out.println("ffffffffffff");
        int doc_num = 1;
        int total_terms=171149;
        BufferedWriter term_index = new BufferedWriter(new FileWriter("term_index.txt", true));
        String doc_term = new String(Files.readAllBytes(Paths.get(adres_of_docindex)));
           //HashMap<Integer,HashMap<Integer,Integer>> hm=new HashMap<Integer,HashMap<Integer,Integer>>();
           Map<Integer, LinkedHashMap<Integer, Integer>> hm = new HashMap<Integer, LinkedHashMap<Integer, Integer>>();
           
        //for (int term_num = 1; term_num <= total_terms; term_num++) 
       // {
            //hm.put(1, null);
            //term_index.append(term_num+"    ");

            String[] info_of_onedoc = doc_term.split("\n");
            
            for (int single_doc=0;single_doc<info_of_onedoc.length;single_doc++) 
            {
                
                String[] info_one_term = info_of_onedoc[single_doc].split("    ");
                //System.out.println(" docid  "+info_one_term[0]);
                //System.out.println(" 1  "+info_one_term[1]);
                //System.out.println(" 2  "+info_one_term[2]);
                
                for (int i = 1; i < info_one_term.length; i++) 
                {
                     String[] count_of_one_term = info_one_term[i].split(":");
                     int term_count_in_curent_doc=Integer.parseInt(count_of_one_term[1]);
                     int id_of_term=Integer.parseInt(count_of_one_term[0]);
                     int id_of_doc=Integer.parseInt(info_one_term[0]);
                    
                    if(hm.containsKey(id_of_term))
                    {
                        hm.get(id_of_term).put(id_of_doc,term_count_in_curent_doc);
                    }
                    else
                    {
                        //HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
                        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
                        map.put(id_of_doc,term_count_in_curent_doc);
                        hm.put(id_of_term, map);
                    }
                    
                    
                   // System.out.println(" ist_pair"+info_one_term[i]);
//                    if(Integer.parseInt(count_of_one_term[0])>term_num)
//                    {
//                        break;
//                    }
                    //System.out.println(" term_id"+count_of_one_term[0].toString());
                    //System.out.println(String.valueOf(String.valueOf(term_num)));
//                    if(count_of_one_term[0].equals(String.valueOf(term_num)))
//                    {
//                        term_index.append(doc_num+":"+count_of_one_term[1]+"    ");
//                        break;
//                    }

                }
                //doc_num++;
                single_doc=single_doc+2;/////to ignore two endl
            }
            //doc_num=1;
           // term_index.append("\n\n");
       // }
       int size=hm.size();
        for (Map.Entry<Integer, LinkedHashMap<Integer, Integer>> set
                : hm.entrySet()) 
        {
           int term_id=set.getKey();
           term_index.append(term_id+"    ");
            for (Map.Entry<Integer, Integer> entry : set.getValue().entrySet()) 
            {
                term_index.append(entry.getKey()+":"+entry.getValue()+"    ");
                
                //System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            }
            term_index.append("\n\n");
//            // Printing all elements of a Map
//            System.out.println(set.getKey() + " = "
//                    + set.getValue());
        }
        String Term_index_file_address="C:\\Users\\Dell\\Desktop\\part2 ir\\term_index.txt";
        term_info(Term_index_file_address);
    }
}
