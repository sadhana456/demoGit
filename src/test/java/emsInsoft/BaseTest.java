package emsInsoft;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;

/**
 * Created by Titi on 4/26/2016.
 */
public class BaseTest {

    static BaseMain base = new BaseMain();

    @BeforeClass
    public static  void  setup() throws IOException {
        base.openBrowser();
    }
    @AfterClass
    public static void  done(){
        base.closeBrowser();


    }
}
