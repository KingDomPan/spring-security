package com.gemini.util.format;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 树形结构构造器.
 */
public class TreeBuilder<T extends TreeFormat<T, PK>, PK extends Serializable> {

    public static <E extends TreeFormat<E, P>, P extends Serializable> TreeBuilder<E, P> newTreeBuilder(
            Class<E> clazz, Class<P> pk) {
        return new TreeBuilder<E, P>();
    }

    public Set<T> buildToTreeSet(Collection<T> origin) {
        Set<T> target = new HashSet<T>();
        toTreeFormat(origin, target);
        return target;
    }

    public List<T> buildToTreeList(Collection<T> origin) {
        List<T> target = new ArrayList<T>();
        toTreeFormat(origin, target);
        return target;

    }

    private void toTreeFormat(Collection<T> origin, Collection<T> target) {
        LinkedList<T> queue = new LinkedList<T>();
        Map<PK, T> cache = new HashMap<PK, T>();
        for (T data : origin) {
            if (data.getParentId() == null) {
                target.add(data);
            } else {
                queue.add(data);
            }
            cache.put(data.getId(), data);
        }
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                T data = queue.poll();
                T parent = cache.get(data.getParentId());
                if (parent != null) {
                    parent.addChildren(data);
                } else {
                    queue.add(data);
                }
            }
            if (queue.size() == queueSize) {
                for (int i = 0; i < queueSize; i++) {
                    target.add(queue.poll());
                }
            }
        }
    }
}
