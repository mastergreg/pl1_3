/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Runner.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Thu 11 Aug 2011 09:23:40 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.ArrayList;
public class Runner
{
  private int a=0;
  private int m=0;
  private int li=0;
  private int hi=0;
  private int mlo=0;
  private int mho=0;
  private int mwidth=0;
  private int mul=0;
  private double pow=0;
  private Program prog;

  Runner()
  {

  }
  Runner(int a,int m,int li,int hi,Program prog)
  {
    this.a=a;
    this.m=m;
    this.li=li;
    this.mlo=li;
    this.hi=hi;
    this.mho=hi;
    this.prog = prog;
  }
  public void SetRunner(int a,int m,int li,int hi,Program prog)
  {
    this.a=a;
    this.m=m;
    this.li=li;
    this.mlo=li;
    this.hi=hi;
    this.mho=hi;
    this.prog = prog;
  }
  public void run()
  {
    ArrayList<PR> P = prog.getProg();
    for(PR rlP : P)
    {
      int t = rlP.getTimes();
      int c = rlP.getC();

      if (c=='A')
      {
        mul = a*t;
        mlo+=mul;
        mho+=mul;
      }
      else 
      {
        pow=Math.pow(m,t);
        mlo*=pow;
        mho*=pow;
      }
    }
  }
  public int getMHO()
  {
    return mho;
  }
  public int getMLO()
  {
    return mlo;
  }
  public int outPutCheck(int lo,int ho)
  {
    if(mho-mlo>ho - lo) return 1;
    if(mho>ho) return 1; //high out exceeded
    if(mlo>ho) return 1; //
    if(mlo<lo) return 2; //low out not reached
    if(mho<lo) return 2; //
    return 0;
  }
}
