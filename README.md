# ❌⭕ Fragment-Based Tic-Tac-Toe

An Android **Kotlin** implementation of the classic Tic-Tac-Toe game, split into a **TopFragment** for status and scores and a **BottomFragment** for the 3 × 3 grid. Play head-to-head on one device, keep a running score, and reset the board at any time.

---

## 📖 Gameplay at a Glance

* **Two players** (Player 1 = **X**, Player 2 = **O**).  
* Tap an empty square to place your symbol.  
* First to align **three in a row** (horizontally, vertically, or diagonally) wins the round.  
* Scores persist until the **Reset** button is pressed.  
* A draw is declared if the board fills with no winner.  

Status messages (“Player 1’s Turn”, “Player 2 Wins”, “Draw”) appear in the top fragment.

---

## 🏗️ Project Structure

app/
└─ src/main/
├─ java/com/example/tictactoe/
│ ├─ MainActivity.kt ← hosts both fragments
│ ├─ topFragment.kt ← header: scores + status + reset
│ └─ bottomFragment.kt ← 3×3 grid & game logic
├─ res/
│ ├─ layout/
│ │ ├─ activity_main.xml ← <FragmentContainerView> ×2
│ │ ├─ fragment_top.xml
│ │ └─ fragment_bottom.xml
│ └─ values/ (strings, themes …)
└─ AndroidManifest.xml

markdown
Copy

### Key Classes & Layout

File | Role
--- | ---
`bottomFragment.kt` | Manages grid buttons, turn switching, win/draw detection, and board reset.
`topFragment.kt` | Displays running scores and current status; handles global reset request.
`MainActivity.kt` | Hosts fragments and exposes a `resetGame()` helper.

---

## 🖥️ Getting Started

1. **Clone or copy** into a new Android Studio project.  
2. Open with **Android Studio Giraffe** (or newer) and **Kotlin 1.9+**.  
3. Ensure **ViewBinding** is on in *build.gradle*:

   ```gradle
   android {
       buildFeatures {
           viewBinding true
       }
   }
Run on an emulator or device (API 21+). There are no external assets required.

🔧 Customization Ideas
Idea: Where to Change
Board size (e.g., 4 × 4)	Update fragment_bottom.xml & winning-pattern list in bottomFragment.
Alternate symbols/emojis: Change currentSymbol, flip, and button text.
Sound or haptic feedback,	add to each button’s setOnClickListener.
Victory animations	trigger in Statues () after a win.

<img width="1344" height="2992" alt="image" src="https://github.com/user-attachments/assets/19d05f06-22b8-485f-b49d-d17b54afdffe" />

Roadmap
Highlight winning line with color/animation

Two-player LAN / online mode (WebSockets)

AI opponent (Minimax) for single-player

Theme switch (light / dark/dynamic color)

Instrumented UI tests with Espresso

License
© 2025 Mohamad Syaj. All Rights Reserved.
This code is provided for personal or educational use only. You may not sell, distribute, publish, or incorporate any portion of it into commercial products without the author's explicit written permission.

Author
Mohamad Syaj – feel free to open issues or PRs!

Enjoy the game, and may your triples never be blocked!
