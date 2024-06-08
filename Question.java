package model;

public class Question {

	protected int id;
	protected String question;
	
	
	public Question() {
		super();
	}


	public Question(int id, String question) {
		super();
		this.id = id;
		this.question = question;
	}


	public Question(String question) {
		super();
		this.question = question;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
}
