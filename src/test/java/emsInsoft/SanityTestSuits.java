package emsInsoft;

import org.junit.Assert;
import org.junit.Test;
//import org.junit.Test;

//import org.junit.Test;

/**
 * Created by Titi on 4/26/2016.
 */
public class SanityTestSuits extends BaseTest{
    @Test
    public void check() throws InterruptedException {
        Assert.assertTrue(new Employee().viewEmployee());
    }
    @Test
    public void newEmployees() throws InterruptedException{
        Assert.assertTrue(new CreatEmployee().newEmployee());
    }
    @Test
    public void checkDepart(){
       // newDepartment dep = new newDepartment();
        Assert.assertEquals(new newDepartment().newAddDepartment(),"Submitted successfully");

    }


    @Test
    public void checkoutTest(){
        registerEmployee reg = new registerEmployee();
    }
//    @Test
//    public void regCheck() throws InterruptedException {
//        registerEmployee reg = new registerEmployee();
//        reg.register();
//    }
    @Test
    public void statusDepartCheck() throws InterruptedException {
        DepActive  dep  = new DepActive();
        dep.statusDepartment();
}
}
