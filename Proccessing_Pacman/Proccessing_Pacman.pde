Game game = new Game(28,36);

public void settings(){
  size(600,800);
}

void setup(){
  frameRate(5);
}

void keyReleased()
{
  game.onKeyReleased();
}

void keyPressed()
{
  game.onKeyPressed();
}
   


void draw(){
    game.update();
   background(0);
   int[][] board = game.getBoard();
   for(int x = 0; x < game.getWidth(); x++){
     for (int y = 0; y < game.getHeight(); y++){
       if (board[x][y] == 0){
         fill(0,0,0); // sort
       }
       else if (board[x][y] == 1){ //yellow
         fill(255,255,0);
       }
      /* else if (board[x][y] == 2){
         fill(pink);
       }
       else if (board[x][y] == 3){
         fill(blå);
       }
       else if (board[x][y] == 4){
         fill(grøn);
       }
       else if (board[x][y] == 5){
         fill(rød);
       }*/
       stroke(100,100,100);
       rect(x*21.42,y*22.22,21.42,22.22);
     }
   }
   fill(255);
        
      
}
