% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : mama_mia.pl
% 
% * Purpose :
% 
% * Creation Date : 28-06-2011
% 
% * Last Modified : Tue 05 Jul 2011 05:10:47 PM EEST
% 
% * Created By : Greg Liras <gregliras@gmail.com>
% 
% _._._._._._._._._._._._._._._._._._._._._.*/

  execuTe(_,_,I,OM,""):- OM=I.
  execuTe(_,M,I,OM,"M"):- OM is M*I.
  execuTe(A,_,I,OM,"A"):- OM is A+I.

  big_sista(_,_,OMO,OMO,[]).
  big_sista(A,M,I  ,O  ,[P|Prog]):-
    execuTe(A,M,I,I2,P),
    big_sista(A,M,I2,O,Prog).

  big_mama(A,M,LI,HI,LO,HO,LIMIT,Prog,RetProg):-
    length(Prog,L),
    L =< LIMIT,
    big_sista(A,M,LI,MLO,Prog),
    big_sista(A,M,HI,MHO,Prog),
    (
        MLO >= LO,
        MLO =< HO,
        MHO >= LO,
        MHO =< HO -> RetProg = Prog
      ;
        moreProg(Prog,RProg),
        big_mama(A,M,LI,HI,LO,HO,LIMIT,RProg,RetProg)
    ).

  moreProg(IProg,OProg):-OProg=["M"|IProg];OProg=["A"|IProg].

  mama_mia(A,M,LI,HI,LO,HO,Prog):-
    LIMIT1 is HO/A,
    LIMIT2 is ceiling(log(HO)/log(M)),
    LIMIT is min(LIMIT1,LIMIT2),
    big_mama(A,M,LI,HI,LO,HO,LIMIT,[],SProg),
    flatten(SProg,FProg),
    name(Prog,FProg).
