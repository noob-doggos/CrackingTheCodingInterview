import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class CTCI_4_DisplayTable
{
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
            curTableList.add(tableNum+"");
            TreeMap<String, Integer> foodCount = map.get(tableNum);
            allFoods.forEach(curFood -> curTableList.add(foodCount.containsKey(curFood) ? ""+foodCount.get(curFood) : "0"));
            toReturn.add(curTableList);
        }

        return toReturn;
    }
    
    public static void main(String[] args)
    {
        // [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
        String[][] ordersArr = {{"David","3","Ceviche"}, {"Corina","10","Beef Burrito"}, {"David","3","Fried Chicken"}, {"Carla","5","Water"}, {"Carla","5","Ceviche"}, {"Rous","3","Ceviche"}};
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
