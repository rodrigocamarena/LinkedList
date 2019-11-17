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

We used the following format for timming the action:

long start = System.currentTimeMillis();

code

long end = System.currentTimeMillis(); System.out.println(end-start);

When adding System.currentTimeMillis() time test to both methods we noticed that the filling method took significantly more time.

When running the program ten times, with a smaller input file of 1000 words. The values for timemillis were the following: (303, 469, 353, 392, 421, 374, 328, 327, 403, 431) This made an average value of 380, with the min being 303 and max being 469. This version of our code is in the testing branch

We figured out that this was due to the fact that with our old version of the code it had to go through the whole LinkedList in order to find the right place. As the LinkedList grew in size, this took a very long time.

It was clear that our filling method was the bottle neck of the program and it had to be changed in order to gain in efficiency. We therefore decided to re write our code in order to improve its performance.

Once we had changed our code, we noticed that there was an improvement in speed. Our new values were: (231, 245, 214, 231, 259, 297, 332, 235, 311, 292) For an average of 265, a 30% reduction compared to the code we previously had.

We further improve the code for longer input files to be more efficient by implementing a Hashmap which goes to the correct letter directly. This version of the code can be found here: [Testing][TestingLink]
[TestingLink] : https://github.com/therodrigocamarena/ExerciseAmaury/tree/Testing_final

**Verification Testing:**
In this testing phase, we created a VerificationTesting class which enables the user to efficiently conduct tests regarding the sorted file using a menu. Option 1: Short test. Request an input word from the user, checks that word is present, then randomly takes a sample of 100 words from the file and verifies that the word is correctly ordered whilst giving an output to the user.

Option 2: Long test. Request an input word from user like in option 1 but instead of checking for 100 random words, it does it for the entirity of the file word by word.

This version of our code is the one shown in the master branch.

**Input Testing:**
We checked for a variety of different inputs: numbers (negative, positive and large), special characters (/ . * @) and letters with accents. Since the Linked list is composed of strings, it did not affect the sorting. Instead, what happened is that the numbers and special characters are placed before the start of the sorted file in numerical and alphabetical order (unicode value for special char)
