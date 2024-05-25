import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.* ;

import java.util.List;

public class SILabTest{

    @Test
    public void everyBranch(){
        /*
            - allItems=null, payment = 0
            - allItems=({discount=10,price=301,barcode=0,name=a}), payment=300
            - allitems=({name=a,barcode=123,price=300,disc=0}), payment = 200
            - allitems=({bardoce=ab,price=0,discount=0,name=a}), payment = 0
            - allitems=({barcode=null,price=0,discount=0,name=""}), payment = 0
        * */

       assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 0)) ;

       assertTrue(SILab2.checkCart(List.of(new Item("a","0",301,(float) 0.1)),300));
       assertFalse(SILab2.checkCart(List.of(new Item("a","123",300,0)),200));

       assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("a","ab",0,0)), 0));
       assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("",null,0,0)),0));
    }

    @Test 
    public void mulitpleMethods(){
        /*
         * allItems=(
         *     {price=100,barcode=1,name=a,discount=0}, sum = 100
         *     {price=301,discount=0,barcode=1,name=a}, sum = 301
         *     {price=302,discount=50,barcode=1, name=a}, sum = 151
         *     {price=302,discount=50,barcode=0, name=a} sum=121
         * ) , payment = 100
         * */

        //public Item(String name, String code, int price, float discount)

        assertTrue(SILab2.checkCart(List.of(
                new Item("a", "1", 100, 0),
                new Item("a", "1", 301, 0),
                new Item("a", "1", 302, (float) 0.5),
                new Item("a", "0", 302, (float) 0.5)
        ), 100 + 301 + 151 + 121));
    }
}