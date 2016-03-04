package org.nopx.vocabapp;
import org.nopx.vocabapp.settings.KanjiSettingsActivity;
import org.nopx.vocabapp.settings.KanjiSettingsFragment;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class KanjiQuiz extends Activity
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
	boolean[] lektionen = new boolean[40];
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
		android.util.Log.d("Error","0");
		vocabHandler = new Vocab(lektionen);
		android.util.Log.d("Error","1");
		vocabList = vocabHandler.getVocabList(lektionen);
		android.util.Log.d("Error","2");
		vocabListCorrectAmount = new int[vocabList.length];
		android.util.Log.d("Error","3");
		
        if(quizSubject.equals("@string/quizname5")){
			questionIndex =1;
			answerIndex =0;
		}
		if(quizSubject.equals("@string/quizname6")){
			questionIndex =0;
			answerIndex =1;
		}
        if(quizSubject.equals("@string/quizname7")){
			questionIndex =0;
			answerIndex =2;
		}
		if(quizSubject.equals("@string/quizname8")){
			questionIndex =2;
			answerIndex =0;
		}
		if(quizSubject.equals("@string/quizname9")){
			questionIndex =0;
			answerIndex =3;
		}
		android.util.Log.d("Error","4");
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
		if(lektionen.length >= 50)
			vocabList = vocabHandler.getQuestionAnswerSet(btns.length);
		else
			vocabList = vocabHandler.getQuestionAnswerSetKanji(btns.length);
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
		lektionen[0] = sharedPref.getBoolean("pref_KanjiLektion11",false);
		lektionen[1] = sharedPref.getBoolean("pref_KanjiLektion12",false);
		lektionen[2] = sharedPref.getBoolean("pref_KanjiLektion13",false);
		lektionen[3] = sharedPref.getBoolean("pref_KanjiLektion14",false);
		lektionen[4] = sharedPref.getBoolean("pref_KanjiLektion15",false);
		lektionen[5] = sharedPref.getBoolean("pref_KanjiLektion16",false);
		lektionen[6] = sharedPref.getBoolean("pref_KanjiLektion17",false);
		lektionen[7] = sharedPref.getBoolean("pref_KanjiLektion18",false);
		lektionen[8] = sharedPref.getBoolean("pref_KanjiLektion19",false);
		lektionen[9] = sharedPref.getBoolean("pref_KanjiLektion20",false);
		lektionen[10] = sharedPref.getBoolean("pref_KanjiLektion21",false);
		lektionen[11] = sharedPref.getBoolean("pref_KanjiLektion22",false);
		lektionen[12] = sharedPref.getBoolean("pref_KanjiLektion23",false);
		lektionen[13] = sharedPref.getBoolean("pref_KanjiLektion24",false);
		lektionen[14] = sharedPref.getBoolean("pref_KanjiLektion25",false);
		lektionen[15] = sharedPref.getBoolean("pref_KanjiLektion26",false);
		lektionen[16] = sharedPref.getBoolean("pref_KanjiLektion27",false);
		lektionen[17] = sharedPref.getBoolean("pref_KanjiLektion28",false);
		lektionen[18] = sharedPref.getBoolean("pref_KanjiLektion29",false);
		lektionen[19] = sharedPref.getBoolean("pref_KanjiLektion30",false);
		lektionen[20] = sharedPref.getBoolean("pref_KanjiLektion40",false);
		lektionen[21] = sharedPref.getBoolean("pref_KanjiLektion41",false);
		lektionen[22] = sharedPref.getBoolean("pref_KanjiLektion42",false);
		lektionen[23] = sharedPref.getBoolean("pref_KanjiLektion43",false);
		lektionen[24] = sharedPref.getBoolean("pref_KanjiLektion44",false);
		lektionen[25] = sharedPref.getBoolean("pref_KanjiLektion45",false);
		lektionen[26] = sharedPref.getBoolean("pref_KanjiLektion46",false);
		lektionen[27] = sharedPref.getBoolean("pref_KanjiLektion47",false);
		lektionen[28] = sharedPref.getBoolean("pref_KanjiLektion48",false);
		lektionen[29] = sharedPref.getBoolean("pref_KanjiLektion49",false);
		lektionen[30] = sharedPref.getBoolean("pref_KanjiLektion50",false);
	}
}
