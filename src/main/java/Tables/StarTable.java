package Tables;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by susha on 3/19/2016.
 */
public class StarTable {
    public String dimension;
    Map<String, Integer> starTable;

    @Override
    public String toString() {
    Iterator<Map.Entry<String, Integer>> entries = starTable.entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry<String, Integer> entry = entries.next();
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println("Key: " + key + ", Value: " + value);
    }
        return null;
    }
    
    public StarTable(String dimen) {
        starTable = new TreeMap<String, Integer>();
        this.dimension = dimen;
    }

    public void insert(String attribute) {
        if (!starTable.containsKey(attribute)) {
            starTable.put(attribute, 1);
        } else {
            int i = starTable.get(attribute);
            starTable.replace(attribute, ++i);
        }
    }

    public void validateStar(int min_sup) {//program goes through the and validates stars
        for (String key : starTable.keySet()) {
            if (starTable.get(key) < min_sup) {
                starTable.replace(key, -1);
            }
        }

    }

    public boolean isStar(String attribute) {
        return (starTable.get(attribute) == -1);
    }
}
