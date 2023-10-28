package com.food.utility;

import org.springframework.stereotype.Component;

import com.food.exception.AmtException;

@Component
public class OrderConformation {public String payment(int amt ,int option,int actualamt) throws AmtException
{
	
String str;
if(option==1)
	
{
	System.out.println("You have selected cash on delivery option");
	System.out.println("you can pay for food when you received your Delivery");
	System.out.println("Amount of food rs:"+amt);
	System.out.println("Cash paid Successfully Enjoy your food....!");
	System.out.println("Thank you...!");
	return "Cash on Delivery confirmed";
	
}
else if(option==2)
	
{ 
	if(amt==actualamt) 
	{
	System.out.println("You have selected Online Payment");
	System.out.println("Online Payment done Successfully rs:"+amt);
	System.out.println("Your Order will be Delivered in 30-mins Enjoy your food");
	System.out.println("Thank you...!");	
	return " Delivery confirmed";
}else
{
	throw new AmtException("insufficent amount please pay the right amount");
}
}
else 
{
	System.out.println("Entered invalid option Please Try again...");
	return "try again";
}
}
}