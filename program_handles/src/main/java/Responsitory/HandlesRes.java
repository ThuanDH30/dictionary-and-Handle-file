/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;
import DataAccess.handlesDao;
/**
 *
 * @author Bravo
 */
public class HandlesRes implements IhandlesRes {
    private handlesDao choice = handlesDao.instance();

    @Override
    public void findPersonInfo() {
        choice.findPersonInfo();
    }

    @Override
    public void copyNewFile() {
        choice.copyNewFile();
    }
    
}
