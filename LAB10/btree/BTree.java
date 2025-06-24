package LAB10.btree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;
        mediana = push(root, cl);
        if (up) {
            pnew = new BNode<>(orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, root);
            pnew.childs.set(1, nDes);
            root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean found = current.searchNode(cl, pos);
            if (found) {
                System.out.println("Item duplicado");
                up = false;
                return null;
            }
            E mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(orden - 1)) {
                    mediana = dividedNode(current, mediana, pos[0]);
                } else {
                    putNode(current, mediana, nDes, pos[0]);
                    up = false;
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        for (int i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int posMdna = (k <= orden / 2) ? orden / 2 : orden / 2 + 1;
        nDes = new BNode<>(orden);

        for (int i = posMdna; i < orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }
        nDes.count = (orden - 1) - posMdna;
        current.count = posMdna;

        if (k <= orden / 2) {
            putNode(current, cl, rd, k);
        } else {
            putNode(nDes, cl, rd, k - posMdna);
        }

        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;
        return median;
    }
    //método para buscar solo con una clave
    public boolean search(E cl) {
        return searchRecursive(root, cl);
    }

    private boolean searchRecursive(BNode<E> node, E cl) {
        if (node == null) return false;
        int[] pos = new int[1];
        boolean found = node.searchNode(cl, pos);
        if (found) {
            System.out.println(cl + " se encuentra en el nodo " + node.getIdNode() + " en la posición " + pos[0]);
            return true;
        } else {
            return searchRecursive(node.childs.get(pos[0]), cl);
        }
    }

    //método para eliminar un nodo
    public void remove(E cl) {
        root = removeRecursive(root, cl);
        if (root != null && root.count == 0 && root.childs.get(0) != null) {
            root = root.childs.get(0); //elimina la raíz vacía
        }
    }

    private BNode<E> removeRecursive(BNode<E> node, E key) {
        if (node == null) return null;
        int[] pos = new int[1];
        boolean found = node.searchNode(key, pos);

        if (found) {
            if (node.childs.get(pos[0]) == null) {
                for (int i = pos[0]; i < node.count - 1; i++) {
                    node.keys.set(i, node.keys.get(i + 1));
                }
                node.count--;
            } else {
                BNode<E> predNode = node.childs.get(pos[0]);
                while (predNode.childs.get(predNode.count) != null) {
                    predNode = predNode.childs.get(predNode.count);
                }
                E predKey = predNode.keys.get(predNode.count - 1);
                node.keys.set(pos[0], predKey);
                node.childs.set(pos[0], removeRecursive(node.childs.get(pos[0]), predKey));
            }
        } else {
            BNode<E> child = node.childs.get(pos[0]);
            if (child == null) return node;
            node.childs.set(pos[0], removeRecursive(child, key));
        }

        //para manjear el underflow o subflujo
        if (node.childs.get(pos[0]) != null && node.childs.get(pos[0]).count < (orden - 1) / 2) {
            fixUnderflow(node, pos[0]);
        }
        return node;
    }

    private void fixUnderflow(BNode<E> parent, int idx) {
        BNode<E> child = parent.childs.get(idx);
        BNode<E> left = idx > 0 ? parent.childs.get(idx - 1) : null;
        BNode<E> right = idx < parent.count ? parent.childs.get(idx + 1) : null;

        if (left != null && left.count > (orden - 1) / 2) {
            for (int i = child.count; i > 0; i--) {
                child.keys.set(i, child.keys.get(i - 1));
                child.childs.set(i + 1, child.childs.get(i));
            }
            child.childs.set(1, child.childs.get(0));
            child.keys.set(0, parent.keys.get(idx - 1));
            child.childs.set(0, left.childs.get(left.count));
            child.count++;

            parent.keys.set(idx - 1, left.keys.get(left.count - 1));
            left.count--;
        } else if (right != null && right.count > (orden - 1) / 2) {
            child.keys.set(child.count, parent.keys.get(idx));
            child.childs.set(child.count + 1, right.childs.get(0));
            child.count++;

            parent.keys.set(idx, right.keys.get(0));
            for (int i = 0; i < right.count - 1; i++) {
                right.keys.set(i, right.keys.get(i + 1));
                right.childs.set(i, right.childs.get(i + 1));
            }
            right.childs.set(right.count - 1, right.childs.get(right.count));
            right.count--;
        } else {
            if (right != null) {
                child.keys.set(child.count++, parent.keys.get(idx));
                for (int i = 0; i < right.count; i++) {
                    child.keys.set(child.count++, right.keys.get(i));
                    child.childs.set(child.count, right.childs.get(i));
                }
                child.childs.set(child.count, right.childs.get(right.count));

                for (int i = idx; i < parent.count - 1; i++) {
                    parent.keys.set(i, parent.keys.get(i + 1));
                    parent.childs.set(i + 1, parent.childs.get(i + 2));
                }
                parent.count--;
            } else if (left != null) {
                for (int i = 0; i < child.count; i++) {
                    left.keys.set(left.count++, child.keys.get(i));
                    left.childs.set(left.count, child.childs.get(i));
                }
                left.childs.set(left.count, child.childs.get(child.count));
                left.keys.set(left.count++, parent.keys.get(idx - 1));

                for (int i = idx - 1; i < parent.count - 1; i++) {
                    parent.keys.set(i, parent.keys.get(i + 1));
                    parent.childs.set(i + 1, parent.childs.get(i + 2));
                }
                parent.count--;
            }
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "BTree is empty...";
        return writeTree(root);
    }

    private String writeTree(BNode<E> current) {
        if (current == null) return "";
        StringBuilder s = new StringBuilder(current.toString()).append("\n");
        for (int i = 0; i <= current.count; i++) {
            if (i < current.childs.size() && current.childs.get(i) != null) {
                s.append(writeTree(current.childs.get(i)));
            }
        }
        /*for (int i = 0; i <= current.count; i++) {
            if (current.childs.get(i) != null) {
                s.append(writeTree(current.childs.get(i)));
            }
        }*/
        return s.toString();
    }

    //ejercicio 3
    public static BTree<Integer> building_BTree(String filePath) throws ItemNoFound {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int orden = Integer.parseInt(br.readLine().trim());
            BTree<Integer> btree = new BTree<>(orden);

            Map<Integer, BNode<Integer>> nodos = new HashMap<>();
            Map<Integer, Integer> niveles = new HashMap<>();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int nivel = Integer.parseInt(partes[0]);
                int id = Integer.parseInt(partes[1]);

                BNode<Integer> nodo = new BNode<>(orden);
                nodo.count = partes.length - 2;
                for (int i = 2; i < partes.length; i++) {
                    nodo.keys.set(i - 2, Integer.parseInt(partes[i]));
                }
                nodo.count = partes.length - 2;
                /*for (int i = 2; i < partes.length; i++) {
                    nodo.keys.add(Integer.parseInt(partes[i]));
                }
                nodo.count = nodo.keys.size();*/

                nodos.put(id, nodo);
                niveles.put(id, nivel);
            }

            List<Integer> ids = new ArrayList<>(nodos.keySet());
            ids.sort(Comparator.comparingInt(niveles::get));

            Map<Integer, List<Integer>> hijosPorPadre = new HashMap<>();
            Map<Integer, Integer> padres = new HashMap<>();

            for (int id : ids) {
                int nivelActual = niveles.get(id);
                for (int otro : ids) {
                    if (niveles.get(otro) == nivelActual - 1) {
                        hijosPorPadre.computeIfAbsent(otro, k -> new ArrayList<>()).add(id);
                        padres.put(id, otro);
                        break;
                    }
                }
            }

            for (Map.Entry<Integer, List<Integer>> entry : hijosPorPadre.entrySet()) {
                BNode<Integer> padre = nodos.get(entry.getKey());
                List<Integer> hijos = entry.getValue();
                for (int i = 0; i < hijos.size(); i++) {
                    while (padre.childs.size() <= i) {
                        padre.childs.add(null);
                    }
                    padre.childs.set(i, nodos.get(hijos.get(i)));
                }
            }

            Integer raizId = ids.stream().filter(id -> !padres.containsKey(id)).findFirst().orElse(null);
            if (raizId == null) throw new ItemNoFound("No se encontró nodo raíz válido.");
            btree.root = nodos.get(raizId);

            return btree;
        } catch (IOException | NumberFormatException e) {
            throw new ItemNoFound("Error al construir el árbol B: " + e.getMessage());
        }
    }

    //ejercicio4
    public String buscarNombre(int codigo) {
        if (!(root != null && root.keys.get(0) instanceof RegistroEstudiante))
            return "Operación no soportada para este tipo";

        RegistroEstudiante dummy = new RegistroEstudiante(codigo, "");
        RegistroEstudiante resultado = buscarNombreRec(root, dummy);
        return resultado != null ? resultado.getNombre() : "No encontrado";
    }

    @SuppressWarnings("unchecked")
    private RegistroEstudiante buscarNombreRec(BNode<E> node, RegistroEstudiante buscado) {
        if (node == null) return null;

        for (int i = 0; i < node.count; i++) {
            RegistroEstudiante actual = (RegistroEstudiante) node.keys.get(i);
            int cmp = buscado.compareTo(actual);
            if (cmp == 0) return actual;
            if (cmp < 0) return buscarNombreRec(node.childs.get(i), buscado);
        }
        return buscarNombreRec(node.childs.get(node.count), buscado);
    }



    public static class ItemNoFound extends Exception {
        public ItemNoFound(String msg) {
            super(msg);
        }
    }
}