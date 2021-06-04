/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

/**
 *
 * @author Dell
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    List<String> s;  
    String word = "";
    int flag = 0;
    int loc = 0;
    String []LineWords;
    int WordI = 0;
    String line= "";
    int f =0;
  //  SuggestionLabel sugg;
    AutoSuggestor autoSuggestor ;
    public NewJFrame() throws IOException {
        initComponents();
       // s = new TreeSet<String>();
//       sugg = new SuggestionLabel();
        s=new ArrayList<String>();
        LineWords = new String[500];
        File file = new File("E:\\College\\Level 3\\Read.txt");
        JFrame f = new JFrame();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){
            s.add(st);
        }
        
        autoSuggestor = new AutoSuggestor(jTextArea1, this, (ArrayList<String>) s, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            boolean wordTyped(String typedWord) {
               // System.out.println(typedWord);
                return super.wordTyped(typedWord);//checks for a match in dictionary and returns true or false if found or not
            }
        };
        
    
    
    }
int pos = 0;
    private void highligh(JTextComponent textComp, String pattern) {
        try
            {
                Highlighter hilite = textComp.getHighlighter();
                Document doc = textComp.getDocument();
                String text = doc.getText(0, doc.getLength());
                if((loc-pattern.length()) < loc){
                    hilite.addHighlight(loc-pattern.length(), loc, myHighlightPainter);
                  //  pos+= pattern.length();
                }
                
            }
            catch(Exception e)
            {
                
            }
    }
 /*   
    public void removeHighlights(JTextComponent jTextArea, String turnLightOff) {


           Highlighter hilite = jTextArea.getHighlighter();

           Highlighter.Highlight[] hilites = hilite.getHighlights();

           for (int i = 0; i < hilites.length; i++) {

              if(hilites[i].equals(turnLightOff))
              {
               int wordLenght = hilites[i].getEndOffset() - hilites[i].getStartOffset();

              if(wordLenght == turnLightOff.length()){

                  if (hilites[i].getPainter() instanceof TextHighLighter) {

                      hilite.removeHighlight(hilites[i]);
              }

              }
              }
           }                
}*/
    
   /* private void removehighligh(JTextComponent textComp, String pattern) {
        try
            {
                Highlighter hilite = textComp.getHighlighter();
                Document doc = textComp.getDocument();
                String text = doc.getText(0, doc.getLength());
                if((loc-pattern.length()) < loc){
                    hilite.removeHighlight(myHighlightPainter);
                  //  pos+= pattern.length();
                }
                
            }
            catch(Exception e)
            {
                
            }
    }
    public void removeHighlights(JTextComponent jTextArea, String turnLightOff) {


           Highlighter hilite = jTextArea.getHighlighter();

           Highlighter.Highlight[] hilites = hilite.getHighlights();

           for (int i = 0; i < hilites.length; i++) {

              int wordLenght = hilites[i].getEndOffset() - hilites[i].getStartOffset();

              if(wordLenght == turnLightOff.length()){

                  if(hilites[i].getPainter() instanceof TextHighLighter) {
                      hilite.removeHighlight(hilites[i]);
                  } else {
                  }

              }
           }                
}*/
      Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.red);
     /* Highlighter.HighlightPainter light = new MyHighlightPainter(Color.yellow);
      
       private void highlighyellow(JTextComponent textComp, String pattern) {
        try
            {
                Highlighter hilite = textComp.getHighlighter();
                Document doc = textComp.getDocument();
                String text = doc.getText(0, doc.getLength());
                if((loc-pattern.length()) < loc){
                    hilite.addHighlight(WordI-pattern.length(), WordI, light);
                  //  pos+= pattern.length();
                }
                
            }
            catch(Exception e)
            {
                
            }
    }*/
   
    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter
    {

        public MyHighlightPainter(Color color) {
            super(color);
        }
        
    }
    
   
  /*  public void highlight(JTextComponent textComp, String pattern)
        {
            try
            {
                Highlighter hilite = textComp.getHighlighter();
                Document doc = textComp.getDocument();
                String text = doc.getText(0, doc.getLength());
                int pos = 0;
                while((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos)) >= 0)
                {
                    hilite.addHighlight(pos, pos+pattern.length(), myHighlightPainter);
                    pos+= pattern.length();
                }
            }
            catch(Exception e)
            {
                
            }
        }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("framee");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName(""); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setForeground(new java.awt.Color(204, 0, 51));
        jButton1.setText("Scan");

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(204, 255, 204));
        exitButton.setForeground(new java.awt.Color(204, 51, 0));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(exitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 605, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(exitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
         /*   if(evt.getKeyCode()==KeyEvent.VK_DELETE ||evt.getKeyCode()==KeyEvent.VK_CAPS_LOCK ||evt.getKeyCode()==KeyEvent.VK_SHIFT ||evt.getKeyCode()==KeyEvent.VK_ENTER ||evt.getKeyCode()==KeyEvent.VK_SPACE || evt.getKeyCode()==KeyEvent.VK_4)
            {
               // System.out.println("HIIIIII");
            }
            else if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE)
            {
                WordI--;
            }
            else 
            {       
                WordI++;
            }
            line = jTextArea1.getText();
            for(String data:s)
            {
                for(int i=0; i<LineWords.length ; i++)
                {
                   // System.out.println(LineWords[i]);
                    
                    LineWords = line.split("\\$");
                    if(s.equals(LineWords[i]))
                    {
                        highligh(jTextArea1,LineWords[i]);
                        System.out.println(LineWords[i]);
                    }
                    
                }
            }  */
         
         
              // TODO add your handling code here:
  /*      String to_check = jTextArea1.getText();
        int to_check_len = to_check.length();
     //   int flag=0;
     
         /*    String text = jTextArea1.getText();
        //String []st = text.split(" ");
        String to_check = text.substring(text.lastIndexOf(" ")+1);
         
         
        for(String data:s)
        {
           
            if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getKeyCode()==KeyEvent.VK_DELETE ||evt.getKeyCode()==KeyEvent.VK_CAPS_LOCK ||evt.getKeyCode()==KeyEvent.VK_SHIFT ||evt.getKeyCode()==KeyEvent.VK_ENTER)
            {

            }
            else 
            {   
                String check_from_data = "";
                for(int i=0; i<to_check_len; i++)
                {
                    if(to_check_len <= data.length())
                    {
                        
                        check_from_data = check_from_data + data.charAt(i);
                        
                    }
                }
                if(check_from_data.equals(to_check))
                {
                    jTextArea1.setText(data);
                    jTextArea1.setSelectionStart(to_check_len);
                    jTextArea1.setSelectionEnd(data.length());
                    
                    break;
                }
            }
            
        }*/
        
      //  System.out.println(autoSuggestor.sugg);
       // System.out.println(autoSuggestor.sugglen);
        if(evt.getKeyCode()==KeyEvent.VK_DELETE ||evt.getKeyCode()==KeyEvent.VK_CAPS_LOCK ||evt.getKeyCode()==KeyEvent.VK_SHIFT ||evt.getKeyCode()==KeyEvent.VK_ENTER ||evt.getKeyCode()==KeyEvent.VK_SPACE || evt.getKeyCode()==KeyEvent.VK_4)
        {
           // System.out.println("HIIIIII");
        }
        else if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE)
        {
            if(loc>0)
            {
                loc--;
                /* StringBuffer sb= new StringBuffer(word);
                sb.deleteCharAt(sb.length()-1);*/

                if(word.length()==0 || word.length()==1)
                {
                    word="";
                }
                else
                {
                    word = word.substring(0, word.length()-1);
                }
                  // System.out.println(word.length());
            }
           // System.out.println(loc);
            
        }
        else{
            word += evt.getKeyChar();
            loc ++;
           // loc = evt.getKeyLocation();
        }
           /* if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                word = "";
                line = "";
                lineInMemory = line;
            }*/
