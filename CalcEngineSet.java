import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CalcEngineSet extends CalcEngine{

    Set<String> setA = new HashSet<String>();
    Set<String> setB = new HashSet<String>();
    Set<String> setResult = new HashSet<String>();
    
    public static void main (String[] args) {
    	CalcEngineSet c = new CalcEngineSet();
    	c.setA.addAll(Arrays.asList(new String[] { "1", "3", "5", "7", "9" }));
    	c.setB.addAll(Arrays.asList(new String[] { "12", "1", "3", "4", "6", "9" }));
    	System.out.println("Set A: " + c.setA);
    	System.out.println("Set B: " + c.setB);
    	System.out.println(c.subtraction());
    	System.out.println("Set A: " + c.setA);
    	System.out.println("Set B: " + c.setB);
    	System.out.println("Set Res: " + c.setResult);
    	
    	   
    }

    public CalcEngineSet(){
        super();
    }
    
    public void clear() {}
    
    public Set<String> union(){
    	
    	setResult.addAll(setA);
    	setResult.addAll(setB);
    	
    	return setResult;
    }
    
    public Set<String> intersection(){
    	setResult.addAll(setA);
    	setResult.retainAll(setB);
    	
    	return setResult;
    }
    
    public Set<String> subtraction(){
    	setResult.addAll(setA);
    	setResult.removeAll(setB);
    	return setResult;
    }
}