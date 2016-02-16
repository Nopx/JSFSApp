package org.nopx.vocabapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

class Quiz extends Activity{
	
	//Buttons with which you select an answer
	private Button[] btns = new Button[4];
	//View which displays the question
	private TextView questionView = new TextView();
	
	/* List with all the values that can be asked for
	 * at each value index is an array with 
	 * the question at index #questionIndex
	 * the answer at index #answerIndex
	 * the category at index #0 */
	private String[][] questionList;
	//List with all the possible answervalues, indexes like questionList
	private String[][] answerList;
	
	/*List which saves values for current question
	 * question at index #0
	 * random answers at indexes #1 #2 #3
	 */
	private String[][] questionSet;
	
	protected int answerIndex;
	protected int questionIndex;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz);
		
        btns = new Button[4];
		//get Views
		questionView = (TextView)findViewById(R.id.question);
		btns[0] = (Button)findViewById(R.id.answer1Btn);
		btns[1] = (Button)findViewById(R.id.answer2Btn);
		btns[2] = (Button)findViewById(R.id.answer3Btn);
		btns[3] = (Button)findViewById(R.id.answer4Btn);
		
		vocabList = getIntent().getStringExtra(R.intentmessages.vocabList);
		answerList = getIntent().getStringExtra(R.intentmessages.answerList);
		questionIndex = getIntent().getStringExtra(R.intentmessages.questionIndex);
		answerIndex = getIntent().getStringExtra(R.intentmessages.answerIndex);
		
		setupNewQuestion();
	}
	
	public Button[] getButtons(){
		return btns;
	}
	
	public TextView getQuestionView(){
		return questionView;
	}
	
	public String getQuizSubject(){
		return quizSubject;
	}
	
	public String[][] getVocabList(){
		return vocabList;
	}
	
	//Evaluates given answer and displays evaluation
	public void evaluate(View view){
		String answerString = questionSet[0][questionIndex]+" - "+
								questionSet[0][answerIndex];
		if(((Button)view).getText().equals(vocabList[0][answerIndex])){
			TextView lastAnswer =((TextView)findViewById(R.id.lastAnswer));
			lastAnswer.setText("@string/CorrectAnswer"+": "+answerString);
			lastAnswer.setTextColor(0xff00ff00);
			
		}
		else{
			TextView lastAnswer =((TextView)findViewById(R.id.lastAnswer));
			lastAnswer.setText("@string/WrongAnswer"+": "+answerString);
			lastAnswer.setTextColor(0xffff0000);
		}
		setupNewQuestion();
	}
	
	//Initializes a new random question with random answers into questionSet
	private void reloadQuestionSet(){
		questionSet = new String[questionList[0].length][4];
		Random rGen = new Random();
		int[] rAnswerIndexes = new int[3];
		for(int i =0; i < rAnswerIndexes.length; i++)
			rAnswerIndexes[i] = -1;
		
		questionSet[0] = vocabList[rGen.nextInt(questionList.length)];
		for(int i =0; i <rAnswerIndexes.length;i++){
			int rInt = rGen.nextInt(answerList.length);
			
			if(questionSet[0][questionIndex].equals(answerList[rInt][questionIndex])
				|| !questionSet[0][0].equals(answerList[rInt][0])){
				i--;
			}
			else{
				for(int j =0; j <rAnswerIndexes.length;j++){
					if(rAnswerIndexes[j] == rAnswerIndexes[i])
						i--;
				}
			}
		}
	}
	
	//Displays the current questionset
	private void setupNewQuestion(){
		reloadQuestionSet();
		//Set view texts
		answerBtnNum = new Random().nextInt(btns.length);
		questionView.setText(questionSet[0][questionIndex]);
		btns[answerBtnNum].setText(questionSet[0][answerIndex]);
		//randomize wrong answers
		for(int i =0; i<btns.length; i++){
			if(i == answerBtnNum){
				btns[0].setText(questionSet[i][answerIndex]);
			}
			else{
				btns[i].setText(questionSet[i][answerIndex]);
			}
		}
	}
	
}
