# CYK_Java [![Run on Repl.it](https://replit.com/badge/github/NickMarcha/CYK_Java)](https://replit.com/new/github/NickMarcha/CYK_Java)

See [exampleGrammar.txt](exampleGrammar.txt) and [exampleGrammar2.txt](exampleGrammar2.txt) to configure grammar

# Example runs:

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

## Some reflections
- Math "arrays" starting at 1 instead of zero could probably warrant a proper abstraction.
- Sets/list are implemented in many ways I'm not sure which the formula symbols coincide with what properties (i.e. Uniqueness, indexing)
- I don't think Tupples are well implemented in Java, especially when trying to perform set operations on them. Might be better when using libraries. The one I found was last updated 2012 so I just implemented the parts I needed myself. 
- Was not certain of how to handle different rule-type objects in same list. Ended up keeping the seperate this time, previous implementation I made an interface which kept them in the same array. This time I was going for making them seem as though they were stored the same place behind and abstraction, asside from indexing this might be a better approach. 
