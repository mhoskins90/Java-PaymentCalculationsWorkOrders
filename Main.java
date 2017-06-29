
import java.text.DecimalFormat;
import java.util.Scanner;//USED FOR USER INPUT
import java.text.NumberFormat;//USED FOR FORMATTING DECIMALS
//import Payments.Questions;


public class Main {
	public String continue_program  = "yes";
	Scanner input = new Scanner(System.in);

	private String section_choice;

	public void initial_question(){
		System.out.print("Choose to access (P) Payments or (W) Work Orders:  ");
		section_choice = input.nextLine();
	}//END INITIAL QUESTION

	public String getSectionChoice(){
		return this.section_choice;
	}//END GETTER

	public void setContinue(String var_continue){
		if (var_continue.toLowerCase().equals("q")){
			continue_program = var_continue;
		}
	}

	public static void main(String[] args){   
		//Scanner input = new Scanner(System.in);
		Main main = new Main();
		//System.out.println(section_choice);

		while ( main.continue_program.equals("yes") ){

			main.initial_question();
			String section_choice = main.getSectionChoice();

			if ( section_choice.toLowerCase().equals("p")  ) {

				try{//START PAYMENTS TRY
				DecimalFormat formatter = new DecimalFormat("#0.00"); 
				PaymentQuestions paymentQuestions = new PaymentQuestions();

				paymentQuestions.ask_questions();		

				String questionType = paymentQuestions.getVariable("questionType");
				String unitNumber = paymentQuestions.getVariable("unitNumber");
				String amountDue = paymentQuestions.getVariable("amountDue");
				String amountCollected= paymentQuestions.getVariable("amountCollected");
				String dateDue = paymentQuestions.getVariable("dateDue");
				String dateCollected= paymentQuestions.getVariable("dateCollected");

				System.out.println("\nYour entered data:\n"+unitNumber+", "+amountDue+", "+amountCollected+", "+dateDue+", "+dateCollected);
				float aDue = Float.parseFloat(amountDue);
				float aCollected = Float.parseFloat(amountCollected);

				float calculation = (float) aDue - aCollected;
				System.out.println("Unit "+unitNumber+" still owes $"+ formatter.format(calculation) );
				}catch(Exception e){
					System.out.println("Error in Payments:\n"+e);
				}//END PAYMENTS TRY

			}//END PAYMENTS CONDITIONAL
			//-------------------------------------------------------------------------------------------------------------------------
			else if ( section_choice.toLowerCase().equals("w")  ) {
				try{//START WORK ORDER TRY
				WorkOrderQuestions workOrderQuestions = new WorkOrderQuestions();

				workOrderQuestions.ask_questions();		

				String questionType = workOrderQuestions.getVariable("questionType");
				String unitNumber = workOrderQuestions.getVariable("unitNumber");
				String workOrderIssue = workOrderQuestions.getVariable("workOrderIssue");

				System.out.println("\nYour entered data:\n"+unitNumber+", "+workOrderIssue);

				System.out.println("Unit "+unitNumber+" has "+ workOrderIssue);
				}catch(Exception e){
					System.out.println("Error in Work Orders:\n"+e);
				}//END WORK ORDER TRY

			}//END WORK ORDERS CONDITIONAL

			System.out.print("\nEnter (Q) Quit to stop | Anything else to continue:  ");
			String continue_question = main.input.nextLine();//INPUT FROM MAIN OBJECT MAIN->INPUT
			main.setContinue(continue_question);
		}//END OUTER WHILE
	}//END MAIN METHOD
}//END PUBLIC CLASS MAIN
