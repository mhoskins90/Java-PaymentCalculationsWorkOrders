//import Payments.Questions;

import java.text.*;//USED FOR FORMATTING DECIMALS

public class Main {

	public static void main(String[] args){
		NumberFormat formatter = new DecimalFormat("#0.00");     

		try{
		Questions paymentQuestions = new Questions();


		paymentQuestions.ask_questions();		

		String questionType = paymentQuestions.getVariable("questionType");
		String unitNumber = paymentQuestions.getVariable("unitNumber");
		String amountDue = paymentQuestions.getVariable("amountDue");
		String amountCollected= paymentQuestions.getVariable("amountCollected");
		String dateDue = paymentQuestions.getVariable("dateDue");
		String dateCollected= paymentQuestions.getVariable("dateCollected");

		System.out.println("\nYour entered data:\n"+unitNumber+", "+amountDue+", "+amountCollected+", "+dateDue+", "+dateCollected);
		int aDue = Integer.parseInt(amountDue);
		int aCollected = Integer.parseInt(amountCollected);

			float calculation = (float) aDue - aCollected;
			System.out.println("Unit "+unitNumber+" still owes $"+ formatter.format(calculation));
		}
		catch(Exception e){
			System.out.println("Error, "+e);
		}


		//System.out.println(questionType);
		//paymentQuestions.ask_questions();
		



	}
}
