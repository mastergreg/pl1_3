% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : magic.pl
% 
% * Purpose :
% 
% * Creation Date : 28-06-2011
% 
% * Last Modified : Mon 04 Jul 2011 12:14:49 PM EEST
% 
% * Created By : Greg Liras <gregliras@gmail.com>
% 
% _._._._._._._._._._._._._._._._._._._._._.*/
  quick_sort(List,Sorted):-q_sort(List,[],Sorted).
  q_sort([],Acc,Acc).
  q_sort([H|T],Acc,Sorted):-
    pivoting(H,T,L1,L2),
    q_sort(L1,Acc,Sorted1),q_sort(L2,[H|Sorted1],Sorted).

  pivoting(_,[],[],[]).
  pivoting(H,[X|T],[X|L],G):-X=<H,pivoting(H,T,L,G).
  pivoting(H,[X|T],L,[X|G]):-X>H,pivoting(H,T,L,G).

  sub(BASE,A,B,C) :-
   subH(BASE,A,B,0,C).

  subH(_   ,[]     ,_     ,_    ,[]) :-!.
  subH(BASE,[A|AS] ,[B|BS],CARRY,[C|CS]) :-
    AL is B-A-CARRY,
    (AL<0 -> C is AL+BASE , CARRY2 = 1; C=AL,CARRY2 = 0),
    subH(BASE,AS,BS,CARRY2,CS) .

  is_Magic(A,BASE) :-
    quick_sort(A,SA),
    reverse(SA,RSA),
    sub(BASE,SA,RSA,A).
    
  next(BASE,A,NXT) :-
    nextH2(BASE,A,NXT,1).

  nextH2(_   ,[]    ,[]     ,_) :- !.
  nextH2(_   ,AS    ,AS     ,0) :- !.
  nextH2(BASE,[A|AS],[N|NXT],CARRY):-
    DIG is A+CARRY,
    (
      DIG<BASE -> (DIG = N, CARRY2 = 0 )
      ; (N is 0 , CARRY2 = 1)
    ),
    nextH2(BASE,AS,NXT,CARRY2).

  makeStart([]    ,0):-!.
  makeStart([L|LS],DIGITS):-
    length([L|LS],DIGITS),
    NDIG is DIGITS-1,
    L=0,
    makeStart(LS,NDIG).

    
  
  nth(0,[X|_],X).
  nth(N,[_|T],R):- M is N-1,nth(M,T,R).


  makeContestant(BASE,NUM,CONTESTANT):-
      quick_sort(NUM,SNUM),
      reverse(SNUM,RSNUM),
      sub(BASE,SNUM,RSNUM,CONTESTANT).

  failNum(LIMIT,NUM):-
    nth(LIMIT,NUM,A),
    A>0.  

  findMagic(LIMIT,BASE,NUM,RNUM):-
    !,
  (
      failNum(LIMIT,NUM) -> RNUM=0 
    ;
      makeContestant(BASE,NUM,CONTESTANT)
    (
      is_Magic(CONTESTANT,BASE) -> RNUM=CONTESTANT
    ; 
      next(BASE,NUM,NEXT),
      findMagic(LIMIT,BASE,NEXT,RNUM)
    )
  ).

  computed(_,[],_,RESULT,RESULT):-!.
  computed(BASE,[N|NUM],POWER,RESULT,RETURN):-
    RESULT2 is RESULT+N*BASE^POWER,
    POWER2 is POWER+1,
    computed(BASE,NUM,POWER2,RESULT2,RETURN).
  magic(BASE,DIGITS,NUM) :-
    makeStart(ST,DIGITS),
    next(10,ST,START),
    LIMIT is truncate(DIGITS/2),
    findMagic(LIMIT,BASE,START,RNUM),
    computed(BASE,RNUM,0,0,NUMF),
    NUM2 is round(NUMF),
    (
      NUM2=0 -> fail
      ;
      NUM=NUM2
    ).
