package com.eci.tka.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.eci.tka.controller.Controller;
import com.eci.tka.entity.Candidate;

 class Client {
	 
		public static void display() {  
			
           Scanner sc=new Scanner(System.in);
	    Controller controller = new Controller();

	    System.out.println("WELCOME TO ELECTION COMMISION OF INDIA HUB");  
	    System.out.println();
        while(true) {
    	 
    	 System.out.println("------------------------------------");
    	 System.out.printf("|%-35s|\n","            MENU");
    	 System.out.println("------------------------------------");

    	 System.out.printf("|%-35s|\n","1. show all candidates");
    	 System.out.println("------------------------------------");
    	 System.out.printf("|%-35s|\n","2. insert candidates");
    	 System.out.println("------------------------------------");
    	 System.out.printf("|%-35s|\n","3. according party");
    	 System.out.println("------------------------------------");
         
    	 System.out.printf("|%-35s|\n","4. according assembly");
    	 System.out.println("------------------------------------");
         
    	 System.out.printf("|%-35s|\n","5. according state");
    	 System.out.println("------------------------------------");
         
    	 System.out.printf("|%-35s|\n","6. according gender");
    	 System.out.println("------------------------------------");
    	 
    	 System.out.printf("|%-35s|\n","7. Update  eci data");
    	 System.out.println("------------------------------------");
         
    	 System.out.printf("|%-35s|\n","8. Delete Data");
    	 System.out.println("------------------------------------");
         
    	 
    	 System.out.printf("|%-35s|\n","9. Exit");
    	 System.out.println("------------------------------------");
    	
   System.out.println("Enter your choice:" );
    	
          
          int ch=sc.nextInt();
          sc.nextLine();
           System.out.println();
          
          switch(ch) {
          case 1:
        	  System.out.println("All candidates list:-\n");
              List<Candidate>allcandidate = controller.getAllCandidates();
        	  for (Candidate can : allcandidate) {
        		  System.out.printf("%-20d%-15s%-10s%-10s%-10s%-7s%-5d\n"
        				  ,can.getEid(),can.getName(),can.getPartyname(),can.getStatename(),can.getAssembly(),can.getGender(),can.getAge());
        				  				
        	  }
        	  System.out.println("-------------------------------------------------");
				break;
          case 2:
        	     System.out.println("Number of entry:");
                 int num=sc.nextInt();
                 System.out.println();
                 controller.insertCandidate(num);
                 System.out.println("--------------------------------------------------");
        	     break;
          case 3:
        	      System.out.println("Enter the party name");
        	      String partyname=sc.nextLine();
        	      System.out.println();
        	List<Candidate>candidatebyparty=controller.getCanByParty(partyname);
        	for (Candidate can : candidatebyparty) {
        		System.out.printf("%-20d%-15s%-10s%-10s%-10s%-7s%-5d\n"
        ,can.getEid(),can.getName(),can.getPartyname(),can.getStatename(),can.getAssembly(),can.getGender(),can.getAge());
				}
        	System.out.println("--------------------------------------------------");
        	break;
        	
          case 4:
              System.out.println("Enter the Assembly name");
              String aname = sc.nextLine();
              System.out.println();
              List<Candidate> byassembly=new ArrayList<Candidate>();
             byassembly = controller.candidatebyassembly(aname);
             System.out.println(byassembly);
             break;

          case 5:
              System.out.println("Enter State Name");
              String stname = sc.nextLine();
              System.out.println();
              List<Candidate> byState =new ArrayList<Candidate>();
			  byState = controller.getCandidateByState(stname);
			  System.out.println(byState);
              break;

          case 6:
              System.out.println("Enter Gender of Candidate");
              String gen = sc.nextLine();
              System.out.println();
              List<Candidate> bygen = controller.candidatebygender(gen);
              if (bygen != null && !bygen.isEmpty()) {
                  for (Candidate can : bygen) {
                      System.out.printf("%-10d%-15s%-15s%-15s%-15s%-7s%-5d\n",
                              can.getEid(), can.getName(), can.getPartyname(), can.getStatename(),
                              can.getAssembly(), can.getGender(), can.getAge());
                  }
              } else {
                  System.out.println("No candidates found for this gender.");
              }
              break;
              
             
         case 7:
                 
                  System.out.print("Enter the current Candidate ID (prevcid): ");      //for update by id
                  int prevcid = sc.nextInt();
                  System.out.print("Enter the new Candidate ID (newcid): ");
                  int newcid = sc.nextInt();
                  sc.nextLine();  
                  System.out.print("Enter Candidate name: ");
                  String name = sc.nextLine();
                  System.out.print("Enter Candidate party: ");
                  String party = sc.nextLine();
                  System.out.print("Enter Candidate assembly: ");
                  String assembly = sc.nextLine();
                  System.out.print("Enter Candidate state: ");
                  String statename = sc.nextLine();
                  System.out.print("Enter Candidate gender: ");
                  String gender = sc.nextLine();
                  System.out.print("Enter Candidate age: ");
                  int age = sc.nextInt();
                  
                 
                  String updateResult = controller.updateCandidateData(prevcid, newcid, name, party, assembly, statename, gender, age);
                  System.out.println(updateResult);
                  break;
                  
              case 8:
                  System.out.print("Enter Candidate ID to delete: ");
                  int deleteId = sc.nextInt();
                  String deleteResult = controller.deleteCandata(deleteId);
                  System.out.println(deleteResult);
                  break;
                  
           case 9:
              System.out.println("Exit");
            
              break;

          default:
              System.out.println("Invalid choice, please try again.");
      }
  }
}
	  
public static void main(String[] args) {
			
			display();
			
		}
}

