package casino;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
class Money{
static int totalmoney;//所持金
 static int money;//賭け金
 static int entryMoney;//参加料
 static int counter=0;//ゲームを続けるか
}
//ルーレットクラス///////////////////////////////////////////
class  roulette extends Money{
  int number;//ルーレットで出た目
     roulette(int a){
      Setting(a);
     }
     static void Setting(int n){//賭け金設定
      money=n;
      totalmoney=totalmoney-money;
     }
     static int PayOff(){//精算
      return totalmoney=totalmoney+money;
     }
  void StraightUp(int n) {//１つを当てる
   number=(int)(Math.random()*35)+1;
   if(number==n){
    money*=36;
    System.out.println("勝ちです");
   }else{
    money=0;
    System.out.println("負けです");
   }
  }
  void Split(int a,int b){//２つを当てる
   number=(int)(Math.random()*35)+1;
   if(number==a||number==b){
    money*=18;
    System.out.println("勝ちです");
   }else{
    money=0;
    System.out.println("負けです");
   }
  }
  void Street(int a,int b,int c){//３つを当てる
   number=(int)(Math.random()*35)+1;
   if(number==a||number==b||number==c){
    money*=12;
    System.out.println("勝ちです");
   }else{
    money=0;
    System.out.println("負けです");
   }
  }
  void Corner(int a,int b, int c,int d){//４つをあてる
   number=(int)(Math.random()*35)+1;
   if(number==a||number==b||number==c||number==d){
    money*=9;
    System.out.println("勝ちです");
   }else{
    money=0;
    System.out.println("負けです");
   }
  }
  void HiLow(int a){//１９以上かそうでないかを当てる
   number=(int)(Math.random()*35)+1;
   if((a==1&&number>=19)||a==0&&number<19){
    money*=2;
    System.out.println("勝ちです");
   }else{
    money=0;
    System.out.println("負けです");
   }
  }
 
 }
 
 
//スリーカードポーカークラス//////////////////////////////////////////////
class ThreeCardPoker extends Money{
 int number1,number2,number3;
 String Pattern1,Pattern2,Pattern3;
 void setNumber(int n1,int n2,int n3){
  number1=n1;
  number2=n2;
  number3=n3;
 }
 void setPattern(String p1,String p2,String p3){
  Pattern1=p1;
  Pattern2=p2;
  Pattern3=p3;
 }
 ThreeCardPoker(int n1,int n2,int n3,String p1,String p2,String p3){
  setNumber(n1,n2,n3);
  setPattern(p1,p2,p3);
 }
 boolean TryJudge(int n1,int n2,int n3,String p1,String p2,String p3){//勝負するか降りるか判断
  if(n1==n2-1&&n2==n3-1&&p1==p2&&p2==p3){//ストレートフラッシュ
   return true;
  }else if(n1==n2&&n2==n3){//スリーオブカインド
   if((int)(Math.random()*100)<90){
    return true;
    }else{
     return false;
    }
  }else if(n1==n2-1&&n2==n3-1){//ストレート
   if((int)(Math.random()*100)<80){
    return true;
    }else{
     return false;
    }
  }else if(p1==p2&&p2==p3){//フラッシュ
   if((int)(Math.random()*100)<70){
    return true;
    }else{
     return false;
    }
  }else if(n1==n2||n2==n3||n3==n1){//ペア
   if((int)(Math.random()*100)<60){
    return true;
    }else{
     return false;
    }
  }else if(n1==1||n1>11||n2==1||n2>11||n3==1||n3>11){//ハイカード
   if((int)(Math.random()*100)<50){
    return true;
    }else{
     return false;
    }
  }else {
   if((int)(Math.random()*100)<40){//ノーペア
    return true;
    }else{
     return false;
    }
 }
 }
 int HandStrength(int n1,int n2,int n3,String p1,String p2,String p3){//手役の強さを数値化
 if(n1==n2-1&&n2==n3-1&&p1==p2&&p2==p3){//ストレートフラッシュ
  return 6;
 }else if(n1==n2&&n2==n3){//スリーオブカインド
   return 5;
 }else if(n1==n2-1&&n2==n3-1){//ストレート
   return 4;
 }else if(p1==p2&&p2==p3){//フラッシュ
   return 3;
 }else if(n1==n2||n2==n3||n3==n1){//ペア
   return 2;
 }else if(n1==1||n1>11||n2==1||n2>11||n3==1||n3>11){//ハイカード
   return 1;
 }else {
   return 0;
  }
}
 String Hand(int n1,int n2,int n3,String p1,String p2,String p3){//手役の表示
  if(n1==n2-1&&n2==n3-1&&p1==p2&&p2==p3){//ストレートフラッシュ
   return "ストレートフラッシュ";
  }else if(n1==n2&&n2==n3){//スリーオブカインド
    return "スリーオブカインド";
  }else if(n1==n2-1&&n2==n3-1){//ストレート
    return "ストレート";
  }else if(p1==p2&&p2==p3){//フラッシュ
    return "フラッシュ";
  }else if(n1==n2||n2==n3||n3==n1){//ペア
    return "ペア";
  }else if(n1==1||n1>11||n2==1||n2>11||n3==1||n3>11){//ハイカード
    return "ハイカード";
  }else {
    return "ノーペア";
   }
 }
 
