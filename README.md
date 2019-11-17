LINKEDLIST DICTIONARY ASSIGNMENT
================================

## Epics

The program has been divided in several stages/epics.
  1. The fist stage consisted on creating the program. This stage is saved in the branch "Rodrigo". Even though, the program succesfully delivers the ordered text file, it takes an eternity to do it. 
  2. In this stage, we ran several test such as Perfomance Test, Verification Test, etc. (For more detail, we encourage you to go to the Test Section). Moreover, thanks to the Perfomance Test ran in this code, we were able to develop a faster version. That is why, the Perfomance Test is done in the first program but the Verfication one in the faster version as a class.
  3. In this stage, we have just refactor every method, class, variable and constructor with the most descriptive name possible.  

## Code description

The following piece of code is made to take a txt file made of words as input and sort the file in alphabetical order. In order to do that and for a better organization, we have divided the program in 4 classes.

  1. **Main Class:** made out of a main function to declare and initialize objects (for example: The Dictionary of type LinkedList, an Letters Alphabet of type HashMap, etc) and call methods declared in other classes.
  
  2. **Method Class:** as its name says, this class contains all the methods related with the process of reading every single line from the provided text file (_sorteddict.txt_), then check the order of the word read, add it to its correspondant position at that moment in the LinkedList and finally when every single line of the text file has been read and added to the correct position the program creates a new text file under the name of _unsorteddict.txt_ and fill it with the words ordered with the use of the LinkedList. (There are two extra text files: _unsorteddict2.txt_ and _unsorteddict3.txt_ which are samples from the _unsorteddict.txt_).
  
  3. **Menu:** Once, the program has created the ordered text file, our program displays a menu with several options (Search a word by its position or viceversa, run a test (which is possible thanks to the VerficationTest class), ask for help or exit the program). So, the Menu class is in charge of the menu and its correspondant options.
  
  4. **Verification Test** in this case, the user is able to call the Test menu through the regular menu. This new menu, offers the user to run 2 types of testing:
    * **Short Test:** The user input a word and then the program verificates the word is ordered correctly comparing it with 100 random words.
    * **Long Test:** Same as the short test but instead of comparing with 100 random words, the programs compares the word with every single word contained.
    
 ## Test 

**Performance Testing:**
We knew that our program could function since it sorted a short text file quite easily. We therefore decided to begin with performance testing. There are two main methods to our Alphabetical class, the filling method and the alphabetical method.

In order to count the time elapsed from the moment the program is run to when the file text is created and filled, we added two counters of type long:

  1. long start = System.currentTimeMillis();

  2. long end = System.currentTimeMillis(); 
  
Start variable, will save the time in milliseconds at the moment of running the program. 
End variable, will save the time in milliseconds right after the text file is filled.

Finally, we will print the time elapsed. In order to do that, we extract to the end variable the start variable and print it.
  
  * System.out.println(end-start);

When adding System.currentTimeMillis() time test to both methods we noticed that the filling method took significantly more time. When running the program ten times, with a smaller input file of 1000 words. The values for timemillis were the following: (303, 469, 353, 392, 421, 374, 328, 327, 403, 431) This made an average value of 380, with the min being 303 and max being 469. This version of our code is in the testing branch

We figured out that this was due to the fact that with our old version of the code it had to go through the whole LinkedList in order to find the right place. As the LinkedList grew in size, this took a very long time. It was clear that our filling method was the bottle neck of the program and it had to be changed in order to gain in efficiency. We therefore decided to re write our code in order to improve its performance. Once we had changed our code, we noticed that there was an improvement in speed. Our new values were: (231, 245, 214, 231, 259, 297, 332, 235, 311, 292) For an average of 265, a 30% reduction compared to the code we previously had.

All this testing was done in our preliminary code, stored at the branch [Testing_final][TestingLink]

**Verification Testing:**

In this testing phase, we created a VerificationTesting class which enables the user to efficiently conduct tests regarding the sorted file using a menu. Option 1: Short test. Request an input word from the user, checks that word is present, then randomly takes a sample of 100 words from the file and verifies that the word is correctly ordered whilst giving an output to the user.

Option 2: Long test. Request an input word from user like in option 1 but instead of checking for 100 random words, it does it for the entirity of the file word by word.

This version of our code is the one shown in the master branch [master][master].

**Input Testing:**
We checked for a variety of different inputs: numbers (negative, positive and large), special characters (/ . * @) and letters with accents. Since the Linked list is composed of strings, it did not affect the sorting. Instead, what happened is that the numbers and special characters are placed before the start of the sorted file in numerical and alphabetical order (unicode value for special char)

## Refactoring

**ALL THESE CHANGES CAN BE APPRECIATED AT THE [REFACTORING][REFACTOR] BRANCH.**

### Coding principles 

#### Meaningfull names :

We updated the choice of words in the code in various ways:
1.	Changed the name of every variable to English
2.	Changed the name of variables that were called “counter, i, ,j etc.” to give them a meaning
3.	Changed the name of methods to better describe their function

#### Method length

We went through in order to check that we had separate functions which had a specific task.
We did not have much work to do here since we had already ensured that our functions stuck to doing one thing and one thing only in order to have more clarity and to build our code in a more structured way.

#### Redundant commenting
In order to keep following the principles, once we had finished giving meaningful names to our code and saw that our functions were “self-explanatory” we decided to get rid of the comments since there was virtually no more use for them.

#### Single responsibility
Our code is comprised of 4 classes. One for testing, one to run it, one storing methods and one for the menu. Each class has a specific function:
1.	Testing: As explained in the readme on the testing branch, our testing class has two tests that are user ran
2.	Main: the main class is used to initialize the variables and call the methods.
3.	Menu: the menu class is the class which comprises mostly the different interactions that the user can have with the software, scanning input and analyzing
4.	Methods class contains all the different methods used to read, sort and print the code 
Our methods also have a similar approach where they aim to change on aspect and one aspect only of the sorting, whether it is for Buffered_reader function or the filling_method they only aim to do a single thing at a time.

#### Repeats
Due to the structure of our code, we have no repetition. Having followed the principles stated above, we didn’t find any repeats in our code. 
#### Keep it simple
Our program is less than 350 lines of code, divided into 4 different classes. The main method class is shorter than 125 lines which shows our effort to use methods and not go into unnecessary complexity. We did not find anything to simplify when looking through our code.

#### YAGNI
After deleting a few functions that were useless, we are now at a point where every function coded is used by our program.




[TestingLink]: https://github.com/therodrigocamarena/ExerciseAmaury/tree/Testing_final
[master]: https://github.com/therodrigocamarena/LinkedList
[REFACTOR]: https://github.com/therodrigocamarena/LinkedList/tree/Refactor
