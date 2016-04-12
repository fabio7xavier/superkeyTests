/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superkey.keychain;

import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static superkey.keychain.KeyEntry.parse;

/**
 *
 * @author ico
 */
public class KeyEntryTest {
    private KeyEntry entryA, entryB, entryEmpty;
    
    public KeyEntryTest() {
    }
    
    @Before
    public void setUp() {
        entryA = new KeyEntry();
        entryA.setApplicationName("appx");
        entryA.setUsername("xx");
        entryA.setPassword("secret@@@");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test( expected = IllegalArgumentException.class)
    public void testSetApplicationNameWithNull() {
        entryA.setApplicationName( null);
    }
 
    @Test( expected = IllegalArgumentException.class)
    public void testSetPasswordWithNull() {
        entryA.setPassword( null);
    }
    
     @Test( expected = IllegalArgumentException.class)
    public void testSetUserName() {
        entryA.setUsername( null);
        System.out.println("user is null");
    }

    @Test
    public void testKey() {
        // the key is the application name
        assertEquals("failed to get existing key field", entryA.getApplicationName(), "appx");
    }
    
    @Test
    public void testGetPass() {
        assertEquals("Not expected password", entryA.getPassword(), "secret@@@");
    }

    @Test
    public void testFormatAsCsv() {
        String expects = "appx" + KeyEntry.FIELDS_DELIMITER + "xx" + KeyEntry.FIELDS_DELIMITER + "secret@@@";
        assertEquals("failed to format entry to delimited string", entryA.formatAsCsv(), expects);
                   
    }

    @Test
    public void testToString() {
        String expected = "appx" + "\t" + "xx" + "\t" + "secret@@@";
        assertEquals("failed convert to string", expected, entryA.toString());
    }

    @Test
    public void testParse() {
        
        String csvExpect = entryA.formatAsCsv();
        KeyEntry keyExpect = parse(csvExpect);
        
        assertEquals("failed to parse", entryA.getApplicationName(), keyExpect.getApplicationName());
        assertEquals("failed to parse", entryA.getUsername(), keyExpect.getUsername());
        assertEquals("failed to parse", entryA.getPassword(), keyExpect.getPassword());
        
    }

}
