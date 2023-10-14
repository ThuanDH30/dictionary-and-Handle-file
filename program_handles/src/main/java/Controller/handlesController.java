/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Responsitory.HandlesRes;
import View.Menu;

/**
 *
 * @author Bravo
 */
public class handlesController extends Menu {

    private HandlesRes HandlesRes;
    static String[] option = {"Find Person Info", "Copy Text To new file", "Quit"};

    public handlesController() {
        super("========== File Processing =========", option);
        HandlesRes = new HandlesRes();
    }

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:
                HandlesRes.findPersonInfo();
                break;
            case 2:
                HandlesRes.copyNewFile();
                break;
            case 3:
                System.out.println("Exit!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!!!");
        }
    }

}
