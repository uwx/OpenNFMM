package nfm.open;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

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

    public interface Pool<T> extends List<T>, Collection<T>, Serializable {

        @FunctionalInterface
        public static interface Condition<E> {
            public boolean test(E e);
        }
        
        public T pop();
        public T getFirstIfCondition(Condition<? super T> c);
    }
    
    public static class ArrayPool<E> extends ArrayList<E> implements Pool<E> {
        
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
        public ArrayPool(int initialCapacity) {
            super(initialCapacity);
        }

        /**
         * Constructs an empty list with an initial capacity of ten.
         */
        public ArrayPool() {
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
        public ArrayPool(Collection<? extends E> c) {
            super(c);
        }
        
        public E getFirstIfCondition(Pool.Condition<? super E> c) {
            for (E e : this) {
                if (c.test(e))
                    return e;
            }
            return null;
        }
        
        public E pop() {
            E el = get(size() - 1);
            remove(size() - 1);
            return el;
        }
    }


    /**
     * @serial include
     */
    static class UnmodifiablePool<E> implements Pool<E> {

        /**
         * 
         */
        private static final long serialVersionUID = -1051171175571332861L;

        final Pool<? extends E> list;
        
        public int size()                   {return list.size();}
        public boolean isEmpty()            {return list.isEmpty();}
        public boolean contains(Object o)   {return list.contains(o);}
        public Object[] toArray()           {return list.toArray();}
        public <T> T[] toArray(T[] a)       {return list.toArray(a);}
        public String toString()            {return list.toString();}

        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private final Iterator<? extends E> i = list.iterator();

                public boolean hasNext() {return i.hasNext();}
                public E next()          {return i.next();}
                public void remove() {
                    throw new UnsupportedOperationException();
                }
                @Override
                public void forEachRemaining(Consumer<? super E> action) {
                    // Use backing collection version
                    i.forEachRemaining(action);
                }
            };
        }

        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        public boolean containsAll(Collection<?> coll) {
            return list.containsAll(coll);
        }
        public boolean addAll(Collection<? extends E> coll) {
            throw new UnsupportedOperationException();
        }
        public boolean removeAll(Collection<?> coll) {
            throw new UnsupportedOperationException();
        }
        public boolean retainAll(Collection<?> coll) {
            throw new UnsupportedOperationException();
        }
        public void clear() {
            throw new UnsupportedOperationException();
        }

        // Override default methods in Collection
        @Override
        public void forEach(Consumer<? super E> action) {
            list.forEach(action);
        }
        @Override
        public boolean removeIf(Predicate<? super E> filter) {
            throw new UnsupportedOperationException();
        }
        @SuppressWarnings("unchecked")
        @Override
        public Spliterator<E> spliterator() {
            return (Spliterator<E>)list.spliterator();
        }
        @SuppressWarnings("unchecked")
        @Override
        public Stream<E> stream() {
            return (Stream<E>)list.stream();
        }
        @SuppressWarnings("unchecked")
        @Override
        public Stream<E> parallelStream() {
            return (Stream<E>)list.parallelStream();
        }
        
        public boolean equals(Object o) {return o == this || list.equals(o);}
        public int hashCode()           {return list.hashCode();}

        public E get(int index) {return list.get(index);}
        public E set(int index, E element) {
            throw new UnsupportedOperationException();
        }
        public void add(int index, E element) {
            throw new UnsupportedOperationException();
        }
        public E remove(int index) {
            throw new UnsupportedOperationException();
        }
        public int indexOf(Object o)            {return list.indexOf(o);}
        public int lastIndexOf(Object o)        {return list.lastIndexOf(o);}
        public boolean addAll(int index, Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void replaceAll(UnaryOperator<E> operator) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void sort(Comparator<? super E> c) {
            throw new UnsupportedOperationException();
        }

        public ListIterator<E> listIterator()   {return listIterator(0);}

        public ListIterator<E> listIterator(final int index) {
            return new ListIterator<E>() {
                private final ListIterator<? extends E> i
                    = list.listIterator(index);

                public boolean hasNext()     {return i.hasNext();}
                public E next()              {return i.next();}
                public boolean hasPrevious() {return i.hasPrevious();}
                public E previous()          {return i.previous();}
                public int nextIndex()       {return i.nextIndex();}
                public int previousIndex()   {return i.previousIndex();}

                public void remove() {
                    throw new UnsupportedOperationException();
                }
                public void set(E e) {
                    throw new UnsupportedOperationException();
                }
                public void add(E e) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public void forEachRemaining(Consumer<? super E> action) {
                    i.forEachRemaining(action);
                }
            };
        }

        public List<E> subList(int fromIndex, int toIndex) {
            return new UnmodifiablePool<>(new ArrayPool<>(list.subList(fromIndex, toIndex)));
        }

        /**
         * UnmodifiableRandomAccessList instances are serialized as
         * UnmodifiableList instances to allow them to be deserialized
         * in pre-1.4 JREs (which do not have UnmodifiableRandomAccessList).
         * This method inverts the transformation.  As a beneficial
         * side-effect, it also grafts the RandomAccess marker onto
         * UnmodifiableList instances that were serialized in pre-1.4 JREs.
         *
         * Note: Unfortunately, UnmodifiableRandomAccessList instances
         * serialized in 1.4.1 and deserialized in 1.4 will become
         * UnmodifiableList instances, as this method was missing in 1.4.
         */
        private Object readResolve() {
            return this;
        }

        UnmodifiablePool(Pool<? extends E> list) {
            if (list==null)
                throw new NullPointerException();
            this.list = list;
        }

        @Override
        public E pop() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E getFirstIfCondition(Pool.Condition<? super E> c) {
            return list.getFirstIfCondition(c);
        }
        
    }
    
    /**
     * Player object for each player
     */
    static final Player[] players = new Player[8];

    /**
     * player's car
     */
    static final Pool<Vehicle> playerCarPool = new ArrayPool<>(1);
    
    /**
     * list that AI cars (and potential unlocked cars) can be pulled from
     */
    static final Pool<Vehicle> carPool = new ArrayPool<>();
    
    /**
     * list of every car definition (this is created after load and unmodifiable)
     */
    static Pool<Vehicle> carDefs = null;
    
    static final Pool<String> stages = new ArrayPool<>(xtGraphics.nStages);

    /**
     * index in {@link #playerCarPool}
     */
    public static int playersc;
    
    static {
        
    }
}
