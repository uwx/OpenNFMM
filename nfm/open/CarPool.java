package nfm.open;

import java.util.ArrayList;
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
        
        public Vehicle(ContO co, Stat baseStat) {
            this.co = co;
            this.baseStat = new Stat(baseStat);
        }
        
        public Vehicle copy() {
            return new Vehicle(new ContO(co), baseStat);
        }
    }
    
    /**
     * Player object for each player
     */
    static final Player[] players = new Player[8];
    
    /**
     * list that cars can be pulled from
     */
    static final List<Vehicle> carPool = new ArrayList<>();
}
