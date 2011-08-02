/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Program.java

* Purpose :

* Creation Date : 02-08-2011

* Last Modified : Tue 02 Aug 2011 07:36:15 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/
import java.util.LinkedList;
public class Program
{
  private LinkedList<Integer> Prog=null;
  private int length;
  private int CurrentCounter;
  private int ListSize;
  private Integer curr=null;
  public Program()
  {
    length=0;
    CurrentCounter = 1;
    ListSize = 1;
    curr=new Integer(0);
    Prog = new LinkedList<Integer>();
    Prog.add(curr);
  }
  public Program(Program p)
  {
    length=p.getLength();
    CurrentCounter=p.getCurrentCounter();
    ListSize=p.getListSize();
    Prog=p.getProg();
    curr=Prog.getLast();
  }
  private void shiftR()
  {
    if(CurrentCounter<32)
    {
      CurrentCounter++;
      curr*=2;
    }
    else
    {
      CurrentCounter=0;
      ListSize++;
      curr = new Integer(0);
      Prog.add(curr);
    }
    length++;
  }
  private void increment()
  {
    curr++;
  }
  public Program addA()
  {
    Program newP = new Program(this);
    newP.shiftR();
    return newP;
  }
  public Program addM()
  {
    Program newP = new Program(this);
    newP.shiftR();
    newP.increment();
    return newP;
  }
  public int getLength()
  {
    return length;
  }
  public int getCurrentCounter()
  {
    return CurrentCounter;
  }
  public int getListSize()
  {
    return ListSize;
  }
  public LinkedList<Integer> getProg()
  {
    return new LinkedList<Integer>(Prog);
  }
  public String toString()
  {
    String s="";
    for(Integer I:Prog)
    {
      s+=I.intValue();
    }
    return s;
  }


}
