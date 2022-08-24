/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ElectronicAddressDAOTest {
    
    public ElectronicAddressDAOTest() {
    }

    ElectronicAddressDAO edao = new ElectronicAddressDAO();

    @Test
    public void testGetEaIDbyEmail() {
       
        String expResult = "1";
        String result = edao.getEaIDbyEmail("hoangnvliu@gmail.com");
        assertEquals(expResult, result);
    
    }
    @Test
    public void testGetEaIDbyEmail_2() {
       
        String expResult = "1";
        String result = edao.getEaIDbyEmail("hoangnvliu@gmail.com");
        assertEquals(expResult, result);
    
    }@Test
    public void testGetEaIDbyEmail_3() {
       
        String expResult = "1";
        String result = edao.getEaIDbyEmail("3");
        assertEquals(expResult, result);
    
    }
    

    
}
