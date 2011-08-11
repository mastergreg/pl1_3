/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Program.java

* Purpose :

* Creation Date : 04-08-2011

* Last Modified : Wed 10 Aug 2011 08:48:48 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;
import java.util.List;

public class Program implements Cloneable
{ 
  private LinkedList<PR> Prog = null;
  private PR last = null;
  public Program()
  {
    Prog = new LinkedList<PR>();
    //Prog.add(new PR('S'));
  }
  public Program(LinkedList<PR> newP)
  {
    Prog = newP;
  }
  public void add(char C)
  {
    try
    {
      last = Prog.getLast();
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
    catch(java.util.NoSuchElementException e)
    {
      last = new PR(C);
      Prog.add(last);
    }
  }
  public LinkedList<PR> getProg()
  {
    return Prog;
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
      if(c != 'S')
      for(int i=0;i<t;i++)
      {
        S.append(c);
      }
    }
    return S.toString();
  }
}

