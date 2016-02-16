package org.nopx.vocabapp;
import org.nopx.vocabapp.settings.SettingsActivity;
import org.nopx.vocabapp.settings.SettingsFragment;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class QuizActivity extends Activity
{
	//Wether German Romaji or Japanese will be asked for
	int questionIndex =0;
	int answerIndex =1;
	//which button will have the right answer
	int answerBtnNum =0;
	//Which vocab is going to be asked
	int vocabIndex =0;
	
	public static int STATE_WORDS =0;
	public static int STATE_KANJI =1;
	int state;
	//True for every Lektion which will be tested
	boolean[] lektionen = new boolean[50];
	//List of vocab that will be tested
	String[][] vocabList;
	int[] vocabListCorrectAmount;
	String[][] lastVocab;
	
	//Views
	TextView questionView;
	Button[] btns;
	
	String quizSubject;
	Vocab vocabHandler;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        
        btns = new Button[4];
		//get Views
		questionView = (TextView)findViewById(R.id.question);
		btns[0] = (Button)findViewById(R.id.answer1Btn);
		btns[1] = (Button)findViewById(R.id.answer2Btn);
		btns[2] = (Button)findViewById(R.id.answer3Btn);
		btns[3] = (Button)findViewById(R.id.answer4Btn);
        
		quizSubject = getIntent().getStringExtra(VocabApp.EXTRA_MESSAGE);
		initializeBoolList();
		vocabHandler = new Vocab(lektionen);
		vocabList = vocabHandler.getVocabList(lektionen);
		vocabListCorrectAmount = new int[vocabList.length];
		
        if(quizSubject.equals("@string/quizname1")){
			questionIndex =1;
			answerIndex =0;
		}
		if(quizSubject.equals("@string/quizname2")){
			questionIndex =0;
			answerIndex =1;
			state = 0;
		}
        if(quizSubject.equals("@string/quizname3")){
			questionIndex =2;
			answerIndex =0;
			state = 0;
		}
		if(quizSubject.equals("@string/quizname4")){
			questionIndex =0;
			answerIndex =2;
			state = 0;
		}
		if(quizSubject.equals("@string/quizname5")){
			questionIndex =0;
			answerIndex =2;
			state = 1;
		}
		if(quizSubject.equals("@string/quizname6")){
			questionIndex =0;
			answerIndex =2;
			state = 1;
		}
		if(quizSubject.equals("@string/quizname7")){
			questionIndex =0;
			answerIndex =2;
			state = 1;
		}
		if(quizSubject.equals("@string/quizname8")){
			questionIndex =0;
			answerIndex =2;
			state = 1;
		}
		setupNewQuestion();
    }
    
    public void evaluate(View view){
		String answerString = vocabList[0][questionIndex]+" - "+
								vocabList[0][answerIndex];
		if(((Button)view).getText().equals(vocabList[0][answerIndex])){
			TextView lastAnswer =((TextView)findViewById(R.id.lastAnswer));
			lastAnswer.setText("Richtig: "+answerString);
			lastAnswer.setTextColor(0xff00ff00);
			
		}
		else{
			TextView lastAnswer =((TextView)findViewById(R.id.lastAnswer));
			lastAnswer.setText("Falsch: "+answerString);
			lastAnswer.setTextColor(0xffff0000);
		}
		setupNewQuestion();
	}
	
	public void setupNewQuestion(){
		//new random values
		vocabList = vocabHandler.getQuestionAnswerSet(btns.length);
		//Set view texts
		answerBtnNum = new java.util.Random().nextInt(btns.length);
		questionView.setText(vocabList[0][questionIndex]);
		btns[answerBtnNum].setText(vocabList[0][answerIndex]);
		//randomize wrong answers
		for(int i =0; i<btns.length; i++){
			if(i == answerBtnNum){
				btns[0].setText(vocabList[i][answerIndex]);
			}
			else{
				btns[i].setText(vocabList[i][answerIndex]);
			}
		}
	}
    
    private void initializeBoolList(){
		android.content.SharedPreferences sharedPref = 
			android.preference.PreferenceManager.getDefaultSharedPreferences(this);
		lektionen[0] = sharedPref.getBoolean("pref_Lektion1",false);
		lektionen[1] = sharedPref.getBoolean("pref_Lektion2",false);
		lektionen[2] = sharedPref.getBoolean("pref_Lektion3",false);
		lektionen[3] = sharedPref.getBoolean("pref_Lektion4",false);
		lektionen[4] = sharedPref.getBoolean("pref_Lektion5",false);
		lektionen[5] = sharedPref.getBoolean("pref_Lektion6",false);
		lektionen[6] = sharedPref.getBoolean("pref_Lektion7",false);
		lektionen[7] = sharedPref.getBoolean("pref_Lektion8",false);
		lektionen[8] = sharedPref.getBoolean("pref_Lektion9",false);
		lektionen[9] = sharedPref.getBoolean("pref_Lektion10",false);
		lektionen[10] = sharedPref.getBoolean("pref_Lektion11",false);
		lektionen[11] = sharedPref.getBoolean("pref_Lektion12",false);
		lektionen[12] = sharedPref.getBoolean("pref_Lektion13",false);
		lektionen[13] = sharedPref.getBoolean("pref_Lektion14",false);
		lektionen[14] = sharedPref.getBoolean("pref_Lektion15",false);
		lektionen[15] = sharedPref.getBoolean("pref_Lektion16",false);
		lektionen[16] = sharedPref.getBoolean("pref_Lektion17",false);
		lektionen[17] = sharedPref.getBoolean("pref_Lektion18",false);
		lektionen[18] = sharedPref.getBoolean("pref_Lektion19",false);
		lektionen[19] = sharedPref.getBoolean("pref_Lektion20",false);
		lektionen[20] = sharedPref.getBoolean("pref_Lektion21",false);
		lektionen[21] = sharedPref.getBoolean("pref_Lektion22",false);
		lektionen[22] = sharedPref.getBoolean("pref_Lektion23",false);
		lektionen[23] = sharedPref.getBoolean("pref_Lektion24",false);
		lektionen[24] = sharedPref.getBoolean("pref_Lektion25",false);
		lektionen[25] = sharedPref.getBoolean("pref_Lektion26",false);
		lektionen[26] = sharedPref.getBoolean("pref_Lektion27",false);
		lektionen[27] = sharedPref.getBoolean("pref_Lektion28",false);
		lektionen[28] = sharedPref.getBoolean("pref_Lektion29",false);
		lektionen[29] = sharedPref.getBoolean("pref_Lektion30",false);
		lektionen[30] = sharedPref.getBoolean("pref_Lektion31",false);
		lektionen[31] = sharedPref.getBoolean("pref_Lektion32",false);
		lektionen[32] = sharedPref.getBoolean("pref_Lektion33",false);
		lektionen[33] = sharedPref.getBoolean("pref_Lektion34",false);
		lektionen[34] = sharedPref.getBoolean("pref_Lektion35",false);
		lektionen[35] = sharedPref.getBoolean("pref_Lektion36",false);
		lektionen[36] = sharedPref.getBoolean("pref_Lektion37",false);
		lektionen[37] = sharedPref.getBoolean("pref_Lektion38",false);
		lektionen[38] = sharedPref.getBoolean("pref_Lektion39",false);
		lektionen[39] = sharedPref.getBoolean("pref_Lektion40",false);
		lektionen[40] = sharedPref.getBoolean("pref_Lektion41",false);
		lektionen[41] = sharedPref.getBoolean("pref_Lektion42",false);
		lektionen[42] = sharedPref.getBoolean("pref_Lektion43",false);
		lektionen[43] = sharedPref.getBoolean("pref_Lektion44",false);
		lektionen[44] = sharedPref.getBoolean("pref_Lektion45",false);
		lektionen[45] = sharedPref.getBoolean("pref_Lektion46",false);
		lektionen[46] = sharedPref.getBoolean("pref_Lektion47",false);
		lektionen[47] = sharedPref.getBoolean("pref_Lektion48",false);
		lektionen[48] = sharedPref.getBoolean("pref_Lektion49",false);
		lektionen[49] = sharedPref.getBoolean("pref_Lektion50",false);
	}
}
