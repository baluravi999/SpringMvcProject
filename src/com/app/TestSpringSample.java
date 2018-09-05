package com.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("/sample-servlet.xml") 
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class TestSpringSample {  
	@Autowired  
	private CodeUtil codeUtil;  
	@Autowired  
	private CoDecUtil codecUtil; 
    private String pwd; 
    private String encStr;
    private String decStr; 
    String empty="";
    
    @Before  
    public void setPwd() { 
    pwd=codeUtil.genPwd();  }  
    
    @Test //1
   public void testACheckNull(){  
	assertNotNull("Generated Pwd is Null",pwd);
			 }  
    @Test //2 
public void testBCheckEmpty(){  
    	assertNotEquals("generated pass is empty",pwd,empty);  
	} 
			
    private void assertNotEquals(String pwd2, String empty2, String empty3) {
	
		
	}

	@Test  //3
   public void testCEncCheck(){  
    	    	encStr=codecUtil.doDecode(pwd);    
    	    	if(encStr==null ||"".equals(encStr.trim())){
    	    		fail("Encoding of String is  not proper") ; 
    	    		}  }
    	@Test //4
 public void testDDecCheck(){   
    	decStr=codecUtil.doDecode(encStr);   
    	assertEquals(decStr,pwd);  
    	assertTrue(decStr.equals(pwd));  } 
    @After 
    public void setNullData(){  
    	    	pwd=null;   
    	    	encStr=null;   
    	    	decStr=null;  }
    	    
    	    } 