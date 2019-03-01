package fr.moko.main.java.games_Launchers.recherche_Launcher;

import fr.moko.main.java.games_Launchers.Games.Methods_Games;
import fr.moko.main.java.games_Launchers.Games.Texts_Games;
import fr.moko.main.java.games_Launchers.Games.Utilities_Games;
import fr.moko.main.java.games_Launchers.recherche_Launcher.recherche.Methods_Recherche;
import fr.moko.main.java.games_Launchers.recherche_Launcher.recherche.Texts_Recherche;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Lance le jeu "Recherche +/-"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Recherche_Launcher {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    // Instance : "Methods_Games"
    Methods_Games methods_Games = new Methods_Games();

    // Instance : "Texts_Games"
    Texts_Games texts_Games = new Texts_Games();

    //Instance : "Utilities_Games"
    Utilities_Games utilities_Games = new Utilities_Games();

    // Instance : "Texts_Recherche"
    Texts_Recherche texts_Recherche = new Texts_Recherche();

    // Instance : "Methods_Recherche"
    Methods_Recherche methods_Recherche = new Methods_Recherche();



    /**
     * Lancement du jeu "Recherche +/-"
     *
     * @param al_Configuration : (ArrayList) Valeurs de configuration
     * @param array_str_Main_Menu_Choices : (String[]) Choix du menu principal
     */
    public void recherche_Launcher(ArrayList al_Configuration, String array_str_Main_Menu_Choices[]) {

        // Récupération des valeurs de configuration
        boolean boo_DevMode = (boolean) al_Configuration.get(0);
        int int_Recherche_NumberOfUnities = (int) al_Configuration.get(1);
        int int_Recherche_NumberOfChances = (int) al_Configuration.get(2);
        logger.info("Récupération des valeurs de configuration");

        // Initialisation (String) Sous-mode en mode "Duel"
        String str_Sub_Mode = new String();

        // Initialisation (String) résultat gagnant
        String str_WinningResult = methods_Recherche.run_str_WinningResult(int_Recherche_NumberOfUnities);
        logger.debug("(String) Résultat gagnant : " + str_WinningResult);



        // Lancement du compteur de tours
        logger.info("Lancement du compteur de tours");
        for (int i = 0; i < int_Recherche_NumberOfChances; i++) {

            if (array_str_Main_Menu_Choices[1].equals("Défense") || array_str_Main_Menu_Choices[1].equals("Duel")) {

                logger.trace("############################");
                logger.trace("<<< START >>> Mode \"Défense\"");
                logger.trace("############################");

                // IF - Mode "Duel"
                logger.info("IF - Mode \"Duel\"");
                if (array_str_Main_Menu_Choices[1].equals("Duel")) {

                    // Màj - (String) Sous-mode (Pour mode "Duel")
                    str_Sub_Mode = "Défense";
                    logger.debug("Màj - (String) Sous-mode (Pour mode \"Duel\") : " + str_Sub_Mode);
                }


                // Instance - (ArrayList) Données de défense
                ArrayList al_Recherche_Defense = new ArrayList();
                logger.info("Instance - (ArrayList) Données de défense");

                // Initialisation et injection - (int[]) Combinaison secrète
                int array_int_Combination[] = new int[int_Recherche_NumberOfUnities];
                logger.debug("Initialisation et injection - (int[]) Combinaison secrète : " + Arrays.toString(array_int_Combination));
                al_Recherche_Defense.add(0, array_int_Combination);

                // Initialisation et injection - (int[]) Derniers inférieurs
                int array_int_LastInferior[] = new int[int_Recherche_NumberOfUnities];
                logger.debug("Initialisation et injection - (int[]) Derniers inférieurs : " + Arrays.toString(array_int_LastInferior));
                al_Recherche_Defense.add(1, array_int_LastInferior);

                // Initialisation et injection - (int[]) Derniers supérieurs
                int array_int_LastSuperior[] = new int[int_Recherche_NumberOfUnities];
                logger.debug("Initialisation et injection - (int[]) Derniers supérieurs : " + Arrays.toString(array_int_LastSuperior));
                al_Recherche_Defense.add(2, array_int_LastSuperior);

                // Initialisation et injection - (int[]) Proposition de l'ordinateur
                int array_int_ComputerProposal[] = new int[int_Recherche_NumberOfUnities];
                al_Recherche_Defense.add(3, array_int_ComputerProposal);
                logger.debug("Initialisation et injection - (int[]) Proposition de l'ordinateur : " + Arrays.toString(array_int_ComputerProposal));

                // Initialisation et injection - (char[]) Résultat de la comparaison
                char array_ch_ComparisonResult_Defense[] = new char[int_Recherche_NumberOfUnities];
                logger.debug("Initialisation et injection - (char[]) Résultat de la comparaison : " + Arrays.toString(array_ch_ComparisonResult_Defense));
                al_Recherche_Defense.add(4, array_ch_ComparisonResult_Defense);



                // SI - Premier tour
                if (i == 0) {
                    logger.info("SI - Premier tour");

                    // Affiche "But du jeu :"
                    texts_Games.display_BUT_DU_JEU();

                    // SI - Mode "Duel", affiche l'énoncé
                    if (array_str_Main_Menu_Choices[1].equals("Duel")) {
                        logger.info("SI - Mode \"Duel\", affiche l'énoncé");

                        // Affichage énoncé en mode "Duel"
                        texts_Games.display_Duel_Statement();
                    }

                    // Affichage énoncé en mode "Défense"
                    texts_Recherche.display_Defense_Statement(int_Recherche_NumberOfUnities);

                    // Affiche "A vous de jouer !"
                    texts_Games.display_A_VOUS_DE_JOUER();

                    // Initialisation (int) Combinaison Try Catch
                    int int_Combination_TryCatch = 0;
                    logger.debug("Initialisation (int) Combinaison Try Catch : " + int_Combination_TryCatch);

                    // Initialisation (boolean) Combinaison validée
                    boolean boo_Combination_Validated = false;
                    logger.debug("Initialisation (boolean) Combinaison validée : " + boo_Combination_Validated);

                    // DO {} WHILE - La Combinaison n'est pas validée
                    do {
                        logger.info("DO {} WHILE - La Combinaison n'est pas validée");

                        // Lance le scanner pour le combinaison secrète
                        Scanner sc_Combinaison = methods_Games.run_sc_Combination(array_str_Main_Menu_Choices, str_Sub_Mode);
                        logger.info("Lance le scanner pour le combinaison secrète");

                        // Vérifie si la combinaison secrète ne contient bien que des nombres
                        int_Combination_TryCatch = methods_Recherche.run_Combination_TryCatch(sc_Combinaison, int_Combination_TryCatch);
                        logger.info("Vérifie si la combinaison secrète ne contient bien que des nombres");

                        // Vérifie la validité de la combinaison secrète
                        boo_Combination_Validated = methods_Recherche.run_Combination_Treatment(int_Recherche_NumberOfUnities, int_Combination_TryCatch, boo_Combination_Validated);
                        logger.info("Vérifie la validité de la combinaison secrète");

                    } while (!boo_Combination_Validated);
                    logger.info("DO {} WHILE - Sortie -> La combinaison est validée");

                    // Conversion (int[]) Combinaison secrète en tableau d'entiers
                    array_int_Combination = utilities_Games.run_int_TO_arrayInt(int_Recherche_NumberOfUnities, int_Combination_TryCatch);
                    logger.debug("Conversion (int[]) Combinaison secrète en tableau d'entiers : " + Arrays.toString(array_int_Combination));

                    // MàJ - Combinaison secrète dans ArrayList "al_RecherchePlusMoins_Defense"
                    al_Recherche_Defense.set(0, array_int_Combination);
                    logger.info("MàJ - Combinaison secrète dans ArrayList \"al_RecherchePlusMoins_Defense\"");

                    // Conversion (String) Combinaison secrète en chaîne de caractère
                    String str_Combination = utilities_Games.run_arrayInt_TO_str(int_Recherche_NumberOfUnities, array_int_Combination);

                    // Affiche la combinaison secrète
                    texts_Games.display_VOTRE_COMBINAISON(str_Combination);

                    // Initialisation des derniers supérieurs
                    al_Recherche_Defense = methods_Recherche.run_arrayInt_LastSuperiorInitialization(int_Recherche_NumberOfUnities, al_Recherche_Defense);
                }
            }
        }
    }
}
