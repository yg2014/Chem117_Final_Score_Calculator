package com.smallventuresnursery.android;

//import course.examples.theanswer.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class FinalTestGradeCalculator extends Activity {

    private EditText Test1Score;
    private EditText Test2Score;
    private EditText Test3Score;
    private EditText HomeworkScore;
    private EditText FinalGrade;
    private TextView FinalTestScore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Test1Score = (EditText) findViewById(R.id.editText_ScoreTest1);
		Test2Score = (EditText) findViewById(R.id.editText_Score_Test2);
		Test3Score = (EditText) findViewById(R.id.editText_Score_Test3);
		HomeworkScore = (EditText) findViewById(R.id.editText_Score_Homework);
		FinalGrade = (EditText) findViewById(R.id.editText_Score_Grade);
		FinalTestScore = (TextView) findViewById(R.id.textView_TestFinalScore);

		
		((Button) findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				float t1 = Float.parseFloat( Test1Score.getText().toString());
				float t2 = Float.parseFloat( Test2Score.getText().toString());
				float t3 = Float.parseFloat( Test3Score.getText().toString());
				float hw = Float.parseFloat( HomeworkScore.getText().toString());
				float grade = Float.parseFloat( FinalGrade.getText().toString());
				
				float FinalTest = grade *5 - hw - t1 - t2 - t3;
				float min = findLowestScore(t1,t2,t3);
				
				if ( FinalTest >  min) {
					// case FinalTest is not the lowest score 
					//(i.e., FinalTest is higher than the lowest test )
					FinalTest = (grade * 5 - (t1 + t2 + t3 + hw) + min) / 2;
				}

				FinalTestScore.setText(Float.toString(FinalTest));
			}
        });

	}

	private Float findLowestScore(float t1, float t2, float t3) {
		float min = t1;
		
		min = Math.min(min, t2);
		min = Math.min(min, t3);
		
		return min;
	}
}
