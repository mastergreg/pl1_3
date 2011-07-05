% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : mama_mia.pl
% 
% * Purpose :
% 
% * Creation Date : 28-06-2011
% 
% * Last Modified : Tue 05 Jul 2011 03:48:48 AM EEST
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

  big_mama(A,M,LI,HI,LO,HO,Prog,RetProg):-
    big_sista(A,M,LI,MLO,Prog),
    big_sista(A,M,HI,MHO,Prog),
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
        big_mama(A,M,LI,HI,LO,HO,RProg,RetProg)
    ).

  moreProg(IProg,OProg):-OProg=["A"|IProg];OProg=["M"|IProg].

  mama_mia(A,M,LI,HI,LO,HO,Prog):-
    big_mama(A,M,LI,HI,LO,HO,[],Prog).
