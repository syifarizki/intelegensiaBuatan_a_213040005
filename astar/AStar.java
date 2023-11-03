package astar;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class AStar {

    public void search(NodeUCS start, NodeUCS goal) {
        Queue<Solusi> queue = new LinkedBlockingQueue<>();
        Solusi solusiStart = new Solusi();
        solusiStart.setNode(start);

        queue.add(solusiStart);
        int costAll = 0;
        System.out.println("Mencari solusi dari " + start.getNilai() + " ke " + goal.getNilai());

     
        while (!queue.isEmpty()) {
            Solusi eval = queue.poll();

            System.out.println("Evaluasi: " + eval.getNode().getNilai());

            if (eval.getNode().equals(goal)) {
                System.out.println("Solusi ditemukan: ");

                for (NodeUCS node : eval.getNodes()) {
                    System.out.print(node.getNilai() + " -> ");
                }
                System.out.print(eval.getNode().getNilai());

                break;
            }
            else {
                System.out.println("Suksesor " + eval.getNode().getNilai() + ": ");

                Solusi solusiSuksesor = new Solusi();
                eval.getNode().isVisited = true;

                NodeUCS best = null;
                int min = Integer.MAX_VALUE;
                int cost = 0;
                int i = 0;

                for (NodeUCS node : eval.getNode().getTetangga()) {
                    int costTetangga = eval.getNode().getTetanggaCost().get(i);
                    if (eval.getNode().getTetanggaCost().size() > i) {
                        int apakahMin = node.getCost() + costTetangga + costAll;

                        System.out.print(node.getNilai() + " (" + node.getCost() + " + " +
                                costTetangga + " + " + costAll + "), = " + apakahMin + "\n");

                        if (node.isVisited == true) {
                            System.out.println(node.getNilai() + " sudah dikunjungi.\n");
                        }
                        if (min > apakahMin && node.isVisited == false) {
                            min = apakahMin;
                            best = node;
                            cost = i;
                            node.isVisited = true;
                        }

                    }
                    else {
                        return;
                    }
                    i++;
                }

                NodeUCS successor = best;
                solusiSuksesor.setNode(successor);
                solusiSuksesor.setNodes(eval.getNodes());
                solusiSuksesor.getNodes().add(eval.getNode());

              
                System.out.println();
                System.out.println("Node terpilih: " + best.getNilai() + " (" + min + ")");

                costAll += eval.getNode().getTetanggaCost().get(cost);

              
                queue.offer(solusiSuksesor);
                System.out.println();
            }
        }
    }
}