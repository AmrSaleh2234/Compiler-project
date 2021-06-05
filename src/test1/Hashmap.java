/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hheka
 */
public class Hashmap {
    public static void main(String[] args) throws IOException {
    Map<String, ArrayList<String>> multiValueMap = new HashMap<String, ArrayList<String>>();

    multiValueMap.put("LineNo", new ArrayList<String>());
    multiValueMap.put("Lexeme", new ArrayList<String>());
    multiValueMap.put("Return Token", new ArrayList<String>());
    multiValueMap.put("LNL", new ArrayList<String>());
    multiValueMap.put("matchability", new ArrayList<String>());
    multiValueMap.get("LineNo").add("1");
    multiValueMap.get("Lexeme").add("/^");
    multiValueMap.get("Return Token").add("Comment");
    multiValueMap.get("LNL").add("2");
    multiValueMap.get("matchability").add("Matched");
   // for (Map.Entry<String, ArrayList<String>> set : multiValueMap.entrySet()) {
		//    System.out.println(set.getKey() + " = " + set.getValue());
		//}
    
    System.out.println((multiValueMap.get("LineNo")));
}}
