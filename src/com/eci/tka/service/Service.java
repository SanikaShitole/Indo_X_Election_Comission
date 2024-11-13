package com.eci.tka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.eci.tka.dao.Dao;
import com.eci.tka.entity.Candidate;

public class Service {

	Dao dao = null;
	Scanner sc = new Scanner(System.in);

	public List<Candidate> getAllCandidates() {
		dao = new Dao();
		List<Candidate> allcandidate = dao.getAllCandidate();

		return allcandidate;
	}

	public List<Candidate> candidatebyparty(String party) {
		dao = new Dao();
		List<Candidate> partyDB = dao.getAllCandidate();
		List<Candidate> byparty = new ArrayList<Candidate>();
		for (Candidate can : partyDB) {

			if (can.getPartyname().toLowerCase().equals(party.toLowerCase())) {
				byparty.add(can);
			}
		}
		return byparty;
	}

	public List<Candidate> candidatebyassembly(String assembly) {
		dao = new Dao();
		List<Candidate> allCandidate = new ArrayList<Candidate>();
		List<Candidate> byassembly = new ArrayList<Candidate>();

		allCandidate = dao.getAllCandidate();
		for (Candidate candidate : allCandidate) {
			if (candidate.getAssembly().equalsIgnoreCase(assembly)) {
				byassembly.add(candidate);
			}
		}
		return byassembly;
	}

	public void insertCandidate(int num) {
		dao = new Dao();
		int count = 1;
		while (num > 0) {
			System.out.println("Enter ID of candidate");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println();

			System.out.println("enter name of candidate");
			String name = sc.nextLine();
			System.out.println();

			System.out.println("enter partyname of candidate");
			String partyname = sc.nextLine();
			System.out.println();

			System.out.println("enter state of candidate");
			String state = sc.nextLine();
			System.out.println();

			System.out.println("enter assembly of candidate");
			String assembly = sc.nextLine();
			System.out.println();

			System.out.println("enter gender of candidate");
			String gen = sc.nextLine();
			System.out.println();

			System.out.println("enter age of candidate");
			int age = sc.nextInt();
			System.out.println();

			dao.insertCandidate(id, name, partyname, state, assembly, gen, age);
			System.out.println("Insersion succesfully Done");
			count++;
			num--;
         }
	}
	public List<Candidate> getCandidatebyState(String state) {
		dao = new Dao();
		List<Candidate> AllCandidate = new ArrayList<Candidate>();
		List<Candidate> byState = new ArrayList<Candidate>();
		AllCandidate=dao.getAllCandidate();
		
		for (Candidate can : AllCandidate) {
			if (can.getStatename().equalsIgnoreCase(state));
			{
				byState.add(can);
			}
		}
		return byState;
	}

	public List<Candidate> CandidateBygender(String gen) {
		dao = new Dao();
		List<Candidate> allCandidate = new ArrayList<Candidate>();
		List<Candidate> bygen = new ArrayList<Candidate>();
		allCandidate = dao.getAllCandidate();
		for (Candidate can : allCandidate) {
			if (can.getGender().equalsIgnoreCase(gen));
			{
				bygen.add(can);
			}
		}
		return bygen;
	}
		public String updateCandidateData(int prevcid, int newcid, String name, String party, String assembly,String statename, String gender,int age) {
			String res = null;
			dao = new Dao();
			int count = 0;
			for (Candidate candidate : dao.getAllCandidate()) {

				if (prevcid == candidate.getEid()) {
					count++;
					dao = new Dao();
					res = dao.updateCandidateData(prevcid, newcid, name, party, assembly, statename,gender,age);

				}

			}
			if (count == 0) {
				res = "This candidate id is not existing";
			}

			return res;
		}

		// delete any candidate
		public String deleteCandate(int id) {
			dao = new Dao();
			String result = dao.deleteCandata(id);

			return result;
		}

	
	}

