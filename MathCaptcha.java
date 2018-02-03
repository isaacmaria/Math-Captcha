
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.*;
class MathCaptcha{  
	
	static float output,res;

	static Label l = new Label();
	
	
	
public static void main(String args[]){  
    Frame f= new Frame("MATH CAPTCHA");  
    int max=9,min =0;
    Random rand = new Random();
    
  
	

    Button b1=new Button("ENTER");
    Button b2=new Button("RETRY");
    
    int num1,num2,op;
  
    

    int randomNum = rand.nextInt((max - min) + 1) + min;
    num1= randomNum;
    System.out.println(randomNum);
    String path="digits\\"+randomNum+".jpg";
    f.add(new JLabel(new ImageIcon(path)));
  
    randomNum = Math.abs(rand.nextInt())%3+1;
    op=randomNum;
    System.out.println(randomNum);
    
    path="operations\\"+randomNum+".jpg";
    f.add(new JLabel(new ImageIcon(path)));
  
    
    randomNum = rand.nextInt((max - min) + 1) + min;
    num2 =randomNum;
    System.out.println(randomNum);
    path="C:\\Users\\IsaacIvan\\Desktop\\MATH CAPTCHA\\digits\\"+randomNum+".jpg";
    f.add(new JLabel(new ImageIcon(path)));
  
    f.add(new JLabel(new ImageIcon("C:\\Users\\IsaacIvan\\Desktop\\MATH CAPTCHA\\operations\\5.jpg")));
  
    TextArea area=new TextArea("");  
    area.setSize(70, 70);
    f.add(area);  
  
    f.add(b1);
    f.add(b2);


    b1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){ 
        	
        	 output = Float.parseFloat(area.getText());
        System.out.println(output);
       
        
        switch(op)
        {
        case 1: res = num1+num2;
        	break;
        case 2: res = num1-num2;
        	break;
        case 3: res = num1*num2;
        	break;
        
        	
        }
        System.out.println(res);
        
     
        
        if(output==res)
        {	

        	l.setText("VALIDATED");
        	f.remove(b2);
        	
        }
        else
        {

        	l.setText("TRY AGAIN");
        	
        	
        	
        }
        	
            }  
        });  
  
    b2.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){ 
        		f.dispose();
        		MathCaptcha.main(null);
            }  
        }); 
    
    f.add(l);
    l.setText("");
    
    f.setSize(1800,300);  
    f.setLayout(new FlowLayout(FlowLayout.LEFT));  
    f.setVisible(true); 
    f.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
         }
     }
);
    
}  



}

