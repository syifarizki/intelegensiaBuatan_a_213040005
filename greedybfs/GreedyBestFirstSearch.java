package greedybfs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GreedyBestFirstSearch {

    public void search(NodeUCS start, NodeUCS goal) {
        Queue<Solusi> queue = new LinkedBlockingQueue<>();
        Solusi solusiStart = new Solusi();
        solusiStart.setNode(start);
        queue.add(solusiStart);
        System.out.println("Mencari solusi dari " + start.getNilai() + " ke " + goal.getNilai());

        while (!queue.isEmpty()) {
            Solusi eval = queue.poll();
            System.out.println("Evaluasi: " + eval.getNode().getNilai());

            if (eval.getNode().equals(goal)) {
                System.out.println("Solusi ditemukan: ");

                for (NodeUCS node : eval.getNodes()) {
                    System.out.print(node.getNilai() + " -> ");
                }

                System.out.println(eval.getNode().getNilai());
                break;
            } else {
                System.out.println("Suksesor " + eval.getNode().getNilai());
                Solusi solusiSuksesor = new Solusi();
                
                NodeUCS best = null;
                int min = Integer.MAX_VALUE;
                int depth = 0;

                for (NodeUCS node : eval.getNode().getTetangga()) {
                    if (depth < 5) {
                        System.out.print(node.getNilai() + " (" + node.getCost() + "), ");

                        if (min > node.getCost()) {
                            min = node.getCost();
                            best = node;
                        }

                    } else {
                        return;
                    }

                    depth++;
                }

                NodeUCS successor = best;
                solusiSuksesor.setNode(successor);
                solusiSuksesor.setNodes(eval.getNodes());
                solusiSuksesor.getNodes().add(eval.getNode());

                System.out.println();
                System.out.println("Node terpilih: " + best.getNilai() + " (" + min + ")");
                queue.offer(solusiSuksesor);
                System.out.println();
            }
        }

    }
}
