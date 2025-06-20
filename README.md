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
* **Replay Options:** After losing, choose to go back to the home screen or play again.

---

## Gameplay

![InitialGIF](https://github.com/user-attachments/assets/ca78f1b5-3fbe-452d-8fcf-a40313c1474c)

![WrongGIF](https://github.com/user-attachments/assets/a34097cc-7860-4873-86c6-d8c18d0c5227)

---

## How to Play

1. Open the app and select your grid size (4x4 or 6x6).
2. Tap **Play** to start.
3. The game will briefly reveal all matching fruit pairs.
4. Flip two cards at a time to find matching pairs.
5. If the cards don't match, you receive one strike (X).
6. Accumulate 5 strikes and the game ends.
7. Choose to return home or try again.

---

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/fruit-match-game.git
   ```
2. Open the project in Android Studio.
3. Build and run the app on your emulator or device.

---

## Technologies Used

* Kotlin
* Android Studio

---

## Project Structure

* `MainActivity.kt` – Home screen with grid size selection.
* `GameActivity.kt` – Game screen handling gameplay and logic.
* Layout XML files for each activity.
* Drawable resources for fruit images and UI elements.
