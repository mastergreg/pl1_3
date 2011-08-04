/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Program.java

* Purpose :

* Creation Date : 04-08-2011

* Last Modified : Thu 04 Aug 2011 08:46:12 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;

public class Program implements Cloneable
{ 
  private class PR
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
  private LinkedList<PR> Prog = null;
  private PR last = null;
  public Program()
  {
    Prog = new LinkedList<PR>();
    Prog.add(new PR('S'));
  }
  public Program(LinkedList<PR> newP)
  {
    Prog = newP;
  }
  public void add(char C)
  {
    last = Prog.getLast();
    if(last!=null)
    {
      if(last.getC()==C)
      {
        last.inc();
      }
      else
      {
        last = new PR(C);
        Prog.add(last);
      }
    }
    else
    {
      last = new PR(C);
      Prog.add(last);
    }

  }
  public Program clone()
  {
    LinkedList<PR> newProg = new LinkedList<PR>();
    for(PR p : Prog)
    {
      newProg.add(p.clone());
    }
    return new Program(newProg);
  }
  public String toString()
  {
    StringBuilder S = new StringBuilder();
    for(PR p : Prog)
    {
      int t = p.getTimes();
      char c = p.getC();
      for(int i=0;i<t;i++)
      {
        S.append(c);
      }
    }
    return S.toString();
  }
}

