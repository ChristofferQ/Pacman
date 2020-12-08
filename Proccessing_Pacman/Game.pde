class Game {
  private int width;
  private int height;
  private int[][] board;
  private Dot player;
  private Keys keys;
  
  
  
  Game(int width, int height){
    this.board = new int[width][height];
    this.width = width;
    this.height = height;
    player = new Dot(0,0,width-1, height-1);
    keys = new Keys();
  }
  
  public int getWidth(){
    return width;
  }
  
  public int getHeight(){
    return height;
  }
  
  public void update(){
    updatePlayer();
    clearBoard();
    populateBoard();
    
  }
  
  public int[][] getBoard(){
    return board;
  }
  
  private void updatePlayer()
  {
    if(keys.upDown() && !keys.downDown())
    {
      player.moveUp();
    }
    if(keys.leftDown() && !keys.rightDown())
    {
      player.moveLeft();
    }
    if(keys.downDown() && !keys.upDown())
    {
      player.moveDown();
    }
    if(keys.rightDown() && !keys.leftDown())
    {
      player.moveRight();
    }
  }
  
   private void populateBoard()
  {
    //Insert player
    board[player.getX()][player.getY()] = 1;
  }
  
  private void clearBoard()
  {
    for(int y = 0; y < height; ++y)
    {
      for(int x = 0; x < width; ++x)
      {
        board[x][y]=0;
      }
    }
  }
  
  public void onKeyPressed()
  {
    keys.onKeyPressed();
  }
  
  public void onKeyReleased()
  {
    keys.onKeyReleased();
  }
}
