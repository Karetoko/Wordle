# Wordle
A small application which runs the game "Wordle". Written just for fun :)

### What is "Wordle"?

  Wordle is a guessing game with the goal of guessing the (randomly chosen) word by a certain amount of attempts (usually six).
  After each guess, the characters of the answer word is highlighted. Furthermore, characters on the right position are additionally highlited (in a different colour). 
  
### How is this program written? 
This program contains four classes:
   + The class 'WordList' selects a random word and examines whether a certain word is contained in a list. The list is saved as an .txt file, it can be expanded (**IMPORTANT**: change final variables in 'WordList')!
   + The class 'WordleDrawNew' is a basic assosiative structure which contains the node class 'WordleDrawNewNode'. It checks, among others, for perfect matches. 'WordleDrawNew' converts a word into characters which are saved in the node class 'WordleDrawNewNode' (with additional information).
   + The node class 'WordleDrawNewNode' contains the essential information (character, position, etc.). I wrote this as a node class mainly because I wanted to practise writing assosiative data structures. 
   + The class 'main' runs the actual application with the graphical output (done with CodeDraw). I want to apologize in advace for the terrible naming :/ 
    
### Any specific things regarding the gameplay?

  One thing to note is that, unlike the actual "Wordle" game, the user can choose the word length here (from 4 to 10; normally limited to only 5).
  Furthermore, there are some minor differences regarding the highlighting (blue insted of yellow, for better readability). 
  The game interaction is also different from the original. Unlike the original game, it doesn't accurately display the amount of characters when a character is contained in a word more than once.
  For example, if the given word is 'autumn' and the user enters 'summer', *both* m's in the word 'summer' will be highlighted (only one character should be highlighted according to the original rules). 
  I chose to ignore these issues because this would require some restructuring and is not *that* impactful on the gameplay in my opinion (*sorry!*). Lastly, the list of words is not the best one out there; it doesn't contain many widely used words such as 'crane' ,'beard' or 'flair', to name a few. 
  
  
For any further questions, feel free to contact me.
Happy playing! :)


Karetoko
  
