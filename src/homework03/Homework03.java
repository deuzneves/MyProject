/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework03;

import java.util.Scanner;

/**
 *
 * @author Deuzito
 */
public class Homework03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
    Scanner sc = new Scanner(System.in);
    
    String first3numbers;
    String first4numbers;
    String lastfew;
    String num1;
    boolean allow=false;
    
    do {
        System.out.println("Please enter your mobile phone number: ");
    num1 = sc.nextLine(); 
          // ask user for their phone number - valid if it contains 10 or 11 charactrs
     
         if ((num1.length()<10) || (num1.length()>11)){ //amount of numbers could be 10 or 11, see the conditions for each of them
             System.out.print("Invalid number. "); 
         }
         else {
              // if phone number contains 10 characters - valid them if contains only numbers
             first3numbers = num1.substring(0,3); //select the first 3 numbers of the input
     if ((num1.length()==10) && (num1.matches("[0-9]+"))){ // input must contain 10 characters and only numbers
         
         // for valid Irish phone numbers, first 3 numbers must start with either 085, 086 or 087
         switch (first3numbers) {
        case "085": case "086": case "087":
            allow=true;
            System.out.println("Thanks, I will call you tomorrow.");
            break;
   
        default:
            allow=false;
           System.out.print("Invalid number. ");
         }      
         
    } else {
         // if phone number contains 11 characters - valid if the 4º character is either "-" or " "(space)
        first4numbers = num1.substring(0,4);
        lastfew = num1.substring(5);
        
       if (((num1.length()==11)) && (first3numbers.matches("[0-9]+")) && (lastfew.matches("[0-9]+"))) {
         // if number of characters are 11, the 4ª character must be a space or "-" and the rest of sequence be numbers
         
           switch (first4numbers) {
               case "085-": case "085 ": case "086-": case "086 ": case "087-": case "087 ":
                   allow=true;
                   System.out.println("Thanks, I will call you tomorrow.");
                   break;
               default:
                   allow=false; 
                   System.out.print("Invalid number. ");
        }
       } else {
           System.out.print("Invalid number. "); // if input doesn't match the conditions, ask them again for a new number
       }    
      }
     }    // loop will stop when user's phone numbers matches the Irish numbers
    } while (!allow==true);   
   }
  }