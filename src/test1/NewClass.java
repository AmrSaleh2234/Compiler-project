/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author hheka
 */
public class NewClass {

    /**
     *
     * @return
     * @throws IOException
     */
    public String loadFromFile(String path) throws IOException {
    return new String(Files.readAllBytes(Paths.get(path)));
}
    
    
}
