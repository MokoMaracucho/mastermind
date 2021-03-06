package fr.moko.main;

import fr.moko.main.java.games_Launchers.Games_Launcher;

import org.apache.logging.log4j.*;

/**
 * Class "Main {}"
 *
 * @author : Moko
 * @version : 1.0
 */
public class Main {

    // Instance : "Logger"
    static Logger logger = LogManager.getRootLogger();

    /**
     * Méthode "main(String[] args)"
     *
     * @param args : ...
     */
    public static void main(String[] args) {

        String str_DevMode_Console = new String();

        if (args.length == 0){

             str_DevMode_Console = "";
        }
        else {

            str_DevMode_Console = args[0];
        }

        // Instance "Games_Launcher"
        Games_Launcher games_Launcher = new Games_Launcher();
        games_Launcher.games_Launcher(str_DevMode_Console);
    }
}
