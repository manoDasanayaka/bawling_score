# bawling_score
Application uses a simple Object oreintation approach to solve the problem.
Refer to below diagram. 
BawlingTry is the actual representation of a User try in the Game. It contains the number of pins knocked by that try.
BawlingFrame is the next level of the application, where it denotes a frame of multiple tries (In the solution we take it as a list of two).
BawlingGame is the top level. It has a list of BawlingFrames.

This uses a Constant to define application constants as well, so that the change of any such configuration is also provisioned.
Also a common Util class to handle all the utility methods.

## How to use
Main class contains a sample of usage.

You got to feed the individual Frame as below,

  `BawlingFrame frame1 = generateBallingFrame(4,5);`
  
  `BawlingFrame frame2 = generateBallingFrame(4,6);`
  
  `BawlingFrame frame3 = generateBallingFrame(4,2);`

  It accepts the couple of tries in sequence. Also, if you want to feed in a strike hit:
  
 `BawlingFrame strikeFrame = generateBallingFrame(10);`
 
 To get the results:
  
  `BawlingGame game = new BawlingGame();`
  
  `game.setGameFrames(gameFrames);`
  
  `int score = game.getScore();`  
  
  `System.out.println("Score is ===>"+ score);`
  
  
![Bawling](https://user-images.githubusercontent.com/24270502/187472774-7571e6e6-5903-4cc9-8a1c-8c132c153571.png)
