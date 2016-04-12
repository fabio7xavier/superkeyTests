/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superkey.keychain;

import java.io.File;
import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fabio
 */
public class KeyChainTest {
    
    private  HashMap<String, KeyEntry> keyEntriesCollection = new HashMap<>();
    private CipherTool cifra;
    private File ficheiro;
    private KeyChain keyA;
    private KeyEntry entryA;
    
    
    public KeyChainTest() {
    }
    
    @Before
    public void setUp() {
        
        keyEntriesCollection.put("Fabio", entryA);
        //keyA = new KeyChain(ficheiro, cifra );
        
    }
    
    @After
    public void tearDown() {
    }
    
}
