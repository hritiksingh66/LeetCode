class Solution {
    class Node {
        String name;
        Map<String, Node> children;
        List<List<String>> paths;
        boolean deleted;

        Node(String name) {
            this.name = name;
            this.children = new HashMap<>();
            this.paths = new ArrayList<>();
            this.deleted = false;
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("");
        for (List<String> path : paths) {
            Node curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new Node(folder));
                curr = curr.children.get(folder);
            }
            curr.paths.add(new ArrayList<>(path));
        }

        Map<String, List<Node>> serialToNodes = new HashMap<>();

        serialize(root, serialToNodes);

        for (List<Node> nodes : serialToNodes.values()) {
            if (nodes.size() > 1) {
                for (Node node : nodes) {
                    markDeleted(node);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        collectRemainingPaths(root, result);
        return result;
    }

    private String serialize(Node node, Map<String, List<Node>> serialToNodes) {
        if (node.children.isEmpty()) {
            return "";
        }

        // Serialize children in sorted order
        List<String> childrenSerials = new ArrayList<>();
        for (String childName : new TreeSet<>(node.children.keySet())) {
            Node child = node.children.get(childName);
            String childSerial = serialize(child, serialToNodes);
            childrenSerials.add(childName + "(" + childSerial + ")");
        }

        String serial = String.join("", childrenSerials);
        if (!serial.isEmpty()) {
            serialToNodes.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        }
        return serial;
    }

    private void markDeleted(Node node) {
        if (node == null || node.deleted) {
            return;
        }
        node.deleted = true;
        for (Node child : node.children.values()) {
            markDeleted(child);
        }
    }

    private void collectRemainingPaths(Node node, List<List<String>> result) {
        if (node.deleted) {
            return;
        }
        for (List<String> path : node.paths) {
            result.add(path);
        }
        for (Node child : node.children.values()) {
            collectRemainingPaths(child, result);
        }
    }
}