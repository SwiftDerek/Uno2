Seal Team 6: Uno Card Game


Derek Williams
Justin Hummel
Ishmael Bryant


Project Plan




1. Scope Statement


What type of platform (Windows, Macintosh, UNIX, etc.) must the software work with? What programming language will be used?
	The programming language we will use is Java which does not require a specific platform to work with because of the JVM (Java Virtual Machine). The JVM is designed to run Java programs regardless of OS because it provides a virtual machine at compile time. As long as the user has a Java runtime environment downloaded then he or she will be able to run our program. Any setup files will be included as part of the installation process for our program.


Will the software function as a standalone application on a given computer, or will it function over a network connection?
	Our game will require no network connection and be a standalone application as an executable. It will not work on any mobile devices excluding laptops.


What other software, if any, must the software interact with?
	The software will not require any other software to interact with. The game will exist as a standalone executable once the user executes it.


If you are building a game, how many players will be supported? Will there be a computer player? If so, will it use artificial intelligence?
	For our game, we will have two to four players supported. The initial configuration of the program will allow the user to choose how many players they want to play with before they start the game. If time permits, we will then add computer player functionality that uses artificial intelligence. 








Will the software use a graphical interface or a command line interface?
	The software will use a GUI all controlled by the user. The game will have elements modeled from the real UNO game displayed to the user including cards and a board display along with a menu.


If the project is similar in nature to commonly used projects in the past, what tricks can be used to make it unique?
	The game could have extra cards included to make the game more interesting like a card to have two players exchange hands, a card that has the player remove their current cards and draw an equal amount, or other cards that affect the state of the game and its players. 














































2. Org Chart





Organizational chart to show that all phases of development are being shared among the group.
























3. Gantt Chart


https://docs.google.com/spreadsheets/d/10kBuCDDn6SUKlcnA0cbm4ikT84xQ4xaO53e97WhKG60/edit?usp=sharing


Please click the link above to view the Gantt Chart for the project.






















































4. Tools and Standards


Programming Language: Java 8


IDE: Netbeans/Eclipse


Documentation/Design Tools: Google Docs and Microsoft Visio


GUI Framework: Java Swing


Process Model: Incremental/Waterfall/Agile


Coding Style: Google Java Style Guide: https://google.github.io/styleguide/javaguide.html 


Our model will use a combination of incremental and waterfall. The design and documentation will follow the waterfall model and once the pre-documentation and design is complete we will switch to an incremental model and agile process for coding, testing, and documentation. We will aim to have a functional version of the game completed first and add additional functionality incrementally.
























5. Configuration Management Plan


	Our software versioning system will be utilized with Git/GitHub where development and release versions will be shared by members of the project. With each increment we will mark down what development version has been completed and place into the shared git system for the project. The numbering system will be major.minor.build for each version of the project. Development and release versions will be using only the major number with 1 for the former and 2 for the latter. The minor number represents the stage of development currently being versioned (i.e. GUI card, scoreboard logic, etc…) and build represents the version of the minor build being worked on. Our versioning will be incrementally developed but if changes need to be conducted in prior versions they can be following an agile approach.


Development Versions
	1.0 - GUI Background
	1.1 - GUI Cards
	1.2 - GUI Buttons
	1.3 - GUI Text
	1.4 - GUI Menu
	1.5 - GUI Controller
	1.6 - Player Control Logic
	1.7 - Card Logic
	1.8 - Deck Logic
	1.9 - Score Logic
	1.10 - Additional Functionality
	1.11 - Test Cases
	1.12 - Requirements Cases


     2. Release Version
	2.0 - Deploy Executable
Programmer’s Manual


Requirements Documentation
Introduction

Scope - Please refer to the Scope Statement above.

Definitions:

Discard Pile: Displays the last card that was discarded which is in the middle of the board.

Draw Pile: A button that can be clicked to draw a card from the deck of Uno cards.

Game Board: The graphical user interface where the buttons, cards, and player actions will be shown to the players.

GUI: The entire program displayed graphically. 

User: This will refer to the person(s) who executed the program. 



Since the game is not going to be sold commercially or for public use, the creation of the game is protected under standard copyright law. 

For official rules of the game attached is a PDF of the rule page on every UNO game: http://service.mattel.com/instruction_sheets/UNO%20Basic%20IS.pdf



General Description

