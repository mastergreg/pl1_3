/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Program.java

* Purpose :

* Creation Date : 04-08-2011

* Last Modified : Thu 11 Aug 2011 07:31:53 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.ArrayList;

public class Program implements Cloneable
{ 
  private ArrayList<PR> Prog = null;
  private PR last = null;
  public Program()
  {
    Prog = new ArrayList<PR>();
    //Prog.add(new PR('S'));
  }
  public Program(ArrayList<PR> newP)
  {
    Prog = newP;
  }
  public void add(char C)
  {
    try
    {
      last = Prog.get(Prog.size());
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
    catch(java.lang.IndexOutOfBoundsException e)
    {
      last = new PR(C);
      Prog.add(last);
    }
  }
  public ArrayList<PR> getProg()
  {
    return Prog;
  }
  public Program clone()
  {
    ArrayList<PR> newProg = new ArrayList<PR>();
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

