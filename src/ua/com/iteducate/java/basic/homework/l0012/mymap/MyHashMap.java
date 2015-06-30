/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.l0012.mymap;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author user
 * @param <K> key
 * @param <V> value
 */
//public class MyHashMap<K extends Integer, V> implements Map<K, V>{
public class MyHashMap<K, V> extends AbstractMap<K,V> implements Map<K, V> {
    
    private KeyValue[] hashmap;
    private int size;
    private final float alpha = 0.75f;
    private int p;
    private final int w = 32;

    public MyHashMap() {
        this.p = 5;
        this.size = (int) Math.pow(2, 5);//32
        this.hashmap = new KeyValue[size];
        
    }
    
    public int myHash(K key){
            int keyInt = key.hashCode();
            long s = (long) ((Math.sqrt(5)-1)/2*Math.pow(2, w));
            long y = (long) ((keyInt*s)%(Math.pow(2, w)));
            int hash = (int)(y >> (w-p));
            //hash &= size - 1; //size must = w!
            return hash;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.keySet().size() == 0);
    }

    @Override
    public boolean containsKey(Object o) {
        Set <K> keys = this.keySet();
        K k = (K)o;
        for (K key : keys){
            if (key == k) return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object o) {
        Collection <V> values = this.values();
        V v = (V)o;
        for (V value : values){
            if (value == v) return true;
        }
        return false;
    }

    @Override
    public V get(Object o) {
        K k = (K)o;
        int index = this.myHash(k);
        if (hashmap[index] != null){
            KeyValue dummy = hashmap[index];
            do{
                if (dummy.getKey() == k){
                    return (V) dummy.getValue();                    
                }else if(dummy.getNext() == null){
                    return null;
                }else{
                    dummy = dummy.getNext();
                }
            }while (dummy != null);
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        int sz = this.keySet().size();
        double beta = sz/(double)this.size;
        if (sz != 0 && beta >= this.alpha){
            this.size *= 2;
            KeyValue[] temp = Arrays.copyOf(hashmap, this.size);
            hashmap = temp;
            temp = null;
        }
        int index = this.myHash(k);
        if (hashmap[index] == null){
            hashmap[index] = new KeyValue(k, v);
            return null;
        }else{
            KeyValue dummy = hashmap[index], dummyprev = null;
            do{
                if (dummy.getKey() == k){
                    return (V) dummy.setValue(v);                    
                }else if(dummy.getNext() == null){
                    dummyprev = dummy;
                    dummy = new KeyValue(k, v);
                    dummyprev.setNext(dummy);
                    return null;
                }else{
                    dummyprev = dummy;
                    dummy = dummy.getNext();
                }
            }while (dummy != null);
        }
        return null;
    }

    @Override
    public V remove(Object o) {
        K k = (K)o;
        int index = this.myHash(k);
        if (hashmap[index] == null){
            return null;
        }else{
            KeyValue dummy = hashmap[index];
            do{
                if (dummy.getKey() == k){
                    V v = (V) dummy.getValue();
                    dummy.setValue(null);
                    return v;
                }else{
                    dummy = dummy.getNext();
                }
            }while (dummy != null);
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        for (KeyValue instance: hashmap){
            instance = null;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet();
        for (KeyValue instance : hashmap){
            if (instance != null){
                KeyValue dummy = instance;
            do{
                keys.add((K) dummy.getKey());
                dummy = dummy.getNext();
            }while (dummy != null);
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        for (KeyValue instance: hashmap){
            if (instance != null){
                KeyValue dummy = instance;
            do{
                values.add((V) dummy.getValue());
                dummy = dummy.getNext();
            }while (dummy != null);
            }
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entry = new HashSet<>();
        for (KeyValue instance: hashmap){
            if (instance != null){
                KeyValue dummy = instance;
            do{
                entry.add(dummy);
                dummy = dummy.getNext();
            }while (dummy != null);
            }
        }
        return entry;
    }
    
    static class KeyValue<K,V> implements Map.Entry<K, V>{
        private final K key;
        private V value;
        private KeyValue<K, V> next;
        private int hash;
        

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
        }
        
        @Override
        public V getValue(){
            return this.value;
        }
        
        @Override
        public K getKey(){
            return this.key;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
        
        public KeyValue getNext(){
            return this.next;
        }
        
        public void setNext(KeyValue kv){
            this.next = kv;
        }
    }
    
}
