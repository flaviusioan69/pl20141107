package com.example.jogodoadivinhapl;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class Inicial extends ActionBarActivity {

	private JogoAdivinha mJogo;
	private EditText mEtMin;
	private EditText mEtMax;
	private int mMin, mMax;
	private Button mBtnComecarJogo;
	private OnClickListener mTratadorDeClicks;
	private TextView mTvDebug;
	
	private void comecarJogo(){
		String sMin=mEtMin.getText().toString();
		String sMax=mEtMax.getText().toString();
		
		try{
			mMin = Integer.parseInt(sMin);
			mMax = Integer.parseInt(sMax);
			
			mJogo=new JogoAdivinha (mMin, mMax);
			String estado=mJogo.estadoDoJogoEnquantoFrase();
			mTvDebug.setText(estado);
		}
		catch (Exception e){
			//como reagir se o parse do input do user falhar?
			//respondamos com hints a informar o que o user fez errado
			mEtMin.setHint("Ei, por favor, escreva apenas nºs (e.g. 1)");
			mEtMax.setHint("Ei, por favor, escreva apenas nºs (e.g. 1000)");
			mEtMin.setText("");
			mEtMax.setText("");
			mTvDebug.setText("Jogo não criado: formato de dados inválido.");
		}
	}//comecarJogo
	
	private void init(){
		mEtMin=(EditText) findViewById (R.id.id_et_min);
		mEtMax=(EditText) findViewById (R.id.id_et_max);
		mBtnComecarJogo=(Button) findViewById (R.id.id_btn_comecar_jogo);
		mTvDebug=(TextView) findViewById (R.id.id_tv_debug);
		
		mTratadorDeClicks = new OnClickListener(){
			@Override
			public void onClick(View v) {
				int id=v.getId();
				switch (id){
					case R.id.id_btn_comecar_jogo: comecarJogo(); break;
				}//switch
			}//onClick
		};//mTratadorDeClicks
		
		mBtnComecarJogo.setOnClickListener(mTratadorDeClicks);
	}//init
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
