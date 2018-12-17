package data;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class TestData {
   private final static Logger logger= LoggerFactory.getLogger(TestData.class);


   @Test
   public void testMain(){
      logger.debug("BEGIN");
      String data="{3,9,20,#,#,1,5,7}";

      System.out.println(data);
   }

//   private TreeNode  deserizlize(String data){
//      if(data.equals("{}")){
//         return null;
//      }
//      ArrayList<> treeList=new ArrayList<>();
//      data=data.replace("{","");
//      data=data.replace("}","");
//      String[] vals = data.split(",");
//
//   }
}
