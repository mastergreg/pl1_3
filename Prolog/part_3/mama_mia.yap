% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : mama_mia.yap
% 
% * Purpose :
% 
% * Creation Date : 28-06-2011
% 
% * Last Modified : Sat 06 Aug 2011 01:18:21 PM EEST
% 
% * Created By : Greg Liras <gregliras@gmail.com>
% 
% _._._._._._._._._._._._._._._._._._._._._.*/

  execuTe(_,_,I,OM,''):- OM=I.
  execuTe(_,M,I,OM,'M'):- OM is M*I.
  execuTe(A,_,I,OM,'A'):- OM is A+I.

  big_sista(_,_,OMO,OMO,[]).
  big_sista(A,M,I  ,O  ,[P|Prog]):-
    execuTe(A,M,I,I2,P),
    big_sista(A,M,I2,O,Prog).

  bigga_sista(A,M,LI,HI,MLO,MHO,Prog):-
    big_sista(A,M,LI,MLO,Prog),
    big_sista(A,M,HI,MHO,Prog).
    

  big_mama(A,M,LI,HI,LO,HO,LIMIT,Prog,RetProg):-
    length(Prog,L),
    bigga_sista(A,M,LI,HI,MLO,MHO,Prog),
    L =< LIMIT,
    (
        MLO > HO -> fail
      ;
        MHO > HO -> fail
      ;
        MW is MHO-MLO,
        W is HO-LO,
        MW > W -> fail
      ;
        MLO >= LO,
        MHO >= LO -> RetProg = Prog
      ;
        moreProg(Prog,RProg),
        big_mama(A,M,LI,HI,LO,HO,LIMIT,RProg,RetProg)
    ).

  moreProg(IProg,OProg):-OProg=['M'|IProg];OProg=['A'|IProg].

  mama_mia(A,M,LI,HI,LO,HO,Prog):-
    LIMIT1 is HO / A,
    LIMIT2 is ceiling(((log(HO)))/((log(M)))),
    LIMIT is max(LIMIT1,LIMIT2),
    big_mama(A,M,LI,HI,LO,HO,LIMIT,[],SProg),
    !,
    set_prolog_flag(to_chars_mode,iso),
    atom_chars(Prog,SProg).
