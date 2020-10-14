# java_33
Write console game application “Bulls and Cows”
Requirements:
1. The application must generate number (aka, generated number) containing 4 unrepeated digits from 1 to 9 (example, 1234)
1. The application shall allow the user to enter number (aka, user number) from the console
1. The application shall display out on console number of the bulls (existing digit at a correct position) 
and number of the cows (existing digit at an incorrect place),
 example:(generated number: 1234, user number: 4836, output: 1 cows; 1 bulls)
1. The application shall define the game finish once the user enters a number equaled the generated one (0 cows; 4 bulls)
1. The application should allow the user at each move to see all previous the game moves (example: 4836(1 cows, 1 bulls); 
4321(4 cows, 0 bulls) ; 4231 (2 cows, 2 bulls); 1234 (0 cows, 4 bulls) )
1. The application should keep the game history in the file with name containing date, hours, minutes and number of moves 
(example: 2020-05-24_21_14_6) the file name from the example means that the game had finished on May 24, 2020 at 21 o’clock 14 minutes with 6 moves 
1. The application should not inform the user about wrong move
 example, user enters 111b ,  the generated number 1234, application prints out 2 cows; 1 bulls with meaning of the wrong move – wrong response)

Note: In the debug-test mode the application may print out the generated number for only testing purposes 

