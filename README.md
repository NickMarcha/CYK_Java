# CYK_Java [![Run on Repl.it](https://replit.com/badge/github/NickMarcha/CYK_Java)](https://replit.com/new/github/NickMarcha/CYK_Java)
See exampleGrammar.txt and exampleGrammar2.txt to configure grammar
Example runs
```
Specify Grammar file:
exampleGrammar.txt
Loading file:
C:\Users\....\exampleGrammar.txt
Title: baaba language
Loaded grammar, type a string to test it:
babb
...

...
    [1]             [2]             [3]             [4]             
[0] [S{B}]          [S{S}, S{A}]    [S{S}, S{B}]    []              
[1] []              [S{C}, S{A}]    [S{S}, S{B}]    []              
[2] []              []              [S{B}]          []              
[3] []              []              []              [S{B}]          

{babb} is not included in Grammar
Loaded grammar, type a string to test it:
baaba
...

...
    [1]             [2]             [3]             [4]             [5]             
[0] [S{B}]          [S{S}, S{A}]    []              [S{S}, S{B}]    [S{S}, S{A}]    
[1] []              [S{C}, S{A}]    [S{B}]          [S{S}, S{B}]    [S{S}, S{A}]    
[2] []              []              [S{C}, S{A}]    [S{S}, S{B}]    [S{S}, S{A}]    
[3] []              []              []              [S{B}]          [S{S}, S{A}]    
[4] []              []              []              []              [S{C}, S{A}]    

{baaba} is included in Grammar
```

```
exampleGrammar2.txt
Loading file:
C:\Users\....\exampleGrammar2.txt
Title: Fish language - she eats a fish with a fork
Loaded grammar, type a string to test it:
eat all fish
    [1]             [2]             [3]             
[0] []              []              []              
[1] []              []              []              
[2] []              []              [S{N}]          

{eat all fish} is not included in Grammar

Loaded grammar, type a string to test it:
she eats a fish with a fork
...

...
    [1]             [2]             [3]             [4]             [5]             [6]             [7]             
[0] [S{NP}]         [S{S}]          []              [S{S}]          []              []              [S{S}]          
[1] []              [S{VP}, S{V}]   []              [S{VP}]         []              []              [S{VP}]         
[2] []              []              [S{Det}]        [S{NP}]         []              []              []              
[3] []              []              []              [S{N}]          []              []              []              
[4] []              []              []              []              [S{P}]          []              [S{PP}]         
[5] []              []              []              []              []              [S{Det}]        [S{NP}]         
[6] []              []              []              []              []              []              [S{N}]          

{she eats a fish with a fork} is included in Grammar
```