 void Dividend(int n1,int n2,int n3,String p1,String p2,String p3){//配当金の設定
  if(n1==n2-1&&n2==n3-1&&p1==p2&&p2==p3){//ストレートフラッシュ
   money*=9;
  }else if(n1==n2&&n2==n3){//スリーオブカインド
   money*=8;
  }else if(n1==n2-1&&n2==n3-1){//ストレート
   money*=7;
  }else if(p1==p2&&p2==p3){//フラッシュ
   money*=6;
  }else if(n1==n2||n2==n3||n3==n1){//ペア
   money*=5;
  }else if(n1==1||n1>11||n2==1||n2>11||n3==1||n3>11){//ハイカード
   money*=4;
  }else {
   money*=3;
   }
 }
 }
 class TotalMoneyManagement extends Money{//所持金管理
 static void Setting(int n){//参加料と賭け金設定、所持金管理
    money=n;
    entryMoney=n;//参加料
    totalmoney=totalmoney-entryMoney;
   }
 static int PayOff(){//精算
    return totalmoney=totalmoney+money;
   }
}
class LoseComment extends Money{//負けコメント
 LoseComment(int e,int m){
  e=entryMoney;
  m=money;
 }
 public String toString(){
  return "ディーラーの勝利です。残念！　参加費：＄"+entryMoney+"  "+"賭け金による損失：＄"+money;
 }
}
class WinComment extends Money{//勝ちコメント
 WinComment(int e,int m){
  e=entryMoney;
  m=money;
 }
 public String toString(){
  return "あなたの勝利です。おめでとうございます！　参加費：＄"+entryMoney+"  "+"賭け金による報酬：＄"+money;
 }
}
//ブラックジャッククラス////////////////////////////////////////////////////////////
  enum Suit {
    クラブ,
    ダイヤ,
    スペード,
    ハート,
}
  class Card {
    private Suit mySuit;
    private int myNumber;
    public Card(Suit aSuit, int aNumber){
        this.mySuit=aSuit;
        if(aNumber>=1 && aNumber<=13){
        this.myNumber= aNumber;
    }else{
        System.err.println(aNumber + "は無意味なカードです");
        System.exit(1);
        
    }}
     public int getNumber(){
         return myNumber;
     }
     public String toString(){
         String numStr = "Error";
         
         switch(this.myNumber){
         
         case 1:
         numStr="エース";
         break;
             
         
         case 2:
         numStr = "2";
         break;
         
         case 3:
         numStr= "3";
         break;
         
         case 4:
         numStr ="4";
         
         case 5:
         numStr ="5";
         break;
         
         case 6:
         numStr = "6";
         break;
         
         case 7:
         numStr= "7";
         break;
         
         case 8:
         numStr ="8";
         
         case 9:
         numStr ="9";
         break;
         case 10:
         numStr = "10";
         break;
         
         case 11:
         numStr= "ジャック";
         break;
         
         case 12:
         numStr ="クイーン";
         break;

         case 13:
         numStr ="キング";
         break;
         
         
         }
         
         return mySuit.toString() +"の"+ numStr ;
     }
 
}
  class Deck {
    
    private Card[] myCards;
    private int numCards;
    
    public Deck(){
        
        this(1,false);
    }
    
    public Deck(int numDecks, boolean shuffle){
        this. numCards= numDecks* 52;
        this. myCards = new Card[this.numCards];
        int c=0;
        
        for(int d=0; d<numDecks;d++){
            
            for(int s=0; s<4;s++){
                
                for(int n=1; n<=13;n++){
                    
                    this.myCards[c] =new Card(Suit.values()[s],n);
                    c++;
                }
            }
        }
        
        if(shuffle){
            this.shuffle();
         }
        }
    
      public void shuffle(){
          Random rng = new Random();
          Card temp;
         
          int j;
          for(int i=0; i< this.numCards;i++){
              j=rng.nextInt(this.numCards);
              
              temp = this.myCards[j];
              this.myCards[i] = this.myCards[j];
              this.myCards[j]= temp;
              
          }
          
      }
        
      public Card dealNextCard(){
          Card top = this.myCards[0];
          
          for(int c =1;c< this.numCards;c++){
              this.myCards[c-1]= this.myCards[c];
          }
          this.myCards[this.numCards-1]= null;
          
          this.numCards--;
          
          return top;
      }
       public void printDeck(int numToPrint){
           
           for(int c=0; c<numToPrint;c++){
               System.out.printf("%3d/%d%s\n",c+1,this.numCards,this.myCards[c].toString());
               
           }
           System.out.printf("\t\t[%d other]\n",this.numCards-numToPrint);
           
       }
}
  class Player {
     
     private String name;
     private Card[] hand =new Card[10];
     private int numCards;
     
     public Player(String aName){
         this.name =aName;
         this.emptyHand();
     
     }
     public void emptyHand(){
         for(int c=0; c<10;c++){
             this.hand[c]=null;
         }
               this.numCards=0;
     }
         public boolean addCard(Card aCard){
             
             if(this.numCards==10){
                 System.err.printf("%s's hand already has 10 cards;"+"cannot add another\n",this.name);
                 System.exit(1);
             }
             this.hand[this.numCards]= aCard;
             this.numCards++;
             return(this.getHandSum()<=21);
         }
         public int getHandSum(){
             int handSum=0;
             int cardNum;
             int numAces =0;
             for(int c=0;c< this.numCards;c++){
                 
                 cardNum= this.hand[c].getNumber();
                 
                 if(cardNum==1){
                     numAces++;
                     handSum+=11;
                 }
                 else if(cardNum>10){
                     handSum+=10;
                 }
                 else{
                     handSum+=cardNum;
                 }
                 
             }
            
             
             while(handSum>21&&numAces>0){
                 handSum-=10;
                 numAces--;
             }
             
             
             return handSum;
         }
         public void printHand(boolean showFirstCard){
             System.out.printf("%sカード:\n",this.name);
             for(int c=0;c<this.numCards;c++){
                 if(c==0 && !showFirstCard){
                     System.out.println(" [？]");
                 }else{
                     System.out.printf(" %s\n",this.hand[c].toString());
                 }
                 
                 
               
                 }
             }
             
     
     }
 
 class TotalMoneyManegementForBAndC extends Money{
	 static void Setting(int n){//賭け金設定、所持金管理
		    money=n;
		    totalmoney=totalmoney-money;
		   }
		 static int PayOff(){//精算
		    return totalmoney=totalmoney+money;
		   }
 }
