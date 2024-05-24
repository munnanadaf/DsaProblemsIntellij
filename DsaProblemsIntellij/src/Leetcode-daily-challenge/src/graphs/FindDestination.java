package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindDestination {
    public String destCity(List<List<String>> paths) {
        Set<String> sources = new HashSet<>();
        for(List<String> subPath: paths){
            sources.add(subPath.get(0));
        }
        for(List<String> subPath: paths){
            if(sources.add(subPath.get(1)))
                return subPath.get(1);
        }
        return "";
    }
}