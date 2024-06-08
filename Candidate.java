package model;

public class Candidate {
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String city;
	protected int age;
	protected String profession;
	protected String politicalParty;
	protected String reason;
	protected String about;
	
	public Candidate(int id, String firstName, String lastName, String city, int age, String profession,
			String politicalParty, String reason, String about) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.age = age;
		this.profession = profession;
		this.politicalParty = politicalParty;
		this.reason = reason;
		this.about = about;
	}

	public Candidate(String firstName, String lastName, String city, int age, String profession,
			String politicalParty, String reason, String about) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.age = age;
		this.profession = profession;
		this.politicalParty = politicalParty;
		this.reason = reason;
		this.about = about;
	}

	public Candidate() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(String pliticalParty) {
		this.politicalParty = pliticalParty;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", age=" + age + ", profession=" + profession + ", politicalParty=" + politicalParty + ", reason="
				+ reason + ", about=" + about + "]";
	}
	
	
}
