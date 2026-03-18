import java.util.*;

// LeetCode 1600. Throne Inheritance
class ThroneInheritance {
    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;

    // Initialize with king name
    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();
        children.put(kingName, new ArrayList<>());
    }

    // Add a child to a parent
    public void birth(String parentName, String childName) {
        children.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
        children.put(childName, new ArrayList<>());
    }

    // Mark a person as dead
    public void death(String name) {
        dead.add(name);
    }

    // Return current inheritance order
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    // Preorder DFS traversal helper
    private void dfs(String person, List<String> order) {
        if (!dead.contains(person)) {
            order.add(person);
        }
        for (String child : children.getOrDefault(person, new ArrayList<>())) {
            dfs(child, order);
        }
    }
}