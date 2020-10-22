package com.luckyboy.sun.event;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Vector;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-10-15 16:17
 **/
public class EventClassOne extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventClassOne(Object source) {
        super(source);
    }

}

class EventClassTwo extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventClassTwo(Object source) {
        super(source);
    }
}

class EventSource {
    private String who;
    Vector listeners = new Vector();



    public EventSource(String who) {
        this.who = who;
    }

    public String getActioner() {
        return who;
    }

    public void addMyEventListener (MyEventListener listener) {
        listeners.add(listener);
    }

    public void say(String words) {
        System.out.println(this.getActioner()+"说：" + words);
        for(int i = 0;i< listeners.size();i++) {
            MyEventListener listener = (MyEventListener) listeners.elementAt(i);
            listener.onMyEvent(new EventClassOne(this));
        }
    }
}

class MyEventListener implements EventListener {
    public void onMyEvent(EventObject e) {
        if(e.getSource() instanceof EventSource) {
            EventSource source = (EventSource) e.getSource();
            System.out.println("收到来自" + source.getActioner() + "事件");
        }
    }
}