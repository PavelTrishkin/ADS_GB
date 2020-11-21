package ru.gb.trishkin.lesson6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
    static int level = 6;

    public static void main(String[] args) {

        int balanced = 0;
        int notBalanced = 0;

        Collection<Tree> treeList = new ArrayList<>();
        addTree(treeList);

        for (Tree tree: treeList) {
            if (tree.isBalanced()){
                System.out.println("Tree with level: " + tree.level() + " is balanced: " + tree.isBalanced());
                balanced++;
            }
            else {
                System.out.println("Tree with level: " + tree.level() + " is balanced: " + tree.isBalanced());
                notBalanced++;
            }
        }

        double notBalancedPercent = (double) (100 * notBalanced)/ treeList.size();
        double balancedPercent = (double) (100 * balanced)/ treeList.size();
        System.out.println("Total trees: " + treeList.size() + " with level " + level);
        System.out.println("Total balanced: " + balanced + " trees");
        System.out.println("Total not balanced: " + notBalanced + " trees");
        System.out.println("The percentage is not balanced trees: " + notBalancedPercent + "%");
        System.out.println("The percentage is balanced trees: " + balancedPercent + "%");
    }

    private static void addTree(Collection<Tree> treeCollection){
        for (int i = 0; i < 20; i++) {
            treeCollection.add(new TreeImpl<Integer>(level));
        }
        for (Tree tree: treeCollection) {
            addToTree(tree);
        }
    }

    private static void addToTree(Tree<Integer> tree){
        int maxQuantity = (int) Math.pow(2, tree.level()) - 1;

        for (int i = 0; i < maxQuantity ; i++) {
            int value = (int)((100 * Math.random()) - (100 * Math.random()));
//            System.out.println("Value " + value);
            tree.add(value);
        }
    }
}