if(f==0){
        if(evt.getKeyCode() == KeyEvent.VK_SPACE || evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode()==KeyEvent.VK_4) {
            System.out.println("SECOND!!!!!!!!!!!!!!!!!!!!");
          //  loc = evt.getKeyLocation();
            for(int i=0 ;i<s.size();i++)
            {
            //    System.out.println(s.get(i));
              //  System.out.println(word);
                if(word.equals(s.get(i)))
                {
                    flag = 1;
                    break;
                }
                
            }
            LineWords[WordI] = word;
            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            {
                WordI = 0;
            }
            else
            {
                WordI++;
            }
            
            if(flag == 0 && !LineWords[0].equals("/^"))
            {
                System.out.println("HIIIIIIIIIIIIIIIIIIII!!!!!!!!!!!!!!!!");
                System.out.println(word);
                //jTextArea1.setForeground(Color.red);
                highligh(jTextArea1,word);
                System.out.println(loc);

            }
         /*   else{
                jTextArea1.setForeground(Color.black);
                System.out.println(loc);
            }*/
            word = "";
            flag = 0;
            loc++;
       /*     word = word.replaceAll("null","");
            line += word;
            word = "";
            String text = textarea.getText();
            String[] words = line.split(" ");*/
        }
}
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
       //  this.setVisible (false);
         System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
      try{  JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename= f.getAbsolutePath();
        
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            jTextArea1.read(br, null);
            br.close();
           // jTextArea1.requestFocus();
        }
        catch(Exception e)
        {
            System.out.println("ERRORRR!!!!!!!!!!!!!!!!!!!");
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
