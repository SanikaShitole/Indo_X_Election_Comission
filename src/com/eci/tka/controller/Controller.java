package com.eci.tka.controller;

import java.util.ArrayList;
import java.util.List;

import com.eci.tka.entity.Candidate;
import com.eci.tka.service.Service;

public class Controller {
            Service service=null;
            
         public List<Candidate> getAllCandidates(){
        	   service=new Service();
        	  List<Candidate> allcandidate = service.getAllCandidates();
        	  return allcandidate;
          }
         public List<Candidate> getCanByParty(String party) {
        	 service=new Service();
        	List<Candidate>candidatebyparty =service.candidatebyparty(party);
			
        	return candidatebyparty;
        	 
         }
         public void insertCandidate(int num) {
        	 Service service=new Service();
        	 service.insertCandidate(num);
        	 
         }
         public List<Candidate>getCandidateByState(String st) {
        	 Service service=new Service();
        	  List<Candidate> candidatebyState = new ArrayList <Candidate>();
        	  candidatebyState= service.getCandidatebyState(st);
			 return candidatebyState;
         }
         public List<Candidate> candidatebyassembly(String ass) {
        	 Service service=new Service();
        	  List<Candidate> candidatebyassembly  =new ArrayList<Candidate>();
        	  candidatebyassembly= service.candidatebyassembly(ass);
        	  return candidatebyassembly;
        			  }
         public List<Candidate> candidatebygender(String gen) {
        	 Service service=new Service();
        	  List<Candidate> candidatebygender  =new ArrayList<Candidate>();
        	  candidatebygender= service.CandidateBygender(gen);
        	  return candidatebygender;
}
         public String updateCandidateData(int prevcid, int newcid, String name, String party, String assembly,String statename,String gender, int age) {
     		service = new Service();
     		String result = service.updateCandidateData(prevcid, newcid, name, party, assembly, statename, gender, age);
     		return result;
     	}

     
     	public String deleteCandata(int id) {
     		service = new Service();
     		String result = service.deleteCandate(id);

     		return result;
     	}

}