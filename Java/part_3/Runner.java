/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Runner.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Mon 01 Aug 2011 08:31:36 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

public class Runner
{
  private int a=0;
  private int m=0;
  private int li=0;
  private int hi=0;
  private int mlo=0;
  private int mho=0;
  private String prog;

  Runner()
  {

  }
  Runner(int a,int m,int li,int hi,String prog)
  {
    this.a=a;
    this.m=m;
    this.li=li;
    this.mlo=li;
    this.hi=hi;
    this.mho=hi;
    this.prog = prog;
  }
  public void SetRunner(int a,int m,int li,int hi,String prog)
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
    for(int i = 0; i < prog.length() ; i++)
    {
      char c = prog.charAt(i);
      if (c=='0')
      {
        mlo+=a;
        mho+=a;
      }
      else if (c=='1')
      {
        mlo*=m;
        mho*=m;
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
    if(mho>ho) return 1; //high out exceeded
    if(mlo>ho) return 1; //
    if(mlo<lo) return 2; //low out not reached
    if(mho<lo) return 2; //
    return 0;
  }
}
