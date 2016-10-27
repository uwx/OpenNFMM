package nfm.open;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import nfm.open.CarPool.Vehicle;

public class CarPool {
    public static class Player {
        /** not a stage conto */
        ContO co;
        Stat stat;
        final Mad mad;
        int sc;
        public Player(Mad mad) {
            this.mad = mad;
        }
        public Player(Player v) {
            this.co = v.co;
            this.stat = new Stat(v.stat);
            this.mad = v.mad;
            this.sc = v.sc;
        }
        public void setCar(ContO co, Stat s, int sc) {
            this.co = co;
            this.sc = sc;
            this.stat = new Stat(s);
        }
    }
    
    public static class Vehicle {
        final ContO co;
        final Stat baseStat;
        final int sc;
        
        public Vehicle(ContO co, Stat baseStat, int sc) {
            this.co = co;
            this.baseStat = new Stat(baseStat);
            this.sc = sc;
        }
        
        public Player create(int sc, int im) {
            Player p = new Player(GameSparker.mads[im]);
            p.setCar(co, baseStat, sc);
            return p;
        }
    }
    
    public static class Pool<E> extends ArrayList<E> {
        
        @FunctionalInterface
        public static interface Condition<E> {
            public boolean test(E e);
        }

        /**
         * 
         */
        private static final long serialVersionUID = 3792334378466719180L;
        
        /**
         * Constructs an empty list with the specified initial capacity.
         *
         * @param  initialCapacity  the initial capacity of the list
         * @throws IllegalArgumentException if the specified initial capacity
         *         is negative
         */
        public Pool(int initialCapacity) {
            super(initialCapacity);
        }

        /**
         * Constructs an empty list with an initial capacity of ten.
         */
        public Pool() {
            super();
        }

        /**
         * Constructs a list containing the elements of the specified
         * collection, in the order they are returned by the collection's
         * iterator.
         *
         * @param c the collection whose elements are to be placed into this list
         * @throws NullPointerException if the specified collection is null
         */
        public Pool(Collection<? extends E> c) {
            super(c);
        }
        
        public E getFirstIfCondition(Condition<E> c) {
            for (E e : this) {
                if (c.test(e))
                    return e;
            }
            return null;
        }
    }
    
    /**
     * Player object for each player
     */
    static final Player[] players = new Player[8];

    /**
     * player's car
     */
    static final Pool<Vehicle> playerCarPool = new Pool<>(1);
    
    /**
     * list that AI cars (and potential unlocked cars) can be pulled from
     */
    static final Pool<Vehicle> carPool = new Pool<>();
    
    /**
     * list of every car definition
     */
    static final Pool<Vehicle> carDefs = new Pool<>(xtGraphics.nCars);
    
    static final Pool<String> stages = new Pool<>(xtGraphics.nStages);

    /**
     * index in {@link #playerCarPool}
     */
    public static int playersc;
}
