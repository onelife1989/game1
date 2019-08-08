package Hit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeBreaker {

	public static void main(String[] args){
		/*変数の初期化*/
		  //タイトル
		  String title = "***CodeBreaker***";
		  //ルール
		  String rule = "3つの数字を当てよう！\n"
				  +"1から6の数字が用意されます。\n"
				  +"3つの中に同じ数字はありません。\n"
				  +"入力した数字の、"
				  + "位と数字が当たっていれば \"Hit\" \n"
				  + "数字だけ当たっていれば\"Blow\"\n"
				  + "全て\"Hit\" なら終了です。";
		  //3つの数字が入る配列(答えと入力用)
		  int[] answer = new int[3];
		  int[] input = new int[3];
		  //Hit,Blow,入力した回数を入れる変数
		  int hit = 0,blow = 0,count = 0;
		  
		  //キー入力を受け取る
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  //タイトル、ルールの表示
		  System.out.println(title);
		  System.out.println(rule);
		  
		  //答えの生成
		  //answerの長さ分ループ
		  for(int i = 0; i < answer.length; i++){
			  boolean flag = false;
			  //1~6までの整数を生成
			  //(intでキャストした場合、整数部だけ取り出される)
			  //answerにランダムな整数が挿入
			  answer[i] = (int)(Math.random()*9 +1);
			  do{
				  flag = false;
				  //j(i-1)の値が0以下になるまで(iの値が1以上の時)ループ
				  //つまり最初のforループが2回目になってから
				  for(int j = i -1; j >= 0; j--){
					  //answerの配列の現在の値(i)と前の値(j)を比較
					  if(answer[i] == answer[j]){
						//配列の現在と前の値が同じなら
					  	flag = true;
					  	//配列の現在の値を入れ直す
					    answer[i] = (int)(Math.random()*6 + 1);
					  }
				  }
			  //flagがtrueの間(現在の配列が入れ直しになっている間)
			  }while(flag == true);
		  }
		  //answerの中身を確認
		  String A = "";
		  for(int key : answer){
			  A += String.valueOf(key);
		  }
		   System.out.println("(答え = " + A + ")");
		  
		  //無限ループ
		  while(true){
			  count++;
			  System.out.println("***"+count+"回目***");
			  //インプット
			  //answerの長さ分ループ
			  for(int i = 0; i < answer.length; i++){
				  System.out.println((i + 1)+"個目");
				  try{
					  //input[i]が数値かどうか
					  input[i] = Integer.parseInt(br.readLine());
				  //文字列を数値に変換した時のエラーをキャッチ
				  }catch(NumberFormatException e){
					  System.err.println("数値を入力してください");
					  i--;
				  //入力時のエラーをキャッチ
				  }catch (IOException e){
					  System.err.println("もう一度入力してください");
					  i--;
				  }
			  }
			  //答え判断
			  hit = 0;
			  blow = 0;
			  for(int i = 0; i < answer.length; i++){
				  for(int j = 0; j < answer.length; j++){
					  //同じインデックスで値も同じ時 hit
					  if(i == j && input[i] == answer[j] ){
					    hit++;
					  //インデックスが違っても値が同じならblow
					  }else if(input[i] == answer[j]){
						  blow++;
					  }
				  }
			  }
			  
			  System.out.println("ヒット:" + hit +"  , ブロー:" + blow);
			  //3回ヒットで終了、それ以外は続行
			  if(hit == 3){
				  System.out.println("成功！");
				  break;
			  }else{
				  System.out.println("もう一度!");
			  }
		  }
		  
	}//mainクラスのend
	
}//ブロックのend
