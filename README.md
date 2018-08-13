Hero vs Monster

Overview
Implement a battle between a hero and a monster.  The
user plays the hero and the monster is controlled by the
computer.
The battle proceeds in rounds, with the hero and mon-
ster  taking  turns.   In  each  turn,  the  hero  can  choose  to
attack,  defend,  run  away,  or  use  an  item.   The  monster
can attack, defend, or run away.
Both the hero and monster have a certain amount of
health and do a certain (though slightly random) amount
of damage when they attack.  They also have some level
of dexterity, which improves their chance of hitting when
attacking or dodging when being attacked.
The hero also has an inventory of items.  This includes weapons and armor, which the user can
choose to equip on their turn.  These may change the amount of damage dealt/absorbed and have
other properties.  The hero may also have items that restore some amount of health.
In each battle, the monster and its attributes should be randomly generated.

Implementation
Write a Hero and Monster class (or use a single class if your implementation doesn’t require two). 
Write a Heromon class to act as the main executable.  Continue to alternate between hero and 
monster until one of them dies or runs away.

Additional Features
-Monster  AI  –  how  should  the  monster  decide  what  to  do?   (e.g.,  always  attack,  alternate
attacking and defending, run away if health low, etc.)
-Weaknesses  –  some  monsters  may  have  a  weakness  to  a  particular  weapon  (e.g.,  pointed
weapons) or a property of that weapon (e.g., fire)
-Multiple monsters – in some battles, there may be more than one monster attacking the hero
-Multiple battles – let the user fight multiple battles.  In between battles, they can return to
town to heal their wounds and upgrade their equipment (with sufficient finances).
