package model;

import java.util.ArrayList;

public class AnswerByCandidate {

	protected int candidateId;
	protected String candidateName ;
	ArrayList<Answer> listAnswer = new ArrayList<Answer>();
	
	public AnswerByCandidate(int candidateId, String candidateName, ArrayList<Answer> listAnswer) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.listAnswer = listAnswer;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public ArrayList<Answer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(ArrayList<Answer> listAnswer) {
		this.listAnswer = listAnswer;
	}
	
	
	
	
	
	
}
