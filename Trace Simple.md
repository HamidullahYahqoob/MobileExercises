| Ligne exécutée      | Effet |
| :----: | :----: |
| val a = 5 + 2 * 2      | a = 9       |
| for ( i in 1..2 )   | a = 9 <br/> i parcourt l'interval 1, 2        |
| for( j in 4..6 )   | a = 9 <br/> i = 1  <br /> j parcourt l'interval 4, 5, 6      |
| println( ( i + j ).toString() + ( i.toString() + " " + a ))   | a = 9 <br /> i = 1 <br /> j = 4 <br /> affiche " 51 9"     |
| println( ( i + j ).toString() + ( i.toString() + " " + a ))   | a = 9 <br /> i = 1 <br /> j = 5 <br /> affiche " 61 9"     |
| println( ( i + j ).toString() + ( i.toString() + " " + a ))   | a = 9 <br /> i = 1 <br /> j = 6 <br /> affiche " 71 9"     |
| for( j in 4..6 )   | a = 9 <br/> i = 2  <br /> j parcourt l'interval 4, 5, 6      |
| println( ( i + j ).toString() + ( i.toString() + " " + a ))   | a = 9 <br /> i = 2 <br /> j = 4 <br /> affiche " 62 9"     |
| println( ( i + j ).toString() + ( i.toString() + " " + a ))   | a = 9 <br /> i = 2 <br /> j = 5 <br /> affiche " 72 9"     |
| println( ( i + j ).toString() + ( i.toString() + " " + a ))   | a = 9 <br /> i = 2 <br /> j = 6 <br /> affiche " 82 9"     |