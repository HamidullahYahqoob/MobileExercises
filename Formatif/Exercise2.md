| ligne exécutée           | effet                                                      | pile d'appels |
|--------------------------|------------------------------------------------------------|---------------|
| var a = 100                    | a = 100                                                | __main__      |
| a += double(a) + (3 * triple(8))                  | a = 100 <br />  appelle double avec 100→x                                           | __main__      |
| val z = x * 2 | x : 100 <br /> z = 200     | __double__ <br /> main      |
| return z             | x : 100 <br /> z = 200, retourne 200     | __double__ <br /> main      |
| a += double(a) + (3 * triple(8))                | a: 100 <br /> double(a): 200 <br /> appelle triple avec 8→a  |  __main__ |
| return a * 3 | a: 8 <br /> retourne 8*3, retourne 24     | __triple__  <br /> main    |
| a += double(a) + (3 * triple(8)) | ma: 100 <br /> double(a): 200 <br /> triple(8):24 <br /> après execution a = 372 | __main__      |
| println(a)             | affiche "372"	                                    |  __main__ |
