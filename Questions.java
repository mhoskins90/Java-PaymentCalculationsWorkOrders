import java.util.*;

public abstract class Questions {
	//UNIVERSAL
	public String questionType;
	private String unitNumber;
	//PAYMENTS
	private String amountDue;
	private String amountCollected;
	private String dateDue;
	private String dateCollected;
	//WORK ORDERS
	private String workOrderIssue;

	public Questions(){
		this.questionType = "Unknown";
	}//END CONSTRUCTOR

	public void ask_questions(){
		System.out.print("Called From Abstract Class - Questions");
	}//END ASK QUESTIONS

	public String getVariable(String var_type){
		switch(var_type){
			//UNIVERSAL
			case "questionType": return this.questionType;
			case "unitNumber": return this.unitNumber;
			//PAYMENTS
			case "amountDue": return this.amountDue;
			case "amountCollected": return this.amountCollected;
			case "dateDue": return this.dateDue;
			case "dateCollected": return this.dateCollected;
			//WORK ORDERS
			case "workOrderIssue": return this.workOrderIssue;
			//DEFAULT
			default: return "Error, there is no... ("+var_type+")";
		}//END SWITCH
	}//END GET VARIABLE

	public String setVariable(String var_type, String var_to_set){
		switch(var_type){
			//UNIVERSAL
			case "questionType": this.questionType = var_to_set;
			case "unitNumber": this.unitNumber = var_to_set;
			//PAYEMENTS
			case "amountDue": this.amountDue = var_to_set;
			case "amountCollected": this.amountCollected = var_to_set;
			case "dateDue": this.dateDue = var_to_set;
			case "dateCollected": this.dateCollected = var_to_set;
			//WORK ORDERS
			case "workOrderIssue": this.workOrderIssue = var_to_set;
			//DEFAULT
			default: return "Error, there is no... ("+var_type+")";
		}//END SWITCH
	}//END GET VARIABLE
}//END PUBLIC CLASS QUESTIONS

class PaymentQuestions extends Questions{
	
	public PaymentQuestions(){
		this.questionType = "Rent";
	}//END CONSTRUCTOR

	@Override
	public void ask_questions(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Unit Number:  "); 
		this.setVariable("unitNumber", input.nextLine());
		//------------------------------------------------------
		System.out.print("Enter Amount Due:  "); 
		this.setVariable("amountDue", input.nextLine());
		//------------------------------------------------------
		System.out.print("Enter Amount Collected:  "); 
		this.setVariable("amountCollected", input.nextLine());
		//------------------------------------------------------
		System.out.print("Enter Date Due:  "); 
		this.setVariable("dateDue", input.nextLine());
		//------------------------------------------------------
		System.out.print("Enter Date Collected:  "); 
		this.setVariable("dateCollected", input.nextLine());
	}//END ASK QUESTIONS

}//END CLASS PAYMENT QUESTIONS

class WorkOrderQuestions extends Questions{
	
	public WorkOrderQuestions(){
		this.questionType = "Rent";
	}//END CONSTRUCTOR

	@Override
	public void ask_questions(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Unit Number:  "); 
		this.setVariable("unitNumber", input.nextLine());
		//------------------------------------------------------
		System.out.print("Enter Work Order Issue:  "); 
		this.setVariable("workOrderIssue", input.nextLine());
	}//END ASK QUESTIONS

}//END CLASS WORK ORDER QUESTIONS