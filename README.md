# Snake2DGame
The Snake game is a classic video game where the player controls a snake that moves around a grid, eating food and growing in length. Here's a summary of how you can implement the Snake game using Java's JFrame and Swing libraries, following the principles of object-oriented programming (OOP):

The Snake class represents the snake entity in the game. It maintains the snake's current position, direction, and length. It provides methods to move the snake, check for collisions, and update its position.

The Food class represents the food entity in the game. It maintains the current position of the food. It provides methods to generate a new position for the food.

The GamePanel class extends the JPanel class and represents the main game panel. It handles the game logic, such as updating the snake's position, checking for collisions, and handling user input. It contains an instance of the Snake class and an instance of the Food class.

The GameFrame class extends the JFrame class and represents the main game window. It contains an instance of the GamePanel class and sets up the game window with the necessary settings. Implement the game loop:

The game loop continuously updates the game state and renders it on the screen. It handles user input and updates the snake's position based on the input. It checks for collisions between the snake and the food or the boundaries of the game panel. It updates the score and the game state accordingly.

Implement key listeners to handle user input for changing the snake's direction. Update the snake's direction based on the user's input.

Use the Graphics class to draw the snake, food, and the game panel on the JFrame.

By following these steps, you can create a Snake game using Java's JFrame and Swing libraries while adhering to the principles of OOP.

Image Of Food Head and Body.

https://drive.google.com/drive/folders/1Trh8cnIy_tpDuRsKwlz3zEcqPEwd2GPQ?usp=share_link104f5)

![Screenshot 2023-06-23 103107](https://github.com/YashSahaa/Snake2DGame/assets/136882182/56ac5165-4160-45f0-ba39-b3472a7dee13)

![Screenshot 2023-06-23 103045](https://github.com/YashSahaa/Snake2DGame/assets/136882182/dd0b582a-39ae-4ccc-ba89-f100b7bf0999)

![Screenshot 2023-06-23 103020](https://github.com/YashSahaa/Snake2DGame/assets/136882182/64f72eca-ed2a-4671-b8c4-a9846eda1e5d)


