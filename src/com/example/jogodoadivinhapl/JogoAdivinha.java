package com.example.jogodoadivinhapl;

import java.util.ArrayList;
import java.util.Random;

public class JogoAdivinha {
	
	public enum EstadoDoJogo{
		JOGO_NAO_INICIADO,
		JOGO_PEDE_MAIOR,
		JOGO_PEDE_MENOR,
		JOGO_TERMINADO
	}//EstadoDoJogo
	
	//membros de dados
	int mMin;
	int mMax;
	int mUltimoNumJogado;
	int mNumSorteado;
	ArrayList<Integer> mColJogadas=new ArrayList <Integer>();
	EstadoDoJogo mEstado;
	int mTentativas;
	
	private static final int NENHUM = -1;
	//comportamentos
	
	public int inteiroAleatorio (int a, int b){
		int ret;
		Random r=new Random();
		int amplitude = (b-a)+1;
		int salto = r.nextInt(amplitude);
		ret = a + salto;
		return ret;
	}//inteiroAleatorio
	
	//construtores
	public JogoAdivinha (){
		mMin=1;
		mMax=1000;
		mUltimoNumJogado=NENHUM;
		mNumSorteado = inteiroAleatorio (mMin, mMax);
		mTentativas=0;
		mEstado=EstadoDoJogo.JOGO_NAO_INICIADO;
	}//construtor por defeito - sem params
	
	public JogoAdivinha (int min, int max){
		mMin=min;
		mMax=max;
		mUltimoNumJogado=NENHUM;
		mNumSorteado = inteiroAleatorio (mMin, mMax);
		mTentativas=0;
		mEstado=EstadoDoJogo.JOGO_NAO_INICIADO;
	}//JogoAdivinha
}
