/*
 * Copyright (C) 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.core.remoting.event;

/**
 * Recyclable Event
 *
 * @author pbting
 * @date 2019-08-28 2:41 PM
 */
public class RecyclableEvent extends Event {

    /**
     * Unit in seconds. the default is zero means will recycle once
     */
    private int recycleInterval;

    private volatile boolean isCancel = false;

    public RecyclableEvent(Object source, Object value, Class<? extends Event> eventType, int recycleInterval) {
        super(source, value, eventType);
        this.recycleInterval = recycleInterval;
    }

    public RecyclableEvent(Object source, Object value) {
        super(source, value, null);
    }

    public RecyclableEvent(Object source, Class<? extends Event> eventType, int recycleInterval) {
        super(source, Event.EMPTY_VALUE, eventType);
        this.recycleInterval = recycleInterval;
    }

    public RecyclableEvent(Object source, int recycleInterval) {
        super(source, Event.EMPTY_VALUE, null);
        this.recycleInterval = recycleInterval;
    }


    public int getRecycleInterval() {
        return recycleInterval;
    }

    public void setRecycleInterval(int recycleInterval) {
        this.recycleInterval = recycleInterval;
    }

    public void cancel() {
        isCancel = true;
    }

    public boolean isCancel() {
        return isCancel;
    }
}