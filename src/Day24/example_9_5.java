package Day24;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class example_9_5 extends JFrame{

	String[] str= {"이름", "학번", "학과", "과목"}; 
	example_9_5(){ 
		setTitle("GridLayout Test02"); 
		setSize(300,300); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		Container c=getContentPane(); 
		c.setLayout(new GridLayout(4,2,5,5)); 
		for(int i=0; i<8; i++) { 
			if(i%2==0) { 
				JLabel l=new JLabel(str[i/2]); c.add(l);
			} else { JTextField tf=new JTextField(""); 
				c.add(tf); 
				} 
		} setVisible(true); 
	} 

	public static void main(String[] args) {
		new example_9_5(); 
	}

}