Product Perspective - The software is being built as part of a Software Engineering class to demonstrate proper documentation and the development process of a full software program. The program will be modeled after the popular UNO card game and is being built to serve as a graphical representation of the game. The program will be useful to those who don’t have physical access to the UNO card game or wish to to learn how to play UNO.

Product Function - The UNO card game is designed for two to four players where the objective of the game is to hold one card and shout “UNO!” to signal that the player has one card left in his or her hand. Winning the game requires that one player is only holding no cards through a series of actions where the player discards cards based on the draw pile’s card. The card drawn through the draw pile is placed in the discard pile and if a number or color matches any card in a player’s hand, then he or she may place that card on the draw pile on their turn. There are also special cards that the players may place in the discard pile to impact other players.

User characteristics - Users will be anyone with access to a computer and the Java runtime environment. There is no age requirement. Knowing the rules of the game prior to playing will help.

General constraints - The user who executes the program will need the Java runtime environment installed and a working computer. There will also need to be another player (up to four total players) in order to play properly. The GUI will also use English as the language choice but players shouldn’t need to know English in order to play.

Assumptions and dependencies - The only assumption is that the user has the Java runtime environment. If not, we have included a link to the latest version of the JVM for users to download prior to execution. Also, if the user does not know the rules of the game we have included a link to the official rules of the game created by Mattel however, we do not have a scoring system like the official rules state for their game. The first player in the game to hold one card and declare “UNO!” wins the game. 



Specific Requirements

GUI(Graphical User Interface)

	1.0.0 - The program provides a GUI for the user to play the game.

		1.1.0 - A clear background for the board.

		1.2.0 - A menu interface for the user at the top of the GUI.
			1.2.1 - A button to initialize/restart the game and GUI.
			1.2.2 - A help button to display rules of the game.
			1.2.3 - A popup window to ask user for number of players at
				beginning of game initialization.

		1.3.0 - Buttons to control flow of game
			1.3.1 - An “UNO!” button for player to win game.
			1.3.2 - Button to draw card from draw pile.
			1.3.3 - Button to discard card into discard pile.
			1.3.4 - Button to catch player who does not call UNO.

		
		1.4.0 - The UNO cards displayed on the board
			1.4.1 - Each card has an oval with the type of card displayed					within the card.
			1.4.2 - The numbered cards are 1-9 and have a color of red,					green, yellow, or blue.
			1.4.3 - The special cards are designed appropriately.

		1.5.0 - Various text boxes to provide information to players.
			1.5.1 - Text to describe areas of the board. (Piles, buttons…)
			1.5.2 - Text to show the current player on the board.
			1.5.3 - Text to show total cards in player hands. 

Playing Cards

	2.0.0 - The game has a total of 108 cards.

		2.1.0 - There are 76 number cards (0-9)
			2.1.1 - 19 red, blue, yellow, and green cards

		2.2.0 - There are 32 word cards
			2.2.1 - 8 Draw 2 Cards (2 of each color)
			2.2.2 - 8 Reverse Cards (2 of each color)
			2.2.3 - 8 Skip Cards (2 of each color)
			2.2.4 - 4 Wild cards
			2.2.5 - 4 Wild Draw 4 cards

		2.3.0 - The cards in the deck/draw pile are shuffled at the start of
			the game.

Game Logic

	3.0.0 - The game progresses until a player is left with no cards.
		
		3.1.0 - Special word cards that change state of game
			3.1.1 - Draw 2 Cards: The next player must draw 2 cards					from the deck.
			3.1.2 - Reverse Card: The direction of play is reversed. If 
				only two players then the original player goes again.
			3.1.3 - Skip Card: The next player is skipped for one turn.
			3.1.4 - Wild Card: Player chooses a color for the discard pile.
			3.1.5 - Wild Draw 4 Card: Same as Wild but next player
				draws 4 cards.

		3.2.0 - Players each take turns to win the game.
			3.2.1 - Each player draws 7 cards from the draw pile in the
				beginning of the game.
			3.2.2 - The top card is flipped to start the discard pile.
			3.2.3 - If it’s a player’s turn, he or she may discard card that
				matches number or color ( or wild) to the discard pile.
			3.2.4 - If no card is playable then the player’s turn is over.
			3.2.5 - The current player draws a card if no card is played
				their turn.
			3.2.6 - If the drawn card is playable, he or she may play it.

		3.3.0 - Once a player reaches one card left in their hand, he or she
			must press the “UNO!” button. 
		3.3.1 - Once a player has no cards, he or she wins game..
		
		


	



































