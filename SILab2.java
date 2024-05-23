import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        if (allItems == null){ //1 
            throw new RuntimeException("allItems list can't be null!"); // 2 
        }

        float sum = 0;

        /**
         * float sum =0 i int i =0 se 3  
         * i < allItems.size() e 4 
         */
        for (int i = 0 ; i < allItems.size(); i++){ 
            Item item = allItems.get(i); 
            
            if (item.getName() == null || item.getName().length() == 0){ // 5
                item.setName("unknown"); // 6 
            }
            
            if (item.getBarcode() != null ){ // 7
                String allowed = "0123456789"; 
                char chars[] = item.getBarcode().toCharArray();
                /**
                 * String allowed, char chars i int j = 0 se 8 
                 * j < item.getBarcode() se 9 
                 */
                for (int j = 0; j < item.getBarcode().length(); j++){
                    char c = item.getBarcode().charAt(j);
                   
                    if (allowed.indexOf(c) == -1){ // char c i uslov 10 
                        throw new RuntimeException("Invalid character in item barcode!"); // 11
                    }

                    // j++ e 12 
                }

                if (item.getDiscount() > 0){ // 13 
                    sum += item.getPrice()*item.getDiscount(); // 14 
                }

                else {
                    sum += item.getPrice(); // 15 
                }

            }
            
            else {
                throw new RuntimeException("No barcode!"); // 16
            }


            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){ // 17 
                sum -= 30; // 18 
            }
            //19 e i++ 
        }

        if (sum <= payment){ // 20
            return true; // 21 
        }

        else {
            return false; // 22 
        }
        
    } // 23 
}
