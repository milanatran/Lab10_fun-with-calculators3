import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CalcEngineSet extends CalcEngine{

    Set<String> setA = new HashSet<String>();
    Set<String> setB = new HashSet<String>();
    Set<String> setResult = new HashSet<String>();
    
    public static void main (String[] args) {
    	//testing the methods (will be deleted)
    	CalcEngineSet c = new CalcEngineSet();
    	c.setA.addAll(Arrays.asList(new String[] { "1", "2", "3", "4"}));
    	c.setB.addAll(Arrays.asList(new String[] { "3", "4", "5", "6" }));
    	System.out.println("Intersection" + c.intersection());
    	System.out.println("Set A: " + c.setA);
    	System.out.println("Set B: " + c.setB);
    	System.out.println("Union" + c.union());
    	System.out.println("Set A: " + c.setA);
    	System.out.println("Set B: " + c.setB);
    	System.out.println("Intersection" + c.intersection());
    	System.out.println("Set A: " + c.setA);
    	System.out.println("Set B: " + c.setB);
    	System.out.println("Set Res: " + c.setResult);
    	
    	   
    }

    public CalcEngineSet(){
        super();
    }
    
    
    //Converts the String from text inputs to a set
    public Set<String> stringToSet(String input) {
    	Set<String> set = new HashSet<String>();
		String[] array = input.split("");
		for(String s : array) {
			set.add(s);
		}
    	return set;
    }
    
  
    
    //saves the text inputs converted as sets into the field vars setA and setB
    public void setSet(String inputA, String inputB) {
    	setA = stringToSet(inputA);
    	setB = stringToSet(inputB);
    }
    
    //Calculates the union between setA and setB
    //returns the result set
    public Set<String> union(){
    	//first empty out the setResult
    	setResult.removeAll(setResult);
    	setResult.addAll(setA);
    	setResult.addAll(setB);
    	
    	return setResult;
    }
    
    
  //Calculates the intersection between setA and setB
    //returns the result set
    public Set<String> intersection(){
    	setResult.removeAll(setResult);
    	setResult.addAll(setA);
    	setResult.retainAll(setB);
    	
    	return setResult;
    }
    
    
  //Calculates the subtraction between setA and setB
    //returns the result set
    public Set<String> subtraction(){
    	setResult.removeAll(setResult);
    	setResult.addAll(setA);
    	setResult.removeAll(setB);
    	return setResult;
    }
    
    
}