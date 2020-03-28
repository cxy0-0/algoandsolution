package main;

import appUtils.AppUtils;
import java.util.List;
import dto.RoverDTO;
import dto.ParameterDTO;
import imp.DirectionController;

public class AspiratorAutomaticApp {
    public static void main(String[] args) {
        System.out.println("******* Début du Test 1 **********\n");

        String pathName = "src/main/resources/testFile";
        if (args.length == 1) {
            pathName = args[0];
        }

        List<String> lines = AppUtils.readFileInput(pathName);

        System.out.println("étape 1 ::  Lire le fichier de paramétrage \n");
        System.out.println("contenu du fichier " + lines + "\n");

        // 2
        System.out.println("étape 2 ::  Récupération des objets \n");
        ParameterDTO parameter = new ParameterDTO(lines);
        System.out.println("Dimension de la grille : " + parameter.getGridDTO());
        System.out.println("Position initiale de l’aspirateur : " + parameter.getRoverDTO());
        System.out.println("Instructions : " + parameter.getCommand() + "\n");

        // 3
        System.out.println("étape 3 ::  Résultat \n");
        RoverDTO iHooverArrived = DirectionController.getRoverPosition(parameter.getGridDTO(), parameter.getRoverDTO(),
                parameter.getCommand());
        System.out.println("On attend comme position finale " + iHooverArrived);

        // fin
        System.out.println("******* Fin du Test 1 ********");
    }
}