//カジノクラス///////////////////////////////////
public class Casino extends Money{
 static int cnt=0;
 static void Check(int n) throws NumberFormatException{
 }
 public static void main(String[] args) {
  BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
  try{
   //file0.txtから所有コインの呼び出し/////
       File file = new File("file0.txt");
       if (checkBeforeReadfile(file)){
         BufferedReader br = new BufferedReader(new FileReader(file));
         String str;
         while((str = br.readLine()) != null){
          totalmoney=Integer.parseInt(str);
         }
         br.close();
       }else{
         System.out.println("ファイルが見つからないか開けません");
       }
     }catch(FileNotFoundException e){
       System.out.println(e);
     }catch(IOException e){
       System.out.println(e);
     }
  while(cnt<1){
   try{
    System.out.println("カジノへようこそ");
    System.out.println("現在のあなたの所持金は＄"+totalmoney+"です");
 
    while(counter<1){//リトライ
         
    System.out.println("\nどのゲームで遊びますか？\n1:ルーレット\n2:スリーカードポーカー\n3:ブラックジャック\n4:クラップス");
    String game=reader.readLine();
    if(Integer.parseInt(game)>=5||Integer.parseInt(game)<=0){
     throw new Exception();
    }
    
    switch(Integer.parseInt(game)){//カジノの種類をこたえる
    //ルーレット////////////////////////////////////////////////////
    case 1:System.out.print("賭け金を所持金の範囲で設定してください\n＄");
    String line=reader.readLine();
    Check(Integer.parseInt(line));
    int retryCounterR=0;
    while(retryCounterR<1){//正しく入力されるまでリトライ
        if(Integer.parseInt(line)<=totalmoney){
         retryCounterR++;
         }else{
          System.out.println("正しい範囲で賭け金を設定してください");
          System.out.print("＄");
          line=reader.readLine();
         }
        }
     System.out.println("賭け方を選んでください\n1:ストレートアップ(一種類）\n2:スプリット（二種類）\n3:"
           + "ストリート（三種類）\n4:コーナー（四種類）\n5:ハイロウ（18以下かどうか）");
    String line2=reader.readLine();
    if(Integer.parseInt(line2)>5){
     throw new Exception();
    }
     switch(Integer.parseInt(line2)){//ルーレットの種類を答える
     case 1:System.out.println("どの数字にしますか？");
     String choose=reader.readLine();
     Check(Integer.parseInt(choose));
     roulette bet=new roulette(Integer.parseInt(line));
           bet.StraightUp(Integer.parseInt(choose));
     break;
     case 2:System.out.println("数字を２つ選んでください");
     String choose2=reader.readLine();
     Check(Integer.parseInt(choose2));
     String choose3=reader.readLine();
     Check(Integer.parseInt(choose3));
     roulette bet2=new roulette(Integer.parseInt(line));
     bet2.Split(Integer.parseInt(choose2),Integer.parseInt(choose3));
     break;
     case 3:System.out.println("数字を３つ選んでください");
     String choose4=reader.readLine();
     Check(Integer.parseInt(choose4));
     String choose5=reader.readLine();
     Check(Integer.parseInt(choose5));
     String choose6=reader.readLine();
     Check(Integer.parseInt(choose6));
     roulette bet3=new roulette(Integer.parseInt(line));
     bet3.Street(Integer.parseInt(choose4),Integer.parseInt(choose5),Integer.parseInt(choose6));
     break;
     case 4:System.out.println("数字を４つ選んでください");
     String choose7=reader.readLine();
     Check(Integer.parseInt(choose7));
     String choose8=reader.readLine();
     Check(Integer.parseInt(choose8));
     String choose9=reader.readLine();
     Check(Integer.parseInt(choose9));
     String choose10=reader.readLine();
     Check(Integer.parseInt(choose10));
     roulette bet4=new roulette(Integer.parseInt(line));
     bet4.Corner(Integer.parseInt(choose7),Integer.parseInt(choose8)
       ,Integer.parseInt(choose9),Integer.parseInt(choose10));
     break;
     case 5:System.out.println("ハイなら0、ロウなら1を入力してください");
     String choose11=reader.readLine();
     Check(Integer.parseInt(choose11));
     roulette bet5=new roulette(Integer.parseInt(line));
     bet5.HiLow(Integer.parseInt(choose11));
     break;
     }
     roulette.PayOff();
     break;
       
    //スリーカードポーカー////////////////////////////////////////
    case 2:System.out.println("スリーカードポーカーへようこそ");
    System.out.println("現在のあなたの所持金は＄"+totalmoney+"です");
    if(totalmoney<=1){
     System.out.println("所持金が＄"+totalmoney+"であるためスリーカードポーカーで遊ぶことはできません");
     break;
    }else{
  int x[][]=new int[2][3];//トランプの数字
  String y[][]=new String[2][3];//トランプの柄
  for(int j=0;j<2;j++){//プレイヤーとディーラーのトランプ生成
  int cnt=0;
  for(int i=0;i<3;i++){//トランプの数字と柄の生成
    int randomNumber=(int)(Math.random()*13)+1;//数字の生成
    switch(i){//得た数字を小さい順に並べる
    case 0:x[j][0]=randomNumber;
    break;
    case 1:
     if(x[j][0]>=randomNumber){
      x[j][1]=x[j][0];
      x[j][0]=randomNumber;
     }else{
      x[j][1]=randomNumber;
     }
     break;
    case 2:
     if(x[j][0]>=randomNumber){
      x[j][2]=x[j][1];
      x[j][1]=x[j][0];
      x[j][0]=randomNumber;
     }else if(randomNumber>=x[j][0]&&randomNumber<=x[j][1]){
      x[j][2]=x[j][1];
      x[j][1]=randomNumber;
     }else{
      x[j][2]=randomNumber;
     }
    }
    int randomPattern=(int)(Math.random()*4);//柄の生成
    switch(randomPattern){
    case 0:y[j][cnt]="クラブ";
    cnt++;
    break;
    case 1:y[j][cnt]="スペード";
    cnt++;
    break;
    case 2:y[j][cnt]="ダイヤ";
    cnt++;
    break;
    case 3:y[j][cnt]="ハート";
    cnt++;
    break;
  }
  }
  }
  System.out.println("＄１～＄"+totalmoney/2+"の範囲で参加料をお支払いください");
  System.out.print("＄");
     String line3;
     line3=reader.readLine();//参加料を入力
     int retryCounter=0;
     while(retryCounter<1){//正しく入力されるまでリトライ
     if(Integer.parseInt(line3)>=1&&Integer.parseInt(line3)<=totalmoney/2){
      retryCounter++;
      }else{
       System.out.println("正しい範囲で参加料をお支払いください");
       System.out.print("＄");
       line3=reader.readLine();
      }
     }
     TotalMoneyManagement.Setting(Integer.parseInt(line3));//所持金-参加料
     System.out.println("あなたのカード:\n "+y[0][0]+"の"+x[0][0]+"\n "+y[0][1]+"の"+x[0][1]+"\n "+y[0][2]+"の"+x[0][2]);
   System.out.println("勝負するなら1、降りるなら0を入力してください（勝負すると参加料と同額である＄"+money+"が賭けられます）");
   String choice=reader.readLine();//勝負するか降りるか（1か0か）
   if(Integer.parseInt(choice)!=0&&Integer.parseInt(choice)!=1){//1と0以外で例外処理
       throw new Exception();
      }
   switch(Integer.parseInt(choice)){//勝負する場合と降りる場合
   case 0://降りた場合
    System.out.println("勝負を降りました");
    break;
   case 1://勝負する場合
    ThreeCardPoker t=new ThreeCardPoker(x[1][0],x[1][1],x[1][2],y[1][0],y[1][1],y[1][2]);//スリーカードポーカーインスタンス生成
    if(t.TryJudge(x[1][0],x[1][1],x[1][2],y[1][0],y[1][1],y[1][2])){//勝負か降りるか判断メソッドの呼び出し
       System.out.println("勝負が成立しました！＄"+money+"が賭けられます");
       System.out.print("ディーラーのカード:\n "+y[1][0]+"の"+x[1][0]+"\n "+y[1][1]+"の"+x[1][1]+"\n "+y[1][2]+"の"+x[1][2]+"：");
       System.out.println(t.Hand(x[1][0],x[1][1],x[1][2],y[1][0],y[1][1],y[1][2]));//手役判断メソッドの呼び出し
       System.out.print("あなたのカード:\n "+y[0][0]+"の"+x[0][0]+"\n "+y[0][1]+"の"+x[0][1]+"\n "+y[0][2]+"の"+x[0][2]+"：");
       System.out.println(t.Hand(x[0][0],x[0][1],x[0][2],y[0][0],y[0][1],y[0][2]));//手役判断メソッドの呼び出し
     int dealarHandStrengh=t.HandStrength(x[1][0],x[1][1],x[1][2],y[1][0],y[1][1],y[1][2]);//手役の強さメソッドの呼び出し
     int playerHandStrength=t.HandStrength(x[0][0],x[0][1],x[0][2],y[0][0],y[0][1],y[0][2]);//手役の強さメソッドの呼び出し
     LoseComment l=new LoseComment(entryMoney,money);//負けコメントインスタンス生成
     WinComment w=new WinComment(entryMoney,money);//勝ちコメントインスタンス生成
     if(dealarHandStrengh>playerHandStrength){//勝ち負け判断
     System.out.println(l);
      money=-money;
     }else if(dealarHandStrengh<playerHandStrength){
      t.Dividend(x[0][0],x[0][1],x[0][2],y[0][0],y[0][1],y[0][2]);
      System.out.println(w);
     }else if(x[1][2]>x[0][2]) {
      System.out.println(l);
      money=-money;
     }else if(x[1][2]<x[0][2]) {
      t.Dividend(x[0][0],x[0][1],x[0][2],y[0][0],y[0][1],y[0][2]);
      System.out.println(w);
     }else if(x[1][1]>x[0][1]){
      System.out.println(l);
      money=-money;
     }else if(x[1][1]<x[0][1]){
      t.Dividend(x[0][0],x[0][1],x[0][2],y[0][0],y[0][1],y[0][2]);
      System.out.println(w);
     }else if(x[1][0]>x[0][0]){
      System.out.println(l);
      money=-money;
     }else if(x[1][0]<x[0][0]){
      System.out.println(w);
   }else{
    System.out.println("引き分けです。賭け金は返却されます。※参加費は返されません");
    money=0;
   }
    }else{
       System.out.println("ディーラーが勝負を降りました。参加費と賭け金は返却されます");
    }
    TotalMoneyManagement.PayOff();//所持金の調整
   }
    }
    break;
  
   case 3:
   //ブラックジャック/////////////////////////////////////
    System.out.println("ブラックジャックへようこそ");
    System.out.println("現在のプレイヤーさんの所持金は＄"+totalmoney+"です");
    System.out.print("賭け金を所持金の範囲で設定してください\n＄");
    String line10=reader.readLine();
    Check(Integer.parseInt(line10));
    int retryCounterB=0;
    while(retryCounterB<1){//正しく入力されるまでリトライ
        if(Integer.parseInt(line10)<=totalmoney){
         retryCounterB++;
         }else{
          System.out.println("正しい範囲で賭け金を設定してください");
          System.out.print("＄");
          line10=reader.readLine();
         }
        }
    TotalMoneyManegementForBAndC.Setting(Integer.parseInt(line10));
         Deck theDeck=new Deck(1, true);
         
         Player me =new Player ("あなたの");
         Player dealer =new Player("ディーラーの");
         
         me.addCard(theDeck.dealNextCard());
         dealer.addCard(theDeck.dealNextCard());
         me.addCard(theDeck.dealNextCard());
         dealer.addCard(theDeck.dealNextCard());
         
         System.out.println("カードが配られます\n");
         me.printHand(true);
         dealer.printHand(false);
         
         
         boolean meDone =false;
         boolean dealerDone =false;
         String ans;
         
         while(!meDone||! dealerDone){
             if(!meDone){
                 System.out.println("ヒットならh、ステイならsを押してください");
                 ans=reader.readLine();
                
                 
                 if(ans.compareToIgnoreCase("H")==0){
                     
                 meDone=!me.addCard(theDeck.dealNextCard());
                 me.printHand(true);
                 
                 }else{
                     meDone=true;
                     }                 
                }
             
              if(!dealerDone){
                     if(dealer.getHandSum()<17){
                         System.out.println("ディーラーがヒットしました\n");
                         dealerDone=!dealer.addCard(theDeck.dealNextCard());
                         dealer.printHand(false);
                         }else{
                             System.out.println("ディーラーがステイしました\n");
                             dealerDone=true       ;                      
                         }
                 }
                 System.out.println();
                 
             }
         
         
         me.printHand(true);
         dealer.printHand(true);
         
         int mySum= me.getHandSum();
         int dealerSum=dealer.getHandSum();
         
         if(mySum>dealerSum&&mySum<=21||dealerSum>21){
             System.out.println("あなたの勝ちです");
             money*=2;
         }else{
             System.out.println("ディーラーの勝ちです");
             money=0;
         }
         TotalMoneyManegementForBAndC.PayOff();      
           
   break;
   //クラップス///////////////////////////

    case 4:
    	System.out.println("クラップスへようこそ");
        System.out.println("現在のあなたの所持金は＄"+totalmoney+"です");
        System.out.print("賭け金を所持金の範囲で設定してください\n＄");
        String line11=reader.readLine();
        Check(Integer.parseInt(line11));
        int retryCounterC=0;
        while(retryCounterC<1){//正しく入力されるまでリトライ
            if(Integer.parseInt(line11)<=totalmoney){
             retryCounterC++;
             }else{
              System.out.println("正しい範囲で賭け金を設定してください");
              System.out.print("＄");
              line11=reader.readLine();
             }
            }
        TotalMoneyManegementForBAndC.Setting(Integer.parseInt(line11));
          Random ran = new Random() ;
          System.out.println("あなたの番です");
          System.out.println("サイコロを２つ振ります");
     
     
          int num1 = ran.nextInt(6);
          num1++;
 
          int num2 = ran.nextInt(6);
          num2++;
          System.out.println(num1+"と"+ num2+"が出ました。");
         
          
          int sum1=num1+num2;
          if(sum1==7||sum1==11){
           System.out.println("二つのサイコロの合計が"+sum1+"なので");
           System.out.println("あなたの勝ちです");
           money*=2;
          }else if(sum1==2||sum1==3||sum1==12){
               System.out.println("二つのサイコロの合計が"+sum1+"なので");
               System.out.println("あなたの負けです");
               money=0;
          }else{
           System.out.println("二つのサイコロの合計は"+sum1+"です");
           System.out.println("勝負は続きます");
           while(true){
           System.out.println("次はディーラーの番です。Enterを押してください");
           String Dealer=reader.readLine();
              int num3 = ran.nextInt(6);
              num3++;
              int num4 = ran.nextInt(6);
              num4++;
              int sum2=num3+num4;
              System.out.println(num3+"と"+ num4+"が出ました。");
           
              if(sum2==7){
               System.out.println("ディーラーの二つのサイコロの合計が"+sum2+"なので");
               System.out.println("あなたの勝ちです");
               money*=2;
              break;
          }else{
              System.out.println("二つのサイコロの合計は"+sum2+"です");
              System.out.println("勝負は続きます");
              System.out.println("次はあなたの番です。Enterを押してください");
              String linePlayer=reader.readLine();
              int num5 = ran.nextInt(6);
              num5++;           
              int num6 = ran.nextInt(6);
              num6++;
              int sum3=num5+num6;
              System.out.println(num5+"と"+ num6+"が出ました。");
              if(sum3==7){
              System.out.println("あなたの二つのサイコロの合計が"+sum3+"なので");
              System.out.println("あなたの負けです");
              money=0;
              break;
           }else{
              System.out.println("あなたの二つのサイコロの合計は"+sum3+"です");
                  }
                  }
              }
           }
          TotalMoneyManegementForBAndC.PayOff(); 
      break;
    }
         
    System.out.println("よって所持金が＄"+totalmoney+"になりました");
   if(totalmoney<=0){
    System.out.println("GAME　OVER");
    totalmoney=10000;
    break;
   }
        System.out.println("まだ続けるなら0、終わるなら1を入力してください");
        String a=reader.readLine();
        counter=Integer.parseInt(a);
   }
         
    
    System.out.println("ありがとうございました。またのご参加をお待ちしております");
    cnt++;
   }catch(IOException e){
      System.out.println(e);
     }catch(NumberFormatException e){
      System.out.println("引数は正の整数にしてください。最初からやり直します。");
     }catch(Exception e){
      System.out.println("処理できません。最初からやり直してください　※賭け金は返却されますが参加料は返却されません");
     }
    try{
     //file0.txtに所有コインを書き込み//////////////////
        File file = new File("file0.txt");
        if (checkBeforeWritefile(file)){
          BufferedWriter bw = new BufferedWriter(new FileWriter(file));
         
          bw.write(String.valueOf(totalmoney));
          bw.newLine();
          bw.close();
        }else{
          System.out.println("ファイルに書き込めません");
        }
      }catch(IOException e){
        System.out.println(e);
      }
    
   }
 }
 private static boolean checkBeforeReadfile(File file){
     if (file.exists()){
       if (file.isFile() && file.canRead()){
         return true;
       }
     }
     return false;
   }
 private static boolean checkBeforeWritefile(File file){
     if (file.exists()){
       if (file.isFile() && file.canWrite()){
         return true;
       }
     }
     return false;
   }
}
