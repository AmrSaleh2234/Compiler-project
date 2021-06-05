/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.IOException;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author hekal
 */
public class Compiler {
    
    Map<String, ArrayList<String>> multiValueMap = new HashMap<String, ArrayList<String>>();
    ArrayList<String> ids = new ArrayList<String>();
    ArrayList<Integer> index = new ArrayList<Integer>();
public Compiler(){
    multiValueMap.put("LineNo", new ArrayList<String>());
    multiValueMap.put("Lexeme", new ArrayList<String>());
    multiValueMap.put("ReturnToken", new ArrayList<String>());
    multiValueMap.put("LNL", new ArrayList<String>());
    multiValueMap.put("matchability", new ArrayList<String>());
   
}
public void compile(String string) throws IOException{
    
        int LineNo = 1;
        int LNL = 0 ;
        String rt = null;
      //  String[] ids = new String[1000];
      
        
        int in = 0;
        int state = 1 ;
        String id = "";
        String digit ="";
        try{
        for(int i = 0; i < string.length(); i++){
           char c = string.charAt(i);
           if (c=='\n'){
            LineNo+=1;
            LNL = 0 ;
           }
            switch(state){
                case(1):{
                    if(c == 'C'){id += "C";state = 2 ; 
                    }else if (c == 'N'){id += "N";state = 6 ;
                    }else if (c == 'G'){id += "G";state = 14 ; 
                    }else if (c=='R')  {id += "R";state = 21;
                    }else if (c == 'L'){id += "L";state = 38 ;
                    }else if (c =='Y') {id += "Y";state = 45;
                    }else if (c=='O')  {id += "O";state = 50;
                    }else if (c=='S')  {id += "S";state = 67;
                    }else if (c=='I')  {id += "I";state = 84;
                    }else if(c=='$')   {id += c;state = -1 ;rt="Token Delimiter";i--;
  
                    }else if (c=='/'){
                     if ( (i+1)< string.length()&& string.charAt(i+1) == '@' ){  id += "/";state = 92;
                     }else if ((i+1)< string.length()&& string.charAt(i+1) == '^'){ id += "/";state = 92;
                            }else{id += c;state = -1 ;rt="Arithmetic Operation";i--;
                     }}else if (c=='@'){id += "@";state = 95 ; 
                        }else if (c=='.'){id += c;state = -1 ;rt="LineDelimiter";i--;
                          
                        }else if (c=='"'){id += c;state = -1 ;rt="QuotationMark";i--;
                           
                        }else if (c=='\''){id += c;state = -1 ;rt="QuotationMark";i--;
                        }else if (c=='+'){id += c;state = -1 ;rt="Arithmetic Operation";i--;
                           
                            
                        }else if (c == '-'){
                            
                            if ( (i+1)< string.length()&& string.charAt(i+1) == '>' ){state = 101;}
                            else{id += c;state = -1 ;rt="Arithmetic Operation";i--;}
                    
                        }else if (c == '*'){id += c;state = -1 ;rt="Arithmetic Operation";i--;
                           
                        }else if ( c=='~'){id += c;state = -1 ;rt="Logic operators";i--;
                            
                        }else if (c =='&'){id += "&";state = 105;
                        }else if (c=='|'){id += "|";state = 107;
                        }else if (c == '='){
                            
                            if ( (i+1)< string.length()&& string.charAt(i+1) == '=' ){id += "=";state = 109;
                            }else{id += c;state = -1 ;rt="Assignment operator";i--;}
                            
                        }else if (c=='!'){
                            
                            if ((i+1)< string.length()&& string.charAt(i+1) == '=' ){id += "!";state = 111;}
                            else{ id += "!";state = 1 ;
                               
                                set("LineNo",String.valueOf(LineNo));
                                
                               // System.out.println(id);
                                //System.out.println(i);
                                set("Lexeme", id);
                                set("ReturnToken", "Error");
                                LNL++;
                                set("LNL", String.valueOf(LNL));
                                set("matchability", "UnMatched");  
                                id="";
                            }
                            
                        }else if (c =='<'){
                            if ( (i+1)< string.length()&& string.charAt(i+1) == '=' ){id += "<";state = 113;}
                            else{id += c;state = -1 ;rt="relational operators";i--;}
                            
                            
                        }else if (c =='>'){
                            if ( (i+1)< string.length()&& string.charAt(i+1) == '=' ){id += ">";state = 115;}
                            else {id += c;state = -1 ;rt="relational operators";i--;
                            }
                           
                        }else if (c=='{'){
                            id += c;state = -1 ;rt="Braces";i--;
                           
                        }else if (c=='}'){
                            id += c;state = -1 ;rt="Braces";i--;
                        }else if (c=='['){
                            id += c;state = -1 ;rt="Braces";i--;
                        }else if (c ==']'){
                            id += c;state = -1 ;rt="Braces";i--;
                        }else if (c == '('){
                            id += c;state = -1 ;rt="Braces";i--;
                        }else if (c == ')'){
                            id += c;state = -1 ;rt="Braces";i--;
                            
                          //////here the digit match function   
                        }else if (isDigit(c)|| isLetter(c)|| c=='_'){
                           
                            while (true){
                                if(isDigit(string.charAt(i+1) )|| isLetter(string.charAt(i+1))|| string.charAt(i+1) =='_'){
                                    id+=string.charAt(i);
                                    i++;
                                }else {
                                  id+=string.charAt(i);
                                  
                                  if(isid(id).equals("num")){
                                  state = -1 ;rt="Constant";i--;    
                                
                                }else if (isid(id).equals("id")){
                                 state = -1 ;rt="Identifier";i--; 
                                 
                               }else if (isid(id).equals("numid")){
                                      
                                      
                                ids.add(id);
                                index.add(i+1);
                               // System.out.println(ids.get(0));
                                //System.out.println(index.get(0));
                                set("LineNo",String.valueOf(LineNo));
                                set("Lexeme", id);
                                set("ReturnToken", "Error");
                                LNL++;
                                set("LNL", String.valueOf(LNL));
                                set("matchability", "UnMactched"); 
                                id="";
                                }else if (isid(id).equals("idnum")){
                                 state = -1 ;rt="Identifier";i--;}
                                break;}}
                        }else if(c ==' ' || c == '\n'||c =='\r'){
                                state = 1;
                        }}break;
             ///for print
                
                case(-1):{
                state = 1 ;
                
                set("LineNo",String.valueOf(LineNo));
                set("Lexeme", id);
                
                set("ReturnToken", rt);
                rt="";
                LNL++;
                set("LNL", String.valueOf(LNL));
                set("matchability", "Matched");
                id="";
                
                }break;
                    //Errorstate
                case(0):{while(true){
                        state = 1 ;
                        id += string.charAt(i-1);
                        if((i+1)<string.length()&& (string.charAt(i+1)=='$'|| string.charAt(i+1)=='.')||string.charAt(i+1)=='('){
                            state = 1 ;
                            id += string.charAt(i);
                           // System.out.println(id);
                            //System.out.println(i);
                                   
                                ids.add(id);
                                index.add(i+1);
                            set("LineNo",String.valueOf(LineNo));
                            set("Lexeme",id);
                            set("ReturnToken", "Error");
                            LNL++;
                            set("LNL", String.valueOf(LNL));
                            set("matchability", "UnMatched");
                            id = "";
                           
                            break;
                        }
                        if((i+1)<string.length()){
                        i++;}
                    }
                }break;
                case(2):{if(c=='h'){id += "h";state = 3 ;}else{state =0 ;}}break;
                case(3):{if(c=='j'){id += "j";state = 4 ;}else{state =0 ;}}break;
                case(4):{if(c=='i' && string.charAt(i+1)=='$'||string.charAt(i+1)=='.' ){
                    id += c;
                    rt="Character";
                    state=-1;
                    i--;
                    
                }else{state =0 ;}}break;
                case(6):{if(c=='O'){id += "O";state = 7 ;}else{state =0 ;}}break;
                case(7):{if(c=='R'){id += "R";state = 8 ;}else{state =0 ;}}break;
                case(8):{if(c=='e'){id += "e";state = 9 ;}else{state =0 ;}}break;
                case(9):{if(c=='t'){id += "t";state = 10 ;}else{state =0 ;}}break;
                case(10):{if(c=='u'){id += "u";state = 11 ;}else{state =0 ;}}break;
                case(11):{if(c=='r'){id += "r";state = 12 ;}else{state =0 ;}}break;
                case(12):{if(c=='n'){id += c;state = -1 ;rt="Void";i--;
               
                }else{state =0 ;}}break;
                case(14):{if(c=='e'){id += "e";state = 15 ;}else{state =0 ;}}break;
                case(15):{if(c=='t'){id += "t";state = 16 ;}else{state =0 ;}}break;
                case(16):{if(c=='B'){id += "B";state = 17 ;}else{state =0 ;}}break;
                case(17):{if(c=='a'){id += "a";state = 18 ;}else{state =0 ;}}break;
                case(18):{if(c=='c'){id += "c";state = 19 ;}else{state =0 ;}}break;
                case(19):{if(c=='k'){id += c;state = -1 ;rt="Return";i--;
               
                }else{state =0 ;}}break;
                case(21):{if(c=='e'){id += "e";state = 22 ;}else{state =0 ;}}break;
                case(22):{if(c=='p'){id += "p";state = 23 ;}else if(c=='i'){state = 31;}else{state =0 ;}}break;
                case(23):{if(c=='e'){id += "e";state = 24 ;}else{state =0 ;}}break;
                case(24):{if(c=='a'){id += "a";state = 25 ;}else{state =0 ;}}break;
                case(25):{if(c=='t'){id += "t";state = 26 ;}else{state =0 ;}}break;
                case(26):{if(c=='W'){id += "W";state = 27 ;}else{state =0 ;}}break;
                case(27):{if(c=='h'){id += "h";state = 28 ;}else{state =0 ;}}break;
                case(28):{if(c=='e'){id += "e";state = 29 ;}else{state =0 ;}}break;
                case(29):{if(c=='n'){id += c;state = -1 ;rt="Loop";i--;
                
                }else{state =0 ;}}break;
                case(31):{if(c=='t'){id += "t";state = 32 ;}else{state =0 ;}}break;
                case(32):{if(c=='e'){id += "e";state = 33 ;}else{state =0 ;}}break;
                case(33):{if(c=='r'){id += "r";state = 34 ;}else{state =0 ;}}break;
                case(34):{if(c=='a'){id += "a";state = 35 ;}else{state =0 ;}}break;
                case(35):{if(c=='t'){id += "t";state = 36 ;}else{state =0 ;}}break;
                case(36):{if(c=='e'){id += c;state = -1 ;rt="Loop";i--;
                
                }else{state =0 ;}}break;
                case(38):{if(c=='a'){id += "a";state = 39 ;}else if(c=='o'){id += "o";state = 42;}else{state =0 ;}}break;
                case(39):{if(c=='s'){id += "s";state = 40 ;}else{state =0 ;}}break;
                case(40):{if(c=='t'){id += c;state = -1 ;rt="End";i--;
               
                }else{state =0 ;}}break;
                case(42):{if(c=='l'){id += "l";state = 43 ;}else{state =0 ;}}break;
                case(43):{if(c=='i'&& string.charAt(i+1)=='$'||string.charAt(i+1)=='.'){id += c;state = -1 ;rt="Struct";i--;
               
                }else{state =0 ;}}break;
                case(45):{if(c=='e'){id += "e";state = 46 ;}else{state =0 ;}}break;
                case(46):{if(c=='s'){id += "s";state = 47 ;}else{state =0 ;}}break;
                case(47):{if(c=='i'){id += "i";state = 48 ;}else{state =0 ;}}break;
                case(48):{if(c=='f'){id += c;state = -1 ;rt="Condition";i--;
                
                }else{state =0 ;}}break;
                case(50):{if(c=='u'){id += "u";state = 51 ;}else if(c=='t'){id += "t";state = 57;}else if(c=='m'){ id += "m";state = 65;}else{state = -2 ;} }break;
                case(51):{if(c=='t'){id += "t";state = 52 ;}else{state =0 ;}}break;
                case(52):{if(c=='L'){id += "L";state = 53 ;}else{state =0 ;}}break;
                case(53):{if(c=='o'){id += "o";state = 54 ;}else{state =0 ;}}break;
                case(54):{if(c=='o'){id += "o";state = 55 ;}else{state =0 ;}}break;
                case(55):{if(c=='p'){id += c;state = -1 ;rt="Break";i--;
                
                }else{state =0 ;}}break;
                case(57):{if(c=='h'){id += "h";state = 58 ;}else{state =0 ;}}break;
                case(58):{if(c=='e'){id += "e";state = 59 ;}else{state =0 ;}}break;
                case(59):{if(c=='r'){id += "r";state = 60 ;}else{state =0 ;}}break;
                case(60):{if(c=='w'){id += "w";state = 61 ;}else{state =0 ;}}break;
                case(61):{if(c=='i'){id += "i";state = 62 ;}else{state =0 ;}}break;
                case(62):{if(c=='s'){id += "s";state = 63 ;}else{state =0 ;}}break;
                case(63):{if(c=='e'){id += c;state = -1 ;rt="Condition";i--;
               
                }else{state =0 ;}}break;
                case(65):{if(c=='w' &&( string.charAt(i+1)=='$'||string.charAt(i+1)=='.' ||string.charAt(i+1)==' ' ) ){id += c;state = -1 ;rt="Integer";i--;
               
                    
                
                }else{state =0 ;}
                }break;
                case(67):{if(c=='t'){id += "t";state = 68 ;}else if(c=='e'){id += "e";state = 72;}else if(c=='I'){id += "I";state = 79;} else{state =0 ;}}break;
                case(68):{if(c=='a'){id += "a";state = 69 ;}else{state =0 ;}}break;
                case(69):{if(c=='r'){id += "r";state = 70 ;}else{state =0 ;}}break;
                case(70):{if(c=='t'){id += c;state = -1 ;rt="Start";i--;
                
                }else{state =0 ;}}break;
                case(72):{if(c=='r'){id += "r";state = 73 ;}else{state =0 ;}}break;
                case(73):{if(c=='i'){id += "i";state = 74 ;}else{state =0 ;}}break;
                case(74):{if(c=='e'){id += "e";state = 75 ;}else{state =0 ;}}break;
                case(75):{if(c=='s'){id += "s";state = 76 ;}else{state =0 ;}}break;
                case(76):{if(c=='t'){id += "t";state = 77 ;}else{state =0 ;}}break;
                case(77):{if(c=='l'&& string.charAt(i+1)=='$'||string.charAt(i+1)=='.'){id += c;state = -1 ;rt="String";i--;
                
                }else{state =0 ;}}break;
                case(79):{if(c=='M'){id += "M";state = 80 ;}else{state =0 ;}}break;
                case(80):{if(c=='w'){id += "w";state = 81 ;}else{state =0 ;}}break;
                case(81):{if(c=='f'&& string.charAt(i+1)=='$'||string.charAt(i+1)=='.'){id += c;state = -1 ;rt="SFloat";i--;
               
                }else if(c=='w'&& string.charAt(i+1)=='$'||string.charAt(i+1)=='.'){id += c;state = -1 ;rt="SInteger";i--;
                
                }else{state =0 ;}}break;
                case(84):{if(c=='n'){id += "n";state = 85 ;}else if(c=='M'){id += "M";state = 124;}else{state =0 ;}}break;
                case(85):{if(c=='c'){id += "c";state = 86 ;}else{state =0 ;}}break;
                case(86):{if(c=='l'){id += "l";state = 87 ;}else{state =0 ;}}break;
                case(87):{if(c=='u'){id += "u";state = 88 ;}else{state =0 ;}}break;
                case(88):{if(c=='d'){id += "d";state = 89 ;}else{state =0 ;}}break;
                case(89):{if(c=='e'){id += c;state = -1 ;rt="Inclusion";i--;
               
                }else{state =0 ;}}break;
                case(92):{if(c=='@'){
                    id += "@";
                    state = 1 ;
               
                set("LineNo",String.valueOf(LineNo));
                set("Lexeme", id);
                set("ReturnToken", "Comment");
                LNL++;
                set("LNL", String.valueOf(LNL));
                set("matchability", "Matched");
                id="";
                //Skip Muliti line
                //-------------------------------------------------------------------------
              while(true){
                        i++;
                        if(string.charAt(i)=='\n'||string.charAt(i)=='\r'){LineNo++;LNL = 0 ;};
                        if((i+1)< string.length()&& string.charAt(i)=='@'&& string.charAt(i+1)=='/'){
                            i--;
                            state = 1 ;
                            break;
                        }
                    }
                //-------------------------------------------------------------------------
                }else if (c=='^'){id += "^";state = 1;
                set("LineNo",String.valueOf(LineNo));
                set("Lexeme", id);
                set("ReturnToken", "Comment");
                LNL++;
                set("LNL", String.valueOf(LNL));
                set("matchability", "Matched");
                id="";
                //Skip  line
                //-------------------------------------------------------------------------
                while(true){
                        i++;
                        if(string.charAt(i)=='\n'){LineNo++; LNL=0;  state = 1 ;break;};
                        
                    }
                //---------*----------------------------------------------------------------
                }else{state =0 ;}}break;
                case(95):{if(c=='/'){id += c;state = -1 ;rt="Comment";i--;
               
                }else{state =0 ;}}break;
                case(101):{if(c=='>'){id += c;state = -1 ;rt="Access Operator";i--;
               
                }else{state =0 ;}}break;
                case(105):{if(c=='&'){id += c;state = -1 ;rt="Logic operators";i--;
               
                }else{state =0 ;}}break;
                case(107):{if(c=='|'){id += c;state = -1 ;rt="Logic operators";i--;
                
                }else{state =0 ;}}break;
                case(109):{if(c=='='){id += c;state = -1 ;rt="relational operators";i--;
               
                }else{state =0 ;}}break;
                case(111):{if(c=='='){id += c;state = -1 ;rt="relational operators";i--;
                
                }else{state =0 ;}}break;
                case(113):{if(c=='='){id += c;state = -1 ;rt="relational operators";i--;
                }else{ state=0;}}break;
                case(115):{if(c=='='){id += c;state = -1 ;rt="relational operators";i--;
                }else{state=0;}
                }break;
                case(124):{if(c=='w'){id += "w";state = 125 ;}else{state =0 ;}}break;
                case(125):{if(c=='f'&& string.charAt(i+1)=='$'||string.charAt(i+1)=='.'){
                id += c;state = -1 ;rt="Float";i--;
                }else{state =0 ;}}break;         
    
    
        }}
}catch(Exception e ){

            //JOptionPane.showMessageDialog(null,"", "error", JOptionPane.ERROR_MESSAGE);
}
}


public void set(String Col , String Data){
       multiValueMap.get(Col).add(Data);
   }
   public ArrayList get(String col){
     // System.out.println(multiValueMap);
       return  (multiValueMap.get(col));
   }
   public String LastToken(){
      if (multiValueMap.get("Lexeme").isEmpty()){
          return null ;
      
      }else{
      return multiValueMap.get("Lexeme").get(multiValueMap.get("Lexeme").size()-1);
      }}
   public String loadFromFile(String path) throws IOException {
    return new String(Files.readAllBytes(Paths.get(path)));
    
      
}
   public String isid(String string){
        int len = string.length();
        String status = "" ;
        char[] string1 = string.toCharArray();

        for (int i = 0; i < len; i++){
            if (string1[i] >=48 && string1[i]<=57){
                if (status.contains("num")){
                continue;
                }else{
                status += "num" ; }}
            else if ((string1[i] >=65 && string1[i]<=90)|| string1[i]=='_'){
                if (status.contains("id")){
                    continue;
                }else{
                status += "id";}}
            else if ((string1[i]>=97 && string1[i]<=122)|| string1[i]=='_' ){
               if (status.contains("id")){
                    continue;
                }else{
                status += "id";}}
            
        }
        
        return status ; 
    }
  
   
}
