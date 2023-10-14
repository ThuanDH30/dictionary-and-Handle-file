/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Responsitory.DictionaryRes;
import View.Menu;

/**
 *
 * @author Bravo
 */
public class DictionaryController extends Menu {
    private DictionaryRes DictionaryRes;
    static String[] option = {"Add Word", "Delete Word", "Translate", "Exit"};

    public DictionaryController() {
        super("======== Dictionary program ========", option);
        DictionaryRes = new DictionaryRes();
    }

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:
                DictionaryRes.addNewWord();
                break;
            case 2:
                DictionaryRes.deleteWord();
                break;
            case 3:
                DictionaryRes.translate();
                break;
            case 4:
                System.out.println("Exit!!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!!!");
        }
    }
    
}
