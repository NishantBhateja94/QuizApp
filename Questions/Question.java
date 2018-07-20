package Questions;

import java.util.Arrays;

public class Question {
private int id;
private String question;
private String answers[]= new String[4];
private String rightAnswer;
private int score;
public int sum;
public int attempt;
public boolean marks;
public boolean isMarks() {
	return marks;
}
public void setMarks(boolean marks) {
	this.marks = marks;
}
public int getAttempt() {
	return attempt;
}
public void setAttempt(int attempt) {
	this.attempt = attempt;
}
public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}
private String yourAnswer;
public Question() {}
//public Question(String question,String []answers, String rans){
//	this.question= question;
//	this.answers=answers;
//	this.rightAnswer=rans;
//}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String[] getAnswers() {
	return answers;
}
public void setAnswers(String[] answers) {
	this.answers = answers;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRightAnswer() {
	return rightAnswer;
}
public void setRightAnswer(String rightAnswer) {
	this.rightAnswer = rightAnswer;
}
public String getYourAnswer() {
	return yourAnswer;
}
public void setYourAnswer(String yourAnswer) {
	this.yourAnswer = yourAnswer;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}

@Override
public String toString() {
	return "Question [id=" + id + ", question=" + question + ", answers=" + Arrays.toString(answers) + ", rightAnswer="
			+ rightAnswer + ", score=" + score + ", yourAnswer=" + yourAnswer + "]";
}
@Override
public int hashCode() {
	return question.trim().length();
}
@Override
public boolean equals(Object obj) {
	if(obj instanceof Question){
	if (this == obj)
		return true;
	Question question = (Question)obj;
	if(question.question.equalsIgnoreCase(this.question))
		return true;
	}
	    return false;
	    
}

}
