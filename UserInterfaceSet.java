import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserInterfaceSet extends UserInterface {

    JTextField displaySet2;
    private JTextField displayResult;
    CalcEngineSet calcSet;

    /**
     * Create a user interface.
     *
     * @param engine The calculator engine.
     */
    public UserInterfaceSet(CalcEngineSet engine) {
        super(engine);
        calcSet = engine;
    }
    
    
	public void makeFrame() {
		frame = new JFrame(calc.getTitle());
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        JPanel topSet = new JPanel();
        JPanel bottomSet = new JPanel();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField("Set A");
        displaySet2 = new JTextField("Set B");
        
        JPanel containerPanel = new JPanel(new GridLayout(2, 1));
       
        
        containerPanel.add(display);
        containerPanel.add(displaySet2);
        contentPane.add(containerPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4));
            addButton(buttonPanel, "Union");
            addButton(buttonPanel, "Intersection");
            addButton(buttonPanel, "Subtraction");
            addButton(buttonPanel, "Clear");
            
            addButton(buttonPanel, "Push Set A");
            addButton(buttonPanel, "Push Set B");
            addButton(buttonPanel, "Length Set A");
            addButton(buttonPanel, "Length Set B");
            
            
           
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        
        displayResult = new JTextField("Result");
        
        contentPane.add(displayResult, BorderLayout.SOUTH);
        //contentPane.add(status, BorderLayout.SOUTH);
        
        

        frame.pack();
	}

	 public void actionPerformed(ActionEvent event)
	    {
	        String command = event.getActionCommand();

	        if(command.equals("Union")) {
	        	//get the JTexts for set A and set B and save in field vars in class CalcEngineSet
	        	 calcSet.setSet(display.getText(), displaySet2.getText());
	        	 //call union() and set resulting set as result text
	             displayResult.setText( calcSet.union().toString());
	        }
	        else if(command.equals("Intersection")) {
	        	calcSet.setSet(display.getText(), displaySet2.getText());
	        	 displayResult.setText( calcSet.intersection().toString());
	        }
	        else if(command.equals("Subtraction")) {
	        	calcSet.setSet(display.getText(), displaySet2.getText());
	        	 displayResult.setText( calcSet.subtraction().toString());
	        }
	        else if(command.equals("Clear"))  {
	        	display.setText("Set A");
	        	displaySet2.setText("Set B");
	        	displayResult.setText("Result");
	        }
	        else if(command.equals("Push Set A")) {
	        		if(displayResult.getText().equals("Result")) {} //do nothing
	        		else display.setText(calcSet.pushSetA());
	        	} 
	        else if(command.equals("Push Set B")) {
	        	if(displayResult.getText().equals("Result")) {} //do nothing
        		else displaySet2.setText(calcSet.pushSetB());
	        } 
	        else if(command.equals("Length Set A")) {
	        	calcSet.setSet(display.getText(), displaySet2.getText());
	        	displayResult.setText(calcSet.lengthSetA());
	        }
	        else if(command.equals("Length Set B")) {
	        	calcSet.setSet(display.getText(), displaySet2.getText());
	        	displayResult.setText(calcSet.lengthSetB());
	        }
	        
	       
	        
	        //redisplay();
	    }
}
