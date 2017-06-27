import java.util.*;

public class Questions {
	public String questionType;
	public String unitNumber;
	public String amountDue;
	public String amountCollected;
	public String dateDue;
	public String dateCollected;


	public Questions(){
		this.questionType = "Rent";

	}

	public void ask_questions(){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Unit Number:  "); this.unitNumber = input.nextLine();
		System.out.print("Enter Amount Due:  "); this.amountDue = input.nextLine();
		System.out.print("Enter Amount Collected:  "); this.amountCollected = input.nextLine();
		System.out.print("Enter Date Due:  "); this.dateDue = input.nextLine();
		System.out.print("Enter Date Collected:  "); this.dateCollected = input.nextLine();
	}

	public String getVariable(String var_type){
		switch(var_type){
		case "questionType": return this.questionType;
		case "unitNumber": return this.unitNumber;
		case "amountDue": return this.amountDue;
		case "amountCollected": return this.amountCollected;
		case "dateDue": return this.dateDue;
		case "dateCollected": return this.dateCollected;
		default: return "Error, there is no... ("+var_type+")";

		}

		
	}

}//END questions
