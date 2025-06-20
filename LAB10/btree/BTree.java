package LAB10.btree;

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

    public boolean search(E cl) {
        return searchRecursive(root, cl);
    }

    private boolean searchRecursive(BNode<E> node, E cl) {
        if (node == null) return false;
        int[] pos = new int[1];
        boolean found = node.searchNode(cl, pos);
        if (found) {
            System.out.println(cl + " se encuentra en el nodo con claves: " + node);
            return true;
        } else {
            return searchRecursive(node.childs.get(pos[0]), cl);
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
            if (current.childs.get(i) != null) {
                s.append(writeTree(current.childs.get(i)));
            }
        }
        return s.toString();
    }
}