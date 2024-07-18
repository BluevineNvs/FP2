import matplotlib.pyplot as plt
import networkx as nx

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.node_count = 1  # Contamos la raíz inicialmente

    def insert(self, word):
        current = self.root
        new_nodes = 0
        for char in word:
            if char not in current.children:
                current.children[char] = TrieNode()
                new_nodes += 1
                self.node_count += 1
            current = current.children[char]
        current.is_end_of_word = True
        return new_nodes

# Function to convert Trie to a nested dictionary for visualization
def trie_to_dict(node):
    result = {}
    for char, child in node.children.items():
        result[char] = trie_to_dict(child)
    return result

# Function to add nodes and edges to the graph based on the Trie structure
def add_edges_from_trie(node, parent, graph):
    for char, child in node.children.items():
        graph.add_edge(parent, parent + char)
        add_edges_from_trie(child, parent + char, graph)

# Palabras iniciales
initial_words = ["request","rest","answer","ant","gold"]
# Palabras a insertar
new_words = ["amplitude","filled","warning","golden"]

# Crear el Trie e insertar las palabras iniciales
trie = Trie()
for word in initial_words:
    trie.insert(word)

# Insertar las nuevas palabras y contar los nodos agregados
total_new_nodes = 0
new_nodes_per_word = []
tries = [trie_to_dict(trie.root)]  # List to hold Trie states for each step

for word in new_words:
    new_nodes = trie.insert(word)
    new_nodes_per_word.append(new_nodes)
    total_new_nodes += new_nodes
    tries.append(trie_to_dict(trie.root))  # Append the current Trie state

# Plot the initial Trie and each step
for i, trie_dict in enumerate(tries):
    title = "Trie Inicial" if i == 0 else f"Después de insertar '{new_words[i-1]}'"
    graph = nx.DiGraph()
    add_edges_from_trie(trie.root, "root", graph)
    plt.figure(figsize=(14, 8))
    pos = nx.spring_layout(graph, seed=42)
    nx.draw(graph, pos, with_labels=True, node_size=3000, node_color="skyblue", font_size=10, font_weight="bold", arrows=True)
    plt.title(title, size=15)
    plt.show()

print(total_new_nodes, new_nodes_per_word)
