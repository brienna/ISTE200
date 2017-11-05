// This program takes a name from the command line and prints it as
// part of the message that appears in the DOS window.
//
// usage: java Exercise1 Brienna
//
// Author: Brienna Herold
// Date:   September 4, 2017

public class Exercise1 {

	public static void main(String[] args) {

        // Test to see if a name was entered
	    if(args.length <= 0){
            System.out.println("No name entered");
            System.exit(1);
        }
        // Since a name is present, print it with the message
        System.out.println("\nWelcome to Java, " + args[0]);
        
	}
}
