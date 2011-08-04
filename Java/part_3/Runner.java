/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Runner.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Thu 04 Aug 2011 08:43:55 PM EEST

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
  private int mwidth=0;
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
    for(int i = 1; i < prog.length() ; i++)
    {
      char c = prog.charAt(i);
      if (c=='A')
      {
        mlo+=a;
        mho+=a;
      }
      else if (c=='M')
      {
        mlo*=m;
        mho*=m;
      }
    }
    mwidth = mho-mlo;
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
    int width = ho = lo;
    if(mwidth>width) return 1;
    if(mho>ho) return 1; //high out exceeded
    if(mlo>ho) return 1; //
    if(mlo<lo) return 2; //low out not reached
    if(mho<lo) return 2; //
    return 0;
  }
}
