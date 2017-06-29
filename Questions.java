import java.lang.Integer;
import java.util.Scanner;
import java.lang.System;
import java.text.DecimalFormat;
import java.text.NumberFormat;//USED FOR FORMATTING DECIMALS

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
		//DecimalFormat formatter = new DecimalFormat("#0.00");
		QuestionValidation validate = new QuestionValidation("Payment");
		Scanner input = new Scanner(System.in);
		while (true){
			System.out.print("Enter Unit Number:  "); 
			String concreteUnitNumber =  input.nextLine();
			if (validate.validate_integer(concreteUnitNumber) == "good"){
				//System.out.println("--INPUT VALID--");
				this.setVariable("unitNumber", concreteUnitNumber);
				break;
			}else{
				System.out.println("\nError, not an integer. Try again.\n");
				continue;
			}//END VALIDATION OF INT
		}//END WHILE
		//------------------------------------------------------
		while(true){
			System.out.print("Enter Amount Due:  "); 
			String concreteAmountDue =  input.nextLine();
			if (validate.validate_monetary_value(concreteAmountDue) == "good"){
				this.setVariable("amountDue", concreteAmountDue );
				break;
			}else{
				System.out.println("\nError, not monetary value. Try again.\n");
				continue;
			}//END VALIDATION CONDITIONAL
		}//END WHILE
		//------------------------------------------------------
		while(true){
			System.out.print("Enter Amount Collected:  "); 
			String concreteAmountCollected =  input.nextLine();
			if (validate.validate_monetary_value(concreteAmountCollected) == "good"){
				this.setVariable("amountCollected", concreteAmountCollected );
				break;
			}else{
				System.out.println("\nError, not monetary value. Try again.\n");
				continue;
			}//END VALIDATION CONDITIONAL
		}//END WHILE
		//------------------------------------------------------
		while(true){
			System.out.print("Enter Date Due (mm/dd):  "); 
			String concreteDateDue =  input.nextLine();
			if (validate.validate_date(concreteDateDue) == "good"){
				this.setVariable("dateDue", concreteDateDue );
				break;
			}else{
				System.out.println("\nError, not correct date format. Try again.\n");
				continue;
			}//END VALIDATION CONDITIONAL
		}//END WHILE
		//------------------------------------------------------
		while(true){
			System.out.print("Enter Date Collected (mm/dd):  "); 
			String concreteDateCollected =  input.nextLine();
			if (validate.validate_date(concreteDateCollected) == "good"){
				this.setVariable("dateCollected", concreteDateCollected );
				break;
			}else{
				System.out.println("\nError, not correct date format. Try again.\n");
				continue;
			}//END VALIDATION CONDITIONAL
		}//END WHILE
	}//END ASK QUESTIONS

}//END CLASS PAYMENT QUESTIONS

class WorkOrderQuestions extends Questions{
	
	public WorkOrderQuestions(){
		this.questionType = "WorkOrder";
	}//END CONSTRUCTOR

	@Override
	public void ask_questions(){
		Scanner input = new Scanner(System.in);
		QuestionValidation validate = new QuestionValidation("WorkOrder");

		while (true){
			System.out.print("Enter Unit Number:  "); 
			String concreteUnitNumber =  input.nextLine();
			if (validate.validate_integer(concreteUnitNumber) == "good"){
				//System.out.println("--INPUT VALID--");
				this.setVariable("unitNumber", concreteUnitNumber);
				break;
			}else{
				System.out.println("\nError, not an integer. Try again.\n");
				continue;
			}//END VALIDATION OF INT
		}//END WHILE
		//------------------------------------------------------
		while (true){
			System.out.print("Enter Work Order Issue:  "); 
			String conreteWorkOrderIssue = input.nextLine();
			if (validate.validate_string_length(conreteWorkOrderIssue) == true){
				this.setVariable("workOrderIssue", conreteWorkOrderIssue);
				break;
			}else{
				System.out.println("\nError, must enter more than 2 characters. Try again.\n");
				continue;
			}
		}//END WHILE
	}//END ASK QUESTIONS

}//END CLASS WORK ORDER QUESTIONS
