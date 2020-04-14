import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class TestCartDao {
Map<Integer, ArrayList<Integer>> cart = new HashMap<Integer,ArrayList<Integer>>();
int cart_item_id = 0;

    //Constructor
    public TestCartDao(){

    }

    /**
     * @author Pragyee Nepal
     */
    public void addItem(int userId, int prodId){
        ArrayList<Integer> values = new ArrayList<Integer>(){{add(userId); add(prodId);}};
        cart_item_id++;
        cart.put(cart_item_id, values);
    }

    /**
     * @author Pragyee Nepal
     */
    public void deleteItem(int userId, int prodId){
        ArrayList<Integer> values = new ArrayList<Integer>(){{add(userId); add(prodId);}};
        Iterator<Integer> it = cart.keySet().iterator();
        while (it.hasNext()){
            Integer key = it.next();
            if(cart.get(key).equals(values)){
                it.remove();
            }
        }
    }

}
