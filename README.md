Tamagotchi

Overview:
A tamagotchi is a virtual pet that the user has to take care
of.  The tamagotchi has to eat and drink to stay alive, and
can also die of boredom if ignored for too long.
The user has a starting budget with which to buy food,
snacks, and drinks for the tamagotchi, and gets a certain
amount of money each day.

Implementation:
Write  a Player class  and  a Tamagotchi class  to  model
the user and the pet tamagotchi.  Write a TamagotchiApp
class to act as the main executable.
The tamagotchi has three levels you have to keep track
of – hunger,  thirst,  and boredom.  Say these range from
0 to 100.  Then if any of them reach 100, the tamagotchi will die.
We can model time as a series of days.  For each “day”, the app should report the current status
of the tamagotchi and ask the user what they want to do.  The user can buy food and drinks or play
with the tamagotchi. Food could include things like the following:

bread – decreases hunger
jalape ̃no chips – decrease hunger but increase thirst
and drinks:
water – decreases thirst
lemonade – decreases thirst and boredom
coffee – decreases thirst and hunger
beer – decreases thirst but increases hunger

Additional Features:
-sickness – a tamagotchi can randomly get sick,  or get sick if it’s had too much of the same
food, or too much booze.  The user can buy medicine to try to heal the tamagotchi.
-minigames – let the user play a minigame with the tamagotchi (e.g., guessing a random number
from 1 to 10) to increase its happiness