Design Documentation


Object Diagram




















Pseudocode


// Pseudocode for GUI Window initialization
// (Requirement 1.0.0)
//
// User has executed the UNO program and the GUI window appears


class Uno


	main {
		Call View Instance
		Call Model Instance
		Pass View and Model to Controller
		Make View Visible
}
---------------------------------------------------------------------
// Pseudocode for GUI Menu and general buttons
// (Requirement 1.2.0)
//
// User has executed the UNO program and the GUI menu appears


class UnoMenu


	Declare “Start game” button
	Declare “Restart game” button
	Declare “Help” button
	
	Function ButtonListener {
		Add listeners for buttons
}
---------------------------------------------------------------------
// Pseudocode for Buttons in Controller
// (Requirement 1.3.0)
//
// If a user clicks button, data is sent from controller to model


Class UnoListener


	Function actionPerformed {
		Model/View: Update Player Count (UnoPlayer.addPlayer())
		Model/View: Draw Card (UnoPlayer.draw())
		Model/View: Discard Card (UnoPlayer.discard(UnoCard Card))
Model/View: UNO Win Button (UnoPlayer.win())
Model/View: Start game Button (UnoBoard.start())
Model/View: Restart game Button (UnoBoard.reset())
Model/View: Help game Button (UnoBoard.help())	
}
---------------------------------------------------------------------
// Pseudocode for Initializing Deck at Start of Game
// (Requirement 2.0.0)
//
// The deck of 108 cards is picked and shuffled.


Class Deck
	
	Declare Cards ArrayList
	Declare DiscardPile ArrayList
	
	Public Deck(){
		Get 76 Number Cards (0-9)
		Get 8 Draw 2 Cards
Get 8 Reverse Cards
Get 8 Skip Cards
Get 4 Wild Cards
Get 4 Wild Draw 4 Cards
Shuffle Cards
}


	Function to shuffle {
		For each card in Deck:
			Store card in temporary variable
			Store random card in spot
			Store orginal card randomly in Deck
}
---------------------------------------------------------------------
// Pseudocode for General Game Play
// (Requirement 3.0.0)
//
// The game progresses until a player declares UNO


Class UnoModel 


	Public UnoModel{
		Declare Deck object
		Store number of Players from View
		Call playGame
}






Function playGame{
		Add 7 Cards to Players hands
		Grab top card for discard pile
		
		While current player does not declare UNO{
			If player can discard card
				Discard card
				Call cardAction
			Else
				Draw Card
			
			If Drawn Card can be played AND Player Says Yes
				Discard Card
				Call cardAction


			If Player can declare Uno
				Declare UNO
			
			Rotate to next Player
		}
}




Function cardAction(Card currentCard){
	If Card is Number && Card Can Be Played
		Place currentCard on Discard Pile
	Else If Card is Skip 
		Place currentCard on Discard Pile
		Call skipCard
	Else If Card is Reverse
		Place currentCard on Discard Pile
		Call reverseCard
	Else If Card is Draw 2
		Place currentCard on Discard Pile
		Player draws 2
	Else if Card is Wild
		Place currentCard on Discard Pile
		Call cardColor
	Else
		Place currentCard on Discard Pile
		Call cardColor
		Player draws 4
}


	
	
	

















































Testing Documentation


