# Fruit Match Game

An Android memory matching game built with Kotlin. Challenge your memory by matching pairs of fruits on either a 4x4 or 6x6 grid!

---

## Features

* **Grid Selection:** Choose between a 4x4 or 6x6 grid on the home screen.
* **Memory Challenge:** View all matching fruit pairs briefly before the cards are hidden.
* **Game Mechanics:**

  * Flip cards to find matching fruit pairs.
  * Every incorrect match adds one “X” (a strike).
  * Reach 5 strikes and you lose the game.
* **Timer:** Track how long you take to complete each game.
* **High Scores:** The fastest completion time for each difficulty is saved locally and displayed on the high score screen.
* **Replay Options:** After losing, choose to go back to the home screen or play again.

---

## Gameplay

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/d1120ea6-ccfa-493f-9cf8-e2e963f5810b" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/9130cad0-d367-4991-9e64-c84c214ca9fc" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/ebb2b3ac-6cb1-47bc-83b9-395ccdaf71eb" width="300"/></td>
  </tr>
</table>

---

## How to Play

1. Open the app and select your grid size (4x4 or 6x6).
2. Tap **Play** to start.
3. The game will briefly reveal all matching fruit pairs.
4. Flip two cards at a time to find matching pairs.
5. If the cards don't match, you receive one strike (X).
6. Accumulate 5 strikes and the game ends.
7. Complete the game in the shortest time possible to set a new high score!
8. Choose to return home or try again.

---

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/marklourenco/memorygame.git
   ```
2. Open the project in Android Studio.
3. Build and run the app on your emulator or device.

---

## Technologies Used

* Kotlin 2.0.21
* Android Studio

---

## Project Structure

* `AppData.kt` – Card class, card states, updates tiles and keeps track of difficulty.
* `MainActivity.kt` – The main menu screen. Lets the player choose between 4x4 and 6x6 difficulty using a switch, start a new game, and view the saved high score for the selected difficulty.
* `GameActivity.kt` – Handles the main gameplay screen: card flipping logic, timer, tracking strikes, and saving high scores. Also manages win/loss conditions.
* Layout XML files for each activity.
* Drawable resources for fruit images and UI elements.
* Local JSON file storage for high score tracking.
