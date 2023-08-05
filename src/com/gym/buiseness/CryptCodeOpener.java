/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.buiseness;

import com.healthmarketscience.jackcess.CryptCodecProvider;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import java.io.File;
import java.io.IOException;
import net.ucanaccess.jdbc.JackcessOpenerInterface;

/**
 *
 * @author DELL
 */
public class CryptCodeOpener implements JackcessOpenerInterface{
     @Override
    public Database open(File fl,String pwd) throws IOException {
       DatabaseBuilder dbd =new DatabaseBuilder(fl);
       dbd.setAutoSync(false);
       dbd.setCodecProvider(new CryptCodecProvider(pwd));
       dbd.setReadOnly(false);
       return dbd.open();
    }
}
