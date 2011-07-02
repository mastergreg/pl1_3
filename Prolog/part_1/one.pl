% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : one.pl
% 
% * Purpose :
% 
% * Creation Date : 02-07-2011
% 
% * Last Modified : Sat 02 Jul 2011 09:05:56 PM EEST
% 
% * Created By : Greg Liras <gregliras@gmail.com>
% 
% _._._._._._._._._._._._._._._._._._._._._.*/

  mylast(A,[A|[]]) .
  mylast(X,[_|AS]) :- 
    mylast(X,AS) .

  prelast(A,[A|[_]]) .
  prelast(X,[_|AS]) :-
    prelast(X,AS) .

  elementAt(A,[A|_],0) .
  elementAt(X,[_|LS],N) :-
    K is N-1,
    elementAt(X,LS,K) .

  leng(A,[],A).
  leng(X,[_|LS],N) :-
    K is N+1,
    leng(X,LS,K).

  rever(A,[],A).
  rever(X,[L|LS],A) :-
    rever(X,LS,[L|A]) .

  rev(A,X) :-
    rever(X,A,[]).

  pali(A) :-
    rever(A,A,[]) .

  flatN(X,A) :-
    flatn(X2,A,[]),
    rever(X,X2,[]).
  flatn(A,[],A) .
  flatn(X,[A|AS],B) :-
    is_list(A) ,
    !,
    flatn(X2,A,B) ,
    flatn(X,AS,X2) .
  flatn(X,[A|AS],B) :-
    append([A],B,Z),
    flatn(X,AS,Z) .

  compress(A,[],A,_) .
  compress(X,[A|AS],B,A) :-
    !,
    compress(X,AS,B,A).
  compress(X,[A|AS],B,_) :-
    !,
    compress(X,AS,[A|B],A).

  comPRESS([],[]) .
  comPRESS([A|AS],X) :-
    compress(X2,AS,[A],A),
    rev(X2,X).

    

