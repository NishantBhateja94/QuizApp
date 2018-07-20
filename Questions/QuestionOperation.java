package Questions;
import java.util.HashSet;
import java.util.Iterator;
public class QuestionOperation {
private static QuestionOperation questionOperation = null;
HashSet<Question> questionSet = new HashSet<>();
private QuestionOperation() {}

public void addQuestion(Question question) {
          this.questionSet.add(question);
}
public HashSet<Question> getQuestions(){
	return questionSet;
}
public static QuestionOperation getInstance() {
	if(questionOperation==null)
		questionOperation = new QuestionOperation();
	return questionOperation;
}
public Question getQuestionByIndex(int index){
	int start =0;
	Question currentQuestion = null;
	Iterator<Question> questionItr= questionSet.iterator();
	while(questionItr.hasNext()){
		currentQuestion=questionItr.next();
		if(start==index)
			break;
		    start++;
			}
	return currentQuestion;
}
}
