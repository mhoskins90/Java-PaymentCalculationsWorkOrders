import java.text.DateFormat;
import java.text.SimpleDateFormat;

class QuestionValidation{
	public String type;
	public QuestionValidation( String questionType ){
		this.type = questionType;
		//this.input = userInput;

	}//END CONSTRUCTOR

	public String validate_integer(String userInput){
		
		try{
			int input = Integer.parseInt(userInput);
			return "good";
		} catch(Exception e){
				//System.out.println("Error:\n"+e);
				return "bad";
		}//END INT VALIDATION CLAUSE
	}//END VALIDATE INTEGER METHOD

	public String validate_monetary_value(String userInput){

		if (userInput.matches("[-+]?[0-9]*\\.?[0-9]+")) { 
    		// Is a number - int, float, double
    		//System.out.print("--INPUT VALID--");     
    		return "good";   
		}else{
			//System.out.print("--INPUT VALID--");     
			return "bad";  
		}//END MONEY VALUE CONDITIONAL
	}//END VALIDATE MONEY VALUE METHOD

	public String validate_date(String userInput){
		try{
			DateFormat formatter = new SimpleDateFormat("mm/dd");
			formatter.setLenient(false);
			formatter.parse(userInput.trim());
			return "good";
		} catch(Exception e){
				//System.out.println("Error:\n"+e);
				return "bad";
		}//END INT VALIDATION CLAUSE
	}//END VALIDATE DATE

	public Boolean validate_string_length(String userInput){
		if (userInput.length() < 2){
			return false;
		} else{
			return true;
		}
	}//END VALIDATE STRING LENGTH METHOD

}//END CLASS QUESTION VALIDATION