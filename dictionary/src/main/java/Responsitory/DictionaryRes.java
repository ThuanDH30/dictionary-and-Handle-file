/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import DataAccess.dictionaryDao;

/**
 *
 * @author Bravo
 */
public class DictionaryRes implements IDictionaryRes {
    private  dictionaryDao choice = dictionaryDao.instance();

    @Override
    public void addNewWord() {
        choice.addNewWord();
    }

    @Override
    public void deleteWord() {
        choice.deleteWord();
    }

    @Override
    public void translate() {
        choice.translate();
    }
    
}
