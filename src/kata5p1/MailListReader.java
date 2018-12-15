/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alexis
 */
public class MailListReader {
    public List<String> read(String fileName){
        List<String> mailList = new ArrayList<>();
        try(RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            String line;
            while((line = file.readLine()) != null){
                if(line.matches("(\\w|[.])*@[a-z]*([.a-z]*)*")) 
                    mailList.add(line);
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return mailList;
    }
}
