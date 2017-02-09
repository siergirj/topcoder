package com.topcoder.arena.srm145div1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lottery {

    public String[] sortByOdds(String[] rules) {
        String[] result = new String[rules.length];

        List<Game> games = parseInput(rules);
        Collections.sort(games);

        int i = 0;
        for (Game g : games) {
            result[i++] = g.getName();
            System.out.println(g.getName() + "=" + g.getCombinations());
        }

        return result;
    }

    private List<Game> parseInput(String[] rules) {
        List<Game> result = new LinkedList<Game>();

        for (String r : rules) {
            String[] s = r.split(":");
            String[] ss = s[1].trim().split(" ");
            result.add(new Game(s[0], ss[0], ss[1], ss[2], ss[3]));
        }
        return result;
    }

    protected class Game implements Comparable<Game> {
        private long    choices;
        private long    blanks;
        private Boolean sorted;
        private Boolean unique;
        private long    combinations;
        private String  name;

        public Game(String name, String choices, String blanks, String sorted, String unique) {
            super();
            this.name = name;
            this.choices = Integer.parseInt(choices);
            this.blanks = Integer.parseInt(blanks);
            this.sorted = "T".equals(sorted) ? true : false;
            this.unique = "T".equals(unique) ? true : false;
            calculate();
        }

        private void calculate() {
            if (sorted && unique) {
                long c1 = 1;
                long c2 = 1;
                for (int i = 0; i < blanks; i++) {
                    c1 *= (choices - i);
                }
                for (int i = 0; i < blanks; i++) {
                    c2 *= (blanks - i);
                }
                combinations = c1 / c2;
            } else if (sorted) {
                choices = choices + blanks - 1;
                long c1 = 1;
                long c2 = 1;
                for (int i = 0; i < blanks; i++) {
                    c1 *= (choices - i);
                }
                for (int i = 0; i < blanks; i++) {
                    c2 *= (blanks - i);
                }
                combinations = c1 / c2;
            } else if (unique) {
                combinations = 1;
                for (int i = 0; i < blanks; i++) {
                    combinations *= (choices - i);
                }
            } else {
                combinations = 1;
                for (int i = 0; i < blanks; i++) {
                    combinations *= choices;
                }
            }
        }

        public String getName() {
            return name;
        }

        public long getCombinations() {
            return combinations;
        }

        @Override
        public int compareTo(Game o) {
            if (combinations == o.getCombinations()) {
                return name.equals(o.getName()) ? -1 : 1;
            } else {
                return combinations < o.getCombinations() ? -1 : 1;
            }
        }
    }
}