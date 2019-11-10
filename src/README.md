Testing Homework README.md

Performance Testing:
We knew that our program could function since it sorted a short text file quite easily. We therefore decided to begin with performance testing. There are two main methods to our Alphabetical class, the filling method and the alphabetical method.

We used the following format for timming the action:

long start = System.currentTimeMillis();

code 

long end = System.currentTimeMillis();
System.out.println(end-start);


When adding System.currentTimeMillis() time test to both methods we noticed that the filling method took significantly more time.

When running the program ten times, with a smaller input file of 1000 words. The values for timemillis were the following:
(303, 469, 353, 392, 421, 374, 328, 327, 403, 431)
This made an average value of 380, with the min being 303 and max being 469. 
This version of our code is in the testing branch 
https://github.com/therodrigocamarena/ExerciseAmaury/tree/Testing

We figured out that this was due to the fact that with our old version of the code it had to go through the whole LinkedList in order to find the right place. As the 
LinkedList grew in size, this took a very long time. 
 
It was clear that our filling method was the bottle neck of the program and it had to be changed in order to gain in efficiency.
We therefore decided to re write our code in order to improve its performance.

Once we had changed our code, we noticed that there was an improvement in speed.
Our new values were:
(231, 245, 214, 231, 259, 297, 332, 235, 311, 292)
For an average of 265, a 30% reduction compared to the code we previously had. 

We further improve the code for longer input files to be more efficient by implementing a Hashmap which goes to the correct letter directly.
This version of the code can be found here:
https://github.com/therodrigocamarena/ExerciseAmaury/tree/Testing_final




Verification Testing:

In this testing phase, we created a VerificationTesting class which enables the user to efficiently conduct tests regarding the sorted file using a menu. 
Option 1: Short test. Request an input word from the user, checks that word is present, then randomly takes a sample of 100 words from the file and verifies that the word is correctly ordered whilst giving an output to the user.

Option 2: Long test. Request an input word from user like in option 1 but instead of checking for 100 random words, it does it for the entirity of the file word by word.







Input Testing:

We checked for a variety of different inputs: numbers (negative, positive and large), special characters (/ . * @) and letters with accents. 
Since the Linked list is composed of strings, it did not affect the sorting. Instead, what happened is that the numbers and special characters are placed before the start of the sorted file in numerical and alphabetical order (unicode value for special char)


