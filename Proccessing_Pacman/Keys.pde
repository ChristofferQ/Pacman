class Keys
{
  private boolean upDown = false;
  private boolean leftDown = false;
  private boolean downDown = false;
  private boolean rightDown = false;
 
 
  
  public Keys(){}
  
  public boolean upDown()
  {
    return upDown;
  }
  
  public boolean leftDown()
  {
    return leftDown;
  }
  
  public boolean downDown()
  {
    return downDown;
  }
  
  public boolean rightDown()
  {
    return rightDown;
  }
  

 
  void onKeyPressed()
  {
    if(keyCode == UP)
    {
      upDown = true;
    }
    else if (keyCode == LEFT)
    {
      leftDown = true;
    }
    else if(keyCode == DOWN)
    {
      downDown = true;
    }
    else if(keyCode == RIGHT)
    {
      rightDown = true;
    }
  }

  void onKeyReleased()
  {
    if(keyCode == UP)
    {
      upDown = false;
    }
    else if (keyCode == LEFT)
    {
      leftDown = false;
    }
    else if(keyCode == DOWN)
    {
      downDown = false;
    }
    else if(keyCode == RIGHT)
    {
      rightDown = false;
    }
  }
}
