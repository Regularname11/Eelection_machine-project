package model;


public class Answer {

	protected int questionId;
	protected String answer ;
	protected String question;

	
	public Answer(int questionId, String answer, String question) {
		super();
		this.questionId = questionId;
		this.answer = answer;
		this.question = question;
	}

	public Answer() {
		super();
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswers(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
}
