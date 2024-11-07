//Tic Tac Toe Game, simple in CUI
// our pacage for the game
package XO_GAME;
  
import java.util.ArrayList;
    import java.util.Scanner; //the Scanner scaner to be able to read input from the players
    import java.util.List;
    import java.lang.Math;
        // the class of our game 
        public class XO_Game {
            // this Method show our game Board every time the programm call her. 
            
            static char Board[][]={{' ',' ',' '},           // the game Board will be empthy at first 
                                   {' ',' ',' '},
                                   {' ',' ',' '}};
            
            
            
            static void Board(int play, Player player){
                 if(play!=0){
                    var Row=Math.ceil(((double) play)/3 -1);
                    var Col = play -3*(Math.ceil(((double) play)/3 -1))-1;
                    Board[(int) Row][(int) Col]=player.getMark(play);
                 }
                 // this block of code will fill the Board based on the recent and previus players input.
                 board: {       
                     int i;
                     System.out.println("_____________");
                     for (i = 0; i < Board.length; i++) {
                        for (int j = 0; j < Board[i].length; j++) {
                            System.out.print("| "+Board[i][j]+" ");
                        }
                        System.out.println("|");
                        switch (i){
                            case 2: System.out.println("#############");
                                    break;
                            default: System.out.println("+---+---+---+");
                        }
                    }
                 }   
            }
            
            
            static void playsceen(Player player,Player vsplayer,List playable){
                Scanner in =new Scanner(System.in);
                System.out.print(player.getName()+" where you want to play:\t");
                int play=10;
                try {
                play=in.nextInt();}
                catch(java.util.InputMismatchException e){
                    System.out.print("don't enter letters please, ");
                    in.nextLine();
                }  
                while(vsplayer.check_input(play) || player.check_input(play) || (!(playable.contains(play)))){
                       System.out.print("This is invalid!!\nenter a playable vacant number from 1 to 9:\t");
                       try {
                         play=in.nextInt();}
                       catch(java.util.InputMismatchException e){
                        System.out.print("don't enter letters please, ");
                        in.nextLine();
                       }          
                   }
                   Board(play,player);
            }
            
            
            // our main Method
            public static void main(String args[]){
               int playturn=1;
               List<Integer> playable =new ArrayList<>();
                for (int i = 1; i < 10; i++) {
                    playable.add(i);
                }
           
               Scanner in =new Scanner(System.in);          //a scanner object to read the input from the player(s)
               
               // we define two players from the class Player
               Player player1=new Player();                 
               Player player2=new Player();
               System.out.print("the first player name :\t");   
               player1.setName(in.next());                               //player enter his name
               System.out.print("make your choise X or O :\t");
               player1.setMark(in.next().toUpperCase().charAt(0));       // player choise (X or O) 
               System.out.print("the second player name :\t");          
               player2.setName(in.next());                                //second player name
               player2.setMark(player1);                                 //it will give the player2 X or O dpends on the choice of the first player

               Board(0,player1);                                                 // to show the Board
               
               // game starts here by taking the input from the first player
               while(true){
                   if(playturn==1){
                       playsceen(player1,player2,playable);
                       playturn++;
                       if( player1.check_win() || player1.getCount()==5){
                           break;
                       }
                   }
                   else {
                       playsceen(player2,player1,playable);
                       playturn--;
                       if(player2.check_win()){
                           break;
                       }
                   }
            }
        }
        }