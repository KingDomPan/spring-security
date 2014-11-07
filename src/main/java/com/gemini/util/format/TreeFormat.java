package com.gemini.util.format;

import java.io.Serializable;

/**
 * 树型结构支持.
 */
public interface TreeFormat<T, PK extends Serializable> {
    PK getId();

    PK getParentId();

    void addChildren(T child);
}
