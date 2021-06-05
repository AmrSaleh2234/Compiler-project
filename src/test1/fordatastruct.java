/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hheka
 */
public class fordatastruct {
    Map<String, ArrayList<String>> multiValueMap = new HashMap<String, ArrayList<String>>();
    
    
  public fordatastruct(){
    multiValueMap.put("LineNo", new ArrayList<String>());
    multiValueMap.put("Lexeme", new ArrayList<String>());
    multiValueMap.put("ReturnToken", new ArrayList<String>());
    multiValueMap.put("LNL", new ArrayList<String>());
    multiValueMap.put("matchability", new ArrayList<String>());
  }
   public void init(){
    
    
   }
   public void set(String Col , String Data){
       multiValueMap.get(Col).add(Data);
   }
   public ArrayList get(String col){
     // System.out.println(multiValueMap);
       return  (multiValueMap.get(col));
   }
   public String LastToken(){
      return (multiValueMap.get("Lexeme").get(multiValueMap.get("Lexeme").size()-1));
   }
}
