package Mail;


import javax.swing.JTextField;
import java.awt.Toolkit;


        
public class MyInput{
	static void inputInteger(java.awt.event.KeyEvent evt){
		if(!Character.isDigit(evt.getKeyChar())){
                        Toolkit.getDefaultToolkit().beep();
			evt.consume();
		}
	}
	static void inputInteger(java.awt.event.KeyEvent evt, JTextField txt, int n){
		if(!Character.isDigit(evt.getKeyChar())){
			Toolkit.getDefaultToolkit().beep();
			evt.consume();
		}
		else
		{
			String st=txt.getText();
			if(st.length()>=n)
				evt.consume();
		}	
	}
	static void inputFloat(java.awt.event.KeyEvent evt, JTextField txt){
		if(evt.getKeyChar()==46){
			String st=txt.getText();
			if(st.indexOf(46)!=-1){
				evt.consume();
                        }
                }
		else if(!Character.isDigit(evt.getKeyChar()))
                {
			evt.consume();
                }
	}
        
        static String inputFloat(char num, JTextField txt){
            String st = txt.getText();
            if (num == 46) {
                
                if (st.indexOf(46) != -1) {
                    return "";
                }
                if(st.equals(""))
                    return "0.";

            }
//            if(num=='0'){
//                if(txt.getText().equals("0"))
//                    return "";
//            }
//            else{
//                if(!Character.isDigit(num))
//                {
//                   return "";
//                }
//            }
            return ""+num;
	}
        
        
        
        
        
        
	static void inputFloat(java.awt.event.KeyEvent evt, JTextField txt, int n){
		if(evt.getKeyChar()==46){
			String st=txt.getText();
			if(st.indexOf(46)!=-1){
				evt.consume();
			}
		}
		else if(!Character.isDigit(evt.getKeyChar())){
			evt.consume();
		}
		else
		{
			String st=txt.getText();
			if(!st.equals(""))
			{
				double num=Double.valueOf(st);
				st=""+((long)num);
                                       
				if(st.length()>=n){
				evt.consume();
				}
			}
		}
	}
	static void clearText(JTextField... txt){
		for(JTextField temp:txt){
			temp.setText("");
		}
		txt[0].grabFocus();
	}
        static boolean check(JTextField... txt){
            for(JTextField temp:txt){
                String st=temp.getText();
                if(st.equals("")){
                    temp.grabFocus();
                    return false;
                }
            }
            return true;
        }
}
