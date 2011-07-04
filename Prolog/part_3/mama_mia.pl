% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : mama_mia.pl
% 
% * Purpose :
% 
% * Creation Date : 28-06-2011
% 
% * Last Modified : Mon 04 Jul 2011 09:46:12 PM EEST
% 
% * Created By : Greg Liras <gregliras@gmail.com>
% 
% _._._._._._._._._._._._._._._._._._._._._.*/

  execuTe(_,_,I,OM,""):- OM=I.
  execuTe(M,_,I,OM,"M"):- OM is M*I.
  execuTe(_,A,I,OM,"A"):- OM is A+I.

  big_sista(_,_,OMO,OMO,[]):-!.
  big_sista(M,A,I  ,O  ,[P|Prog]):-
    execuTe(M,A,I,I2,P),
    big_sista(M,A,I2,O,Prog).

  big_mama(M,A,LI,HI,LO,HO,Prog,RetProg):-
    big_sista(M,A,LI,MLO,Prog),
    big_sista(M,A,HI,MHO,Prog),
    (
      MLO >= LO,
      MLO =< HO,
      MHO >= LO,
      MHO =< HO -> RetProg = Prog
      ;
        (MLO > HO ; MHO < LO) -> fail
      ;
        !,
        moreProg(Prog,RProg),
        big_mama(M,A,LI,HI,LO,HO,RProg,RetProg)
    ).

  moreProg(IProg,OProg):-OProg=["A"|IProg];OProg=["M"|IProg].

  mama_mia(M,A,LI,HI,LO,HO,Prog):-
    big_mama(M,A,LI,HI,LO,HO,[],Prog).
