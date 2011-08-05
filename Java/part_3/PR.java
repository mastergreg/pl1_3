/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

 * File Name : PR.java

 * Purpose :

 * Creation Date : 05-08-2011

 * Last Modified : Fri 05 Aug 2011 08:49:04 AM EEST

 * Created By : Greg Liras <gregliras@gmail.com>

 _._._._._._._._._._._._._._._._._._._._._.*/

public class PR
{
  private int times;
  private char character;

  PR(char c)
  {
    times = 1;
    character = c;
  }
  PR(int t,char C)
  {
    times=t;
    character = C;
  }

  public void inc()
  {
    times++;
  }
  public char getC()
  {
    return character;
  }
  public int getTimes()
  {
    return times;
  }
  public  PR clone()
  {
    return new PR(times,character);
  }
}
