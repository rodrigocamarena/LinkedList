REFACTOR
========

### Coding principles 

## Meaningfull names :

We updated the choice of words in the code in various ways:
1.	Changed the name of every variable to English
2.	Changed the name of variables that were called “counter, i, ,j etc.” to give them a meaning
3.	Changed the name of methods to better describe their function

## Method length

We went through in order to check that we had separate functions which had a specific task.
We did not have much work to do here since we had already ensured that our functions stuck to doing one thing and one thing only in order to have more clarity and to build our code in a more structured way.

## Redundant commenting
In order to keep following the principles, once we had finished giving meaningful names to our code and saw that our functions were “self-explanatory” we decided to get rid of the comments since there was virtually no more use for them.

## Single responsibility
Our code is comprised of 4 classes. One for testing, one to run it, one storing methods and one for the menu. Each class has a specific function:
1.	Testing: As explained in the readme on the testing branch, our testing class has two tests that are user ran
2.	Main: the main class is used to initialize the variables and call the methods.
3.	Menu: the menu class is the class which comprises mostly the different interactions that the user can have with the software, scanning input and analyzing
4.	Methods class contains all the different methods used to read, sort and print the code 
Our methods also have a similar approach where they aim to change on aspect and one aspect only of the sorting, whether it is for Buffered_reader function or the filling_method they only aim to do a single thing at a time.

## Repeats
Due to the structure of our code, we have no repetition. Having followed the principles stated above, we didn’t find any repeats in our code. 
## Keep it simple
Our program is less than 350 lines of code, divided into 4 different classes. The main method class is shorter than 125 lines which shows our effort to use methods and not go into unnecessary complexity. We did not find anything to simplify when looking through our code.

## YAGNI
After deleting a few functions that were useless, we are now at a point where every function coded is used by our program.
