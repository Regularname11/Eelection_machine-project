package model;

import java.util.ArrayList;

public class AnswerCandidate {

	protected ArrayList<Answer> answerPublic = new ArrayList<Answer>();
	protected ArrayList<AnswerByCandidate> answerCandidate = new ArrayList<AnswerByCandidate>();
	
	public AnswerCandidate(ArrayList<Answer> answerPublic, ArrayList<AnswerByCandidate> answerCandidate) {
		super();
		this.answerPublic = answerPublic;
		this.answerCandidate = answerCandidate;
	}

	public AnswerCandidate() {
		super();
	}

	public ArrayList<Answer> getAnswerPublic() {
		return answerPublic;
	}

	public void setAnswerPublic(ArrayList<Answer> answerPublic) {
		this.answerPublic = answerPublic;
	}

	public ArrayList<AnswerByCandidate> getAnswerCandidate() {
		return answerCandidate;
	}

	public void setAnswerCandidate(ArrayList<AnswerByCandidate> answerCandidate) {
		this.answerCandidate = answerCandidate;
	}
	
	
	
}