Test Case#
Requirement
Rationale
Input(s)
Expected Output
Passed?
1
1.0.0
GUI is provided for user
Program start
GUI Window
Yes
2
1.1.0
Empty board for game start
Program start
Empty board
Yes
3
1.2.0
Menu interface at top of GUI
Start and Help buttons
See below cases
Yes
4
1.2.1
A Start/Restart button to initialize game
Start button
Popup for players/Board restarted
Yes
5
1.2.2
Help button to show rules
Help button
Popup to show rules of UNO
Yes
6
1.2.3
A message asking for number of players in game
Start button
Popup for player count
Yes
7
1.3.0
Buttons to control flow
GUI buttons
See below cases
Yes
8
1.3.1
UNO Button to declare UNO
UNO button
If player has one card, UNO is declared.
Yes
9
1.3.2
Draw card button
Draw button
Player draws one card each turn.
Yes
10
1.3.3
Discard card button to allow player to take turn.
Any card on board that matches discard pile card.
Card is placed on discard pile.
Yes
11
1.3.4
Catch button for player to catch another who didn’t call UNO
Catch button
Popup displaying if catch is found.
Yes
12
1.4.0
Uno Cards with correct display pictures
Cards in deck
Each card has oval, color, and appropriate number
Yes
13
1.5.0
Text to describe areas of board
Current player and hand updated each turn
Player hand and current player textboxes updated
Yes
14
2.0.0
Total of 108 cards in deck
Initialize model
108 cards counted
Yes
15
2.1.0
Total of 76 number cards in deck
Check addCards method
76 number cards counted with 19 colors
Yes
16
2.2.0
32 special cards
Check addCards method
32 special cards counted
Yes
17
2.3.0
All 108 cards are shuffled for each game to prevent bias
Check shuffle method
All cards are shuffled randomly
Yes
18
3.0.0
The game progresses until a player is left with no card.
If player has no cards, he or she wins.
Popup showing player won and game board cleared.
Yes
19
3.1.1
When Draw 2 played, next player draws 2 and skips their turn.
Draw 2 played 
Next player draws 2 and skips their turn.
Yes
20
3.1.2
When Reverse played, the direction of the game flow is reversed to the previous players.
Reverse played
The direction of the player turns is reversed. 
Yes
21
3.1.3
When Skip played, next player is skipped for his or her turn.
Skip played
The next player is skipped.
Yes
22
3.1.4
When Wild played, the color on the discard pile is changed.
Wild played
Popup displaying which color to pick.
Yes
23
3.1.5
When Wild Draw 4 played, color on discard pile changes and next player draws 4 and is skipped.
Wild Draw 4 played
Popup displaying which color to pick and next player is skipped/draws 4
Yes
24
3.2.0
Each player takes one turn
Players end turn with End Turn button
Next player is given turn
Yes
25
3.2.1
Each player has 7 cards at beginning of game
Game initialization
Player count is 7 for cards
Yes
26
3.2.2
After deck is shuffled, top card is put on discard pile to start game.
Game initialization
Discard Pile has top card from deck
Yes
27
3.2.3
When card is played, it matches card on discard pile (unless wild)
Pick cards that match discard pile
Card is placed on discard pile
Yes
28
3.2.4
If no card is playable, he or she has to end turn.
Pick end turn button
Next player is given turn
Yes
29
3.2.5
Current player has to draw a card if no card is playable
Display draw card button before end turn button
End turn button is displayed and player obtains random card
Yes
30
3.2.6
Drawn card can be played by player if he or she chooses
Draw a card and player can play it
Player ends turn or plays card and ends turn
Yes
31
3.3.0
If player has one card left in hand, he or she may press UNO button to declare UNO.
UNO button pressed
Pop up showing player has or does not have UNO
Yes
32
3.3.1
If player has no cards left, he or she wins game
Play last card in player’s hand
Pop up showing player has won and game board cleared
Yes


Known Bugs and Issues:


Sometimes, when a card is picked to put on the discard pile, the GUI won’t register the click until a second click is pressed. This may be a problem with mouse hardware/software or an issue with the Swing framework.








User Documentation


User Manual:


1. After executing the program, two buttons show up: “Start” and “Help”.
It’s important to understand the rules of Uno so click “Help” before playing or visit http://www.unorules.com/ to learn more.


2. Click “Start” to play the game. A popup will show asking for a selection of two to four players. Once the players are set the 1st player will have his or her turn. 


3. Each player takes a turn where by he or she can play a card that matches the number or color of the card in the draw pile (middle of board). The player may also play a special card that can change the flow of the game. If only two players, some special cards will just change flow back to the player who played the special card.


4. If a player has only one card, he or she can press the UNO button to declare UNO. If he or she does not and the other player catches the player then he or she draws a card. 


5. Once a player reaches no cards he or she wins!


















Installation Instructions


	Please ensure that the latest version of Windows is installed although the program should work on earlier versions of Windows. Also if you do not have Java installed, please use this link to install: https://java.com/en/ 


	If program does not install correctly please consult the FAQ for Java and Windows on the Oracle website. If the program is in a zip file please extract the contents in the zip folder and then run the program.
