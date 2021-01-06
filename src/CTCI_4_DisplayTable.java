import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * CTCI_4_DisplayTable.java 
 * Group: Noob Doggos 
 * Group members: Victor, Eric, Clyde
 */
public class CTCI_4_DisplayTable
{
    /**
     * A method to take in a List of String sub-Lists detailing restaurant order
     * information, outputting a list of String sub-Lists representing a 2D
     * table with the number of each dish offered by the restaurant ordered per
     * restaurant table. The outputted list is sorted in ascending order by
     * table number and food name.
     * 
     * time complexity: O(n log n), where n is the total number of sub-Lists
     * given in the orders parameter.
     * 
     * space complexity: O(n), where n is the total number of sub-Lists given in
     * the orders parameter.
     * 
     * 
     * @param orders,
     *            a List of String sub-Lists detailing restaurant order
     *            information. Each sub-List contains an order. element 0 =
     *            orderer name, element 1 = orderer table number, and element 2
     *            contains the name of the food in the order.
     * @return a List of String sub-Lists representing a 2-D table containing
     *         the number of each food offered by the restaurant ordered per
     *         restaurant table, sorted in ascending order by table number and
     *         food name.
     */
    public List<List<String>> displayTable(List<List<String>> orders)
    {
        List<List<String>> toReturn = new ArrayList<>();
        TreeMap<Integer, TreeMap<String, Integer>> map = new TreeMap<>();
        TreeSet<String> allFoods = new TreeSet<>();
        for (List<String> orderInfo : orders)
        {
            Integer tableNum = Integer.parseInt(orderInfo.get(1));
            String food = orderInfo.get(2);
            TreeMap<String, Integer> foodCount = null;
            if (map.containsKey(tableNum))
            {
                foodCount = map.get(tableNum);
            }
            else
            {
                foodCount = new TreeMap<String, Integer>();
                map.put(tableNum, foodCount);
            }
            foodCount.put(food, foodCount.containsKey(food) ? foodCount.get(food) + 1 : 1);
            allFoods.add(food);
        }

        List<String> initRow = new ArrayList<>();
        initRow.add("Table");
        allFoods.forEach(food -> initRow.add(food));
        toReturn.add(initRow);

        for (Integer tableNum : map.keySet())
        {
            List<String> curTableList = new ArrayList<>();
            curTableList.add(tableNum + "");
            TreeMap<String, Integer> foodCount = map.get(tableNum);
            allFoods.forEach(
                curFood -> curTableList.add(foodCount.containsKey(curFood) ? "" + foodCount.get(curFood) : "0"));
            toReturn.add(curTableList);
        }

        return toReturn;
    }

    public static void main(String[] args)
    {
        String[][] ordersArr = { { "David", "3", "Ceviche" }, { "Corina", "10", "Beef Burrito" },
                { "David", "3", "Fried Chicken" }, { "Carla", "5", "Water" }, { "Carla", "5", "Ceviche" },
                { "Rous", "3", "Ceviche" } };
        List<List<String>> orders = new ArrayList<>();
        for (String[] arr : ordersArr)
        {
            List<String> curRow = new ArrayList<>();
            for (String element : arr)
            {
                curRow.add(element);
            }
            orders.add(curRow);
        }
        System.out.println(new CTCI_4_DisplayTable().displayTable(orders));
    }
}
