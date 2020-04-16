import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class TestCartDao {
Map<Integer, ArrayList<Integer>> cart = new HashMap<Integer,ArrayList<Integer>>();
int cart_item_id = 1;

    //Constructor
    public TestCartDao(){

    }

    /**
     * @author Pragyee Nepal
     */
    public void addItem(int userId, int prodId){
        ArrayList<Integer> values = new ArrayList<Integer>(){{add(cart_item_id); add(userId); add(prodId);}};
        cart.put(cart_item_id, values);
        cart_item_id++;
    }

    /**
     * @author Pragyee Nepal
     */
    public void deleteItem(int userId, int prodId){
        Iterator<Integer> it = cart.keySet().iterator();
        while (it.hasNext()){
            Integer key = it.next();
            ArrayList<Integer> values = new ArrayList<Integer>(){{add(key);add(userId); add(prodId);}};
            if(cart.get(key).equals(values)){
                it.remove();
            }
        }
    }



}
