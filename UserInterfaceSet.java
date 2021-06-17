import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

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
	        	 calcSet.setSet(display.getText(), displaySet2.getText());
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
	        	calcSet.clear();
	        }
	        else if(command.equals("Push Set A")) {}
	        else if(command.equals("Push Set B")) {}
	        else if(command.equals("Length Set A")) {}
	        else if(command.equals("Length Set B")) {}
	        
	        redisplay();
	    }
}
