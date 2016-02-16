package org.nopx.vocabapp;
import org.nopx.vocabapp.settings.SettingsActivity;
import org.nopx.vocabapp.settings.KanjiSettingsActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class VocabApp extends Activity
{
	
	public static String EXTRA_MESSAGE = "org.nopx.MESSAGE";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actionbar, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
			case R.id.settings:
				openSettings();
				return true;
			case R.id.kanjisettings:
				openKanjiSettings();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	public void openSettings(){
		Intent intent = new Intent(this, SettingsActivity.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname1");
		startActivity(intent);
	}
	
	public void openKanjiSettings(){
		Intent intent = new Intent(this, KanjiSettingsActivity.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname1");
		startActivity(intent);
	}
    
    public void open_japGer(View view){
		Intent intent = new Intent(this, QuizActivity.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname1");
		startActivity(intent);
	}
	
	public void open_gerJap(View view){
		Intent intent = new Intent(this, QuizActivity.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname2");
		startActivity(intent);
	}
	
    public void open_hirGer(View view){
		Intent intent = new Intent(this, QuizActivity.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname3");
		startActivity(intent);
	}
	
	public void open_gerHir(View view){
		Intent intent = new Intent(this, QuizActivity.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname4");
		startActivity(intent);
	}
	
	public void open_kanjiGer(View view){
		Intent intent = new Intent(this, KanjiQuiz.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname5");
		startActivity(intent);
	}
	
	public void open_gerKanji(View view){
		Intent intent = new Intent(this, KanjiQuiz.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname6");
		startActivity(intent);
	}
	
	public void open_kanjiKUN(View view){
		Intent intent = new Intent(this, KanjiQuiz.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname7");
		startActivity(intent);
	}
	
	public void open_kunKanji(View view){
		Intent intent = new Intent(this, KanjiQuiz.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname8");
		startActivity(intent);
	}
	
	public void open_kanjiON(View view){
		Intent intent = new Intent(this, KanjiQuiz.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname9");
		startActivity(intent);
	}
	
	public void flashCard(View view){
		Intent intent = new Intent(this, FlashCardActivity.class);
		intent.putExtra(EXTRA_MESSAGE,"@string/quizname4");
		startActivity(intent);
	}
}
