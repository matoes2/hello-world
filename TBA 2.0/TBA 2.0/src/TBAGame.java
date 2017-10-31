/**
 * Created by arodriguez on 10/6/2016.
 */
import java.util.*;
import java.text.DecimalFormat;
import java.util.Random;
public class TBAGame {
    //region Variable Declaration/Initialization
    static String[] huntees = new String[]{"Luanna Pillot", "Odell Tank", "Jenni Nealy", "Jenine Earheart", "Dollie Kavanagh", "Warren Burrus", "Bart Sampson", "Janise Pomerantz", "Cristi Carlin", "Dionna Oum"};
    static int[] hunteeArmor = new int[]{40, 10, 25, 20, 70, 15, 100, 58, 78, 30};
    static int[] hunteeAttack = new int[]{5, 10, 14, 12, 20, 22, 60, 14, 16, 17};
    static String[] dnames = new String[]{"David Baker", "David Baker"};
    static int hunteeHealth = 50;
    static int characterArmor;
    static int characterWeapon;
    static int xp = 0;
    static int xpToLvlUp = 20;
    static int level = 1;
    static Scanner keyboard = new Scanner(System.in).useDelimiter("\\n");
    static int baseWeaponCost = 50;
    static int baseArmorCost = 50;
    static int armorLvL = 1;
    static int weaponLvL = 1;
    static int baseAttack = 10;
    static int baseArmor = 10;
    static int sck = 10;
    static int kah = 10;
    static int cm = 20;
    static int armorDef = 10;
    static double cash;
    static double bucks = 100;
    static double health = 100.0;
    static int pistol = 10;
    static int stunGun = 10;
    static int laserDagger = 20;
    static int maxHealth = 100;
    static Random rand = new Random();
    static DecimalFormat formatter = new DecimalFormat("#,##0.0");
//endregion
    public static void main(String[] args) {
        //region NewGameLoop
        while (true) {
            health = 100;
            System.out.println("Welcome to Bounty Hunter X");
            System.out.println("What is your name agent?");
            String name = keyboard.next();
            if(name.equals("David Baker")){
                System.out.println("You win!!");
                return;
            }
            System.out.println(name + " huh? Well your name won't save your life. Would you like a rundown of the operation? (y/n)");
            while (true) {
                String choice1 = keyboard.next();
                if (choice1.equals("y")) {
                    System.out.println("Ok, what we're doing is top secret.");
                    System.out.println("We are hunting the most dangerous criminals on the planet");
                    System.out.println("We have given you a couple of weapon choices and armor choices. Pick one of each");
                    System.out.println("Choose your weapon:\nPistol\nStun gun\nLaser Dagger");
                    String weaponChoice = keyboard.next();
                    if (weaponChoice.equals("Pistol")) {
                        System.out.println("You chose the pistol. It's damage is: " + pistol);
                        characterWeapon = pistol;
                    } else if ("Stun gun".equals(weaponChoice)) {
                        System.out.println("You chose the stun gun. It's damage is: " + stunGun);
                        characterWeapon = stunGun;
                    } else if (weaponChoice.equals("Laser Dagger")) {
                        System.out.println("You chose the Laser Dagger. It's damage is: " + laserDagger);
                        characterWeapon = laserDagger;
                    }
                    break;
                } else if (choice1.equals("n")) {
                    System.out.println("Alright agent.");
                    System.out.println("Choose your weapon:\nPistol\nStun gun\nLaser Dagger");
                    String weaponChoice = keyboard.next();
                    if (weaponChoice.equals("Pistol")) {
                        System.out.println("You chose the pistol. It's damage is: " + pistol);
                        characterWeapon = pistol;
                    } else if (weaponChoice.equals("Stun gun")) {
                        System.out.println("You chose the stun gun. It's damage is: " + stunGun);
                        characterWeapon = stunGun;
                    } else if (weaponChoice.equals("Laser Dagger")) {
                        System.out.println("You chose the Laser Dagger. It's damage is: " + laserDagger);
                        characterWeapon = laserDagger;
                    }
                    break;
                } else {
                    System.out.println("That was not an option...");
                    health -= 0.1;
                    System.out.println("Your health is now: " + formatter.format(health));
                }
            }
            while (true) {
                System.out.println("Now it's time to choose your armor");
                System.out.println("Choose your armor:\nStreet clothes and kevlar - SCK\nKevlar body armor and helmet - KAH\nChainmail mesh - CM");
                String armorChoice = keyboard.next();
                if (armorChoice.equals("SCK")) {
                    System.out.println("You chose street clothes and kevlar. Your armor is: " + sck);
                    characterArmor = sck;
                    break;
                } else if (armorChoice.equals("KAH")) {
                    System.out.println("You chose kevlar body armor and helmet. Your armor is: " + kah);
                    characterArmor = kah;
                    break;
                } else if (armorChoice.equals("CM")) {
                    System.out.println("You chose chainmail mesh. Your armor is: " + cm);
                    characterArmor = cm;
                    break;
                } else {
                    System.out.println("That was not an option...");
                }
            }
            //endregion
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Are you ready to go hunting?\n \n");
            //region MainGameLoop
            while (true) {
                System.out.println("Hub - Start Hunting\nDeepWeb - Go to the DeepWeb\nC - Character profile\nD - Fight David Baker");
                String choice4 = keyboard.next();
                if (choice4.equals("Hub")) {
                    int hunteeName = rand.nextInt(huntees.length);
                    int hArmor = rand.nextInt(hunteeArmor.length);
                    int hAttack = rand.nextInt(hunteeAttack.length);
                    int hunteeLevel = GetHunteeLevel();
                    System.out.println("Welcome to the hub. This is where you get your case files. This is also where you become a bounty hunter.");
                    System.out.println("It's time to get your case...");
                    System.out.println("Here is your case: \nName: " + huntees[hunteeName] + "\nArmor: " + hArmor + "\nAttack: " + hAttack);
                    System.out.println("Are you ready to fight? (y/n)");
                    while (true) {
                        String choice5 = keyboard.next();
                        if (choice5.equals("y")) {
                            hunteeHealth = 50 + 10 * hunteeLevel;
                            while (health > 0 && hunteeHealth > 0) {
                                FightSequence(hunteeName);
                                System.out.println("Enter H, A, or C");
                                String choice6 = keyboard.next();
                                if (choice6.equals("H")) {
                                    if (health >= 100) {
                                        System.out.println("Sorry, your health is already maxed!");
                                    } else if (health <= 100) {
                                        if (bucks >= 10) {
                                            health = 100;
                                            System.out.println("Your health is now: " + health);
                                        } else {
                                            System.out.println("Sorry, not enough bucks!");
                                        }
                                    }
                                } else if (choice6.equals("A")) {
                                    int damage = CalculateDmg(baseAttack, weaponLvL, characterWeapon, hunteeArmor[hunteeName], hunteeLevel, false, false);
                                    hunteeHealth = hunteeHealth - damage;
                                    System.out.println("You attack and deal " + damage + " damage.");
                                    if (hunteeHealth > 0) {
                                        damage = CalculateDmg(baseArmor, armorLvL, armorDef, hunteeAttack[hunteeName], hunteeLevel, true, false);
                                        health = health - damage;
                                        System.out.println(huntees[hunteeName] + " attacked and dealt " + damage + " damage");
                                        continue;
                                    } else if (hunteeHealth <= 0) {
                                        System.out.println("You killed, " + huntees[hunteeName] + " congrats " + name);
                                        break;
                                    }
                                } else if (choice6.equals("C")) {
                                    CharacterProfile();
                                } else {
                                    System.out.println("That was not an option...");
                                    continue;
                                }
                            }
                            if (health > 0) {
                                int min = (int) (10 * hunteeLevel);
                                int max = (int) (10 * hunteeLevel * 1.8);
                                int exp = rand.nextInt(max - min + 1) + min;
                                xp = xp + exp;
                                cash = rand.nextInt(max + min - 1);
                                bucks = cash + bucks;
                                System.out.println("You killed " + huntees[hunteeName] + ", you got " + exp + " experience and " + cash + " cash");
                                if (xp >= xpToLvlUp) {
                                    level = level + 1;
                                    xpToLvlUp = (int) (xpToLvlUp + 10 * Math.pow(level, 2));
                                    maxHealth += 10;
                                    health = maxHealth;
                                    bucks += 50;
                                    System.out.println("Congrats agent " + name + " you are now level " + level + "\nYour health is now: " + health);
                                }
                            }
                        } else if (choice5.equals("n")) {
                            System.out.println("Ok then... we'll see you soon");
                        } else {
                            System.out.println("Sorry, that was not an option...");
                            continue;
                        }
                        break;
                    }
                    if (health < 0) {
                        System.out.println("Health: " + health);
                        System.out.println("Dammit agent, you died.");
                        System.out.println("Press any key to try again");
                        keyboard.next();
                        break;
                    }
                } else if (choice4.equals("DeepWeb")) {
                    DeepWeb();
                } else if (choice4.equals("C")) {
                    CharacterProfile();
                } else if (choice4.equals("D")) {
                    while (true) {
                        int dname = rand.nextInt(dnames.length);
                        int dhealth = 1000;
                        System.out.println("You chose to fight David Baker... Prepare to Die...");
                        while (health > 0 && dhealth > 0) {
                            DBFightSequence(dname);
                            int dArmor = 1000;
                            int dAttack = 500;
                            System.out.println("Enter H, A, or C");
                            String choice6 = keyboard.next();
                            if (choice6.equals("H")) {
                                if (health >= 100) {
                                    System.out.println("Sorry, your health is already maxed!");
                                } else if (health <= 100) {
                                    if (bucks >= 10) {
                                        health = 100;
                                        System.out.println("Your health is now: " + health);
                                    } else {
                                        System.out.println("Sorry, not enough bucks!");
                                    }
                                }
                            } else if (choice6.equals("A")) {
                                int damage = CalculateDmg(baseAttack, weaponLvL, characterWeapon, 100, 100, false, false);
                                hunteeHealth = hunteeHealth - damage;
                                System.out.println("You attack and deal " + damage + " damage.");
                                if (hunteeHealth > 0) {
                                    damage = CalculateDmg(100, 100, 100, 100, 100, true, false);
                                    health = health - damage;
                                    System.out.println("David Baker attacked and dealt " + damage + " damage");
                                    continue;
                                } else if (hunteeHealth <= 0) {
                                    System.out.println("You killed, David Baker, congrats " + name);
                                    break;
                                }
                            } else if (choice6.equals("C")) {
                                CharacterProfile();
                            } else {
                                System.out.println("That was not an option...");
                                continue;
                            }
                        }
                        if (health < 0) {
                            System.out.println("Health: " + health);
                            System.out.println("You died");
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Sorry That was not an option...");
                }
                if(health < 0){
                    break;
                }
            }
            //endregion

        }
        //endregion
    }

    //region DeepWeb
    static void DeepWeb() {
        while (true) {
            int weaponCost = weaponLvL * baseWeaponCost;
            int armorCost = armorLvL * baseArmorCost;
            System.out.println("Welcome to the DeepWeb");
            System.out.println("Here you can buy weapon and armor upgrades and also refill your health.");
            System.out.println("A - Upgrade armor - Cost: " + armorCost + "\nW - Upgrade weapon - Cost: " + weaponCost + "\nH - Refill health\nE - Exit DeepWeb");
            String choice3 = keyboard.next();
            if (choice3.equals("A")) {
                if (bucks >= armorCost) {
                    bucks = bucks - armorCost;
                    armorLvL += 1;
                    characterArmor += 5;
                    System.out.println("Congrats agent, looks like you successfully bought an armor upgrade.\nYour armor level is now: " + armorLvL + "\nYour armor's strength is now: " + characterArmor);
                } else {
                    System.out.println("You don't have enough bucks agent!");
                }
            }else if (choice3.equals("W")) {
                    if (bucks >= weaponCost) {
                        bucks = bucks - weaponCost;
                        weaponLvL += 1;
                        characterWeapon += 5;
                        System.out.println("Congrats agent, looks like you successfully bought a weapon upgrade.\nYour weapon level is now: " + weaponLvL + "\nYour weapon's strength is now: " + characterWeapon);
                    } else {
                        System.out.println("You don't have enough bucks agent!");
                    }
            }else if (choice3.equals("H")) {
                    System.out.println("Refilling health costs 10 bucks, are you sure you would like to refill your health? (y/n)");
                    String refillHealthChoice = keyboard.next();
                    if (refillHealthChoice.equals("y")) {
                        if (health >= 100) {
                            System.out.println("Sorry, your health is already maxed!");
                        } else if (health < 100) {
                            if (bucks >= 10) {
                                bucks -= 10;
                                health = 100;
                                System.out.println("Your health is now full");
                            } else {
                                System.out.println("Sorry, not enough bucks!");
                            }
                        }
                    } else if (refillHealthChoice.equals("n")) {
                        System.out.println("Well I can't do anything for you...");
                    } else {
                        System.out.println("Sorry, that was not an option...");
                    }

                } else if (choice3.equals("E")) {
                    break;
                } else {
                    System.out.println("Sorry, that was not an option...");
            }
        }
    }
    //endregion
    //region GetHunteeLevel
    static int GetHunteeLevel()
    {
        int hunteeLevel;
        int randVal = rand.nextInt(1000);
        if (randVal < 100)
        {
            hunteeLevel = level - 2;
        }
        else if (randVal < 300)
        {
            hunteeLevel = level - 1;
        }
        else if (randVal < 900)
        {
            hunteeLevel = level;
        }
        else if (randVal < 970)
        {
            hunteeLevel = level + 1;
        }
        else
        {
            hunteeLevel = level + 2;
        }
        if (hunteeLevel < 1)
        {
            hunteeLevel = 1;
        }
        return hunteeLevel;
    }
    //endregion
    //region FightSequence
    static void FightSequence(int hunteeName){
        int hunteeLevel = GetHunteeLevel();
        System.out.println("Your health is: " + health);
        System.out.println("Your armor is: " + characterArmor);
        System.out.println(huntees[hunteeName] + "'s health is: " + hunteeHealth);
        System.out.println(huntees[hunteeName] + "'s level is: " + hunteeLevel);
        System.out.println("Your attack is: " + characterWeapon);
        System.out.println("What do you want to do?");
        System.out.println("H - Heal for 10 bucks");
        System.out.println("A - Attack target");
    }
    //endregion
    //region DBFightSequence
    static void DBFightSequence(int hunteeName){
        hunteeHealth = 1000;
        System.out.println("Your health is: " + health);
        System.out.println("Your armor is: " + characterArmor);
        System.out.println("David Baker's health is: " + hunteeHealth);
        System.out.println("Your attack is: " + characterWeapon);
        System.out.println("What do you want to do?");
        System.out.println("H - Heal for 10 bucks");
        System.out.println("A - Attack target");
    }
    //endregion
    //region CalculateDmg
    static int CalculateDmg(int baseRating, int itemLvl, int itemRating,int hunteeSkill, int hunteeLevel,boolean isHunteeAttack,boolean isAutoCrit)
    {

        double netRating = (baseRating * level * 1.2) + itemLvl * itemRating;
        if (isHunteeAttack)
        {
            netRating = (hunteeSkill * 0.8 * hunteeLevel) - netRating;
        }
        else
        {
            netRating = netRating - (hunteeSkill * 1.2 * hunteeLevel);
        }
        if (netRating < 0)
        {
            netRating = 0;
        }

        int adjustedDmg = (int)(netRating + 10);
        int adjustedDmgMax = (adjustedDmg + 10);
        int damage = randInt(adjustedDmg, adjustedDmgMax);
        if (randInt(1, 50) == 50 || isAutoCrit)
        {
            System.out.println("Critical Hit! ");
            damage = damage * 3;
        }
        return damage;
    }
    //endregion
    //region CharacterProfile
    static void CharacterProfile(){
        double armorBonus = armorLvL * armorDef;
        double weaponBonus = weaponLvL * characterWeapon;
        System.out.println("Character Profile: ");
        System.out.println("Level: " + level);
        System.out.println("Health " + health);
        System.out.println("Armor: " + formatter.format(characterArmor) + "(+" + armorBonus + ")");
        System.out.println("Attack: " + formatter.format(characterWeapon) + "(+" + weaponBonus + ")");
        System.out.println("Bucks: " + bucks);
        System.out.println("XP: " + xp + "/" + xpToLvlUp + " XP to next level");
    }
    //endregion
    //region RandomInt
    static int randInt(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    //endregion
}