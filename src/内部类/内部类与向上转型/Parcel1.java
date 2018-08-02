package 内部类.内部类与向上转型;

import javax.sound.midi.Soundbank;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public class Parcel1 {
    // 这是一个内部类
    private class Contents implements IContents {
        private int i = 11;
        Contents(int i) {
            this.i = i;
        }

        public int value() {
            return i;
        }
    }
    public class Destination implements IDestination{
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
        /*
        String readLabel() { // 'readLabel()' in '内部类.内部类与向上转型.Parcel1.Destination' clashes with 'readLabel()' in '内部类.内部类与向上转型.IDestination'; attempting to assign weaker access privileges ('package-private'); was 'public'
            return label;
        }
        */

    }

    public void ship(String dest) {
        IContents c = new Contents(1);

        IDestination d = new Destination(dest);
        System.out.println(d.readLabel());

        IDestination d2 = new Parcel1.Destination(dest);
        System.out.println(d2.readLabel());

        IDestination d3 = this.new Destination(dest);
        Destination d3casted = (Destination) d3;
        System.out.println(d3.readLabel());
        System.out.println(d3casted.readLabel());

    }

    public void m(IContents c) {
        Contents c1 = (Contents) c;
        System.out.println(c1.value());
    }

    public IContents getContents(int i) {
        return this.new Contents(i);
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("shanghai");

        p.m(p.new Contents(12));
    }
}
/*
Output:
shanghai
shanghai
shanghai
 */